@TC_002_Login_Scenarion_with_different_credential
Feature: Login Scenarion with different credential

  Background: User Entering Home URL
    Given User navigates to Swag Home Page "SwagUrl"

  @Valid_Credential
  Scenario Outline: User Login to Home page with valid Credential
    When I set the "Username" to "<Username>"
    And I set a "Password" to "<Password>"
    When I click the Login Button
    Then validate "<Title>" is displayed on Product Page

    Examples: 
      | url     | Username      | Password     | Title    | num |
      | SwagUrl | standard_user | secret_sauce | Products |   1 |

  @Failed_Credential
  Scenario Outline: User Login to Home page with Unsuccessful Credential
    When I set the "Username" to "<Username>"
    And I set a "Password" to "<Password>"
    When I click the Login Button
    Then the "<Error_Msg>" is displayed

    Examples: 
      | url     | Username        | Password     | Error_Msg                                           |
      | SwagUrl | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |

  @problem_Credential
  Scenario Outline: User Login to Home page with Problem Credential
    When I set the "Username" to "<Username>"
    And I set a "Password" to "<Password>"
    When I click the Login Button

    Examples: 
      | url     | Username     | Password     | Error_Msg                                           |
      | SwagUrl | problem_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |

  @Glitch_Credential
  Scenario Outline: User Login to Home page with Problem Credential
    When I set the "Username" to "<Username>"
    And I set a "Password" to "<Password>"
    When I click the Login Button
    Then validate "<Title>" is displayed on Product Page

    Examples: 
      | url     | Username                | Password     | Title    |
      | SwagUrl | performance_glitch_user | secret_sauce | Products |
