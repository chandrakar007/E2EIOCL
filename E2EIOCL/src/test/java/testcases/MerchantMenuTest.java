package testcases;

import java.awt.AWTException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import pageobjects.CustomerProfile;
import pageobjects.LoginPage;
import pageobjects.MerchantMenu;

public class MerchantMenuTest extends BaseClass {
	MerchantMenu merchantmenu;
	CustomerProfile customerprofile;

	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
	
	
	@Test(dataProvider="merchantInfo", dataProviderClass=DataProviders.class)
	public void verifMerchantMenu(Map<String,String> datamap) throws AWTException{
		
		LoginPage loginpage=new LoginPage();
	//	MerchantMenu merchantmenu= new MerchantMenu();
		merchantmenu=loginpage.loginAppForMerchant(prop.getProperty("username"), prop.getProperty("password"));
		merchantmenu.navigateToMerchantProfile(datamap.get("Retail Outlet Name"),
				datamap.get("Merchant Type"),
				datamap.get("Dealer Name"),
				datamap.get("Enrolment Category"),
				datamap.get("Address 1"),
				datamap.get("Address 2"),
				datamap.get("Location"),
				datamap.get("Merchant Location Type"),
				datamap.get("PIN Code"),datamap.get("State"),datamap.get("District"),datamap.get("City"),
				datamap.get("State Office"),datamap.get("Divisional Office"),datamap.get("Transport Hub"),
				datamap.get("Market Class"),datamap.get("Market Code"),datamap.get("Field Sales Area"),
				datamap.get("PAN No"),datamap.get("Pin Code"),datamap.get("First Name"),datamap.get("Mobile"),datamap.get("Email"),
				datamap.get("Dealer Code"),datamap.get("Supply Point Code"));
		       // Assert.assertTrue(true);
	
		
		
	}
	
}