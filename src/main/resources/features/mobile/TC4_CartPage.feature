Feature: Removing product from the Amazon Cart

  Scenario: Remove product from the Cart
    Given User should be on Cart
    When User should Verify the product added in the cart
    And User should click on delete
    Then User should Verify after removing the product from the product success message "was removed from Shopping Cart."