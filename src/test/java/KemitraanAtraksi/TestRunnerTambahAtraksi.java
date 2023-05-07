// Author : Nisa Hauna Yusriyyah
// Tambah data atraksi CMS Geotara

package KemitraanAtraksi;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", 
		glue={"KemitraanAtraksi", "StepDefinitions"},	
		monochrome = true,
		plugin = {"pretty", "html:target/reports/tambahAtraksi.html",
			    "json:target/reports/tambahAtraksi.json",
			    "junit:target/reports/tambahAtraksi.xml"},
		tags = "@TambahAtraksi")

public class TestRunnerTambahAtraksi {

}
