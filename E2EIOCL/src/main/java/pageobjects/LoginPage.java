package pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionClass;
import base.BaseClass;



public class LoginPage extends BaseClass {
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
//		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	   WebElement InputUsername;
	   @FindBy(xpath="//input[@placeholder='Enter password']")
	   WebElement Inputpswd;
	   @FindBy(xpath="//button[@type='submit']")
	   WebElement login;  
	   ////div[@id='toast-container']
	   @FindBy(xpath="//div[@id='toast-container']")
	   WebElement errorMessage;



	public CustomerProfile loginApp(String uname, String pswd) {
		// TODO Auto-generated method stub
		ActionClass.type(InputUsername,uname);
		ActionClass.type(Inputpswd,pswd);
		ActionClass.click(driver,login);
		return new CustomerProfile();
		
	}
	
	public MerchantMenu loginAppForMerchant(String uname, String pswd) {
		// TODO Auto-generated method stub
		ActionClass.type(InputUsername,uname);
		ActionClass.type(Inputpswd,pswd);
		ActionClass.click(driver,login);
		return new MerchantMenu();
	}
	
	public AdminMenu loginAppForAdmin(String uname, String pswd) {
		// TODO Auto-generated method stub
		ActionClass.type(InputUsername,uname);
		ActionClass.type(Inputpswd,pswd);
		ActionClass.click(driver,login);
		return new AdminMenu();

	
	}
}
	
	
	
	
	
//		 InputUsername.sendKeys(userName);
//		   Inputpswd.sendKeys(password);
//		   login.click();
	
	
//	public String getErrorMessage() {
//		
//		waitForWebElementToAppear(errorMessage);
//		return errorMessage.getText(); 
//	
	
	
	 
	

	


