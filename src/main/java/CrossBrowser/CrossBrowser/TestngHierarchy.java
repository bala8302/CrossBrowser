package CrossBrowser.CrossBrowser;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestngHierarchy {
	
	@BeforeSuite
	public void beforesuite()
	{
	 System.out.println("Before Suite");	
	}
	
	@BeforeSuite
	public void beforetest()
	{
		System.out.println("Before Test");
	}

	@BeforeClass
	public void beforeclass()
	{
	  System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
	  System.out.println("Before Method");
	}
	
	@BeforeGroups
	public void beforegroup()
	{
		System.out.println("Before groups");
	}
	
	@Test(dependsOnMethods="dependonmethod",dependsOnGroups="smoke1")
	public void testing()
	{
	  System.out.println("Test");	
	}
	
	@Test
	public void dependonmethod()
	{
		System.out.println("Depends on method");
	}
	
	@Test(groups="smoke1")
	public void grouping()
	{
		System.out.println("depends on group");
	}

	@AfterGroups
	public void aftergroup()
	{
		System.out.println("After groups");
	}
	
}
