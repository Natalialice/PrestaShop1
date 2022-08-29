Feature: Presta Shop authentication

  Background:
    Given User is on "http://prestashop.qatestlab.com.ua/en/authentication?back=my-account" page
    And The browser is maximized

  Scenario: User is login with valid data
    When User enter email "rey@tut.by"
    When User enter password "123456"
    When User press "Sing in" button
    Then User went to "My account" page
    And User press "Sing out"
    And User back authentication page "Authentication"

    When User enter email "rey@tut.by"
    When User enter password ""
    When User press "Sing in" button
    Then User sees an error message "Password is required."
    
    When User enter password "222"
    When User press "Sing in" button
    Then Check error message "Invalid password."

  Scenario: User is login with empty email field
    When User enter email ""
    When User enter password "222"
    When User press "Sing in" button
    And Message "Input error message" appeared on the page






  Scenario Outline: Error message for invalid data
    When User enter "<email>"
    When User enter "<password>"
    When User press "<Sing in>" button
    Then  "<error message>" is displayed
    Examples:
      | email              | password   | error message          |
      | lto.plus           | 222        | Invalid email address. |
      | kaesut@mailto.plus |            | Password is required.  |
      |                    | rey@tut.by |                        |