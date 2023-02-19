package testcases;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import dataprovider.DataProviders;
import pageobjects.AdminMenu;
import pageobjects.AdminMenuManageRole;
import pageobjects.LoginPage;
import utility.Log;

public class AdminMenuTest extends BaseClass {

	AdminMenu adminmenu;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

//       @Test
//       public void verifyAddUserBtn() {
//    	 	LoginPage loginpage=new LoginPage();
//        	adminmenu=loginpage.loginAppForAdmin(prop.getProperty("username"), prop.getProperty("password")); 
//        	adminmenu.security();
//        	boolean result=adminmenu.addUser();
//        	Assert.assertTrue(result);
//        	adminmenu.clkAddUser();
//	   
//       }
//	

	@Test(dataProvider="addUser", dataProviderClass=DataProviders.class)
	public void verifyAddUser(Map<String, String> datamap) throws AWTException {

		Log.startTestCase("verifyAddUser");
		LoginPage loginpage = new LoginPage();
		Log.info("User is going to click on SignIn");
		adminmenu = loginpage.loginAppForAdmin(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User enter username and password");
		adminmenu.security();
		Log.info("User click on security");
		adminmenu.clkAddUser();
		Log.info("User click on Add User Button");
		adminmenu.addUserForm(datamap.get("User Name"), datamap.get("Email"), datamap.get("Password"),
				datamap.get("Confirm Password"), datamap.get("Secret Question"), datamap.get("Secret Question Answer"),
				datamap.get("Address 1"), datamap.get("City"), datamap.get("PIN Code"), datamap.get("State"),
				datamap.get("District"), datamap.get("Mobile"));

		String actualMsg = adminmenu.getTextmsg();
		String expecetedMsg = "User Added Successfully";
		if (actualMsg.contains(expecetedMsg)) {
			Assert.assertTrue(true);
			System.out.println(actualMsg);
		}

		else {

			Assert.assertTrue(false);
			// System.out.println("User exists");
		}

		Log.endTestCase("verifyAddUser");

	}

	//@Test
	public void verifySearchUser() throws InterruptedException {
		LoginPage loginpage = new LoginPage();
		adminmenu = loginpage.loginAppForAdmin(prop.getProperty("username"), prop.getProperty("password"));
		adminmenu.security();
		 adminmenu.searchUser("test");

	}
}
