@browser
Feature: nopCommerce Test

  Background: Register and login a user in nopCommerce
    Given the user navigates to "https://demo.nopcommerce.com/"
    When clicks on register
    And the user fills the form with "John" and "Doe" and "1" and "8" and "1978" and "john@mail.com" and "ABCD" and "123456"
    And clicks on login
    And the user enters "john@mail.com" and "123456"
    Then user is logged in

  Scenario: The user can buy books
    When the user selects books in the menu
    And buys one of each one
    And goes to the cart
    And selects checkout accepting the terms of service
    And selects country "Mexico" city "CDMX" address "random st #123" zipCode "15926" phone "7845129630"
    And selects shipping method
    And selects payment method
    And selects payment information
    And confirms the order
    Then order is requested successfully


