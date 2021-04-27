package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\parallel", glue = { "parallel" }, monochrome = true,
plugin = {
		"pretty", 
		"json:C:\\Users\\CodeClouds-Kaustav\\eclipse-workspace\\HukoBDDTest\\target\\cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/",
		
		"rerun:C:\\Users\\CodeClouds-Kaustav\\eclipse-workspace\\HukoBDDTest\\target\\failedrun.txt" 
		},
		

		// tags= "@fgtpasslink",
		// tags="@test",

dryRun = false

)

public class ParallelRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();

	}

}
