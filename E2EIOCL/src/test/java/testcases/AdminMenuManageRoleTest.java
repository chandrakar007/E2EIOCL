package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.AdminMenu;
import pageobjects.AdminMenuManageRole;
import pageobjects.LoginPage;
import utility.Log;

public class AdminMenuManageRoleTest extends BaseClass {

	AdminMenu adminmenu;
	AdminMenuManageRole adminMenuManageRole;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@Test
	public void verifyAdminMenuManageRole() throws InterruptedException {
		Log.startTestCase("verifyAddUser");
		LoginPage loginpage = new LoginPage();
		Log.info("User is going to click on SignIn");
		adminMenuManageRole = loginpage.loginAppForAdminManageRole(prop.getProperty("username"),
				prop.getProperty("password"));
		Log.info("User enter username and password");
		adminMenuManageRole.security();
		Log.info("User click on security");
		adminMenuManageRole.manageRole();
		Log.info("User click on Manage Role Option");

		String AllDisplayCount = adminMenuManageRole.TotalRecords();
		String expecetedMsg = "Total 119 Records Found";

		if (AllDisplayCount.contains(expecetedMsg)) {
			Assert.assertTrue(true);
			System.out.println(AllDisplayCount);
		}

		else {

			Assert.assertTrue(false, "Total record not match with actual records");
			// Assert.assertTrue(false);
			// System.out.println("User exists");
		}
		adminMenuManageRole.getRoleNames();
		Log.endTestCase("verifyAdminMenuManageRole");

	}
}