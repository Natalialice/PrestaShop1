@alltests
Feature: Presta Shop authentication

  Background:
    Given User is on "http://prestashop.qatestlab.com.ua/en/"
    And The browser is maximized
    When User click Sign In button

  Scenario: User is login with valid data
    When User enter email "rey@tut.by" and password "123456"
    When User press SubmitLogin button
    Then User went to My account page
    And User press Sign out button
    Then User back Authentication page
    When User enter email "rey@tut.by" and password ""
    When User press SubmitLogin button
    Then Check error message "Password is required."

  Scenario: User is login with invalid password field
    When User enter email "dsdf@gmail.com" and password "222"
    When User press SubmitLogin button
    Then Check error message "Invalid password."

  Scenario: User is login with empty email field
    When User enter email "" and password "dftre11"
    When User press SubmitLogin button
    Then Check error message "An email address required."


  Scenario: User buys the product
    When Open authentication page and log in with valid data
    When User adds the product "Blouse" to the cart
    When User press checkout button
    Then User went to Order page


