package normalPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NormalClass {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("rafgu");
		driver.findElement(By.id("input-lastname")).sendKeys("vam");
		driver.findElement(By.id("input-email")).sendKeys("sjdlsdmsl");
		driver.findElement(By.id("input-telephone")).sendKeys("email");
		driver.findElement(By.id("input-password")).sendKeys("pass");
		driver.findElement(By.id("input-confirm")).sendKeys("cccpass");
	}

}
