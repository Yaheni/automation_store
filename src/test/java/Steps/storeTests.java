package Steps;
import PageObject.DressesPage;
import PageObject.MainPage;
import PageObject.TShirtsPage;
import PageObject.WomenPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;


public class storeTests{

    MainPage mainPage = new MainPage();
    WomenPage womenPage = new WomenPage();
    DressesPage dressesPage = new DressesPage();
    TShirtsPage tShirtsPage = new TShirtsPage();


    @Step
    @Given("^user entered in the \"Women\" category$")
    public void userEnteredInTheWomenCategory() {
        mainPage.goToWomenCategory();

    }

    @Step
    @When("^user clicks adding blouse to cart$")
    public void userClicksAddingBlouseToCart() {
        womenPage.addBlouseToCard();

    }

    @Step
    @Then("^user entered in the \"Dresses\" category$")
    public void userEnteredInTheDressesCategory() {
        mainPage.goToDressesCategory();
    }

    @Step
    @Then("^user clicks adding dress to cart$")
    public void userClicksAddingDressToCart() {
        dressesPage.addDressToCart();

    }

    @Step
    @Then("^blouse is added to the cart$")
    public void blouseIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkFirstItemInCart("Blouse");

    }

    @Step
    @Then("^dress is added to the cart$")
    public void dressIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkSecondItemInCart("Printed Dr...");
    }

    @Step
    @When("^user entered in the \"TShirts\" category$")
    public void userEnteredInTheCategory()  {
        mainPage.goToTshirtsCategory();
    }

    @Step
    @When("^user clicks adding tshirt to cart$")
    public void userClicksAddingTshirtToCart() {
        tShirtsPage.addTShirtToCart();
    }

    @Step
    @When("^tshirt is added to the cart$")
    public void tshirtIsAddedToTheCart() {
        mainPage.openCart();
        mainPage.checkThirdItemInCart("Faded Short Sleeve T-shirts");
    }

    @Step
    @When("^user deleted product from the cart$")
    public void userDeletedProductFromTheCart() {
        mainPage.openCart();
        mainPage.deleteItemFromCart();
    }

    @Step
    @Then("^deleted product disappeared$")
    public void deletedProductDisappeared() {
        mainPage.checkDeletedItem();
    }

    @Step
    @When("^user is finding deleted item$")
    public void userIsFindingDeletedItem() {
        mainPage.findProduct("Blouse");
    }

    @Step
    @Then("^deleted product is founded in the store$")
    public void deletedProductIsFoundedInTheStore() {
        mainPage.checkFoundedProduct("Blouse");
    }
}




