Feature: User Registration

  Scenario Outline: User registers successfully with <passwordType> password
    Given User opens the browser
    When User enters the URL "http://practice.automationtesting.in/"
    And User clicks on My Account Menu
    And User enters registered Email Address in Email-Address textbox
    And User enters <passwordType> password in password textbox
    And User clicks on Register button
    Then Registration should <outcome>

    Examples:
      | passwordType  | outcome                         |
      | strong        | succeed with strong password    |
      | weak          | fail with weak password         |
