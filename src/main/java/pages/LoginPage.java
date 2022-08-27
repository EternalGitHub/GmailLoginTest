package pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase 
{

	//Page Factory 
	@FindBy(name ="login-email")
	WebElement username;
	
	@FindBy(name = "login-password")
	WebElement password;
	
	@FindBy(xpath ="//span[text()='Email Log in']")
	WebElement loginBtn; 
	
	@FindBy(xpath = "//a[@data-auto-id='logo']")
	WebElement logo;
	
	@FindBy(id ="hint-message")
	WebElement error;
	
	//Initializing the page Object
	public LoginPage()
	{
		//this is pointing to current class Object
		//driver is Initialize from testbase class
		PageFactory.initElements(driver,this);
	}
	
	//Actions - Features which are available on LoginPage
	public String loginpagetitle()
	{
		return driver.getTitle();
	}
	
	public Boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public void login(String uname, String pass)
	{
	
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
	}
	
	public String validateErrormsg()
	{
		String actual = error.getText();
		return actual;
		
	}
	
	public void closebrowser()
	{
		driver.quit();
	}
	
	
}
