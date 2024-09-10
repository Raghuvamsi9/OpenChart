package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider ="LoginData",dataProviderClass = DataProviders.class,groups = "DataDriven")
	public void verify_LoginDDT(String email,String pwd,String expResult)
	{      logger.info("****starting TC003_LoginDDT ****");
	      try
	      {
		 //homepage
		   HomePage hp=new HomePage(driver)	;
		   hp.accountbutton();
		   hp.loginbutton();
		   //loginpage
		   LoginPage lp= new LoginPage(driver);
		   lp.username(email);
		   lp.password(pwd);
		   lp.submitbutton();
		   //my account
		   MyAccountPage ma=new MyAccountPage(driver);
		   boolean targetpage=ma.isMyAcountPageExists();
		   /*
		    * data is valid-login success-test pass-logout
		    *              -login failed-test fail
		    * data is invalid-login success-test fail-logout
		    *                -login failed -test pass            
		    */
		   if(expResult.equalsIgnoreCase("valid")) //data is valid
		   {
			   if (targetpage==true)//login success
			   { 
				 hp.accountbutton();  
				 ma.logout();//logout  after assert nothing will executes
				 Assert.assertTrue(true);//test pass  
			   }
			   else 
			   {
				 Assert.assertTrue(false);//test fail
			   }
		   }
	//	   if(expResult.equalsIgnoreCase("invalid")) //data is valid
		   else
		   {
				if (targetpage==true)//login success
				{ 
				  hp.accountbutton();
				  ma.logout();//logout  after assert nothing will executes
				  Assert.assertTrue(false);//test fail
				}
				else 
				{
				  Assert.assertTrue(true);//test pass -here get both are invalid then it is negative test case that why it pass
				}
		   }
	      } // this try close
		   catch (Exception e) {
			Assert.fail();
		}
	      logger.info("****starting TC003_LoginDDT ****");// if you to execute after assertion also put in finally block
	      
 }
}
