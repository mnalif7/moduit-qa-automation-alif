package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/Features/login.feature", glue = {
		"StepDefinitions" }, monochrome = true, plugin = { "pretty", "junit:target/reports/JUnitReports/report.xml",
				"json:target/reports/JSONReports/report.json",
				"html:target/reports/HtmlReports.html" })

public class TestRunner {

}
