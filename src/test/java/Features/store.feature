# language: ru
@store
Функция: Adding products to cart and deleting

  Сценарий: Successful adding product in the cart and deleting one product after that

    Дано  user entered in the "Women" category
    Когда user clicks adding blouse to cart
    Тогда blouse is added to the cart
    Когда user entered in the "Dresses" category
    Когда user clicks adding dress to cart
    Тогда dress is added to the cart
    Когда user entered in the "TShirts" category
    Когда user clicks adding tshirt to cart
    Тогда tshirt is added to the cart
    Когда user deleted product from the cart
    Когда user is finding deleted item
    Тогда deleted product disappeared
    Тогда deleted product is founded in the store
