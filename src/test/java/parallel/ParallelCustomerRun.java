package parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/parallel/customers.feature",
		glue = {"parallel", "base"},
		dryRun = false,
		monochrome = true,
		tags = "@Sanity", //"@ExcelData", 
		plugin = {"pretty", "html:target/reports/CucumberReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:target/test-output-thread/"}
		)
public class ParallelCustomerRun extends AbstractTestNGCucumberTests{

//	@Override
//	@DataProvider
//	public Object [][] scenarios(){
//		return super.scenarios();
//	}
}
