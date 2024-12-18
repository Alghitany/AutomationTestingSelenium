Feature: user could add different products to Shopping cart
  Scenario: user add product to shopping cart
    When user click on the add to cart button
    And choose the specified features of the product
    And confirm adding to shopping cart
    Then The product added successfully to shopping cart
