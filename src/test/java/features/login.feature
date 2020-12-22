Feature: Big Basket  Add to Cart Feature

  Scenario: Big Basket Add to Cart Test Scenario

    Given user is already on Home Page
    Then user clicks on search button
    Then user select By Availability Filter
    And user select item Category Filter
    Then user select by Brand
    Then user gets Respective product names
    Then user clicks on add to cart button
    Then user clicks on Cart button
    Then user removes the items in cart
    Then user closes the browser