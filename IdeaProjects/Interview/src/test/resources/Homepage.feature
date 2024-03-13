Feature: Check the Homepage
  Scenario: Open Browser and check the URL is correctly navigate to Homepage
    Given User Open Chrome
    When User enter URL
    Then Hompage will be Open

    Scenario: Click on Product and check its details
      Given User is on Homepage
      When  User click on Product
      Then  User navigate to Product Details page

      Scenario: Click on Show Reviews to check Review of product
        Given User is on Product Page
        When User click on Show Reviews Button
        Then User Navigate to the Reviews Tab
