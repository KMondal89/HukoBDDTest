package com.huko.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static List<WebElement> fieldValidationMsgs = null;
	public static WebElement element = null;
	private WebDriver driver;

	// Page Factory-OR
	@FindBy(xpath = "//input[@name='email']")
	WebElement Username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignupLink;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement ForgotPWDlink;

	// Initializing Page Factories
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String validate_user_is_on_login_page() throws IOException {
		return driver.getCurrentUrl();

	}

	public void validate_user_enters_valid_username(String uname) {
		Username.sendKeys(uname);

	}

	public void validate_enters_password(String pwd) {
		Password.sendKeys(pwd);
	}

	public void validate_user_clicks_on_login_submit_button() throws InterruptedException {
		LoginBtn.click();
		Thread.sleep(2000);

	}

	public HomePage validate_user_is_navigated_to_homepage_dashboard_page() throws Exception {

		if (driver.findElement(By.xpath("//div[@id='top-header-menu']//child::div[@class='header item']"))
				.isDisplayed()) {
			return new HomePage(driver);

		}

		else { 
			
			throw new Exception("Invalid login creds provided");
		}

	}

	public String validate_user_is_not_navigated_to_homepage_or_dashboard_page() throws Exception {

		if (driver.findElement(By.xpath("//p[contains(text(),'Invalid login')]")).isDisplayed()) {
			String InvalidAlertMsg = driver.findElement(By.xpath("//p[contains(text(),'Invalid login')]")).getText();
			return InvalidAlertMsg;

		} else {
			throw new Exception("valid creds provided");

		}

	}

	public String validate_loginpage_should_validate_that_forgot_password_link_is_available() {
		if (ForgotPWDlink.isDisplayed() && ForgotPWDlink.isEnabled()) {
			return ForgotPWDlink.getText();
		} else
			return "No forgot password link is available";
	}

	public HomePage doLogin(String un, String pd) throws InterruptedException {
		Username.sendKeys(un);
		Password.sendKeys(pd);
		LoginBtn.click();
		Thread.sleep(5000);
		return new HomePage(driver);

	}

}
