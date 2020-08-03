package CrossBrowser.CrossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrows extends ExcelRead {
	
	public static String browsername;
	public static WebDriver driver;
	
	@BeforeMethod
	public void gettingBrowserName()
	{
		System.out.println("Hello invoking  browser");
		browsername = System.getProperty("browserName");
		System.out.println("browsername"+browsername);
	}
	
	@Test(dataProvider="testDPCheck",dataProviderClass=ExcelRead.class)
	public void invokeBrowser(String uname,String pwd,String address)
	{
		switch(browsername)
		{
		   case "Chrome":
			   WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver();
			   break;
			   
		   case "firefox":
			   WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver();
			   break;
			   
			default : 
				System.out.println("Give the correct value");
		
		}
		
		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(uname);
	}
	
	/*@Test(dataProvider="testDPCheck",dataProviderClass=ExcelRead.class)
	public void testDp(String uname,String pwd,String address)
	    { 	
	      System.out.println("uname"+uname);
	      System.out.println("pwd"+pwd);
	      System.out.println("address"+address);
	    }*/
	
	@Test
	public void dependsonMet()
	{
		System.out.println("Depends on methods");
	}
	
	@Test(groups={"smoke"})
	public void dependsongrp()
	{
		
		System.out.println("Depends on groups");
	}

}
