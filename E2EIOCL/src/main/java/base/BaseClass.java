package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import actiondriver.ActionClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentManager;


public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static WebDriver wait;

	
	
	   @BeforeSuite
	   public void beforeSuite() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
//	}
//	
//	    @BeforeTest
//		public void loadConfig() {

			try {
				prop = new Properties();
				System.out.println("super constructor invoked");
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(fis);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("deprecation")
		public static void launchApp() {
//		public static void launchApp(String browserName) {   // This browserName is coming from testng.xml file for browser launch
		   	 WebDriverManager.chromedriver().setup();
		   	String browserName = prop.getProperty("browser");
		   	
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
				// Set Browser to ThreadLocalMap
//				driver.set(new ChromeDriver());
				
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				
				//WebDriverManager.firefoxdriver().setup();
//				driver.set(new FirefoxDriver());
				
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
//				driver.set(new InternetExplorerDriver());
				
			}
			//Maximize the screen
			driver.manage().window().maximize();
			ActionClass.implicitWait(driver, 10);
			ActionClass.pageLoadTimeOut(driver, 10);
			driver.get(prop.getProperty("url"));
			
		}
		
		@AfterSuite()
		public void afterSuite() {
			ExtentManager.endReport();
		}
	    }
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
////			getDriver().manage().window().maximize();
//			//Delete all the cookies
//			driver.manage().deleteAllCookies();
////			getDriver().manage().deleteAllCookies();
//			//Implicit TimeOuts
//			driver.manage().deleteAllCookies();
////			getDriver().manage().timeouts().implicitlyWait
			
			
//			(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
//			//PageLoad TimeOuts
////			getDriver().manage().timeouts().pageLoadTimeout
//			driver.manage().timeouts().pageLoadTimeout
//			(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
//			//Launching the URL
	
//			getDriver().get(prop.getProperty("url"));
		
		
				
		

//		@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
//		public void afterSuite() {
//			ExtentManager.endReport();


