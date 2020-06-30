package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;


public class TShirtsPage {
    WebDriver driver;

    static String tshirtXpath = "//img[@title=\"Faded Short Sleeve T-shirts\"]";
    static String addToCardButtonXpath = "//a[@data-id-product=\"1\"][@title=\"Add to cart\"]";
    static String continueShoppingButtonXpath = "//span[@title=\"Continue shopping\"]";

    By TShirt = By.xpath(tshirtXpath);
    By AddTShirtButton = By.xpath(addToCardButtonXpath);
    By continueShoppingButton = By.xpath(continueShoppingButtonXpath);

    public TShirtsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTShirtToCart() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement btn = driver.findElement(TShirt);
        actions.moveToElement(btn);
        actions.perform();
        driver.findElement(AddTShirtButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(continueShoppingButton).click();
    }

}