package Testcases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshot 
{

	public static void main(String[] args)throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//html/body/button")).click();
		
		//((JavascriptExecutor) driver).executeScript("");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid red'",driver.findElement(By.id("mySubmit")));
		//driver.switchTo().defaultContent();
		
		/*List<WebElement> frames=(List<WebElement>) driver.findElement(By.tagName("iframe"));
		
		System.out.println(frames.size());
		
		for(WebElement frame: frames)
		{
			System.out.println(frame.getAttribute("id"));
		}*/
		
		File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File(".//screenshot//Pradeep.jpg"));
		
	}
}
