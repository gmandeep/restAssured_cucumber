package testrunners;

import org.testng.annotations.AfterClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExtentReportManager;

@CucumberOptions(
    features = "src/test/resources/features",   // Path to feature files
    glue = "definitions",                   // Package name for step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}  // Reporting plugin
//    tags = "@UserAPI"                           // Tags for filtering scenarios
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@AfterClass
    public void tearDown() {
        ExtentReportManager.flushReports();
    }
}
