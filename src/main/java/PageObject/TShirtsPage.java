package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class TShirtsPage {


    SelenideElement tshirt = Selenide.$x("//img[@title=\"Faded Short Sleeve T-shirts\"]");
    SelenideElement addToCardButton = Selenide.$x("//a[@data-id-product=\"1\"][@title=\"Add to cart\"]");
    SelenideElement continueShoppingButton = Selenide.$x("//span[@title=\"Continue shopping\"]");

    public void addTShirtToCart() {
        tshirt.shouldBe(Condition.visible).scrollTo().hover();
        addToCardButton.shouldBe(Condition.visible).click();
        continueShoppingButton.shouldBe(Condition.visible).click();
    }

}