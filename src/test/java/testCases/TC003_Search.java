package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC003_Search extends BaseClass{
	@Test(groups = {"Sanity","Master"})// master means all test cases
	public  void Search()
	{
	   logger.info("**** starting TC003_Search *****");
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
	   // search
	   SearchPage sp= new SearchPage(driver);
	   sp.search(p.getProperty("searchProductName"));
	   sp.searchEnter();
	   sp.addtocart();
	   String message=sp.addiphonemsg();
	   System.out.println(message);
	   sp.items();
	   sp.viewcart();
	   sp.addshopping();
	   HomePage h=new HomePage(driver);
	   h.accountbutton();
	   h.logoutbutton();
	   logger.info("validating expected message");
	    String conformMessage1=sp.accountlogout();
	    System.out.println(conformMessage1);
	    if (conformMessage1.equals("You have been logged off your account. It is now safe to leave the computer."))
	    {                           
			Assert.assertTrue(true);
		} 
	    else 
	    {
			logger.info("Test is failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
	 //   Assert.assertEquals(conformMessage,"You have been logged off your account. It is now safe to leave the computer" );
	    }
	    //incase there is exception then catch block is executed
	    catch (Exception e) {
			logger.info("Test is failed...");
			logger.debug("Debug logs...");
			Assert.fail();// we want to execute catch block need fail by assertion because blocks are executes
			              //in testng (if bock is pass or fail)
	    }
	   logger.info("**** ending TC003_Search *****");
	}
}
