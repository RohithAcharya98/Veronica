package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceTest 
{
	public static WebDriver driver;
	public static void account()
	{
		driver.findElement(By.xpath("/html/body/div[4]/div/section/div/div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")).click();
		driver.findElement(By.xpath("//body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/button[2]")).click();	
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/article/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div/a")).click();
		driver.findElement(By.xpath("//a [@title=\"Mr.\"]")).click();
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/div/article/div[3]/div/div/div/div/div[2]/div/div/div/fieldset/div/div[2]/input")).sendKeys("Rohit");
		
		//driver.findElement(By.id("239:1470;a")).sendKeys("Mulampaka");
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/fieldset/div/div[4]/input")).sendKeys("Mulampaka");
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/div/article/div[3]/div/div/div/div/div[12]/div/div/div/div/input")).sendKeys("8996452");
		//driver.findElement(By.xpath("//input[@id='1005:1470;a']")).sendKeys("5648945");
		
	}
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://jnbank--jnjafull.my.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("robinsonb@jnbank.com.jnjafull");
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).sendKeys("Godisgood333");
		Thread.sleep(2000);
		
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		account();
	}

}
