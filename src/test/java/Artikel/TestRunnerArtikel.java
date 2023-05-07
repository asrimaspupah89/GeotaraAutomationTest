package Artikel;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", // path of feature file
		glue={"Artikel", "StepDefinitions"}, // path of step definition file
		monochrome = true,
		plugin = {"pretty", "html:target/reports/MenampilkanArtikel.html", 
			    "json:target/reports/MenampilkanArtikel.json",
			    "junit:target/reports/MenampilkanArtikel.xml"},
		tags = "@MenampilkanArtikel") 

public class TestRunnerArtikel {

}
