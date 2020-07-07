package Features;

import PageObject.DressesPage;
import PageObject.TShirtsPage;
import cucumber.api.java.ru.*;
import PageObject.MainPage;
import PageObject.WomenPage;


public class storeTests extends SetupTests {

    MainPage mainPage = new MainPage(driver);
    WomenPage womenPage = new WomenPage(driver);
    DressesPage dressesPage = new DressesPage(driver);
    TShirtsPage tShirtsPage = new TShirtsPage(driver);

    @Дано("^user entered in the \"Women\" category$")
    public void userEnteredInTheWomenCategory() {
        mainPage.visit();
        mainPage.goToWomenCategory();
    }

    @Когда("^user clicks adding blouse to cart$")
    public void userClicksAddingBlouseToCart() {
        womenPage.addBlouseToCard();
    }

    @Когда("^user entered in the \"Dresses\" category$")
    public void userEnteredInTheDressesCategory() {
        mainPage.goToDressesCategory();
    }

    @Когда("^user clicks adding dress to cart$")
    public void userClicksAddingDressToCart() {
        dressesPage.addDressToCart();

    }

    @Тогда("^blouse is added to the cart$")
    public void blouseIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkFirstItemInCart("Blouse");

    }

    @Тогда("^dress is added to the cart$")
    public void dressIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkSecondItemInCart("Printed Dress");
    }

    @Когда("^user entered in the \"TShirts\" category$")
    public void userEnteredInTheCategory()  {
        mainPage.goToTshirtsCategory();
    }


    @Когда("^user clicks adding tshirt to cart$")
    public void userClicksAddingTshirtToCart() {
        tShirtsPage.addTShirtToCart();
    }

    @Тогда("^tshirt is added to the cart$")
    public void tshirtIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkThirdItemInCart("Faded Short Sleeve T-shirts");
    }

    @Когда("^user deleted product from the cart$")
    public void userDeletedProductFromTheCart() {
        mainPage.openCart();
        mainPage.deleteItemFromCart();
    }

    @Тогда("^deleted product disappeared$")
    public void deletedProductDisappeared() {
        mainPage.checkDeletedItem();
    }

    @Когда("^user is finding deleted item$")
    public void userIsFindingDeletedItem() {
        mainPage.findProduct("Blouse");
    }

    @Тогда("^deleted product is founded in the store$")
    public void deletedProductIsFoundedInTheStore() {
        mainPage.checkFoundedProduct("Blouse");
    }
}




