package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class WomenPage {
    WebDriver driver;

    static String blouseXpath = "//img[@title=\"Blouse\"]";
    static String addToCardButtonXpath = "//a[@data-id-product=\"2\"][@title=\"Add to cart\"]";
    static String continueShoppingButtonXpath = "//span[@title=\"Continue shopping\"]";

    By Blouse = By.xpath(blouseXpath);
    By AddBlouseButton = By.xpath(addToCardButtonXpath);
    By ContinueShoppingButton = By.xpath(continueShoppingButtonXpath);


    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBlouseToCard() {
        Wait wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(Exception.class);

        Actions actions = new Actions(driver);
        WebElement BlouseCard = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(Blouse));
        actions.moveToElement(BlouseCard);
        actions.perform();
        WebElement addBtn = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(AddBlouseButton));
        addBtn.click();
        WebElement continueShopping = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(ContinueShoppingButton));
        continueShopping.click();
    }

}