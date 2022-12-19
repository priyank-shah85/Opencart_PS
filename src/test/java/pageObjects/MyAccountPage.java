package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy (xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy (xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount_AfterLogin;
	
	@FindBy (xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	//Action Methods
	public boolean isMyAccountPageExists()
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void clickMyAccount()
	{
		lnkMyAccount_AfterLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

}
