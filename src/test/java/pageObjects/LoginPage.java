package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy (xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement btnLogin;
	
	//Action Methods
	public void setEmail (String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword (String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	

}
