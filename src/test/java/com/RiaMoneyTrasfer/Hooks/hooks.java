package com.RiaMoneyTrasfer.Hooks;

import com.RiaMoneyTrasfer.Utilities.DriverFactory;
import com.RiaMoneyTrasfer.Utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Hooks - Run before and after each scenario
 * Like setting up a stage before a play and cleaning up after
 */
public class hooks extends DriverFactory {

    // Runs before every scenario
    @Before
    public void setUp() {
        initializeBrowser();
        openApplication();
    }

    // Runs after every single Gherkin step
    @AfterStep
    public void addScreenshot(Scenario scenario) {
        WebDriver currentDriver = getDriver();
        if (currentDriver != null) {
            // 1. Attach screenshot directly to the Cucumber HTML/Extent report
            final byte[] screenshot = ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

            // 2. Also save a .png file to target/screenshots if a step fails
            if (scenario.isFailed()) {
                String cleanName = scenario.getName().replaceAll("[^a-zA-Z0-9_-]", "_");
                ScreenshotUtil.captureScreenshotToFile(currentDriver, "FAILED_" + cleanName);
            }
        }
    }

    // Runs after every scenario to close the browser opened in @Before
    @After
    public void tearDown() {
        quitBrowser();
    }
}
