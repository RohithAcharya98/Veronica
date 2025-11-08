package Testcases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {

	public static void main(String[] args) throws Exception
	{
		System.out.println("Enter the Sheet name : ");
		FileInputStream file=new FileInputStream("G:\\MyWork\\Salesforce.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		XSSFSheet sheet=workbook.getSheet(str);
		//XSSFSheet sheet1=workbook.getSheet("Deepthi");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		XSSFRow current_Row=sheet.getRow(1);
		
		XSSFCell name=current_Row.getCell(1);
		String Username=name.getStringCellValue();
		
		XSSFCell name1=current_Row.getCell(2);
		String Password=name1.getStringCellValue();
		
		driver.findElement(By.id("email")).sendKeys(Username);
		driver.findElement(By.id("pass")).sendKeys(Password);
		workbook.close();
		driver.quit();
	}

}/**/
