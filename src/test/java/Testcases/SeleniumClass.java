package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumClass
{
	public static void main(String... args)throws Exception
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incongnito");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Way2Automation: Get Online Selenium Certification Course')]"))).click();

		WebElement menu=driver.findElement(By.xpath("//li[@id='menu-item-27617']/a/span[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(menu).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Practice Site 1")).click();/**/
	}
	
}
//div[@class='BYM4Nd']//div/span[@jscontroller='msmzHf']/a/h3 




