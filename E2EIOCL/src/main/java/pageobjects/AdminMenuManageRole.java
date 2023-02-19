package pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionClass;
import base.BaseClass;

public class AdminMenuManageRole extends BaseClass {

	public AdminMenuManageRole() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Admin']")
	WebElement admin;
	@FindBy(xpath = "//a[text()=' Security ']")
	WebElement security;

	@FindBy(xpath = "//a[@title='Manage Roles']")
	WebElement MngRoles;
	@FindBy(xpath = "//button[@id='close-model']")
	WebElement CrossBtn;
	@FindBy(xpath = "//label[text()='Total 119 Records Found']")
	WebElement DisplayCount;
	@FindBy(css=".table.table-bordered.dt-responsive.nowrap.dataTable.dtr-inline.mb-3>tbody>tr>td:nth-child(1)")
	List<WebElement> rolenames;
	
	
	
	   public void security() {
		   ActionClass.click(driver, admin);
		   ActionClass.click(driver, security);
	       }
	   
	   public void manageRole() {
		   ActionClass.click(driver, MngRoles);
	       }

	 public String TotalRecords() throws InterruptedException {
		 
		 String AllDisplayCount=DisplayCount.getText();
		 return AllDisplayCount;		
	}

	public void getRoleNames() throws InterruptedException {

		List<WebElement> RoleNames = driver.findElements(By.cssSelector(
				".table.table-bordered.dt-responsive.nowrap.dataTable.dtr-inline.mb-3>tbody>tr>td:nth-child(1)"));
		List<String> names = new ArrayList<String>();

		for (WebElement RoleName : RoleNames) {
			names.add(RoleName.getText());
			System.out.println(RoleName.getText());
			JavascriptExecutor j1 = (JavascriptExecutor) driver;
			j1.executeScript("window.scrollBy(0,900)");
		}
		System.out.println("********************************");
		WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next page'][1]"));

		while (true) {// for true it will run infinity, until we give break
			RoleNames = driver.findElements(By.cssSelector(
					".table.table-bordered.dt-responsive.nowrap.dataTable.dtr-inline.mb-3>tbody>tr>td:nth-child(1)"));

			for (WebElement RoleName : RoleNames) {
				names.add(RoleName.getText());
				System.out.println(RoleName.getText());
			}

			if (names.contains("fund transfer")) {

				driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
				System.out.println("check" + driver.findElement(By.xpath("(//button[@type='button'])[15]")));

				// To click on summary button
				WebElement ViewSummary = driver.findElement(By.xpath(
						"//div[@class='dropdown-menu show']//a[@class='dropdown-item ng-star-inserted'][normalize-space()='View Summary']"));
				ViewSummary.click();

				// It will return the parent window name as a String
				String parent = driver.getWindowHandle();
				Set<String> allWindow = driver.getWindowHandles();
				int count = allWindow.size();
				System.out.println("Total window " + count);
				for (String child : allWindow) {
					if (!parent.equalsIgnoreCase(child))
						;
					System.out.println("Child Window title is : "
							+ driver.findElement(By.xpath("//h5[normalize-space()='View Role Permissions Details']"))
									.getText());
					Thread.sleep(2000);
				}
				WebElement CrossBtn = driver.findElement(By.xpath("//button[@id='close-model']"));
				CrossBtn.click();

				// To click on editRole button
				driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
				System.out.println("check" + driver.findElement(By.xpath("(//button[@type='button'])[15]")));

				WebElement editRole = driver
						.findElement(By.xpath("//div[@class='dropdown-menu show']//i[@class='bx bx-edit']"));
				editRole.click();

				String parent1 = driver.getWindowHandle();
				Set<String> allWindow1 = driver.getWindowHandles();
				int count1 = allWindow.size();
				System.out.println("Total window " + count);
				for (String child2 : allWindow) {
					if (!parent.equalsIgnoreCase(child2))
						;

					System.out.println("Child2 Window title is : " + driver
							.findElement(By.xpath("//div[@class='modal-header']//h5[text()='Update Role Permissions']"))
							.getText());
					Thread.sleep(2000);

					WebElement ClickOnAdmin = driver.findElement(By
							.xpath("//p[normalize-space()='Admin']//span[@class='permission-action-icon bx bx-plus']"));
					ClickOnAdmin.click();

					WebElement ClickOnAdminDashBoard = driver.findElement(
							By.xpath("//p[text()=' Admin Dashboard ']//span[@class='permission-action-icon']"));
					ClickOnAdminDashBoard.click();

					JavascriptExecutor j1 = (JavascriptExecutor) driver;
					WebElement Security = driver
							.findElement(By.xpath("//p[text()=' Security ']//span[@class='permission-action-icon']"));
					j1.executeScript("window.scrollBy(0,1200)");
					j1.executeScript("arguments[0].scrollIntoView();", Security);
					Security.click();

					driver.findElement(By.xpath("//table//tbody//td//input[@formcontrolname='isItemViewAllow'][1]"))
							.click();

					WebElement crossBtn = driver.findElement(By.xpath("//button[@id='close-model']"));
					crossBtn.click();
				}
				break;
			}

			else {
				nextButton.click();
				System.out.println("false");
			}

		}
	}
}
