package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.OutputLog;

public class CustomersPage {

	WebDriver driver;
	WebDriverWait wait;
	public CustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCustomersMenu() {
		try {
			CustomersMenu.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void clickCustomersMenuItem() {
		try {
			CustomersMenuItem.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(filterBtn));
	}

	public void clickAddNewBtn() {
		try {
			AddNewBtn.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterFirstName(String firstName) {
		try {
			FirstName.clear();
			FirstName.sendKeys(firstName);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterLastName(String lastName) {
		try {
			LastName.clear();
			LastName.sendKeys(lastName);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterEmail(String email) {
		try {
			Email.clear();
			Email.sendKeys(email);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterTelephoneNo(String telephone) {
		try {
			Telephone.clear();
			Telephone.sendKeys(telephone);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterPassword(String password) {
		try {
			Password.clear();
			Password.sendKeys(password);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void confirmPassword(String password) {
		try {
			ConfirmPassword.clear();
			ConfirmPassword.sendKeys(password);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void clickOnSave() {
		try {
			SaveBtn.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void cancel() {
		try {
			CancelBtn.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void navigateAffiliatePage() {
		try {
			AffiliatePage.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterCompany(String companyName) {
		try {
			Company.sendKeys(companyName);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterTrackingCode(String trackingCode) {
		try {
			TrackingCode.sendKeys(trackingCode);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterCheckPayeeName(String name) {
		try {
			CheckPayeeName.sendKeys(name);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void enterCustomerName(String name) {
		try {
			CustomerName.sendKeys(name);
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public void clickOnFilter() {
		try {
			filterBtn.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
	}

	public boolean validateConfirmMsg(String expectedMsg) {
		String actualMsg = null;

		try {
			actualMsg = confirmMsg.getText();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
		return actualMsg.contains(expectedMsg)?true:false;
	}

	public boolean validateTitle(String expectedTitle) {
		String actualTitle = null;

		try {
			actualTitle = driver.getTitle();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}

		return expectedTitle.equals(actualTitle)?true:false;
	}

	public boolean findCustomerByName(String customerName) {
		boolean isFound = false;

		try {
			for (WebElement customer : allCustomerByName) {
				isFound = customer.getText().equals(customerName)?true:false; 
				break;
			}			
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
		return isFound;
	}

	public boolean findCustomerByEmail(String customerEmail) {
		boolean isFound = false;

		try {
			for (WebElement customer : allCustomerByEmail) {
				isFound = customer.getText().equals(customerEmail)?true:false; 
				break;
			}
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
		return isFound;
	}

	public void logOut() {

		try {
			logout.click();
		} catch (NoSuchElementException e) {
			OutputLog.error(e);
		}
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
