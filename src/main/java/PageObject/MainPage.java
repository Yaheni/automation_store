package PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class MainPage {

    static String baseURL = "http://automationpractice.com/index.php";

    private SelenideElement WomenButton = Selenide.$x("//li//a[@title=\"Women\"]");
    private SelenideElement DressesButton = Selenide.$x("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    private SelenideElement TshirtsButton = Selenide.$x("//li[3]//a[@title=\"T-shirts\"]");
    private SelenideElement CartButton = Selenide.$x("//a[@title=\"View my shopping cart\"]");
    private SelenideElement AmountOfGoods = Selenide.$x("//*[@id=\"center_column\"]/h1/span[2]");
    private SelenideElement FirstThing = Selenide.$x("//*[@id=\"header\"]//a[@class=\"cart_block_product_name\"][@title=\"Blouse\"]");
    private SelenideElement SecondThing = Selenide.$x("//*[@id=\"header\"]//a[@class=\"cart_block_product_name\"][@title=\"Printed Dress\"]");
    private SelenideElement ThirdThing = Selenide.$x("//*[@id=\"header\"]//a[@class=\"cart_block_product_name\"][@title=\"Faded Short Sleeve T-shirts\"]");
    private SelenideElement DeleteButton = Selenide.$x("//dt[@class=\"first_item\"]//a[@class='ajax_cart_block_remove_link']");
    private SelenideElement SearchButton = Selenide.$x("//*[@id=\"searchbox\"]/button");
    private SelenideElement SearchInput = Selenide.$x("//*[@id=\"search_query_top\"]");
    private SelenideElement FoundedThing = Selenide.$x("//div[@id=\"center_column\"]//a[@class=\"product-name\"]");
    private SelenideElement AmountCartProducts = Selenide.$x("//a//span[@class=\"ajax_cart_quantity\"]");

    public void goToWomenCategory() {
        Selenide.open(baseURL);
        WomenButton.click();

    }

    public void goToDressesCategory(){
        DressesButton.click();
    }

    public void goToTshirtsCategory(){
        TshirtsButton.click();
    }

    public void checkAmountOfGoodsInCategory(String expectedAmount) {
        AmountOfGoods.shouldHave(Condition.text(expectedAmount));
    }


    public void openCart() {
        CartButton.shouldBe(Condition.visible).scrollTo().hover();
    }

    public void checkCart(String firstThingName, String secondThingName, String thirdThingName) {
        FirstThing.shouldHave(Condition.text(firstThingName));
        SecondThing.shouldHave(Condition.text(secondThingName));
        ThirdThing.shouldHave(Condition.text(thirdThingName));

    }

    public void checkFirstItemInCart(String itemName) {
        FirstThing.shouldHave(Condition.text(itemName));
    }

    public void checkSecondItemInCart(String itemName) {
       SecondThing.shouldHave(Condition.text(itemName));
    }

    public void checkThirdItemInCart(String itemName) {
        ThirdThing.shouldHave(Condition.attribute("title", itemName));
    }

    public void deleteItemFromCart() {
        DeleteButton.click();
    }

    public void checkDeletedItem() {
        AmountCartProducts.shouldHave(Condition.text("2"));
    }

    public void findProduct(String FoundedThingText) {
        SearchInput.setValue(FoundedThingText).pressEnter();
        FoundedThing.shouldHave(Condition.text(FoundedThingText));
    }

    public void checkFoundedProduct(String foundedProduct) {
        FoundedThing.shouldHave(Condition.text(foundedProduct));
    }

}