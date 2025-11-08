package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindinElement1
{
	public static WebDriver driver;
	public static boolean isXpathPresent(String xpath)
	{
		if(driver.findElements(By.xpath(xpath)).size()!=0)
		{System.out.println("Element is Present ");}
		else {System.out.println("Element is not Present");return false;}
		return true;
	}
	public static void main(String... args)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String xpath="//a[@id='js-link-box-te']/small";
		String xpath1="//a[@id='js-link-box-en']/small";
		String realXpath="";
		
		
		try {
			driver.findElement(By.xpath(xpath));
		}
		catch(Exception e) {String str=driver.findElement(By.xpath(xpath1)).getText();
		System.out.println(str+" Print the value");}
		
		
		
		
		
		
		
		
		
		
		
		
		if(isXpathPresent(xpath))
		{realXpath=xpath;}
		else {realXpath=xpath1;}
		String str=driver.findElement(By.xpath(realXpath)).getText();
		System.out.println(str);
		
	}
}