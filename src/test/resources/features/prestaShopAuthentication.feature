Feature: Presta Shop authentication

  Background:
    Given User is on "http://prestashop.qatestlab.com.ua/en/authentication?back=my-account" page
    And The browser is maximized

  Scenario: User is login with valid data
    When User enter login "kaesut@mailto.plus"
    When User enter password "123456"
    When User press "Sing in" button
    Then User went to "My account" page
#    And User press "Sing out"
#    And User back authentication page "Authentication"

  Scenario: User is login with invalid email address
    When User enter login "lto.plus>"
    When User enter password "<222>"
    When User press "<Sing in>" button
    Then Error message "<Invalid email address.>"

  Scenario: User is login with empty email field
    When User enter login ""
    When User enter password "<222>"
    When User press "<Sing in>" button
    Then Message "<An email address required.>"

  Scenario: User is login with empty password field
    When User enter login "<kaesut@mailto.plus>"
    When User enter password "<>"
    When User press "<Sing in>" button
    Then User sees an error message "<Password is required.>"


  Scenario: User enter valid email
    When User enter login "<q@tu.by>"
    When User enter password "<>"
    When User press "<Sing in>" button
    Then User sees an error message "<Password is required.>"

#  Scenario Outline: Error message for invalid data
#    When User entered "<invalid data>"
#    When User press "<Sing in>" button
#    Then  "<error message>" error message  is displayed
#    Examples:
#      | invalid data | error message              |  |
#      | 11111        | An email address required. |  |
#      | NUll         | Password is required.      |  |