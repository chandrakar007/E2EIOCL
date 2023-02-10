package testcases;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.BaseClass;
import dataprovider.DataProviders;
import pageobjects.CustomerProfile;
import pageobjects.LoginPage;


public class LoginPageTest extends BaseClass{
	CustomerProfile cstmrprofile;
	
	

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
//	@Parameters("browser")
//	@BeforeMethod
//	public void setup(String browser) {
//		launchApp(browser);
//	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

	@Test
	public void verifyLoginPage() {
	LoginPage loginpage=new LoginPage();
	cstmrprofile=loginpage.loginApp(prop.getProperty("username"), prop.getProperty("password"));  //This is by usng properties file
	Assert.assertTrue(true);


//	@Test(dataProvider="LoginCredentials", dataProviderClass=DataProviders.class)
//	public void verifyLoginPage(String UserName, String Password) {
//	LoginPage loginpage=new LoginPage();
//	cstmrprofile=loginpage.loginApp(UserName, Password);

		
	
//	@Test(dataProvider="LoginCredentials", dataProviderClass=DataProviders.class)
//	public void verifyLoginPage(Map<String,String> datamap) {
//	LoginPage loginpage=new LoginPage();
//	cstmrprofile=loginpage.loginApp(datamap.get("UserName"),
//			datamap.get("Password"));
	}}
