package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollIntoViewJs
{
	   public static void main(String[] args) throws Exception
	   {
	      WebDriverManager.chromedriver().setup();
	      WebDriver driver = new ChromeDriver();
	      driver.get("https://www.wikipedia.org/");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	      
	      Thread.sleep(2000);
	      WebElement element=driver.findElement(By.xpath("//div[13][@class='other-project']"));
	      //JavascriptExecutor js= (JavascriptExecutor)driver;
	      //js.executeScript("", element);
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	     
	      String str=driver.findElement(By.xpath("//div[13][@class='other-project']/a/div[2]/span[1]")).getText();
	      System.out.println(str);
	      driver.findElement(By.xpath("//div[13][@class='other-project']")).click();
	   /**/}
	}
