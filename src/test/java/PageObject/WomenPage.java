package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class WomenPage {
    WebDriver driver;

    static String blouseXpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img";
    static String addToCardButtonXpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]";
    static String continueShoppingButtonXpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span";

    By Blouse = By.xpath(blouseXpath);
    By AddBlouseButton = By.xpath(addToCardButtonXpath);
    By continueShoppingButton = By.xpath(continueShoppingButtonXpath);


    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBlouseToCard() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement btn = driver.findElement(Blouse);
        actions.moveToElement(btn);
        actions.perform();
        driver.findElement(AddBlouseButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(continueShoppingButton).click();
    }


}