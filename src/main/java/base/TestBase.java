package base;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utils.TestUtil;
import utils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver webDriver;
	public static WebEventListener eventlistener;

	// Create Constructor
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream(
					"V:\\Selenium_Workspace\\MavenPOMDataDriven\\src\\main\\java\\config\\config.properties");
			prop.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");

		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "V:/SeleniumJars/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "V:/SeleniumJars/chromedriver.exe");
			driver = new ChromeDriver();
		}
		webDriver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		webDriver.register(eventlistener);
		driver = webDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAG_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	public static void LoginUrl() {
		driver.get(prop.getProperty("LoginUrl"));
	}

	public static void Registerurl() {
		driver.get(prop.getProperty("Registerurl"));
	}
}
