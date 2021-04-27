package parallel;

import io.cucumber.java.en.Given;

public class ParallelStepDefs {
	@Given("Step from {string} in {string} feature file")
	public void step_from_in_feature_file(String scenario, String file) {
		 System.out.format("Thread ID - %2d - %s from %s feature file.\n",
			        Thread.currentThread().getId(), scenario,file);
	    
	}


}
