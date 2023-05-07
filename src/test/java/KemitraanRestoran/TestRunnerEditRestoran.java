package KemitraanRestoran;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", // path of feature file
		glue={"KemitraanRestoran", "StepDefinitions"}, // path of step definition file
		monochrome = true,
		plugin = {"pretty", "html:target/reports/editRestoran.html", 
			    "json:target/reports/editRestoran.json",
			    "junit:target/reports/editRestoran.xml"},
		tags = "@EditRestoran") 

public class TestRunnerEditRestoran {

}
