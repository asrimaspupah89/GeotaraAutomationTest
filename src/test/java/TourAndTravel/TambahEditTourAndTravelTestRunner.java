package TourAndTravel;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/TourAndTravel", // path of feature file
		glue={"TourAndTravel"}, // path of step definition file
		
		monochrome = true,
		plugin = {"pretty", "html:target/reports/report_addtour.html",
			    "json:target/reports/report_addtour.json",
			    "junit:target/reports/report_addtour.xml"},
		tags = "@0.0")

public class TambahEditTourAndTravelTestRunner {

}
