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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnipProgram {

	public static WebDriver driver;
	public static String disturb="//div[@role='dialog']/div/div[2]/div/div/div/div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']";
	public static void clickNext(String xpath) {
    	driver.findElement(By.xpath(xpath)).click();
    }
	public static boolean isXpathPresent(String xpath){
		if(driver.findElements(By.xpath(xpath)).size()!=0){}
		else {return false;}
		return true;
	}
	public static void waitForIt(String xpath) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public static void main(String[] args)throws Exception {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        String url="https://www.instagram.com/sreeleela_2oo1/";// 
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        waitForIt(disturb);
        driver.findElement(By.xpath(disturb)).click();
        driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
		driver.findElement(By.name("username")).sendKeys("figerstring1");
		driver.findElement(By.name("password")).sendKeys("lokesh@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Not now')]")).click();
		
		String xpath = "//li[@class='_acaz']/div/div/div/div";
		String previous="/html/body/div[1]/div/div/div[3]/div/div/div[3]/div/section/div[1]/div/div[5]/div/div[2]/div[1]/div";
		String previous1="/html/body/div[1]/div/div/div[3]/div/div/div[3]/div/section/div[1]/div/div[4]/div/div[2]/div[1]/div/div";
		String nextButton="//button[@aria-label='Next']/div";
		String pause="//div[@class='x78zum5']/div[2]/div";
		
		for(int i=0;i<4;i++) {clickNext(nextButton);Thread.sleep(2000);}
		
		try {Thread.sleep(5000);}catch(Exception e) {}
		//int n=freshList.size();
		for(int i=0;i<60;i++) {
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath(pause)).click();
				Thread.sleep(3000);
				String str=driver.getCurrentUrl();
	            System.out.println(str); clickNext(previous); 
			}catch(Exception e) {
				break;
//				Thread.sleep(1000); clickNext(previous1);
//				String str=driver.getCurrentUrl();
//	            System.out.println(str);
			}
		}
		
		Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Bufferlinks");
        Set<String> uniqueLinks = new HashSet<String>();
        int rowNum = 0;
        for (String link : uniqueLinks) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(link);
        }
        FileOutputStream fileOut = new FileOutputStream("G:\\MyWork\\Salesforce1.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
		
	}

}
