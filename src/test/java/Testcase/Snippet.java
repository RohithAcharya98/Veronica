package Testcase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snippet {
    public static WebDriver driver;

    public static void clickNext() {
    	driver.findElement(By.xpath("//button[@aria-label='Next']/div")).click();
    }
    public static void main(String[] args) throws Exception {
    	try {
    	    // Kill chromedriver.exe directly
    	    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");

    	    // Kill only Chrome instances started by Chromedriver
    	    String cmd = "wmic process where \"name='chrome.exe' and commandline like '%remote-debugging-port%'\" delete";
    	    Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});

    	    System.out.println("Killed Chromedriver and its Chrome instances, manual Chrome untouched.");
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    	/*ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        String url="https://www.instagram.com/mmagic_peach_/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        Thread.sleep(5000); // Let page load
        driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
		driver.findElement(By.name("username")).sendKeys("figerstring1");
		driver.findElement(By.name("password")).sendKeys("lokesh@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Not now')]")).click();

		int j=0;
        String xpath = "//li[@class='_acaz']/div/div/div/div";
        //int totalLinks=driver.findElements(By.xpath(xpath)).size();
        Set<String> uniqueLinks = new HashSet<String>();
        for (int i = 0; i <6*12 ; i++) {//
        	//System.out.println(totalLinks);
            Thread.sleep(8000);
            if (i < 6*12) {//
                try {
                	List<WebElement> freshList = driver.findElements(By.xpath(xpath));
                	if(i%2==0) {
                		//System.out.println(freshList.size());
                		if(i>12) {clickNext();Thread.sleep(3000);}
                    	if((i>2*11)&&(i%2==0)) {clickNext();Thread.sleep(3000);}
                    	if((i>3*10)&&(i%2==0)) {clickNext();Thread.sleep(3000);}
                    	if(i==28) {break;}
	                    freshList.get(i).click();
	                    String str=driver.getCurrentUrl();
	                    System.out.println(str);
	                    uniqueLinks.add(str);
	                    Thread.sleep(10000);
	                    driver.get(url);
                	}
                } catch (Exception e) {System.out.println("Failed at index " + i + ": " + e.getMessage());}
             
            }
            //if(i==10) {driver.quit();}
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Bufferlinks");

        int rowNum = 0;
        for (String link : uniqueLinks) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(link);
        }
        FileOutputStream fileOut = new FileOutputStream("G:\\MyWork\\Salesforce1.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        /**/
        //driver.quit();
    }
}
