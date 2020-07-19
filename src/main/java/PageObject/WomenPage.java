package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class WomenPage {

     SelenideElement Blouse = Selenide.$("#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link");
     SelenideElement AddBlouseButton = Selenide.$x("//a[@data-id-product=\"2\"][@title=\"Add to cart\"]");
     SelenideElement ContinueShoppingButton = Selenide.$x("//span[@title=\"Continue shopping\"]");

    @Step("Добавление блузочки")
    public void addBlouseToCard() {
        Blouse.shouldBe(Condition.visible).scrollTo().hover();
        AddBlouseButton.shouldBe(Condition.visible).click();
        ContinueShoppingButton.shouldBe(Condition.visible).click();
    }

}