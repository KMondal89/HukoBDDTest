package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import com.huko.qa.factory.Driverfactory;
import com.huko.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private Driverfactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	// For Before Annotation in junit the order will be like first 0 then 1, 2,
	// .......
	
	@Before(value="@skip", order=0)
	public void skip_a_scenario(Scenario scenario) {
		String scenario_name= scenario.getName();
		System.out.println("THE CURRENT SKIPPED SCENARIO IS: "+ scenario_name);
		throw new SkipException(scenario_name);
		
	}
	
	
	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();

	}
	

	@Before(order = 2)
	public void launchBrowser() {
		String BrowserName = prop.getProperty("browser");
		driverFactory = new Driverfactory();
		driver = driverFactory.init_driver(BrowserName);

	}

	// For After Annotation in junit the order will be like first 2, 1 then 0

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take Screenshots when any scenario fails
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);

		}

	}

	@After(order = 0)
	public void quitBrowser() {
		//*******If it is required to take screenshot for every scenario**************
		/*if (scenario.getStatus() != null) {
			// Take Screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);

		*/
		driver.quit();	
	}
		
}

	


