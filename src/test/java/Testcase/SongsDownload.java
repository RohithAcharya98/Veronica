package Testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SongsDownload {

    public static WebDriver driver;
    static Set<String> shareLinks = new HashSet<String>();

    // Safely find element with retry if stale
    public static WebElement safeFindElement(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        int attempts = 0;
        while (attempts < 3) {
            try {
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (StaleElementReferenceException e) {
                attempts++;
                //System.out.println("Retrying find due to stale element: " + attempts);
            }
        }
        throw new RuntimeException("Could not find element: " + locator);
    }

    // Safe click with JS fallback
    public static void safeClick(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int attempts = 0;

        while (attempts < 3) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", element);
                element.click();
                return;
            } catch (ElementClickInterceptedException e) {
                //System.out.println("Click intercepted, using JS click...");
                WebElement element = driver.findElement(locator);
                js.executeScript("arguments[0].click();", element);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                //System.out.println("Retrying click due to stale element: " + attempts);
            }
        }
        throw new RuntimeException("Could not click element: " + locator);
    }

    // Click next video button
    public static void clickNextButton(String nextBtnXpath) {
        safeClick(By.xpath(nextBtnXpath), 10);
    }
    public static boolean isXpathPresent(String xpath){
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(driver.findElements(By.xpath(xpath)).size()!=0){}
		else {driver.navigate().refresh();isXpathPresent(xpath);}
		return true;
	}
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option=new ChromeOptions();
        option.addArguments("--incognito");
        //option.addArguments("--headless");
        driver = new ChromeDriver(option);
        driver.get("https://www.youtube.com/watch?v=CysR4k67dro&list=PLu6cA_NUaMqqjFC2D187Ec9kljG3VKXzL&pp=gAQB");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String shareXpath = "//div[@class='yt-spec-button-shape-next__button-text-content' and contains(text(),'Share')]";
        String shareUrlXpath = "//input[@id='share-url']";
        String nextBtnXpath = "//div[@class='ytp-chrome-controls']//a[@title='Next (SHIFT+n)']";
        String closeBtnXpath = "//yt-icon-button[@id='close-button']";

        for (int i = 0; i < 255; i++) {
            // Click share button
        	
            try{safeClick(By.xpath(shareXpath), 10);}
            catch(TimeoutException e) {driver.navigate().refresh();}

            isXpathPresent(shareUrlXpath);
            // Get the link
            WebElement urlField = safeFindElement(By.xpath(shareUrlXpath), 10);
            try {
                String link = urlField.getAttribute("value");
                shareLinks.add(link);
                System.out.println(link);
            } catch (StaleElementReferenceException e) {
                String link = driver.findElement(By.xpath(shareUrlXpath)).getAttribute("value");
                shareLinks.add(link);
                System.out.println(link);
            }

            // Close popup
            Thread.sleep(1000);
            safeClick(By.xpath(closeBtnXpath), 30);
            Thread.sleep(3000);

            // Click next video
            WebElement element=driver.findElement(By.xpath(nextBtnXpath));
            js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", element);
            Actions action=new Actions(driver);
            action.moveToElement(element).perform();
            clickNextButton(nextBtnXpath);

            Thread.sleep(3000); // slight delay to allow video switch
        }

        writeLinksToExcel("Salesforce2.xlsx");
        driver.quit();
    }

    // Save Set<String> to Excel
    public static void writeLinksToExcel(String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Links");

        int rowNum = 0;
        for (String link : shareLinks) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(link);
        }

       
        System.out.println("✅ Links saved to " + fileName);
    }
}
