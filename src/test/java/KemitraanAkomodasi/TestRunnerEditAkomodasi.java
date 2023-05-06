package KemitraanAkomodasi;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", // path of feature file
		glue={"KemitraanAkomodasi", "StepDefinitions"}, // path of step definition file
		monochrome = true,
		plugin = {"pretty", "html:target/reports/editAkomodasi.html", 
			    "json:target/reports/editAkomodasi.json",
			    "junit:target/reports/editAkomodasi.xml"},
		tags = "@EditAccomodationTestScenario") 

public class TestRunnerEditAkomodasi {

}
