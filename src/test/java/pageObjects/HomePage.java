package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{

	public HomePage(WebDriver driver)
	{ 
		super(driver);
	}
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement clickaccount;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement clickregister;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement clicklogin;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement clicklogout;
public void accountbutton() 
{
		
	clickaccount.click();
}
public void registerbutton()
{
	clickregister.click();
}

public void loginbutton() {
	
	clicklogin.click();
}
public void logoutbutton() {
	
	clicklogout.click();
}
}
