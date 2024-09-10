package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
@Test(groups = {"Sanity","Master"})// master means all test cases
public  void Verify_Login()
{
   logger.info("**** starting TC002_LoginTest *****");
   try {
   //homepage
   HomePage hp=new HomePage(driver)	;
   hp.accountbutton();
   hp.loginbutton();
   //loginpage
   LoginPage lp= new LoginPage(driver);
   lp.username(p.getProperty("Email"));
   lp.password(p.getProperty("passWord"));
   lp.submitbutton();
   //my account
   MyAccountPage ma=new MyAccountPage(driver);
   boolean targetpage=ma.isMyAcountPageExists();
  // Assert.assertEquals(targetpage, true,"login fails");
   Assert.assertTrue(targetpage);
   } catch (Exception e) {
	  Assert.fail();
	}
   logger.info("**** ending TC002_LoginTest *****");
}
}
