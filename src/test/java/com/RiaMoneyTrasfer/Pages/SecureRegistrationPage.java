package com.RiaMoneyTrasfer.Pages;
import com.RiaMoneyTrasfer.Utilities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class SecureRegistrationPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;


    public SecureRegistrationPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//h1[@class=\"text-3xl font-semibold leading-9\"]")
    private WebElement securepageMessage;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registrtionButton;

    @FindBy(xpath = "//button[contains(translate(normalize-space(.), 'GOTI', 'goti'), 'got it')]")
    private WebElement gotit;



    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    private WebElement continuebutton;

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement
    email;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement password;

    /**
     * Gets the registration message text
     */
    public String navigatetosecurepage() throws InterruptedException {
        Thread.sleep(30000);
        System.out.println("📍 Navigated to SecureTransfer page");
        Thread.sleep(20000);
        gotit.click();
        registrtionButton.click();
        String message = securepageMessage.getText();
        System.out.println("✅ Welcome message: " + message);
        continuebutton.click();
        return "securepageMessage";
    }


    public boolean areAllElementsDisplayed() {
        try {
            return email.isDisplayed()
                    && password.isDisplayed()
                    && continuebutton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}








