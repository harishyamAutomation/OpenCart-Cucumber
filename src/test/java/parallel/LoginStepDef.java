package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseTest;
import core.DriverManager;
import io.cucumber.java.en.*;
import page.LoginPage;

public class LoginStepDef{
		
	WebDriver driver = BaseTest.config(); //DriverManager.getDriverManager().getDriver();
	LoginPage loginPg = new LoginPage(driver);
	
	//@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginPg = new LoginPage(driver);
		System.out.println("chrome browser launched");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println(url+"url opened");

	}

	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
		loginPg.enterEmail(username);
		loginPg.enterPassword(password);
		System.out.println("username and password entered");

	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();

		System.out.println("Clicked on login button");

	}

	//////////Login feature///////////////////////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test passed: Login feature :Page title matched. : "+expectedTitle);

			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
			System.out.println("Test Failed: Login feature- page title not matched.");
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPg.clickOnLogOutButton();
		System.out.println("user clicked on logout link.");

	}
}
