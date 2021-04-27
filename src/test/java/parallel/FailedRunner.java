package parallel;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target\\failedrun.txt", glue = { "parallel" }, monochrome = true,
plugin = {
		"pretty", 
		"json:C:\\Users\\CodeClouds-Kaustav\\eclipse-workspace\\HukoBDDTest\\target\\cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/",
		"rerun:C:\\Users\\CodeClouds-Kaustav\\eclipse-workspace\\HukoBDDTest\\target\\failedrun.txt" 
		},
		

		// tags= "@fgtpasslink",
		// tags="@parallel",

dryRun = false

)

public class FailedRunner extends AbstractTestNGCucumberTests  {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();

	}

}
