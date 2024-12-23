package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/customers.feature",
		glue = {"stepDefinitions.customer", "base"},
		dryRun = false,
		monochrome = true,
		//tags = "@Sanity",
		plugin = {"pretty", "html:target/reports/CucumberReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:target/test-output-thread/"}
		)
public class Customer {

}
