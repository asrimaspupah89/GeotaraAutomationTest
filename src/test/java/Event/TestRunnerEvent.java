package Event;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Event", glue= {"Event"}, 
monochrome =true,
plugin = {"pretty", "html:target/HtmlReports/ReportMenampilkanEvent.html",
		"json:target/JSONReports/ReportMenampilkanEvent.json",
		"junit:target/JunitReports/ReportMenampilkanEvent.xml"},
tags = "@MenampilkanEvent" 
		)
public class TestRunnerEvent{
	
}

