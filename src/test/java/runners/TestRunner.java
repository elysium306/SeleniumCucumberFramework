package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:Reports/htmlReport.html",
		"json:Reports/jsonReport.json"},
		features="./src/test/resources/features/Login.feature",
		glue="step_definitions",
		dryRun=false,
		tags="@LoginTest"
		)
public class TestRunner {
	
	//dryRun = we are telling to cucumber to run only the scenario steps, not the implementation

}
