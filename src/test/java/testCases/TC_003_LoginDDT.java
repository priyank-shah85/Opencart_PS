package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email, String password, String exp)
	{
		logger.info("Application logs......");
		logger.info("*** Starting TC_003_LoginDDT ***");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickLogin();
			logger.info("Clicked on Login link");
			
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering Login details");
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			
			if (exp.equals("Valid"))
			{
				if (targetPage == true)
				{
					map.clickMyAccount();
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.fail();
				}
			}
			
			if (exp.equals("Invalid"))
			{
				if (targetPage == true)
				{
					map.clickMyAccount();
					map.clickLogout();
					Assert.fail();
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		
		catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}
		
		logger.info("*** Finished TC_003_LoginDDT ***");
	}

}
