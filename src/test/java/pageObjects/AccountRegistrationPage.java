package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(name = "firstname")
	WebElement txtFirstName;
	
	@FindBy(name = "lastname")
	WebElement txtLastName;
	
	@FindBy(name = "email")
	WebElement txtEmail;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
/*	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue; */
	
	//Action Methods
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setPrivacyPolicy() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='agree']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	public void clickContinue() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
	}

}
