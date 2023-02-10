package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionClass;
import base.BaseClass;

public class MerchantMenu extends BaseClass {
	
	public MerchantMenu() 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[normalize-space()='Merchant']")
	WebElement merchant;
	
	@FindBy(xpath="//ul[@class='sub-menu h-100 mm-collapse ng-star-inserted d-block']//a[@class='side-nav-link-ref ng-star-inserted'][normalize-space()='Profile']")
	WebElement merchantprofile;
	
	@FindBy(xpath="//a[@class='btn btn-primary align-items-center']")
	WebElement addmerchant;
	@FindBy(xpath="//div[@class='main ng-star-inserted']//input[@formcontrolname='retailOutletName']")
	WebElement retailOutlet;
	@FindBy(css="ng-select[name='merchantType'] input[type='text']")
	WebElement enterMerchantType;
	@FindBy(xpath="//input[@name='dealer']")
	WebElement dealer;
	@FindBy(xpath="(//input[@type='text'])[8]")
	WebElement enterEnrCategory;
	@FindBy(xpath="//span[normalize-space()='Specific Approval']")
	WebElement selectEnrCat;
	@FindBy(xpath="//input[@value='True']")
	WebElement selectNwRo;
	@FindBy(xpath="//ng-select[@name='address1']//input[@type='text'][1]")
	WebElement address1;
	@FindBy(xpath="//input[@name='address2']")
	WebElement address2;
	@FindBy(xpath="//input[@name='location']")
	WebElement location;
	@FindBy(xpath="//ng-select[@name='merchantTypeLocation']//input[@type='text']")
	WebElement merlocatntype;
	@FindBy(xpath="//input[@role='combobox']")
	WebElement pin;
	@FindBy(xpath="//ng-select[@name='stateName']//input[@type='text']")
	WebElement state;
	@FindBy(xpath="//ng-select[@name='districtName']//input[@type='text']")
	WebElement district;
	@FindBy(xpath="//input[@name='cityName']")
	WebElement city;
	@FindBy(xpath="(//input[@type='text'])[26]")
	WebElement stateOff;
	@FindBy(xpath="(//input[@type='text'])[27]")
	WebElement divoffice;
	@FindBy(xpath="(//input[@type='text'])[29]")
	WebElement transHub;
	@FindBy(xpath="(//input[@type='text'])[30]")
	WebElement marketClass;
	@FindBy(xpath="(//input[@type='text'])[31]")
	WebElement marketCode;
	@FindBy(xpath="(//input[@type='text'])[32]")
	WebElement fieldSaleArea;
	@FindBy(xpath="//div[@id='basic-information']//button[@type='button'][normalize-space()='Next']")
	WebElement nextBtn;
	@FindBy(xpath="//input[@id='pan1']")
	WebElement pan;
	@FindBy(xpath="//div[@class='col-8 mb-2']//input[@formcontrolname='prmtPIN']")
	WebElement pinCode;
	@FindBy(xpath="//div[@class='col-md-8']//button[@type='button'][normalize-space()='Next']")
	WebElement nextBtn2;
	@FindBy(xpath="(//input[@class='form-check-input me-3'])[1]")
	WebElement sameasRoCheck;
	@FindBy(xpath="//div[@id='contact-details']//input[@formcontrolname='merchant_ContactPersonFirstName']")
	WebElement firstName;
	@FindBy(xpath="//input[@formcontrolname='merchant_contactPersonAddress_MobilePhone']")
	WebElement mobile;
	@FindBy(xpath="(//input[@type='text'])[50]")
	WebElement email;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='Next'])[3]")
	WebElement nextBtn3;
	@FindBy(xpath="//input[@formcontrolname='merchant_ERPCode']")
	WebElement delearCode;
	@FindBy(xpath="//input[@formcontrolname='merchant_SupplyLocationCode']")
	WebElement spointCode;
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement saveBtn;
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement saveMsg;
	


	public void navigateToMerchantProfile(String ROName, String MerchantType, 
			String DealerName, String EnrCategory,
			String adrs1,String adrs2,
			String Locatn,String merlocType,
			String pincode,String State, String District, String City,String StOffice,String DivOffc,
			String TransHub,String MarketClass,String MarketCode, String FieldSalesArea, String Pan, String Pin,
			String FirstName,String Mobile, String Email,String DealerCode,String SPointCode) throws AWTException {
		
		  Robot rb=new Robot();

		  ActionClass.click(driver,merchant);
    	  ActionClass.click(driver,merchantprofile);
    	  ActionClass.click(driver,addmerchant);
    	  ActionClass.type(retailOutlet, ROName);
    	  ActionClass.type(enterMerchantType, MerchantType);
    	  rb.keyPress(KeyEvent.VK_ENTER);
          rb.keyRelease(KeyEvent.VK_ENTER);
    	  ActionClass.type(dealer, DealerName);
    	  ActionClass.type(enterEnrCategory, EnrCategory);
    	//  Enter 
    	  rb.keyPress(KeyEvent.VK_ENTER);
    	  rb.keyRelease(KeyEvent.VK_ENTER);
    	  ActionClass.click(driver,selectNwRo);
    	//to perform Scroll on application using Selenium

    	  ActionClass.type(address1, adrs1);
      	  rb.keyPress(KeyEvent.VK_ENTER);
      	  rb.keyRelease(KeyEvent.VK_ENTER);
    	  ActionClass.type(address2, adrs2);
    	  ActionClass.type(location, Locatn);
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  js.executeScript("window.scrollBy(0,450)", "");
    	  ActionClass.type(merlocatntype, merlocType);
    	  rb.keyPress(KeyEvent.VK_ENTER);
  	      rb.keyRelease(KeyEvent.VK_ENTER);
  	      ActionClass.type(pin, pincode);
  	      rb.keyPress(KeyEvent.VK_ENTER);
	      rb.keyRelease(KeyEvent.VK_ENTER);
  	      ActionClass.type(state, State);
  	      rb.keyPress(KeyEvent.VK_ENTER);
	      rb.keyRelease(KeyEvent.VK_ENTER);
	      ActionClass.type(district, District);
  	      rb.keyPress(KeyEvent.VK_ENTER);
	      rb.keyRelease(KeyEvent.VK_ENTER);
	      ActionClass.type(city, City);
	      JavascriptExecutor js1 = (JavascriptExecutor) driver;
    	  js.executeScript("window.scrollBy(0,350)", "");
	      ActionClass.type(stateOff, StOffice);
  	      rb.keyPress(KeyEvent.VK_ENTER);
	      rb.keyRelease(KeyEvent.VK_ENTER);
	      ActionClass.type(divoffice, DivOffc);
  	      rb.keyPress(KeyEvent.VK_ENTER);
	      rb.keyRelease(KeyEvent.VK_ENTER);
	      ActionClass.click(driver, transHub);
	      ActionClass.type(transHub, TransHub);
	      rb.keyPress(KeyEvent.VK_ENTER);
    	  rb.keyRelease(KeyEvent.VK_ENTER);
	      ActionClass.type(marketClass, MarketClass);
	      rb.keyPress(KeyEvent.VK_ENTER);
    	  rb.keyRelease(KeyEvent.VK_ENTER);
	      ActionClass.type(marketCode, MarketClass);
	      rb.keyPress(KeyEvent.VK_ENTER);
    	  rb.keyRelease(KeyEvent.VK_ENTER);
	      ActionClass.type(fieldSaleArea, FieldSalesArea);
	      rb.keyPress(KeyEvent.VK_ENTER);
    	  rb.keyRelease(KeyEvent.VK_ENTER);
    	  ActionClass.click(driver, nextBtn);
    	  ActionClass.type(pan, Pan);
    	  ActionClass.type(pinCode, Pin);
    	  nextBtn2.click();
    	  sameasRoCheck.click();
    	  JavascriptExecutor js2 = (JavascriptExecutor) driver;
      	  js.executeScript("window.scrollBy(0,450)", "");
    	  ActionClass.type(firstName, FirstName);
    	  ActionClass.type(mobile, Mobile);
    	  ActionClass.type(email, Email);
    	  nextBtn3.click();
    	  ActionClass.type(delearCode, DealerCode);
    	  ActionClass.type(spointCode, SPointCode);
    	  saveBtn.click();
    	  saveMsg.click();
    //	  ActionClass.click(driver, nextBtn2);
    	 // ActionClass.click(driver, sameasRoCheck);
	      
    	  

    	  
    	  
		
	}
      }