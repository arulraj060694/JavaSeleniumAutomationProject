Feature: Validation of Facebook Webpage

  Scenario: Validating the facebook with correct username and correct password
    Given User should open the facebook application
    When User enters the username and password in the application
    And User clicks the login button
    Then User verifies the application moved to home page

  Scenario Outline: Validating the facebook
    Given User should open the facebook application
    When User enters the "<username>" and "<password>" in the application
    And User clicks the login button
    Then User verifies the application moved to home page

    Examples:
      | username |  | password |
      | ramsss   |  | sjdsjab  |
      
      Scenario Outline: Validating the facebook
    Given User should open the facebook application
    When User enters the "<username>" and "<password>" in the application
    And User clicks the login button
    Then User verifies the application moved to home page

    Examples:
      | username |  | password |
      | ramsss   |  | sjdsjab  |

