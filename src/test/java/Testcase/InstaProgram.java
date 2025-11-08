package Testcase;


import java.io.FileInputStream;
//import java.net.SocketException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.SessionNotCreatedException;
//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.openqa.selenium.support.mehreen_pirzadaa_divine.thoppul_spy;
//import org.openqa.selenium.support.actress_arakan2024.spicycorner887;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InstaProgram {
	public static WebDriver driver;
	public static String page="trishriyan_forevr";// anikhasurendran363  pallavi_kaadhalan
	public static boolean isXpathPresent(String xpath){
		if(driver.findElements(By.xpath(xpath)).size()!=0){}
		else {return false;}
		return true;
	}
	public static String methodCall(int i)throws Exception {
		FileInputStream file=new FileInputStream("G:\\MyWork\\Salesforce1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(page);
		//int n = sheet.getLastRowNum(); 
		XSSFRow current_Row=sheet.getRow(i+1);
		XSSFCell name=current_Row.getCell(1);
		String Username=name.getStringCellValue();
		driver.navigate().refresh();
		if(i!=0) {Thread.sleep(3000);}
		//Username="https://www.instagram.com/p/DLFFK1OpUG8/?utm_source=ig_web_copy_link&igsh=MzRlODBiNWFlZA==";
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(Username);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		name.setCellValue(""); 
		workbook.close();
		return Username;
	}
	public static void clickIt(String xpath) {
		try {
			WebElement element1=driver.findElement(By.xpath(xpath));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element1);
			element1.click();
		}
		catch(Exception e) {driver.get("https://savefree.app/en#google_vignette");}
	}
	public static void privateDownload(String xpath,String video) {
		driver.findElement(By.xpath(xpath)).click();
		driver.findElement(By.xpath("//input[@id='s_input']")).sendKeys(video);
		
	}
	public static int methodForIteration(int given,ChromeOptions option,int n) throws Exception{
		int temp=0,k=0,j=0;
			for(int i=given;i<n;i++) {temp=i;	
			if(k==30) {DesktopRefresherPS.refreshEveryTime();
			Thread.sleep(30000);break;}k++;
			if(j==3 && i!=0) {
				DesktopRefresherPS.refreshEveryTime();
				driver=new ChromeDriver(option);
				try {driver.get("https://savefree.app/en#google_vignette");}
				catch(Exception e) {driver.navigate().refresh();}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				j=0;
			}j++;
			String xpath="//div[@class='download-items__btn']";
			String privateXpath="//div[@class='error']//a[@href='/en/download-private-instagram']";
			try {
				String Username=methodCall(i);
				System.out.println((i+2)+" "+Username);	
				if(isXpathPresent(privateXpath)) {methodCall(i+1);}//clickIt(xpath);}
				//else if(isXpathPresent(xpath)&&!isXpathPresent(privateXpath)) {clickIt(xpath);}
				else {clickIt(xpath);}
				/**/
			}
			catch(NoSuchElementException  e) {}//methodCall(i+1);}
			//catch(TimeoutException e) {methodCall(i+1);clickIt(xpath);}
			/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			List<WebElement> links = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@title='Download Photo']")));
			for(WebElement link : links) {
				Thread.sleep(1000);
				link.click();
				Thread.sleep(1000); 
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			}
			/**/
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
		driver.get("https://savefree.app/en#google_vignette");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream file=new FileInputStream("G:\\MyWork\\Salesforce1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(page);
		int n = sheet.getLastRowNum(); 
		temp=methodForIteration(given,option,n);
		KillChromeDriver.killAll();
		System.out.println("Done "+temp);
		//driver.quit();
	}
	public static void main(String... args)throws Exception {
		int temp=2019;
		for(int i=0;i<30;i++) {
			nextStep(temp);temp=temp+30;
		}
		
	}
}
