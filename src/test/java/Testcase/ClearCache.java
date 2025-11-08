package Testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClearCache {

	public static void clearCache() {
		 WebDriverManager.chromedriver().setup();
	     WebDriver   driver = new ChromeDriver();
	     String url="chrome://settings/clearBrowserData?search=cac";// 
	     driver.get(url);
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
	     try {Thread.sleep(5000);}catch(Exception e) {}
	     driver.quit();

	}

}
