package Testcase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InstWork {
    public static WebDriver driver;
    public static String page="trishriyan_forevr";//debjani_bliss thoppul_spy mehreen_pirzadaa_divine
    public static XSSFSheet thisSheet() {
    	XSSFSheet sheet=null;
    	try{
    	    FileInputStream file = new FileInputStream("G:\\MyWork\\Salesforce1.xlsx");
    	    XSSFWorkbook workbook = new XSSFWorkbook(file);
    	    sheet = workbook.getSheet(page);
        }catch(Exception e) {}
    	return sheet;
    }
    public static boolean isXpathPresent(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() != 0;
    }

    public static String methodCall(int i) throws Exception {
        XSSFSheet sheet=null;
        sheet=thisSheet();
        XSSFRow current_Row = sheet.getRow(i + 1);
        XSSFCell name = current_Row.getCell(3);
        String Username = name.getStringCellValue();
        driver.navigate().refresh();
        try{driver.findElement(By.name("q")).clear();}
        catch(NoSuchElementException e) {
        driver.get("https://savefree.app/en#google_vignette");
        driver.findElement(By.name("q")).clear();}
        String download="//button[@id='btn_start']";
        driver.findElement(By.name("q")).sendKeys(Username, Keys.ENTER);
        //if(isXpathPresent(download)) {System.out.println("Hi");}//waitForEle(download); driver.findElement(By.xpath(download)).click();}
        name.setCellValue(""); // Clears the value in the cell
        //workbook.close();
        return Username;
    }

    public static void waitForEle(String xpath) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    public static void methodCall(WebDriverWait wait, String xpath) {
        List<WebElement> links = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        for (WebElement link : links) {
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                js.executeScript("arguments[0].scrollIntoView(true);", link);
                link.click();
            }
            catch(StaleElementReferenceException e) {
            	WebDriverWait waitFor=new WebDriverWait(driver, Duration.ofSeconds(10));
            	waitFor.until(ExpectedConditions.visibilityOf(link));
            	js.executeScript("arguments[0].scrollIntoView(true);", link);
                link.click();
            }
        }
    }
    public static void again(int i,WebDriverWait wait,String photoXpath,String videoXpath)throws Exception {
    	System.out.println("Timeout for index: " + (i + 2));
        methodCall(i); 
        if (isXpathPresent(photoXpath)) {methodCall(wait, photoXpath);}
        if (isXpathPresent(videoXpath)) {methodCall(wait, videoXpath);}
    }
    public static void main(String[] args) throws Exception {
    	//ClearCache.clearCache();
    	ChromeOptions option=new ChromeOptions();
    	option.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.get("https://savefree.app/en#google_vignette");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        XSSFSheet sheet = thisSheet();
        int n = sheet.getLastRowNum();int j=0;
        for (int i = 1656; i <n; i++) {
        	if(j==5) {j=0;DesktopRefresherPS.refreshEveryTime();}j++;
        	// i=44; //      45 46 47 48 49 50          
            String Username = methodCall(i);
            System.out.println((i + 2) + " " + Username);

            final String photoXpath = "//a[@title='Download Photo']";
            final String videoXpath = "//a[@title='Download Video']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
            try {
            	
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return isXpathPresent(photoXpath) || isXpathPresent(videoXpath);
                    }
                });
                String privateXpath="//div[@class='error']//a[@href='/en/download-private-instagram']";
                if(isXpathPresent(privateXpath)) {methodCall(i+1);}
                //if (isXpathPresent(videoXpath)) {Thread.sleep(5000);methodCall(wait, videoXpath);}
                if (isXpathPresent(photoXpath)) {methodCall(wait, photoXpath);}
                if (isXpathPresent(videoXpath)) {methodCall(wait, videoXpath);}
            } 
            catch (NoSuchElementException e) {again(i+1,wait,photoXpath,videoXpath);}
            catch (TimeoutException e) {again(i,wait,photoXpath,videoXpath);}
            catch(ElementClickInterceptedException  e) {again(i,wait,photoXpath,videoXpath);}
        }
        //workbook.close();
        System.out.println("Done");
    }
}
