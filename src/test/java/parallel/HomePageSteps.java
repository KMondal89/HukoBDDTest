package parallel;

import java.util.List;
import java.util.Map;

import org.testng.*;

import com.huko.qa.factory.Driverfactory;
import com.huko.qa.pages.HomePage;
import com.huko.qa.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	private HomePage homepage;
	private LoginPage loginPage = new LoginPage(Driverfactory.getDriver());
	String url = "https://ui.cogmento.com/";

	@Given("user has already logged in the application")
	public void user_has_already_logged_in_the_application(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> lgnCreds = dataTable.asMaps();
		
		String uname = lgnCreds.get(0).get("username");
		String pwd = lgnCreds.get(0).get("password");

		Driverfactory.getDriver().get(url);
		homepage = loginPage.doLogin(uname, pwd);

	}

	@Given("user is on homepage")
	public void user_is_on_homepage() {
		String hmpageURL = homepage.validateCurrrentUrl();

		System.out.println("homepage URL is:  " + hmpageURL);

	}

	@Then("check these sections are available validate the count as four")
	public void check_these_sections_are_available_validate_the_count_as_four(DataTable Expecteditems) throws InterruptedException {
		List<String> Expected_List = Expecteditems.asList();
		System.out.println("The expected list items are: " + Expected_List);

		int itemscount = homepage.validatehomepageitemscount();
		System.out.println("items are:   " + itemscount);

		List<String> actual_items = homepage.validatehomepageitems();
		Assert.assertTrue(Expected_List.containsAll(actual_items));
		System.out.println("Actual items are: "+actual_items);

	}

}
