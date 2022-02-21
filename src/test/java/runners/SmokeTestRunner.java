package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:Reports/htmlReport.html",
		"json:Reports/jsonReport.json"},
		features="./src/test/resources/features",
		glue="step_definitions",
		dryRun=false,
		tags="@SmokeTest"
		)
public class SmokeTestRunner {

}
