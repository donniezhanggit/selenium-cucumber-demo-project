package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.actions.Navigation;

public class SeleniumDriver {

	private static SeleniumDriver SeleniumDriver;

	private static WebDriver driver;
	public static WebDriverWait wait;
	private final static int timeOut = 10;
	public static JavascriptExecutor js = null;
	public static Navigation nav;

	private SeleniumDriver() {
		

		if (Constants.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

		} else if (Constants.browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (Constants.browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.implictWait, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, timeOut);
		nav = new Navigation(driver);
		js = (JavascriptExecutor) driver;

	}

	

	public static void openPage(String url) {
		driver.get(url);
	}

	public static void setupDriver() {
		if (SeleniumDriver == null) {
			SeleniumDriver = new SeleniumDriver();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void tearDown() {
		if (SeleniumDriver != null) {
			driver.close();
			driver.quit();
			SeleniumDriver = null;
		}
	}

}
