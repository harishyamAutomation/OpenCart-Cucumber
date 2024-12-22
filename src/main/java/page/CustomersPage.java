package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomersPage {

	WebDriver driver;
	WebDriverWait wait;
	public CustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomersMenu() {
		CustomersMenu.click();
	}
	
	public void clickCustomersMenuItem() {
		CustomersMenuItem.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(filterBtn));
	}
	
	public void clickAddNewBtn() {
		AddNewBtn.click();
	}
	
	public void enterFirstName(String firstName) {
		FirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		LastName.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void enterTelephoneNo(String telephone) {
		Telephone.sendKeys(telephone);
	}
	
	public void enterPassword(String password) {
		Password.sendKeys(password);
	}
	
	public void confirmPassword(String password) {
		ConfirmPassword.sendKeys(password);
	}
	
	public void clickOnSave() {
		SaveBtn.click();
	}
	
	public void cancel() {
		CancelBtn.click();
	}
	
	public void navigateAffiliatePage() {
		AffiliatePage.click();
	}
	
	public void enterCompany(String companyName) {
		Company.sendKeys(companyName);
	}
	
	public void enterTrackingCode(String trackingCode) {
		TrackingCode.sendKeys(trackingCode);
	}
	
	public void enterCheckPayeeName(String name) {
		CheckPayeeName.sendKeys(name);
	}
	
	public void enterCustomerName(String name) {
		CustomerName.sendKeys(name);
	}

	public void clickOnFilter() {
		filterBtn.click();
	}
	
	public boolean validateConfirmMsg(String expectedMsg) {
		String actualMsg = confirmMsg.getText();
		return actualMsg.contains(expectedMsg)?true:false;
	}
	
	public boolean validateTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		return expectedTitle.equals(actualTitle)?true:false;
	}
	
	public boolean findCustomerByName(String customerName) {
		boolean isFound = false;
		for (WebElement customer : allCustomerByName) {
			isFound = customer.getText().equals(customerName)?true:false; 
			break;
		}
		return isFound;
	}
	
	public boolean findCustomerByEmail(String customerEmail) {
		boolean isFound = false;
		for (WebElement customer : allCustomerByEmail) {
			isFound = customer.getText().equals(customerEmail)?true:false; 
			break;
		}
		return isFound;
	}
	
	public void logOut() {
		logout.click();
	}
	
//	public void filterCustomerByName(String customerName) {
//		CustomerName.sendKeys(customerName);
//		filterBtn.click();
//	}
//	
//	public void filterCustomerByEmail(String customerEmail) {
//		Email.sendKeys(customerEmail);
//		filterBtn.click();
//	}

	@FindBy(xpath="//li[@id='menu-customer']//a[text()=' Customers']")
	public WebElement CustomersMenu;
	
	@FindBy(xpath="//li[@id='menu-customer']/ul//a[text()='Customers']")
	public WebElement CustomersMenuItem;
	
	@FindBy(xpath="//a[@data-original-title='Add New']")
	public WebElement AddNewBtn;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	public WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	public WebElement LastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	public WebElement Telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement Password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	public WebElement ConfirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement SaveBtn;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	public WebElement CancelBtn;
	
	@FindBy(xpath="//a[normalize-space()='Affiliate']")
	public WebElement AffiliatePage;
	
	@FindBy(xpath="//input[@id='input-company']")
	public WebElement Company;
	
	@FindBy(xpath="//input[@id='input-tracking']")
	public WebElement TrackingCode;
	
	@FindBy(xpath="//input[@id='input-cheque']")
	public WebElement CheckPayeeName;
	
	@FindBy(xpath="//input[@id='input-name']")
	public WebElement CustomerName;
	
	@FindBy(xpath="//button[@id='button-filter']")
	public WebElement filterBtn;
	
	@FindBy(xpath="//form[@id='form-customer']//tbody//td[2]")
	public List<WebElement> allCustomerByName;
	
	@FindBy(xpath="//form[@id='form-customer']//tbody//td[3]")
	public List<WebElement> allCustomerByEmail;
	
	@FindBy(xpath="//div[contains(@class, 'alert')]")
	public WebElement confirmMsg;
	
	@FindBy(xpath = "//header[@id='header']//li[2]//a[1]")
	public WebElement logout;
}
