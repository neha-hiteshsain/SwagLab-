@TC_002_Swag_Labs_Checkout_Page
Feature: TC_002 Swag Labs Checkout step one Page

  Scenario Outline: User added Sauce Labs Backpack to the cart and was on the cart page
    Given User navigates to Swag Home Page "<url>" with "<username>" and "<password>"
    When I click the Login Button
    And I have clicked the Sauce Labs Backpack Add to Cart
    Then I have Clicked the Shopping Cart Badge
    And I have Clicked the Checkout Button
    And I set FirstName as Random FirstName
    And I set SecondName as Random SecondName
    And I set Zip  code Field Random Zip Code
    And I click the Continue Button
    Then the "Finish" is "Displayed"

    Examples: 
      | url     | username        | password     | Title     |
      | SwagUrl | SwagUrl_userid1 | SwagPassword | Swag Labs |
      | SwagUrl | SwagUrl_userid3 | SwagPassword | Swag Labs |
      | SwagUrl | SwagUrl_userid4 | SwagPassword | Swag Labs |
