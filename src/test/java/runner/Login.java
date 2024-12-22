package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/login.feature"},
		glue = {"stepDefinitions", "base"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:target/reports/testReport.html"}
		)
public class Login {

	//{"pretty", "html:target/reports/testReport.html"}
	//{"pretty", "json:target/reports/testReportJSON.json"}
	//{"pretty", "junit:target/reports/testReportXML.xml"}
}
