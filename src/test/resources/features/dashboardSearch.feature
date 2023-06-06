Feature: Search functionality verification

  Scenario: Verify search accuracy and ability of user to add and remove item from the cart
    Given user search for "stainless work table"
    Then verify every product in the search result has the word "Table" in its title
    Then verify user is able to add the last of found items to Cart
    And verify user is able to empty the cart



