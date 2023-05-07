// Author : Nisa Hauna Yusriyyah
// Hapus data atraksi CMS Geotara

package KemitraanAtraksi;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", 
		glue={"KemitraanAtraksi", "StepDefinitions"},
		monochrome = true,
		plugin = {"pretty", "html:target/reports/hapusAtraksi.html", 
			    "json:target/reports/hapusAtraksi.json",
			    "junit:target/reports/hapusAtraksi.xml"},
		tags = "@HapusAtraksi") 

public class TestRunnerHapusAtraksi {

}
