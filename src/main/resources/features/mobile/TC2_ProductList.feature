Feature: Selecting Product product on Amazon

  Scenario: Select the iphone on Amazon
    Given User should be on Products Page
    When User should Scroll
    And User should click on product
    Then User should verify after selecting Product success message "Visit the Apple Store"