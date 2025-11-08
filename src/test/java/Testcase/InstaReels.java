package Testcase;

import java.io.File;
import java.io.FileInputStream;
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

public class InstaReels extends CreateAllSheets {
	public static WebDriver driver;  
	//public static String sheetName = "filmynati_";//_am.lisa_69
	public static String disturb="//div[@role='dialog']/div/div[2]/div/div/div/div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']";
	public static String login="//a[contains(text(),'Log In')]";
	public static Set<String> callMethod(String imageXpath,Set<String> uniqueLinks,int i) {
		List<WebElement> videoLinks = driver.findElements(By.xpath(imageXpath));
        for (WebElement link : videoLinks) {
            String href = link.getAttribute("href");
            if (href != null && !uniqueLinks.contains(href)) {
                uniqueLinks.add(href);
                System.out.println(href+" "+i);
            }
        }
        return uniqueLinks;
	}
	public static void waitForIt(String xpath) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public static boolean isXpathPresent(String xpath)
	{
		if(driver.findElements(By.xpath(xpath)).size()!=0)
		{System.out.println("Element is Present ");}
		else {System.out.println("Element is not Present");return false;}
		return true;
	}
	public static void callThisEveryTime(String sheetName)throws Exception {
		// ClearCache.clearCache();
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		//option.addArguments("--headless");
		driver=new ChromeDriver(option);
		String url =sheetName;//   actress_movie_reels
		
		driver.get("https://www.instagram.com/"+url+"/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(5000);
		
		if(isXpathPresent(disturb)) {
			waitForIt(disturb);
			driver.findElement(By.xpath(disturb)).click();
			driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
		}
		else {if(isXpathPresent(login)) {driver.findElement(By.xpath(login)).click();}}
		
		driver.findElement(By.name("username")).sendKeys("figerstring1");
		driver.findElement(By.name("password")).sendKeys("lokesh@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Not now')]")).click();
		
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//span[@class='x5n08af x1s688f']/span"));
		String posts=list.get(0).getText();
		posts=posts.replace(",", "");
		Integer i1=Integer.parseInt(posts);
		i1=i1/12;
		System.out.println(i1);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String imageXpath="//a[contains(@href, '/reel/')]";//"//a[starts-with(@href,'/"+url+"/p/')]"
		String videoXpath="//a[contains(@href, '/p/')]";//"//a[starts-with(@href,'/"+url+"/reel/')]";
        Set<String> uniqueLinks = new HashSet<String>();
        Set<String> videoLinks = new HashSet<String>();	
        int scrollTimes = i1+1; // You can increase this to scroll more
        for (int i = 0; i < scrollTimes; i++) {
            Thread.sleep(5000); // Wait for content to load

            callMethod(imageXpath,uniqueLinks,i);
            callMethod(videoXpath,videoLinks,i);
            //System.out.println(i);
            // Scroll down
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }

        File file = new File("G:\\MyWork\\Salesforce1.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        fis.close(); // Close the input stream after loading workbook

        // Step 2: Create a new sheet with a unique name (if needed)
        
//        int counter = 1;
//        while (workbook.getSheet(sheetName) != null) {
//            sheetName = "sreeleela_fp_" + counter++;
//        }
        Sheet sheet = workbook.createSheet(sheetName);

        // Step 3: Write the data to the new sheet
        int rowNum = 0;
        for (String link : uniqueLinks) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(1).setCellValue(link);
        }
        for (String link : videoLinks) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(3).setCellValue(link);
        }

        // Step 4: Write back to the same file
        FileOutputStream fileOut = new FileOutputStream(file);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        System.out.println("✅ New sheet added to existing Excel file!");

        driver.quit();
        //System.out.println(uniqueLinks);
		
//		List<WebElement> elements=driver.findElements(By.xpath("//a[@role='link']"));
//		for(WebElement element:elements) {
//			System.out.println(element);
//		}/**/
	}
}
