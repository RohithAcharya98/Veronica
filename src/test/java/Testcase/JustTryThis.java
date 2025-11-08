package Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.io.FilenameFilter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustTryThis {
    public static WebDriver driver;
    public static String page = "cult_shriyasaran";
    public static String downloadDir = "C:\\Users\\Rohit\\Downloads";

    public static boolean isXpathPresent(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() != 0;
    }

    public static String methodCall(int i) throws Exception {
        FileInputStream file = new FileInputStream("G:\\MyWork\\Salesforce.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(page);
        XSSFRow current_Row = sheet.getRow(i + 1);
        XSSFCell name = current_Row.getCell(1);
        String Username = name.getStringCellValue();
        driver.navigate().refresh();
        if (i != 0) Thread.sleep(3000);
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(Username);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        name.setCellValue(""); // Clears cell
        workbook.close();
        return Username;
    }

    public static void clickIt(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public static void waitForDownloadToComplete() throws InterruptedException {
        File dir = new File(downloadDir);
        int retry = 0;
        while (retry < 60) { // max 60 seconds wait
        	File[] files = dir.listFiles(new FilenameFilter() {
        	    public boolean accept(File dir, String name) {
        	        return name.endsWith(".crdownload");
        	    }
        	});
            if (files != null && files.length == 0) break;
            Thread.sleep(1000);
            retry++;
        }
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Set download dir preferences
        options.addArguments("download.default_directory=" + downloadDir);
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("download.default_directory", downloadDir);
            put("download.prompt_for_download", false);
            put("safebrowsing.enabled", true);
        }});
        return options;
    }

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://savefree.app/en#google_vignette");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        FileInputStream file = new FileInputStream("G:\\MyWork\\Salesforce.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(page);
        int n = sheet.getLastRowNum();
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (j == 2 && i != 0) {
                waitForDownloadToComplete();
                driver.quit();

                driver = new ChromeDriver(getChromeOptions());
                driver.get("https://savefree.app/en#google_vignette");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                j = 0;
            }
            j++;

            String xpath = "//div[@class='download-items__btn']";
            try {
                String Username = methodCall(i);
                System.out.println((i + 2) + " " + Username);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

                if (isXpathPresent(xpath)) {
                    clickIt(xpath);
                }

            } catch (NoSuchElementException  e) {methodCall(i + 1);clickIt(xpath);}
            catch (TimeoutException  e) {methodCall(i + 1);clickIt(xpath);}
            //TimeoutException
        }

        waitForDownloadToComplete(); // Final download wait
        driver.quit();
        System.out.println("Done");
    }
}
