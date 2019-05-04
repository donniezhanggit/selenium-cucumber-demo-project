package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.actions.Navigation;

public class SeleniumDriver {
	
	private static SeleniumDriver SeleniumDriver;
	
	private static WebDriver driver;
	public static WebDriverWait wait ;
	private final static int pageTimeOut = 10;
	private final static int implicitlyWait = 30;
	private final static int timeOut = 10;
	public static JavascriptExecutor js = null;
	public static Navigation nav ;
	
	
	private SeleniumDriver()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pageTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, timeOut);	
		nav = new Navigation(driver);
		js = (JavascriptExecutor) driver;
	
	}
	
	public static void openPage(String url)
	{
		driver.get(url);
	}
	
	public static void setupDriver()
	{
		if(SeleniumDriver==null)
		{
			SeleniumDriver = new SeleniumDriver();
		}
	}
	
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void tearDown()
	{
		if(SeleniumDriver!= null)
		{
			driver.close();
			driver.quit();
			SeleniumDriver = null;
		}
	}

}
