package com.RiaMoneyTrasfer.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/**
 * Test Runner - The command center for running tests
 * All configuration happens here
 */
@RunWith(Cucumber.class)
@CucumberOptions(


        features = "src/test/resources/Features",


        glue = {"com.RiaMoneyTrasfer.Stepdefination", "com.RiaMoneyTrasfer.Hooks"},

        // What reports should we generate?
        plugin = {
                "pretty",  // Nice console output
                "html:target/cucumber-reports/report.html",  // HTML report
                "json:target/cucumber-reports/report.json"   // JSON report
        },

        // Make console output readable
        monochrome = true,
        tags = "@Login"
)
public class TestRunner {

}
