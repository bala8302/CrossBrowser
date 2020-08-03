package CrossBrowser.CrossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	
	public static WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Test calling");
	}
	
	@Test(invocationCount=2)
	public void testing()
	{
		System.out.println("uname");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
	}
	
	@AfterMethod
	public void afterMethd()
	{
		driver.quit();
	}

}
