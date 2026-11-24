package com.RiaMoneyTrasfer.Stepdefination;

import com.RiaMoneyTrasfer.Pages.LoginPage;
import com.RiaMoneyTrasfer.Pages.SecureRegistrationPage;
import com.RiaMoneyTrasfer.Utilities.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;


public class RegistrationSteps {

    private SecureRegistrationPage secureRegistrationPage;
    private LoginPage loginPage;

    public RegistrationSteps() {
        this.secureRegistrationPage = new SecureRegistrationPage(DriverFactory.getDriver());

    }

    @Then("user should navigates to the registration page")
    public void userShouldNavigatesToTheRegistrationPage() throws InterruptedException {
        secureRegistrationPage.navigatetosecurepage();
    }

    @And("all registration form elements should be displayed")
    public void allRegistrationFormElementsShouldBeDisplayed() {
        secureRegistrationPage.areAllElementsDisplayed();

    }
}