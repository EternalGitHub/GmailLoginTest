package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class RegisterPage extends TestBase
{

	@FindBy(name ="registration-firstname-field")
	WebElement firstname;
	
	@FindBy(xpath = "//span[text()='Please enter your first name']")
	WebElement fnameRequired;
	
	@FindBy(name= "registration-lastname-field")
	WebElement lastname;
	
	@FindBy(id = "hint-message")
	WebElement ferror;

//	@FindBy(xpath = "//input[@value='Male']")
//	WebElement gender;
	
	@FindBy(name="registration-email-field")
	WebElement useremail;
	
	@FindBy(name ="registration-password-field")
	WebElement userpassword;
	
	@FindBy(xpath = "//button[@data-auto-id='registration-submit-button']")
	WebElement registerbtn;
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void userDetails(String fname, String lname) throws InterruptedException
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		Thread.sleep(1000);
	}
	
	public void genderselect()
	{
		List<WebElement> radio = driver.findElements(By.xpath("//label[@class='gl-radio-input__option']"));
		int gender = radio.size();
		System.out.println(radio.size());
		
		for(int i=0;i<=gender;i++)
		{
			String val = radio.get(i).getAttribute("value");
			
			if(val.equalsIgnoreCase("Male"))
			{
				radio.get(i).click();
				break;
			}
		}
		
		WebElement male = driver.findElement(By.xpath("//span[text()='Male']"));
		
		male.click();

	}
	public String firstnameRequired()
	{
		String actual = fnameRequired.getText();
		return actual;
	}
	public String usererror()
	{
		String actual = ferror.getText();
		return actual;
	}
		
	public void LoginDetails(String email, String pass) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement login = driver.findElement(By.xpath("//h5[text()='Login details']"));
		js.executeScript("arguments[0].scrollIntoView(true);",login);
		useremail.sendKeys(email);
		userpassword.sendKeys(pass);
	}
	
	public void checkTerms()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		List<WebElement> checkList = driver.findElements(By.xpath("//div[@class='gl-checkbox']"));
		js.executeScript("arguments[0].scrollIntoView(true);",checkList);
		for(WebElement list : checkList)
		{
			list.click();
		}
	
	}
	
	public void checked()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement check = driver.findElement(By.name("persistentLogin"));
		js.executeScript("arguments[0].scrollIntoView(true);",check);
		check.isSelected();
		check.click();
	}
	
	public void clickRegister()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",registerbtn);
		registerbtn.click();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
