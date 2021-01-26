Feature: Sign in to AutomationPractice.com website

  Background:
    Given user landed on AutomationPractice.com home page

  Scenario Outline: Unsuccessful sign in on AutomationPractice.com page
    When user clicks Sign In button on the home page
    Then user lands on Authentication Page
    When user signs in with "<email>" and "<password>" values
    Then An error message "<errorMessage>" is displayed on this page

    Examples:
      | email     | password | errorMessage               |
      |           |          | An email address required. |
      | a@bsd.sdd |          | Password is required.      |
      |           | 12334    | An email address required. |
      | a@bsd.sdd | 12334    | Authentication failed.     |