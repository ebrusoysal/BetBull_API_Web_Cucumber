Feature: Registration and Users List APIs

  @Registration
  Scenario: Successful registration
    Given Create successful registration payload
    When user calls "RegisterAPI" with "POST" http request
    Then API call is success with response code 200
    And A Token is created after successful registration

  @Registration
  Scenario Outline: Unsuccessful registration
    Given Create payload with "<email>" and "<password>"
    When user calls "RegisterAPI" with "POST" http request
    Then API call is success with response code 400
    And "error" in response body is "<errorMessage>"

    Examples:
      | email              | password | errorMessage                                  |
      | eve.holt@reqres.in |          | Missing password                              |
      |                    | pistol   | Missing email or username                     |
      |                    |          | Missing email or username                     |
      | abc@xyz.com        | 123      | Note: Only defined users succeed registration |

  @UsersList
  Scenario: List users
    Given Create request specifications
    When user calls "UsersListAPI" with "GET" http request
    Then API call is success with response code 200
    And verify users are listed
