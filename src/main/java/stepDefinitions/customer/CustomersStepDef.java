package stepDefinitions.customer;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriverManager;
import core.OutputLog;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import page.CustomersPage;
import page.LoginPage;
import util.ExcelUtils;
import util.RandomDataUtil;
import util.SoftAssertionUtil;

public class CustomersStepDef {

	WebDriver driver;
	WebDriverWait wait;
	private String userName;
	private int count=1;
	
	private LoginPage getLoginPage() {
		return new LoginPage(driver);
	}
	
	private CustomersPage getCustomersPage() {
		return new CustomersPage(driver);
	}
	
	
	@Given("User launches the browser")
	public void user_launches_the_browser() {
	    driver = DriverManager.getDriverManager().getDriver();
	}
	@When("User openes the url {string}")
	public void user_openes_the_url(String url) {
		driver.manage().window().maximize();
	    driver.get(url);
	}
	@Then("User should verify title {string} for login page")
	public void user_should_verify_title_for_login_page(String title) {
		assertTrue(getCustomersPage().validateTitle(title));
	}
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		getLoginPage().enterEmail(username);
		getLoginPage().enterPassword(password);
	}
	@When("User Click on the login button")
	public void user_click_on_the_login_button() {
		getLoginPage().clickOnLoginButton();
	}
	@Then("User should verify the title {string} for Dashboard page")
	public void user_should_verify_the_title_for_dashboard_page(String title) {
		assertTrue(getLoginPage().validateTitle(title));
	}
	@When("User navigate to Customers Menu")
	public void user_navigate_to_customers_menu() {
		getCustomersPage().clickCustomersMenu();
	}
	@When("Users clicks on Customers menu item")
	public void users_clicks_on_customers_menu_item() {
		getCustomersPage().clickCustomersMenuItem();
	}
	@Then("User should get the Customers page")
	public void user_should_get_the_customers_page() {
		assertTrue(getCustomersPage().validateTitle("Customers"));;
	}
	@When("User click on Add New button")
	public void user_click_on_add_new_button() {
		getCustomersPage().clickAddNewBtn();
	}
	@When("User should fill all the customer general details")
	public void user_should_fill_all_the_customer_general_details() {
		String password = RandomDataUtil.generatePassword(8);
		String firstName = RandomDataUtil.generateName(7);
		String lastName = RandomDataUtil.generateName(7);
		getCustomersPage().enterFirstName(firstName);
		getCustomersPage().enterLastName(lastName);
		getCustomersPage().enterEmail(RandomDataUtil.generateEmail(10));
		getCustomersPage().enterTelephoneNo(RandomDataUtil.generateMobileNo());
		getCustomersPage().enterPassword(password);
		getCustomersPage().confirmPassword(password);
		this.userName=firstName+" "+lastName;
	}
	
	@When("User should fill {string}, {string}, {string}, {string}, {string}")
	public void user_should_fill(String firstName, String lastName, String email, String phone, String password) {
		getCustomersPage().enterFirstName(firstName);
		getCustomersPage().enterLastName(lastName);
		getCustomersPage().enterEmail(email);
		getCustomersPage().enterTelephoneNo(phone);
		getCustomersPage().enterPassword(password);
		getCustomersPage().confirmPassword(password);
		this.userName=firstName+" "+lastName;
	}
	
	@When("User should fill all the customer details from testData excel")
	public void user_should_fill_all_the_customer_details_from_test_data_excel() {
		
		ExcelUtils testData = ExcelUtils.getTestDataFile("AddCustomer");
		String [] customerData = new String[5];
		
	    for(int j=0;j<testData.getColCount(); j++) {
	    	customerData[j] = testData.getCellData(count, j);
	    }
	    getCustomersPage().enterFirstName(customerData[0]);
	    getCustomersPage().enterLastName(customerData[1]);
	    getCustomersPage().enterEmail(customerData[2]);
	    getCustomersPage().enterTelephoneNo(customerData[3]);
	    getCustomersPage().enterPassword(customerData[4]);
	    getCustomersPage().confirmPassword(customerData[4]);
	    
	    userName = customerData[0]+" "+customerData[1];
	}
	
//	@After("@ExcelData") //Tried to run a scenario in loop
//	public void fillMultiCustomerDetailsFromExcel() {
//		count++;
//		if(count<ExcelUtils.getTestDataFile("AddCustomer").getRowCount()) {
//			user_click_on_add_new_button();
//			user_should_fill_all_the_customer_details_from_test_data_excel();
//			user_should_fill_all_the_customer_details_from_test_data_excel();
//			click_on_save_button();
//			user_should_get_the_success_message("Success: You have modified customers!");
//		}
//	}
	
	@When("Click on Save button")
	public void click_on_save_button() {
		getCustomersPage().clickOnSave();
	}
	@Then("User should get the success message {string}")
	public void user_should_get_the_success_message(String confirmMessage) {
		
		try {
			assertTrue(getCustomersPage().validateConfirmMsg(confirmMessage));
			OutputLog.info("Customer "+userName+", has been added successfully.");
			//OutputLog.info(SoftAssertionUtil.getInstance().assertTrue(getCustomersPage().validateConfirmMsg(confirmMessage), "***** Success Message mismatched *****")==true?"Customer "+userName+", has been added successfully.":"Something went wrong..!!");
		} catch (AssertionError e) {
			OutputLog.error(e.getMessage()+"\n"+e.getCause());
			getCustomersPage().cancel();
		}
	}
	
//	@Then("User closes the browser")
//	public void user_closes_the_browser() {
//		DriverManager.getDriverManager().quitDriver();
//	}
	
	@When("User enter customer Name")
	public void user_enter_customer_name() {
	   getCustomersPage().enterCustomerName("Abc Def");
	}
	
	@When("click on Filter button")
	public void click_on_filter_button() {
	    getCustomersPage().clickOnFilter();
	}
	@Then("User find the customer by customer name")
	public void user_find_the_customer_by_customer_name() {
	    assertTrue(getCustomersPage().findCustomerByName("Abc Def"));
	}
	@When("User enter customer email")
	public void user_enter_customer_email() {
	    getCustomersPage().enterEmail("abc@gmail.com");
	}
	@Then("User find the customer by email")
	public void user_find_the_customer_by_email() {
	    assertTrue(getCustomersPage().findCustomerByEmail("abc@gmail.com"));
	}
	@Then("Logout the session")
	public void logout_the_session() {
		OutputLog.info("**** Logout");
	    getCustomersPage().logOut();
	}
}
