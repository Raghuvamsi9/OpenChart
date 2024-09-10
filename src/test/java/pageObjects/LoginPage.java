package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath = "//input[@name='email']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement submit;
	
public void username(String email) // here mention the string name as per properties file name 
{                                  //string name properties file name must be same
		
	username.sendKeys(email);
}
public void password(String passWord)// here mention the string name as per properties file name
{                                    //string name properties file name must be same
	password.sendKeys(passWord);
}

public void submitbutton() {
	
	submit.click();
}
}
