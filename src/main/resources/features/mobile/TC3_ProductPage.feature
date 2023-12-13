Feature: Adding product to the Amazon Cart

  Scenario: Adding the product to the Cart
    Given User should be on Product Page
    When User should Scroll until the add to cart is visible
    And User should click on add to cart
    Then User should verify after adding product in to cart success message "Send as a gift. Include custom message"