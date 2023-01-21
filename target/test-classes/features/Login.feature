Feature: Login Application Feature

  @LoginTest
  Scenario: User Login Scenario
    Given User is on the application Home Page
    When Application Page title is FREE CRM
    Then User enters username and password
    And User clicks on Login button
    When User navigate to user Profile page
