package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.AccountConfirmation;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups = {"Regression","Master"})
	public void test_Account_Registration()
	{
		logger.info("Application logs......");
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@test.com");
		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked on Continue");
		
		AccountConfirmation ma = new AccountConfirmation(driver);
		String confmsg = ma.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
		}
		
		catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}
		
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}
	
}
