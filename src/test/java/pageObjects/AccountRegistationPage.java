package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistationPage extends BasePage {
	
	public AccountRegistationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath =  "//input[@name='firstname']")
	WebElement firstname;
	@FindBy(xpath =  "//input[@name='lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@name='confirm']")
	WebElement conformpassword;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement privacy;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement clickoncontinue;
	@FindBy(xpath = "//div[@id='content']/p")
	WebElement msgconformation;
	
public void firstname(String Fname)
{
	firstname.sendKeys(Fname);
}
public void lastname(String Lname)
{
	lastname.sendKeys(Lname);
}
public void Emailid(String Email)
{
	email.sendKeys(Email);
}
public void Telephone(String Tphone)
{
	telephone.sendKeys(Tphone);
}
public void password(String Pword)
{
	password.sendKeys(Pword);
}
public void confirmpassword(String CPwd)
{
	conformpassword.sendKeys(CPwd);
}
public void privacypolicy()
{
	privacy.click();
}
public void continuebutton()
{
	clickoncontinue.click();
//	clickoncontinue.submit();
//	clickoncontinue.sendKeys(Keys.RETURN);
}
public String msgconform()
{
    try {
    	return(msgconformation.getText());	// if register done successfully  conform message is displayed 
	} catch (Exception e) {
		return(e.getMessage());// if register  not done successfully  exception is displayed
	}
	
}

}
