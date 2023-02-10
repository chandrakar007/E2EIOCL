package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionClass;
import base.BaseClass;

public class AdminMenu extends BaseClass{

	
	public AdminMenu() 
	{
		PageFactory.initElements(driver, this);
	}

	   @FindBy(xpath="//span[normalize-space()='Admin']")
	   WebElement admin;   
	   @FindBy(xpath="//a[text()=' Security ']")
	   WebElement security;
	   @FindBy(xpath="//button[normalize-space()='Add User']")
	   WebElement addUser;
	   @FindBy(xpath="//input[@formcontrolname='userName']")
	   WebElement userName;
	   @FindBy(xpath="//input[@formcontrolname='email']")
	   WebElement email;
	   @FindBy(xpath="//input[@formcontrolname='password']")
	   WebElement pswd;
	   @FindBy(xpath="//input[@formcontrolname='cnfPassword']")
	   WebElement cnfrmpass;
	   @FindBy(xpath="(//input[@type='text'])[6]")
	   WebElement securityQue;
	   @FindBy(xpath="//input[@formcontrolname='answer']")
	   WebElement securityAns;  
	   @FindBy(xpath="//input[@formcontrolname='addressLine1']")
	   WebElement address1;
	   @FindBy(xpath="//input[@formcontrolname='city']")
	   WebElement city;
	   @FindBy(xpath="(//input[@name='form_number'])[11]")
	   WebElement pinCode;
	   @FindBy(xpath="(//input[@type='text'])[14]")
	   WebElement state;
	   @FindBy(xpath="//input[@formcontrolname='mobilePhone']")
	   WebElement mobile;
	   @FindBy(xpath="//button[normalize-space()='Create User']")
	   WebElement createUser;
	   @FindBy(xpath="//div[@id='toast-container']")
	   WebElement textMsg;
	   
	   


	       public void security() {
		   ActionClass.click(driver, admin);
		   ActionClass.click(driver, security);
	       }
	
//	       
//	       public void addUser() {
//			  ActionClass.click(driver, addUser);
//		       }
	       public boolean addUser() {
	    	   ActionClass.click(driver, addUser);
		      return ActionClass.isDisplayed(driver, addUser);
		  
	       }
	       
	       public void clkAddUser() {
	    	   ActionClass.click(driver, addUser);
		      
		      
	       }
	       
	       public void addUserForm(String UserName, String Email, 
	   			String Password, String ConPassword,String SecQues, String SecQuesAns,String Address1, String City,
	   			String PinCode, String State,String District,String Mobile) throws AWTException {
	    	   
	    	    Robot rb=new Robot();
	    	   
			   ActionClass.click(driver, admin);
			   ActionClass.click(driver, security);
			   ActionClass.type(userName, UserName);
			   ActionClass.type(email, Email);
			   ActionClass.type(pswd, Password);
			   ActionClass.type(cnfrmpass, ConPassword);
			   ActionClass.type(securityQue, SecQues);
			   rb.keyPress(KeyEvent.VK_ENTER);
		       rb.keyRelease(KeyEvent.VK_ENTER);
			   ActionClass.type(securityAns, SecQuesAns);
			   ActionClass.type(address1, Address1);
			   ActionClass.type(city, City);
			   ActionClass.type(pinCode, PinCode);
			   ActionClass.type(state, State);
			   rb.keyPress(KeyEvent.VK_ENTER);
		       rb.keyRelease(KeyEvent.VK_ENTER);
		       ActionClass.type(mobile, Mobile);
		       ActionClass.click(driver, createUser);
	       }
	       
	       public String getTextmsg() {
	    	   String confirmMsg= textMsg.getText();
	    	   return confirmMsg;
		       
			   
			   
		   }
	       
           }
