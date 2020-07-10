# language: en
@store

Feature: Adding products to cart and deleting

  Scenario: Successful adding product in the cart and deleting one product after that

    Given user entered in the "Women" category
    When user clicks adding blouse to cart
    Then blouse is added to the cart
    When user entered in the "Dresses" category
    When user clicks adding dress to cart
    Then dress is added to the cart
    When user entered in the "TShirts" category
    When user clicks adding tshirt to cart
    Then tshirt is added to the cart
    When user deleted product from the cart
    When user is finding deleted item
    Then deleted product disappeared
    Then deleted product is founded in the store
