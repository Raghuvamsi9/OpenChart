package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
  @FindBy(xpath = "//input[@placeholder='Search']")WebElement Search;
  @FindBy(xpath = "//i[@class='fa fa-search']")WebElement searchEnter;
  @FindBy(xpath = "//span[normalize-space()='Add to Cart']")WebElement Addtocart;
  @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement sucessfullyaddiphone;
  @FindBy(xpath = "//span[@id='cart-total']")WebElement Items;
  @FindBy(xpath="//strong[normalize-space()='View Cart']")WebElement Viewcart;
  @FindBy(xpath="//a[@class='btn btn-default']")WebElement Addshopping;
  @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")WebElement Accountlogout;
  public void search(String search)
  {
	  Search.sendKeys(search);
  }
  public void searchEnter()
  {
	  searchEnter.click();
  }
  public void addtocart()
  {
	  Addtocart.click();
  }
  public void items() {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();", Items);
  }
  public void viewcart()
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();", Viewcart);
  }
  public void addshopping()
  {
	 Addshopping.click();
  }
public String accountlogout() {
	 try {
		  return (Accountlogout.getText());
	    } 
	 catch (Exception e) {
		return (e.getMessage());	
        }
}
public String addiphonemsg() {
	 try {
		  return (sucessfullyaddiphone.getText());
	    } 
	 catch (Exception e) {
		return (e.getMessage());	
       }
}
}
