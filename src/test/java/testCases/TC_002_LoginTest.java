package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity","Master"})
	public void test_Login()
	{
	
		logger.info("Application logs......");
		logger.info("*** Starting TC_002_LoginTest ***");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickLogin();
			logger.info("Clicked on Login link");
			
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering Login details");
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			Assert.assertEquals(targetPage, true,"Invalid credentials");
			logger.info("Successfully logged in");
			
			map.clickMyAccount();
			map.clickLogout();
			logger.info("Successfully logged out");
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}
		
		logger.info("*** Finished TC_002_LoginTest ***");
	}
}
