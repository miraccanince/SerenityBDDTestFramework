Feature: Basic GET Request to Main Page

  Scenario: Verify GET Request to Main Page
    Given the API is up and running
    When I send a GET request to "https://practice.automationtesting.in/"
    Then the response status should be 200
