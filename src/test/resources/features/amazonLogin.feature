@Regression
Feature: Amazon login
  User should be able to login and logout using Amazon login feature

  @loginValidTest @SmokeTest
  Scenario: As a user, I should be directed to login page on click of the sign in button
    Given I am on the amazon homepage
    Then Sign in button is displayed
    When I click on signin button
    Then I should be directed to login page

  @loginInvalidTest @SmokeTest
  Scenario: As a user, I should not be directed to password field when I provide invalid user email
    Given I am on the amazon signin page
    When I enter invalid user email "jon.dow@gmail.com"
    And I clicked on continue button
    Then An error message "There was a problem" should display
    But The password field should not display

    #if you put a tag on top of the Feature,
    #when you run using that tag, it will run everything inside the feature
    
    
    #if you have a tag on top on a scenario,  and when you run using that tag, 
    #only the scenarios tagged with will run. 
    
    @SearchTest @SmokeTest
    Scenario Outline: As a user, I should be able to search different items
    Given I am on the amazon homepage
    When I enter the search term "<items>"
    And I click on search button
    Then I should see the search item "<items>" on search result page
    
    Examples: 
    |items|
    |coffee mug|
    |pretty coffee mug|
    |cool coffee mug|
    |ugly coffee mug|
    |cute coffee mug|
    
    
    
    
    
    