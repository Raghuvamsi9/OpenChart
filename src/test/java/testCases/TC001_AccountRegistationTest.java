package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObjects.AccountRegistationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistationTest extends BaseClass{
    @Parameters({"os","browser"})
    @Test(groups = {"Sanity","Master"})// master means all test cases
    public void AccountRegistationTest()
    {
    logger.info("***** starting TC001_AccountRegistation_Test*****");
    // in case there is exception try and catch block is executes
    try {
    HomePage h=new HomePage(driver);
    h.accountbutton();
    logger.info("clicking on my account link");
    h.registerbutton();
    logger.info("clicking on my register link");
    AccountRegistationPage p=new AccountRegistationPage(driver);
    logger.info("providing customer details");
    p.firstname(randomstring().toUpperCase());
    p.lastname(randomstring().toUpperCase());
    p.Emailid(randomstring()+"@gmail.com");
    p.Telephone(randomnumber());
    String password=randomAlphaNumeric();
    p.password(password);
    p.confirmpassword(password);
    p.privacypolicy();
    p.continuebutton();
    logger.info("validating expected message");
    String conformMessage=p.msgconform();
    System.out.println(conformMessage);
    if (conformMessage.equals("Congratulations! Your new account has been successfully created!"))
    {
		Assert.assertTrue(true);
	} 
    else // if there is any fails or mismatches then else block will executes then test will fail
    {
		logger.info("Test is failed...");
		logger.debug("Debug logs...");
		Assert.assertTrue(false);
	}
 //   Assert.assertEquals(conformMessage,"Congratulations! Your new account has been successfully created!" );
    }
    //incase there is exception then catch block is executed
    catch (Exception e) {
		logger.info("Test is failed...");
		logger.debug("Debug logs...");
		Assert.fail();// we want to execute catch block need fail by assertion because blocks are executes
		              //in testng (if bock is pass or fail)
	}
    logger.info("***** ending TC001_AccountRegistation_Test*****");
    }
    
}
