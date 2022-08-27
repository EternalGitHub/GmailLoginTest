package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase
{
	TestBase tb = new TestBase();
	LoginPage lp = new LoginPage();
	
	@BeforeMethod
	public void setUp()
	{
		
		tb.initialization();
		tb.LoginUrl();
	}
	
	@Test(priority = 1)
	public void titleTest() throws InterruptedException
	{
		String title = lp.loginpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "adidas Online Shop | adidas CA");
		Thread.sleep(1000);
		
	}
	
	@Test(priority = 2)
	public void LogoTest() throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		Boolean flag = lp.validateLogo();
		Assert.assertTrue(flag);
		Thread.sleep(1000);
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(1000);
	}
	
	@Test(priority = 4)
	public void errorMessage()
	{
		LoginPage lp = new LoginPage();
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
		String actual = lp.validateErrormsg();
		String expected = prop.getProperty("error");
		Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void tearDown()
	{
		lp.closebrowser();
	}
}
