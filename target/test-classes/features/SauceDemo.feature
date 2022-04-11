@Regression
Feature: Sauce Demo login tests

Background: 
    Given I am on the login page


  @SauceValidLogin @SmokeTest
  Scenario: Login Valid test
    When I enter username "standard_user" and password "secret_sauce"
    And I click on the login button
    Then I should be in the home page
    And There should be 6 items in the home page

  @SauceInvalidLogin @SmokeTest
  Scenario: Login Invalid test
    When I enter username "standard_user" and password "secret_invalid"
    And I click on the login button
    Then I should not be in the home page
    And There should an error message "Epic sadface: Username and password do not match any user in this service"

  @SmokeTest
  Scenario: Validate all the web elements on login page
