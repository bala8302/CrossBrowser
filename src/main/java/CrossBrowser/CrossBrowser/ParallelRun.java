package CrossBrowser.CrossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelRun extends ExcelRead {
	
	public WebDriver driver;
	@BeforeMethod
	public void beforetest()
	{
		   System.out.println("Before Test calling");
		   
	}
	
	
	@Test(dataProvider="testDPCheck",dataProviderClass=ExcelRead.class)
	public void invokebrowser(String uname,String pwd,String address)
	{
		System.out.println("uname"+uname);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(uname);
	}

}
