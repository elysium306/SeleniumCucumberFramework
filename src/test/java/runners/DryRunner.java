package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Login.feature", 
				glue = "step_definitions", 
				dryRun = true, 
				monochrome = true)
public class DryRunner {
}
