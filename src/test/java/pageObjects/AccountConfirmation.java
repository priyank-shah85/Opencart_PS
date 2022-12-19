package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountConfirmation extends BasePage{

	public AccountConfirmation(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action Methods
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}
		catch (Exception e) {
			return (e.getMessage());
		}
	}

}
