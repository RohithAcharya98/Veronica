/*package Testcases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewExample {

	public static void main(String[] args)throws Exception
	{
		WebDriverManager.chromedriver().setup();//abc.txt
		FileInputStream file=new FileInputStream("E:\\Practice.xlsx");//E:\Practice.xlsx
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter sheet name : ");
		String str=br.readLine();
		
		//new NewExample();String str="Deepthi";
		
		XSSFSheet sheet=workbook.getSheet(str);

		WebDriver driver=new ChromeDriver();
		driver.get("https://jnbank--jnjafull.my.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		XSSFRow cRow=sheet.getRow(1);
		XSSFCell name=cRow.getCell(0);
		XSSFCell name1=cRow.getCell(1);
		
		String UN=name.getStringCellValue();
		String PW=name1.getStringCellValue();
		
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys(UN);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(PW);
		
	}

}
/**/