package Event;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/", glue= {"Event", "TheDriver"},
monochrome =true,
plugin = {"pretty", "html:target/HtmlReports/ReportEditEvent.html",
		"json:target/JSONReports/ReportEditEvent.json",
		"junit:target/JunitReports/ReportEditEvent.xml"},
tags = "@EditEventScenario"
		)
public class TestRunnerEvent{
	
}

