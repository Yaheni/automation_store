import PageObject.DressesPage;
import PageObject.MainPage;
import PageObject.TShirtsPage;
import PageObject.WomenPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {

    public static WebDriver driver;

    MainPage mainPage = new MainPage(driver);
    WomenPage womenPage = new WomenPage(driver);
    DressesPage dressesPage = new DressesPage(driver);
    TShirtsPage tShirtsPage = new TShirtsPage(driver);


    @BeforeAll
    public static void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void End() {
        driver.close();
    }

    @Test
    @Order(1)
    public void HomePage(){
        mainPage.visit();
    }

    @Test
    @Order(2)
    public void WomanPageTests() {
        mainPage.goToWomenCategory();
        mainPage.checkAmountOfGoodsInCategory("There are 7 products.");
        womenPage.addBlouseToCard();
    }


    @Test
    @Order(3)
    public void DressesPageTests() {
        mainPage.goToDressesCategory();
        mainPage.checkAmountOfGoodsInCategory("There are 5 products.");
        dressesPage.addDressToCart();
    }


    @Test
    @Order(4)
    public void TshirtsPageTests() {
        mainPage.goToTshirtsCategory();
        mainPage.checkAmountOfGoodsInCategory("There is 1 product.");
        tShirtsPage.addTShirtToCart();
    }


    @Test
    @Order(5)
    public void CheckCartAndDeleteItem() {
        mainPage.openCart();
        mainPage.checkCart("Blouse", "Printed Dress", "Faded Short Sleeve T-shirts");
        mainPage.deleteItemFromCart();

    }


    @Test
    @Order(6)
    public void FindThing() {
        mainPage.findProduct("Blouse");
    }



}
