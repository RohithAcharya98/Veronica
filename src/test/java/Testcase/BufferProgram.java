package Testcase;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BufferProgram {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static String disturb = "//div[@role='dialog']/div/div[2]/div/div/div/div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']";

    // Extract hrefs
    public static Set<String> callMethod(String xpath, Set<String> uniqueLinks, int i, String label) {
        List<WebElement> links = driver.findElements(By.xpath(xpath));
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && uniqueLinks.add(href)) {
                System.out.println(label + " " + href + " - Scroll " + i);
            }
        }
        return uniqueLinks;
    }

    // Wait for visibility
    public static void waitForIt(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    // Write Excel
    public static void writeToExcel(Set<String> imageLinks, Set<String> videoLinks) throws Exception {
    	Workbook workbook = new XSSFWorkbook();
    	try {
            Sheet sheet = workbook.createSheet("BufferLinks");
            int rowNum = 0;

            for (String link : imageLinks) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(link);
            }
            rowNum = 0;
            for (String link : videoLinks) {
                Row row = sheet.getRow(rowNum++);
                if (row == null) row = sheet.createRow(rowNum - 1);
                row.createCell(1).setCellValue(link);
            }

            try{
            	FileOutputStream fileOut = new FileOutputStream("G:\\MyWork\\Salesforce1.xlsx");
                workbook.write(fileOut);
            }catch(Exception e) {}

            System.out.println("✅ Links saved to Excel successfully!");
        }catch(Exception e) {}
    }

    public static void main(String[] args) throws Exception {
        ClearCache.clearCache();

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String username = "figerstring1";
        String password = "lokesh@12345";
        String profile = "actressmagic_";

        driver.get("https://www.instagram.com/" + profile + "/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(3000);
        waitForIt(disturb);
        driver.findElement(By.xpath(disturb)).click();

        driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Not now')]")).click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Not Now')]"))).click();
        } catch (Exception ignored) {}

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Not Now')]"))).click();
        } catch (Exception ignored) {}

        // ✅ Added: Extract href from specific XPath
        try {
            WebElement linkElement = driver.findElement(By.xpath("//div[@class='_ac7v xat24cr x1f01sob xcghwft xzboxd6']/div/a"));
            String hrefValue = linkElement.getAttribute("href");
            System.out.println("Href value: " + hrefValue);
        } catch (Exception e) {
            System.out.println("❌ Could not find element with the given XPath: " + e.getMessage());
        }

        // Continue with scrolling & scraping
        String imageXpath = "//a[starts-with(@href,'/" + profile + "/p/')]";
        String videoXpath = "//a[starts-with(@href,'/" + profile + "/reel/')]";

        Set<String> imageLinks = new HashSet<String>();
        Set<String> videoLinks = new HashSet<String>();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int scrollTimes = 70;

        for (int i = 0; i < scrollTimes; i++) {
            Thread.sleep(3000);
            callMethod(imageXpath, imageLinks, i, "📷 Image");
            callMethod(videoXpath, videoLinks, i, "🎞️ Reel");
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }

        writeToExcel(imageLinks, videoLinks);
        driver.quit();
    }
}
