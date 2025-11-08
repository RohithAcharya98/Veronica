package Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingClass
{
	public static void main(String... args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement block=driver.findElement(By.xpath("//div[@class='other-projects']"));
		//WebElement block=driver.findElement(By.xpath("//*"));
		List<WebElement> links=block.findElements(By.tagName("a"));
		System.out.println("--------Priting Links------");
		System.out.println("Total Links are : "+links.size());
		for(WebElement link:links)
		{
			System.out.println(link.getText()+"----"+link.getAttribute("href"));
		}
		
	}
}