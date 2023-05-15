package KemitraanAtraksi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features/KemitraanAtraksi",
        glue= {"KemitraanAtraksi"},
        monochrome =true,
        plugin = {"pretty", "html:target/HtmlReports/Report.html",
                "json:target/JSONReports/report.json",
                "junit:target/JunitReports/report.xml"},
            tags = "@EditAtraksi"
)
public class TestRunnerEditAtraksi {
}
