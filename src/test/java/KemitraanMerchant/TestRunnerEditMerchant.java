package KemitraanMerchant;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", // path of feature file
		glue={"KemitraanMerchant", "StepDefinitions"}, // path of step definition file
		
		monochrome = true,
		plugin = {"pretty", "html:target/reports/cucumber.html", 
			    "json:target/reports/cucumber.json",
			    "junit:target/reports/cucumber.xml"},
		tags = "@EditMerchantTest") 

public class TestRunnerEditMerchant {

}
