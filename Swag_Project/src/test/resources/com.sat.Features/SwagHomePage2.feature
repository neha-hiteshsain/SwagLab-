@Swag_Labs_Cart_Page
Feature: Swag Labs Cart Page

  Scenario Outline: User Login to Home page with valid Credential
    Given User navigates to Swag Home Page "<url>" with "<username>" and "<password>"
    When I click the Login Button
    Then validate "<Title>" is displayed on Product Page
    And I have clicked the Sauce Labs Backpack Add to Cart
    And the Shopping Cart Badge had the text "<num>"
    Then I have Clicked the Shopping Cart Badge
    And I have Clicked the Checkout Button

    Examples: 
      | url     | username        | password     | Title     | num |
      | SwagUrl | SwagUrl_userid1 | SwagPassword | Products |   1 |
      | SwagUrl | SwagUrl_userid3 | SwagPassword | Products |   1 |
      | SwagUrl | SwagUrl_userid4 | SwagPassword | Products |   1 |
