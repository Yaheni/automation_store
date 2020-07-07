package Steps;

import PageObject.DressesPage;
import PageObject.MainPage;
import PageObject.TShirtsPage;
import PageObject.WomenPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class storeTests extends SetupTests {

    MainPage mainPage = new MainPage(driver);
    WomenPage womenPage = new WomenPage(driver);
    DressesPage dressesPage = new DressesPage(driver);
    TShirtsPage tShirtsPage = new TShirtsPage(driver);

    @Given("^user entered in the \"Women\" category$")
    public void userEnteredInTheWomenCategory() {
        mainPage.visit();
        mainPage.goToWomenCategory();
    }

    @When("^user clicks adding blouse to cart$")
    public void userClicksAddingBlouseToCart() {
        womenPage.addBlouseToCard();
    }

    @Then("^user entered in the \"Dresses\" category$")
    public void userEnteredInTheDressesCategory() {
        mainPage.goToDressesCategory();
    }

    @Then("^user clicks adding dress to cart$")
    public void userClicksAddingDressToCart() {
        dressesPage.addDressToCart();

    }

    @Then("^blouse is added to the cart$")
    public void blouseIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkFirstItemInCart("Blouse");

    }

    @Then("^dress is added to the cart$")
    public void dressIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkSecondItemInCart("Printed Dress");
    }

    @When("^user entered in the \"TShirts\" category$")
    public void userEnteredInTheCategory()  {
        mainPage.goToTshirtsCategory();
    }


    @When("^user clicks adding tshirt to cart$")
    public void userClicksAddingTshirtToCart() {
        tShirtsPage.addTShirtToCart();
    }

    @When("^tshirt is added to the cart$")
    public void tshirtIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkThirdItemInCart("Faded Short Sleeve T-shirts");
    }

    @When("^user deleted product from the cart$")
    public void userDeletedProductFromTheCart() {
        mainPage.openCart();
        mainPage.deleteItemFromCart();
    }

    @Then("^deleted product disappeared$")
    public void deletedProductDisappeared() {
        mainPage.checkDeletedItem();
    }

    @When("^user is finding deleted item$")
    public void userIsFindingDeletedItem() {
        mainPage.findProduct("Blouse");
    }

    @Then("^deleted product is founded in the store$")
    public void deletedProductIsFoundedInTheStore() {
        mainPage.checkFoundedProduct("Blouse");
    }
}



