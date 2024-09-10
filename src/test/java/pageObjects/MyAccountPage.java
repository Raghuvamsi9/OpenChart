package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath = "//h2[text()='My Account']")// my account page heading
	WebElement msgHeading;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[5]")
	WebElement logout;
	public boolean isMyAcountPageExists()
	{   try {
		 return(msgHeading.isDisplayed()); //true boolean value 
		
	        } 
	catch (Exception e) {
		return false;  // false boolean value
	        }		
	}
public void logout() {
		
		logout.click();
	}
}
