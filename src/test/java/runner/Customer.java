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
		tags = "@Sanity",
		plugin = {"pretty", "html:target/reports/CustomerReport.html"}
		)
public class Customer {

}
