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

    static String dressXpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img";
    static String addToCardButtonXpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]";
    static String continueShoppingButtonXpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span";

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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(continueShoppingButton).click();
    }


}