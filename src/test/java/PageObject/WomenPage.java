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
    static String addToCardButtonXpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]";
    static String continueShoppingButtonXpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span";

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