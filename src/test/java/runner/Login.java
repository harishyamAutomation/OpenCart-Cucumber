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
		//tags = "@Sanity",
		plugin = {"pretty", "html:target/reports/CucumberReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:target/test-output-thread/"}
		)
public class Login {

	//{"pretty", "html:target/reports/testReport.html"}
	//{"pretty", "json:target/reports/testReportJSON.json"}
	//{"pretty", "junit:target/reports/testReportXML.xml"}
}
