package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import freemarker.template.SimpleDate;

// these two are important for logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	/*
	 * for every test cases we need logs so we write logs on baseclass bacause baseclass is
	 * extends all test cases classes 
	 */
	  public static WebDriver driver;
	  public Logger logger;
	  public Properties p;
	  @Parameters({"os","browser"})
	    @BeforeClass(groups= {"sanity","Regression","Master"})
		public void setUp(String os,String browser) throws Throwable
{   
		    //loading properties file
		    FileReader file= new FileReader("./src//test//resources//config.properties");
		    p= new Properties();
		    p.load(file);
		    logger=LogManager.getLogger(this.getClass());// this was dynamcally take the running test case	    
		    if (p.getProperty("execution_env").equalsIgnoreCase("remote")) 
		    {
			  DesiredCapabilities Capabilities=new DesiredCapabilities();
			  //os
			  if (os.equalsIgnoreCase("windows")) 
			     {
				  Capabilities.setPlatform(Platform.WIN11);
			     }
			  else if (os.equalsIgnoreCase("mac")) 
			     {
				  Capabilities.setPlatform(Platform.MAC);
			     }
			  else if (os.equalsIgnoreCase("linux")) 
			     {
				  Capabilities.setPlatform(Platform.LINUX);
			     }
			  else
			     {
				  System.out.println("no matching os ");
			     }
			  //browser
			  switch (browser.toLowerCase())
			  {
			  case "firefox":Capabilities.setBrowserName("firefox");break;
			  case "chrome":Capabilities.setBrowserName("chrome");break;
			  case "edge":Capabilities.setBrowserName("MicrosoftEdge");break;	
			  default:System.out.println("no matching browser");return;
			  }
			  
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), Capabilities);
	     } 
			
	    switch (browser.toLowerCase()) 
		    {
			case "chrome":
				 driver=new ChromeDriver();
				break;
			case "edge":
				 driver=new EdgeDriver();
				break;
			case "firefox":
				 driver=new FirefoxDriver();
				break;
			default:
				System.out.println("no browser");
			//	break;// if we use break means it goes in side the remaining program ,it will not comes out of program if browser is no there
				return;//if we use return means it will comes out of program if browser is no there
			}
	        
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appUrl"));
			driver.manage().window().maximize();
	  }

	    @AfterClass(groups= {"sanity","Regression","Master"})
		public void tearDown()
		{   
			driver.quit();
		}
	    public String randomstring()
	    {    
	      String generatedString=RandomStringUtils.randomAlphabetic(5);
	    	return generatedString;
	    	
	    }
	    public String randomnumber()
	    {    
	      String generatedNumber=RandomStringUtils.randomNumeric(10);
	    	return generatedNumber;
	    	
	    }
	    public String randomAlphaNumeric()
	    { 
	      String generatedString=RandomStringUtils.randomAlphabetic(3);   
	      String generatedNumber=RandomStringUtils.randomNumeric(3);
	    	return (generatedString+"@"+generatedNumber);
	    	
	    }
	    public String captureScreen(String tname)
	    {
	    	String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	    	TakesScreenshot takesScreenShot=(TakesScreenshot)driver;
	    	File sourceFile=takesScreenShot.getScreenshotAs(OutputType.FILE);
	    	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
	    	File targetFile=new File(targetFilePath);
	    	sourceFile.renameTo(targetFile);
			return targetFilePath;// this return  will send screenshot to report otherwise it was in screenshot folder
	    	
	    }
}
