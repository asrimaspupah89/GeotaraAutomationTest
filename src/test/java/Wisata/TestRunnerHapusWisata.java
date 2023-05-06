package Wisata;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Wisata", glue= {"Wisata"}, 
monochrome =true,
plugin = {"pretty", "html:target/HtmlReports/Report.html",
		"json:target/JSONReports/report.json",
		"junit:target/JunitReports/report.xml"},
tags = "@HapusWisata" )

public class TestRunnerHapusWisata {

}
