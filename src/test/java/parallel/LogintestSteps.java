package parallel;

import java.io.IOException;



import com.huko.qa.factory.Driverfactory;
import com.huko.qa.pages.HomePage;
import com.huko.qa.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogintestSteps {
	LoginPage loginpage = new LoginPage(Driverfactory.getDriver());
	HomePage homepage;
	String url = "https://ui.cogmento.com/";

	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException {
		Driverfactory.getDriver().get(url);

	}

	@When("user enters username {string}")
	public void user_enters_valid_username(String username) {
		loginpage.validate_user_enters_valid_username(username);

	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		loginpage.validate_enters_password(password);

	}

	@And("user clicks on login or submit button")
	public void user_clicks_on_login_or_submit_button() throws InterruptedException {
		loginpage.validate_user_clicks_on_login_submit_button();

	}

	@Then("user is navigated to homepage or dashboard page")
	public void user_is_navigated_to_homepage_or_dashboard_page() throws Exception {
	
		
			homepage = loginpage.validate_user_is_navigated_to_homepage_dashboard_page();
			System.out.println("user is navigated to homepage or dashboard page");
			String homepageURL = homepage.validateCurrrentUrl();
			System.out.println("Homepage URL is: " + homepageURL);
		
		
		

	}

	@Then("user is  not navigated to homepage or dashboard page")
	public void user_is_not_navigated_to_homepage_or_dashboard_page() {

		try {

			String errorAlert = loginpage.validate_user_is_not_navigated_to_homepage_or_dashboard_page();
			System.out.println("The login was not successfull with invalid creds: " + errorAlert);

			} 
		catch (Exception e) {
			System.out.println("Right creds provided in invalid login test");
		}

	}
	
	@Then("loginpage should validate that forgot password link is available")
	public void loginpage_should_validate_that_forgot_password_link_is_available() {
		String frgtlinkName=loginpage.validate_loginpage_should_validate_that_forgot_password_link_is_available();
		System.out.println(frgtlinkName);
	}

}
