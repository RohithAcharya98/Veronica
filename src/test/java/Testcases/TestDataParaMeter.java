/*package Testcases;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDataParaMeter 
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis=new FileInputStream("E:\\Salesforce.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noOfRows = sheet.getLastRowNum();
		System.out.println("The No of Rows in Excel Sheet : "+noOfRows);
		
		XSSFRow current_row=sheet.getRow(1);
		XSSFCell Name=current_row.getCell(2);
		String Title=Name.getStringCellValue();
		
		System.out.println("The Title from Excel sheet is : "+Title);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com");
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Title);
		
		workbook.close();
	}
}
/**/