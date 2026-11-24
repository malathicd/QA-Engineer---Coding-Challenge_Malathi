package com.RiaMoneyTrasfer.Pages;

import com.RiaMoneyTrasfer.Utilities.DriverFactory;
import com.RiaMoneyTrasfer.Utilities.BasePage;
import com.RiaMoneyTrasfer.Utilities.ScreenshotUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * This class represents the Login Page
 * Contains all elements and actions for login page
 */
public class LoginPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor - runs when we create this object
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    // Finding elements using @FindBy annotation
    // This is like giving directions to find elements on the page

    @FindBy(xpath = "//h1[contains(text(), 'Send money.')]")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//button[contains(text(), 'Reject All')]")
    private WebElement RejectAllButton;


    @FindBy(xpath = "//*[@id=\"db51d42f-dca2-4e18-b47f-8564214c4624\"]")
    private WebElement MoneyTransfer;

    @FindBy(xpath = "//a[contains(text(), 'Send money to Haiti')]")
    private WebElement SendmoneytoHaiti;


    @FindBy(xpath = "//*[@id=\"amount-from\"]")
    private WebElement SendamountCLP;

    @FindBy(xpath = "//*[@id=\"_44d0aef7961c129bce408706\"]")
    private WebElement robotcheckbox;

    @FindBy(xpath = "//*[@id=\"quote-details\"]/div[2]/div/div/button/span")
    private WebElement downarrowclick;

    @FindBy(xpath = "(//span[@class='flex-1'])[1]")
    private WebElement Hattiselect;

    @FindBy(xpath = "//input[@aria-label=\"Search currency or country\"]")
    private WebElement regionsearch;
    @FindBy(xpath = "//span[contains(text(), 'Haitian Gourde')]")
    private WebElement HTGcurrency;

    @FindBy(xpath = "//*[@id=\"amount-error\"]")
    private WebElement errorMessageElement;

    @FindBy(xpath = "//*[@id=\"amount-to\"]")
    private WebElement conversionAmountElement;

    @FindBy(xpath = " //a[contains(text(), 'Start your transfer')]")
    private WebElement startyourtransfer;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registrtionButton;

    @FindBy(xpath = "//button[contains(translate(normalize-space(.), 'GOTI', 'goti'), 'got it')]")
    private WebElement gotit;



    // Methods - Actions we can perform on this page

    /**
     * Opens the login page
     */
    public void navigateToLoginPage() {
        System.out.println("📍 Navigated to login page");
    }

    /**
     * Gets the welcome message text
     */
    public String getWelcomeMessage() throws InterruptedException {
//this.wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        String message = welcomeMessage.getText();
        System.out.println("✅ Welcome message: " + message);
        ScreenshotUtil.captureScreenshotToFile(driver, "WelcomeMessage");
        Thread.sleep(5000);
        //RejectAllButton.click();
        return message;
    }

    public String NavigatetoHaltiMoneyTransfer(String region) {
        // wait.until(ExpectedConditions.elementToBeClickable( MoneyTransfer));
        //MoneyTransfer.click();
        downarrowclick.click();
        regionsearch.sendKeys(region);
        Hattiselect.click();
        HTGcurrency.click();
        ScreenshotUtil.captureScreenshotToFile(driver, "NavigatingtoMoneyTransfer");
        return "downarrowclick";

    }

    public String Amountsendform(String amount) throws InterruptedException {

        Thread.sleep(2000);
        // wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(SendamountCLP));
        SendamountCLP.clear();
        SendamountCLP.sendKeys(amount);
        if (amount.equals("0") || amount.equals("")) {
            //WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
            //Assert.assertTrue("Error message should be displayed when amount is 0", errorMsg.isDisplayed());
            System.out.println("error: " + errorMessageElement.getText());
        } else {
           // WebElement convertedAmt = wait.until(ExpectedConditions.visibilityOf(conversionAmountElement));
           // Assert.assertTrue("Conversion amount should be displayed when amount > 0", convertedAmt.isDisplayed());
            System.out.println("conversionamount: " + conversionAmountElement.getText());

        }
        ScreenshotUtil.captureScreenshotToFile(driver, "AmountEntered");

        return amount;
    }

    public String Clicktrnasferbutton() {
       // wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(startyourtransfer));
        startyourtransfer.click();
        ScreenshotUtil.captureScreenshotToFile(driver, "Starttotransfer");
        return "startyourtransfer";


    }

    public String NavigateToapppage() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        return "apppage";
    }




    // Connects LoginPage to DashboardPage upon submission
    public SecureRegistrationPage Clickregisterbutton() throws InterruptedException {
        Thread.sleep(5000);
        registrtionButton.click();
        ScreenshotUtil.captureScreenshotToFile(driver, "Clickregisterbutton");
        return new SecureRegistrationPage(DriverFactory.getDriver());
    }
}








