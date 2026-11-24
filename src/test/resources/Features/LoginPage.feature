@RiaMoney
Feature: Login Functionality
  As a user
  I want to login to the application
  So that I can access my account

@Login
  Scenario Outline: Send 25000 CLP to Haiti HTG and validate the converted amount after calculation.

    When user launches the application
    Then User should see welcome message
    When User navigate to Sendmoneyto '<Region>'
    Then Enter the '<amount>' in YouSend form
    And Validate the Conversion rate if not error message will be displayed

  Examples:
    | amount |Region|
    |100|Haiti|
    |0|Haiti|


  @RegistrationPage
  Scenario: verify that when user click on the registrtion button then all the elements should be diaplyed

    When user launches the application
    Then User should see welcome message
    When user click on the registration button
    Then user should navigates to the registration page
    And all registration form elements should be displayed









