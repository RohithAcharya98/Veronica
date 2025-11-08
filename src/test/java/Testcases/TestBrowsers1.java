package Testcases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers1 
{
	public static String browser="chrome";
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get("https://way2automation.com");
			driver.manage().window().maximize();
		}
		else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://way2automation.com");
			driver.manage().window().maximize();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			EdgeDriver driver=new EdgeDriver();
			driver.get("http://way2automation.com");
			driver.manage().window().maximize();
			
		}
		
		String title=driver.getTitle();
		System.out.println(title+" This page is displayed");
		System.out.println(title.length());
	}
	

}
