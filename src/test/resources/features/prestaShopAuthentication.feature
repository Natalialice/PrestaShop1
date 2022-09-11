@smoke
Feature: Presta Shop authentication

  Background:
    Given User is on "http://prestashop.qatestlab.com.ua/en/"
    And The browser is maximized


  Scenario: User is login with valid data
    When User click Sign In button
    When User enter email "rey@tut.by" and password "123456"
    When User press SubmitLogin button
    Then User went to My account page
    And User press Sign out button
    Then User back Authentication page
    When User enter email "rey@tut.by" and password ""
    When User press SubmitLogin button
    Then Check error message "Password is required."

  Scenario: User is login with invalid password field
    When User click Sign In button
    When User enter email "dsdf@gmail.com" and password "222"
    When User press SubmitLogin button
    Then Check error message "Invalid password."

  Scenario: User is login with empty email field
    When User click Sign In button
    When User enter email "" and password "dftre11"
    When User press SubmitLogin button
    Then Check error message "An email address required."

  Scenario: User choose and delete the product in the cart
    When User click Sign In button
    When Authorized user placed the product "Stripe Top" from page "2" in the cart
    When User goes to the order page
    And Delete product from cart
    And User press Sign out button

  Scenario: User buys the product
    When Open authentication page and log in with valid data
    When User choose the product "Floral Top"
    When User went to Item page
    And Added product to cart
    And User press Sign out button

  Scenario: User buys the product
    When Open authentication page and log in with valid data
    When User adds the product "Blouse" to the cart
    When User press checkout button
    Then User went to Order page
    And User check total price "32,40 ₴"

  Scenario: User isn't logged buys a product from Home page
    And User press Sign out button
    When User adds the product "Faded Short Sleeve T-shirts" to the cart from Home page
    When User press checkout button
    Then User went to Order page
    And User check total price "19,81 ₴"
    And User press checkout button



