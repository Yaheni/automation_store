package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class DressesPage {
    WebDriver driver;

    public DressesPage(WebDriver driver) {
        this.driver = driver;
    }

    static String dressXpath = "//li[2]//img[@title=\"Printed Dress\"]";
    static String addToCardButtonXpath = "//a[@data-id-product=\"4\"][@title=\"Add to cart\"]";
    static String continueShoppingButtonXpath = "//span[@title=\"Continue shopping\"]";

    By Dress = By.xpath(dressXpath);
    By AddDressButton = By.xpath(addToCardButtonXpath);
    By continueShoppingButton = By.xpath(continueShoppingButtonXpath);


    public void addDressToCart() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement btn = driver.findElement(Dress);
        actions.moveToElement(btn);
        actions.perform();
        driver.findElement(AddDressButton).click();
        driver.findElement(continueShoppingButton).click();
    }


}