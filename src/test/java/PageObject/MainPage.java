package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    static String baseURL = "http://automationpractice.com/index.php";
    static String womenButtonPath = "//*[@id=\"block_top_menu\"]/ul/li[1]";
    static String dressesButtonPath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a";
    static String tshirtsButtonPath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a";
    static String cartButtonPath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a";
    static String amountOfGoodsTextXpath = "//*[@id=\"center_column\"]/h1/span[2]";
    static String firstThingPath = "//*[@id=\"header\"]//a[@class=\"cart_block_product_name\"][@title=\"Blouse\"]";
    static String secondThingPath = "//*[@id=\"header\"]//a[@class=\"cart_block_product_name\"][@title=\"Printed Dress\"]";
    static String thirdThingPath = "//*[@id=\"header\"]//a[@class=\"cart_block_product_name\"][@title=\"Faded Short Sleeve T-shirts\"]";
    static String deleteButtonPath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt[1]/span/a";
    static String searchInputPath = "//*[@id=\"search_query_top\"]";
    static String searchButtonPath = "//*[@id=\"searchbox\"]/button";
    static String foundedThingPath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a";

    By WomenButton = By.xpath(womenButtonPath);
    By DressesButton = By.xpath(dressesButtonPath);
    By TshirtsButton = By.xpath(tshirtsButtonPath);
    By CartButton = By.xpath(cartButtonPath);
    By AmountOfGoods = By.xpath(amountOfGoodsTextXpath);
    By FirstThing = By.xpath(firstThingPath);
    By SecondThing = By.xpath(secondThingPath);
    By ThirdThing = By.xpath(thirdThingPath);
    By DeleteButton = By.xpath(deleteButtonPath);
    By SearchInput = By.xpath(searchInputPath);
    By SearchButton = By.xpath(searchButtonPath);
    By FoundedThing = By.xpath(foundedThingPath);


    public void visit() {
        driver.get(baseURL);
    }

    public void goToWomenCategory(){
        driver.findElement(WomenButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void goToDressesCategory(){
        driver.findElement(DressesButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void goToTshirtsCategory(){
        driver.findElement(TshirtsButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void checkAmountOfGoodsInCategory(String expectedAmount) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String ActualAmount = driver.findElement(AmountOfGoods).getText();
        Assertions.assertEquals(ActualAmount, expectedAmount);
    }


    public void openCart() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement Cart = driver.findElement(CartButton);
        actions.moveToElement(Cart);
        actions.perform();
    }

    public void checkCart(String firstThingName, String secondThingName, String thirdThingName) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String FirstThingText = driver.findElement(FirstThing).getAttribute("title");
        String SecondThingText = driver.findElement(SecondThing).getAttribute("title");
        String ThirdThingText = driver.findElement(ThirdThing).getAttribute("title");
        Assertions.assertEquals(FirstThingText, firstThingName);
        Assertions.assertEquals(SecondThingText, secondThingName);
        Assertions.assertEquals(ThirdThingText, thirdThingName);
    }

    public void deletePreceFromCart() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(DeleteButton).click();
    }

    public void findThing(String FoundedThingText) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(SearchInput).sendKeys(FoundedThingText);
        driver.findElement(SearchButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String ActualThingText = driver.findElement(FoundedThing).getText();
        Assertions.assertEquals(ActualThingText, FoundedThingText);
    }

}