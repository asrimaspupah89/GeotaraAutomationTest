package KemitraanRestoran;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue={"KemitraanRestoran", "StepDefinitions"}, 
		
		monochrome = true,
		plugin = {"pretty", "html:target/reports/tambahRestoran.html", 
			    "json:target/reports/tambahRestoran.json",
			    "junit:target/reports/tambahRestoran.xml"},
		tags = "@tambahRestoranScenario") 

public class TestRunnerTambahRestoran {

}
