package Testcases;

import java.time.LocalDate;
import java.util.Calendar;

import org.openqa.selenium.By;

public class TicketBooking extends Chanllenge
{
	public static String str=todayDate();
	public static void booking()throws Exception
	{
		String fromPlace="//input[@placeholder='Where from?']";
		String fromPlace1="//div/p[contains(text(),'(BLR)')]";
		String toPlace="//input[@placeholder='Where to?']";
		String toPlace1="//div/p[contains(text(),'(HYD)')]";
		if(findingElement(fromPlace)) 
		{
			sendingParameters(fromPlace, "Bangalore");
			clickingXpath(fromPlace1);
			sendingParameters(toPlace, "Hyderabad");
			clickingXpath(toPlace1);
		}
		String date="//div[@class='flex flex-middle p-relative homeCalender']/button[1]";
		int month=conversion(str,9,8)+14;
		String day=daysOfWeek(month,8,2023);
		
		String str="//div[@aria-label='"+day+" Aug "+month+" 2023']";
		String returnDay=daysOfWeek(month+1,8,2023);
		int returnDay1=month+1;
		String returnXpath="//div[@aria-label='"+returnDay+" Aug "+returnDay1+" 2023']";
		clickingXpath(date);
		Thread.sleep(3000);
		clickingXpath(str);
		String returnbutton="//div[contains(text(),'Return')]";
		String searchbutton="//span[contains(text(),'Search flights')]";
		clickingXpath(returnbutton);
		clickingXpath(returnXpath);
		clickingXpath(searchbutton);
		clickingXpath("//div[10]/div[1][@class='p-relative']/button/div");
		clickingXpath("//*[@id=\"root\"]/div/header/div[2]/div/div/div/div/div[10]/div/div/ul/li[2]/ul/li[3]");
		clickingXpath("//*[@id=\"root\"]/div/header/div[2]/div/div/div/div/div[10]/div/div/ul/div[3]/button");
		clickingXpath("//*[@id=\"root\"]/div/header/div[2]/div/div/div/div/div[12]/button");
		Thread.sleep(3000);
		clickingXpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div[2]/button/span");
	}
	
	public static String daysOfWeek(int day,int month,int year)
	{
		Calendar c=Calendar.getInstance();
		c.set(year,month-1,day);
		String[] days=new String[] {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		int n;
		n=c.get(c.DAY_OF_WEEK);
		System.out.println(days[n-1]);
		return days[n-1];
	}
	public static void result()
	{
		int c=conversion(str,9,8);
		int b=conversion(str,6,5);
		System.out.println(c+" "+b);
		daysOfWeek(19,8,2023);
	}
	public static boolean findingElement(String str)
	{
		boolean b=false;
		if(driver.findElements(By.xpath(str)).size()!=0)
		{b=true;}
		else {System.out.println("No Xpath");}
		return b;
	}
	public static void sendingParameters(String str,String str1)
	{driver.findElement(By.xpath(str)).sendKeys(str1);}
	public static void clickingXpath(String str)throws Exception
	{Thread.sleep(1000);driver.findElement(By.xpath(str)).click();}
	public static String todayDate()
	{
		 LocalDate myObj = LocalDate.now(); // Create a date object
		 String str1=myObj.toString();
		// System.out.println(myObj); // Display the current date
		return str1;
	}
	public static int conversion(String str1,int e,int f)
	{
		 char a=str1.charAt(e);
		 int i1=Character.getNumericValue(a);
		 char b=str1.charAt(f);
		 int i3=Character.getNumericValue(b);
		 int i2=i1*1;
		 int c=i3*10+i2;	 
		 return c;
	}
	public static void changeDateValue(String str)
	{
		
	}
	
}
