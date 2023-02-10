package testcases;

import java.awt.AWTException;
import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import dataprovider.DataProviders;
import pageobjects.CustomerProfile;
import pageobjects.LoginPage;

public class AddCustomerProfileTest extends BaseClass {
	CustomerProfile customerprofile;

	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
	
	@Test(dataProvider="customerinfo", dataProviderClass=DataProviders.class)
	public void verifyAddCustomer(Map<String,String> datamap) throws InterruptedException, AWTException   {
		LoginPage loginpage=new LoginPage();
		customerprofile=loginpage.loginApp(prop.getProperty("username"), prop.getProperty("password"));  //This is by usng properties file
		customerprofile.navigateToAddCustomer(
				datamap.get("PAN No"),
				datamap.get("Pin Code"),
				datamap.get("Customer Type"),
				datamap.get("Sub Customer Type"),
				datamap.get("State Office"),
				datamap.get("Divisional Office")
				);
    	
	}
	
}
