package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class DropDown {
    public static void main(String[] args)throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        

        // 3. Switch to iframe (W3Schools uses an iframe for examples)
        driver.switchTo().frame("iframeResult");
        WebElement dropdown = driver.findElement(By.id("cars"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Saab");
        Thread.sleep(1000);
        select.selectByValue("audi");
        Thread.sleep(1000);
        select.selectByIndex(0);

        List<WebElement> allOptions = select.getOptions();
        System.out.println("All Dropdown Options:");
        for (WebElement option : allOptions) {
            System.out.println("Option: " + option.getText());
        }

        // 10. Get selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Currently Selected: " + selectedOption.getText());

        boolean isMultiple = select.isMultiple();
        System.out.println("Is Multi-select? " + isMultiple);

        // 12. Deselect methods (only work if multi-select)
        if (isMultiple) {
            select.deselectAll();
            // select.deselectByVisibleText("Volvo");
            // select.deselectByIndex(1);
            // select.deselectByValue("audi");
        }

        driver.quit();
    }
}
