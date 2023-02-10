package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionClass;
import base.BaseClass;


public class CusMenu extends BaseClass {
	
	
	public CusMenu() 
	{
		PageFactory.initElements(driver, this);
//		PageFactory.initElements(getDriver(), this);
	}
	
//	   By dashIcon= By.xpath("//i[@class='fa fa-tachometer']");
	  
	   @FindBy(xpath="//span[normalize-space()='Customer']")
	   WebElement cstmr;
	   
	   @FindBy(xpath="//a[normalize-space()='Cards']")
		WebElement card;
	   
	   @FindBy(xpath="//ul[@class='sub-menu h-100 mm-collapse ng-star-inserted d-block']//a[@class='side-nav-link-ref ng-star-inserted'][normalize-space()='Profile']")
	   WebElement profile;
	   
	   @FindBy(xpath="//a[@class='btn btn-primary align-items-center ng-star-inserted']")
	   WebElement addcstmr;
	   
	   @FindBy(xpath="//div[@class='main']//input[@id='pan1']")
	   WebElement enterPan;
	   @FindBy(css=".ng-pristine.ng-valid.ng-touched")
	   WebElement enterPin;
	   @FindBy(xpath="//input[@id='pan1'][1]")
	   WebElement clickPan;
	   @FindBy(xpath="//input[@id='pan1'][1]")
	   WebElement AgainnPan;	
	   @FindBy(xpath="//button[@type='button'][text()='Confirm']")
	   WebElement confirmBtn;
	   @FindBy(xpath="(//input[@type='text'])[5]")
	   WebElement customerType;
	   @FindBy(xpath="(//input[@type='text'])[6]")
	   WebElement subcustomerType;
	   @FindBy(xpath="(//input[@type='text'])[7]")
	   WebElement stateOffice;	
	   @FindBy(xpath="(//input[@type='text'])[8]")
	   WebElement divisionOfc;
	   @FindBy(xpath="(//input[@type='text'])[9]")
	   WebElement trnsprtHub;
	   
	
	
	      public void navigateToAddCustomer() {
		  ActionClass.click(driver,cstmr);
		  ActionClass.click(driver,profile);
		  ActionClass.click(driver,addcstmr);
		
	}
	
	   public void customerProfile(String PAN,String PIN, 
				String CustomerType,
				String SubCustomerType,
				String Stateoffice,
				String DivisionOffice,
				String TransportHub) throws InterruptedException, AWTException {
		   
		    ActionClass.click(driver,cstmr);
		    ActionClass.click(driver,profile);
		    ActionClass.click(driver,addcstmr);
		    ActionClass.type(enterPan, PAN);
		    ActionClass.type(enterPin, PIN);
		    
		    
		    WebElement fileUpload= driver.findElement(By.xpath("//div[@class='main']//input[@type='file']"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",fileUpload);
			
			  Robot rb=new Robot();
			  rb.delay(2000);  
		//  put path to file in a clipboard
			StringSelection ss= new StringSelection("F:\\IOCL_Automation_Data\\Logo\\imageiocl.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//  CTRL+V
		 	rb.keyPress(KeyEvent.VK_CONTROL); //Press on CTRL key
		 	rb.keyPress(KeyEvent.VK_V); //Press on CTRL key

		 	rb.keyRelease(KeyEvent.VK_CONTROL); //Press on CTRL key
		 	rb.keyRelease(KeyEvent.VK_V); //Press on CTRL key		 
		//  Enter 
		 	rb.keyPress(KeyEvent.VK_ENTER);
		 	rb.keyRelease(KeyEvent.VK_ENTER);		 	
		   Thread.sleep(10);
		   //driver.findElement(By.xpath("//div[@class='main']//button[@type='button'][normalize-space()='Upload']")).click();
		   driver.findElement(By.xpath("//div[@class='main']//button[@type='button'][normalize-space()='Upload']")).click();
//		   
		  ActionClass.click(driver, confirmBtn);
//		  ActionClass.type(customerType, CustomerType);
//		  ActionClass.type(subcustomerType, SubCustomerType);
//		  ActionClass.type(stateOffice, Stateoffice);
//		  ActionClass.type(divisionOfc, DivisionOffice);
//		  ActionClass.type(trnsprtHub, TransportHub);
		    
		    
	   }}
	   
//		public boolean addCustomerBtn() {
//			// TODO Auto-generated method stub
//			 return ActionClass.isDisplayed(driver, addcstmr);
//		
//		}	    
//		public CustomerProfile addCustomer() {
//			
//			 ActionClass.click(driver,addcstmr);
//			 return new CustomerProfile();
//		}
//			
//			public ManageCard CardSection() {
//				
//				ActionClass.click(driver,cstmr);
//				ActionClass.click(driver,card);
//		        ManageCard managecard=new ManageCard();
//		        return managecard;
//			    }

		
		       	
		   
//		   type(InputUsername,userName);
//			type(Inputpswd,password);
			
		   
		   



