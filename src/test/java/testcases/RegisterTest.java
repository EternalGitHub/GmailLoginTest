package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.RegisterPage;

public class RegisterTest extends TestBase {

	RegisterPage rp = new RegisterPage();
	TestBase tb = new TestBase();

	// To Initialize the Properties of TestBase Class Create Constructor
	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		tb.initialization();
		tb.Registerurl();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void userDetails() throws InterruptedException
	{
		RegisterPage rp = new RegisterPage();
		rp.userDetails(prop.getProperty("firstname"), prop.getProperty("lastname"));
		rp.clickRegister();

		String actual = rp.usererror();
		String expected = prop.getProperty("usererror");
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void verifyfirstname() throws InterruptedException {
		RegisterPage rp = new RegisterPage();
		rp.userDetails(prop.getProperty("blank"), prop.getProperty("lastname"));
		rp.clickRegister();
		
		String actual = rp.firstnameRequired();
		String expected = prop.getProperty("ferror");
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void selectGender() throws Exception
	{
		RegisterPage rp = new RegisterPage();
		rp.genderselect();
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void logindetails() throws InterruptedException
	{
		RegisterPage rp = new RegisterPage();
		rp.LoginDetails(prop.getProperty("username"),prop.getProperty("password"));
		rp.clickRegister();
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void checkallcheckboxes() throws Exception{
		RegisterPage rp = new RegisterPage();
		rp.checkTerms();
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void loginwithAllDetails() throws Exception
	{
		RegisterPage rp = new RegisterPage();
		rp.userDetails(prop.getProperty("firstname"), prop.getProperty("lastname"));
		rp.LoginDetails(prop.getProperty("username"),prop.getProperty("password"));
		rp.genderselect();
		rp.checkTerms();
		rp.clickRegister();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		rp.closeBrowser();
	}

}
