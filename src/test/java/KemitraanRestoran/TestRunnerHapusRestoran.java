package KemitraanRestoran;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue={"KemitraanRestoran", "StepDefinitons"}, 
		
		monochrome = true,
		plugin = {"pretty", "html:target/reports/hapusRestoran.html", 
			    "json:target/reports/hapusRestoran.json",
			    "junit:target/reports/hapusRestoran.xml"},
		tags = "@hapusRestoranScenario") 

public class TestRunnerHapusRestoran {

}