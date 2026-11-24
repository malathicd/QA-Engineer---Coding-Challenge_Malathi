package com.RiaMoneyTrasfer.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static void captureScreenshotToFile(WebDriver driver, String fileName) {
        if (driver == null) {
            System.out.println("⚠️ Driver is null, skipping screenshot: " + fileName);
            return;
        }
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = Paths.get("reports/screenshots", fileName + ".png");
            Files.createDirectories(destination.getParent());
            Files.copy(srcFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot " + fileName + ": " + e.getMessage());
        }
    }
}
