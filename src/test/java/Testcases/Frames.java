package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames
{
	public static void main(String... args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();//ctrl+shift+o
		driver.get("https://paytm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='app']/header/div[1]/div[2]/div/span")).click();
		System.out.println("Count of frames : "+driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div[2]/a[1]")).click();
	}
}



