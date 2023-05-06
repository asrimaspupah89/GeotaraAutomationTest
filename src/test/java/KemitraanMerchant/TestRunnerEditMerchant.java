package KemitraanMerchant;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", // path of feature file
		glue={"KemitraanMerchant", "StepDefinitions"}, // path of step definition file
		monochrome = true,
		plugin = {"pretty", "html:target/reports/editMerchant.html", 
			    "json:target/reports/editMerchant.json",
			    "junit:target/reports/editMerchant.xml"},
		tags = "@EditMerchantTestScenario") 

public class TestRunnerEditMerchant {

}
