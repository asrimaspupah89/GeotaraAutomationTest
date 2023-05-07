package ManajemenPengguna;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features", // path of feature file
		glue={"ManajemenPengguna"}, // path of step definition file
		
		monochrome = true,
		plugin = {"pretty", "html:target/reports/cucumber.html",
			    "json:target/reports/cucumber.json",
			    "junit:target/reports/cucumber.xml"},
		tags = "@MaskurScenario"
		)

public class TestRunnerManajemenPengguna {

}
