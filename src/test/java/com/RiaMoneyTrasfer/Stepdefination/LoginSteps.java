package com.RiaMoneyTrasfer.Stepdefination;


import com.RiaMoneyTrasfer.Pages.LoginPage;
import com.RiaMoneyTrasfer.Pages.SecureRegistrationPage;
import com.RiaMoneyTrasfer.Utilities.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private LoginPage loginPage;
    private SecureRegistrationPage secureRegistrationPage;

    // Lazy initializer: ensures BaseClass.getDriver() is already initialized by @Before
    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(DriverFactory.getDriver());
        }
        return loginPage;
    }





    @Given("user launches the application")
    public void userLaunchesTheApplication() {

        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @Then("User should see welcome message")
    public void user_should_see_welcome_message() throws InterruptedException {

        loginPage.getWelcomeMessage();
    }




    @Then("Enter the {string} in YouSend form")
    public void enterTheAmountInYouSendForm(String amount) throws InterruptedException {
        loginPage.Amountsendform(amount);

    }

    @When("User navigate to Sendmoneyto {string}")
    public void userNavigateToSendmoneytoRegion( String region) {
        loginPage.NavigatetoHaltiMoneyTransfer(region);

    }


    @And("Validate the Conversion rate if not error message will be displayed")
    public void validateTheConversionRateIfNotErrorMessageWillBeDisplayed() {
        loginPage.Clicktrnasferbutton();

    }
    @When("user click on the registration button")
    public void userClickOnTheRegistrationButton() throws InterruptedException {
        secureRegistrationPage = getLoginPage().Clickregisterbutton();
    }


}

