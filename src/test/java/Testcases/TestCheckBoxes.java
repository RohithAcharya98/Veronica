package Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckBoxes
{
	public static void main(String... args)throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		//driver.findElement(By.xpath("//input[3][@name='color']")).click();
		List<WebElement> links=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total Checkboxes Count : "+links.size());
		for(WebElement checkbox:links)//for each loop 
		{
			Thread.sleep(1000);
			checkbox.click();
			Thread.sleep(1000);
		}
		for(WebElement checkbox:links)//for each loop 
		{
			Thread.sleep(1000);
			checkbox.click();
			Thread.sleep(1000);
		}/**/
	}
}