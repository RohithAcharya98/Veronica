package Testcase;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SongDownloadProgram {
	public static WebDriver driver;
	public static String page="DASFSD";
	public static String methodCall(int i)throws Exception {
		FileInputStream file=new FileInputStream("G:\\MyWork\\Salesforce2.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(page);
		//int n = sheet.getLastRowNum(); 
		XSSFRow current_Row=sheet.getRow(i+1);
		XSSFCell name=current_Row.getCell(1);
		String Username=name.getStringCellValue();
		driver.navigate().refresh();
		if(i!=0) {Thread.sleep(3000);}
		//Username="https://www.instagram.com/p/DLFFK1OpUG8/?utm_source=ig_web_copy_link&igsh=MzRlODBiNWFlZA==";
		driver.findElement(By.name("url")).clear();
		driver.findElement(By.name("url")).sendKeys(Username);
		driver.findElement(By.name("url")).sendKeys(Keys.ENTER);
		
		name.setCellValue(""); 
		workbook.close();
		return Username;
	}
	public static void clickIt(String xpath) {
		WebElement element1=driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();
	}
	public static int methodForIteration(int given,ChromeOptions option,int n) throws Exception{
		int temp=0,k=0,j=0;
			for(int i=given;i<n;i++) {temp=i;	
			if(k==20) {Thread.sleep(20000);break;}k++;
			if(j==3 && i!=0) {
				DesktopRefresherPS.refreshEveryTime();
				driver=new ChromeDriver(option);
				driver.get("https://ezconv.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				j=0;
			}j++;
			String xpath="//button[@type='submit' and contains(text(),'Convert')]";
			String downloadXpath="//button[@type='button' and contains(text(),'Download MP3')]";
			String Username=methodCall(i);
			System.out.println((i+2)+" "+Username);
			//clickIt(xpath);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(downloadXpath)));
			clickIt(downloadXpath);
		}
		return temp;
	}
	public static void nextStep(int given)throws Exception {
		int temp=0;//ClearCache.clearCache();
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--headless");
    	option.setExperimentalOption("detach", true);
    	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(option);
		driver.get("https://ezconv.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream file=new FileInputStream("G:\\MyWork\\Salesforce2.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(page);
		int n = sheet.getLastRowNum(); 
		temp=methodForIteration(given,option,n);
		KillChromeDriver.killAll();
		System.out.println("Done "+temp);
		//driver.quit();
	}
	public static void main(String... args)throws Exception {
		int temp=215;//63-85
		for(int i=0;i<10;i++) {
			nextStep(temp);temp=temp+20;
		}
		
	}
}
