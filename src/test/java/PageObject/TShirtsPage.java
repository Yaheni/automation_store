package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;


public class TShirtsPage {
    WebDriver driver;

    static String tshirtXpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img";
    static String addToCardButtonXpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]";
    static String continueShoppingButtonXpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span";

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