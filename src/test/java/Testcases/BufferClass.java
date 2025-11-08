package Testcases;

import org.openqa.selenium.By;

public class BufferClass extends MainProgram
{
	public static void login() throws Exception
	{
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("fasdfaasdf");//Email
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("fasdfaasdf");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
	}
}