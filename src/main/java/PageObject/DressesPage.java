package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class DressesPage {

    SelenideElement Dress = Selenide.$x("//li[2]//img[@title=\"Printed Dress\"]");
    SelenideElement addToCardButton = Selenide.$x("//a[@data-id-product=\"4\"][@title=\"Add to cart\"]");
    SelenideElement continueShoppingButton = Selenide.$x("//span[@title=\"Continue shopping\"]");

    public void addDressToCart() {
        Dress.shouldBe(Condition.visible).scrollTo().hover();
        addToCardButton.shouldBe(Condition.visible).click();
        continueShoppingButton.shouldBe(Condition.visible).click();
}}

