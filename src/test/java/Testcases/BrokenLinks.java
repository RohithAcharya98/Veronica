package Testcases;
 
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BrokenLinks {
 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebElement element=driver.findElement(By.xpath(""));
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total Links : "+links.size());
		Set<String> urls=new HashSet<String>();
		for(WebElement link : links) {
			String url= link.getAttribute("href");
			if(url==null||url.isEmpty()||url.startsWith("javascript")||url.startsWith("mailto")||url.contains("#")) {
				continue;
			}
			urls.add(url);
		}
	       for (String url : urls) {
	            try {
	                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
	                connection.setRequestMethod("GET");
	                connection.connect();
	                int statusCode = connection.getResponseCode();
 
	                if (statusCode >= 400) {
	                    System.out.println("🔴 Broken Link: " + url + " | Status: " + statusCode);
	                } else {
	                    System.out.println("🟢 Valid Link:  " + url + " | Status: " + statusCode);
	                }
 
	            } catch (Exception e) {
	                System.out.println("❌ Error Checking: " + url + " | Exception: " + e.getMessage());
	            }
	        }
		System.out.println("Total Unique Usable URLs :"+urls.size());
		System.out.println("Checking each Link Status ");
		driver.quit();
 
	}
 
}