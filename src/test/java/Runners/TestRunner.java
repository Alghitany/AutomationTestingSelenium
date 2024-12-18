package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features/Register.feature",  // Path to feature files
        glue = {"StepDefinitions"},               // Path to step definitions
        plugin = {
                "pretty",                             // Standard output
                "html:target/cucumber-reports.html",   // HTML report
                "json:target/cucumber-reports/CucumberTestReport.json", // JSON report
                "junit:target/cucumber-reports/CucumberTestReport.xml"  // JUnit report
        },
        monochrome = true                     // Makes console output readable
 )
public class TestRunner {
}
