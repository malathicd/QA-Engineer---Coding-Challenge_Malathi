package com.RiaMoneyTrasfer.Utilities;
import com.RiaMoneyTrasfer.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver driver;

    // Launch Chrome only once
    public static synchronized void initializeBrowser() {

        if (driver == null) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);



            System.out.println(
                    "Chrome launched successfully."
            );

        } else {

            System.out.println(
                    "Reusing existing Chrome browser."
            );
        }
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            initializeBrowser();
        }

        return driver;
    }

    public static void openApplication() {

        if (driver == null) {
            initializeBrowser();
        }

        driver.get(ConfigReader.getProperty("url")
        );
    }

    // Close browser only after complete execution
    public static synchronized void quitBrowser() {

        if (driver != null) {

            driver.quit();
            driver = null;

            System.out.println(
                    "Chrome browser closed."
            );
        }
    }
}

