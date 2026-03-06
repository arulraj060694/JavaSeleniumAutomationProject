Feature:

 

Feature: To verify the login function of the practice test

Background:
 Given User should launch the application
 When User should enter the login credentials
 And User should verfiy the succesfull login
 
 
 @regression
  Scenario: To verfiy the practice page with valid credentials
    Given User should launch the application
    When User should enter the login credentials
    And User should verify and click the login function
    Then User should verfiy the succesfull login
