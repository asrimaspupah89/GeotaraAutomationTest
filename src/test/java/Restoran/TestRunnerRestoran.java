package Restoran;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Restoran", glue= {"Restoran"}, 
monochrome =true,
plugin = {"pretty", "html:target/HtmlReports/ReportMenampilkanRestoran.html",
		"json:target/JSONReports/ReportMenampilkanRestoran.json",
		"junit:target/JunitReports/ReportMenampilkanRestoran.xml"},
tags = "@MenampilkanRestoran" 
		)
public class TestRunnerRestoran{
	
}