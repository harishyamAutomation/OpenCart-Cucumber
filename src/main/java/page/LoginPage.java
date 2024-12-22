package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.HighlightUtil;

public class LoginPage {

	WebDriver ldriver;
	WebDriverWait wait;

	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='input-username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement LoginBtn;
	
	
	@FindBy(xpath = "//header[@id='header']//li[2]//a[1]")
	WebElement logout;
	
	public void enterEmail(String emailAdd)
	{
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(username));
		
		HighlightUtil.highlightElement(ldriver, username);
		username.clear();
		username.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		HighlightUtil.highlightElement(ldriver, password);
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		HighlightUtil.highlightElement(ldriver, LoginBtn);
		LoginBtn.click();
	}
	
	public void clickOnLogOutButton()
	{
		HighlightUtil.highlightElement(ldriver, logout);
		logout.click();
	}
	
	public boolean validateTitle(String expectedTitle) {
		String actualTitle = ldriver.getTitle();
		return expectedTitle.equals(actualTitle)?true:false;
	}
}
