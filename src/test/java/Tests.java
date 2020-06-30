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
    public void GoToWomenPage() {
        mainPage.goToWomenCategory();
    }

    @Test
    @Order(3)
    public void CheckAmountOfGoodsInWomenCategory(){
        mainPage.checkAmountOfGoodsInCategory("There are 7 products.");
    }

    @Test
    @Order(4)
    public void AddBlouseToCar() {
        womenPage.addBlouseToCard();
    }

    @Test
    @Order(5)
    public void GoToDressesCategory() {
        mainPage.goToDressesCategory();
    }

    @Test
    @Order(6)
    public void CheckAmountOfGoodsInDressesCategory() {
        mainPage.checkAmountOfGoodsInCategory("There are 5 products.");
    }

    @Test
    @Order(7)
    public void AddDressToCart() {
        dressesPage.addDressToCart();
    }

    @Test
    @Order(8)
    public void GoToTshirtsCategory() {
        mainPage.goToTshirtsCategory();
    }

    @Test
    @Order(9)
    public void CheckAmountOfGoodsInTShirtsCategory() {
        mainPage.checkAmountOfGoodsInCategory("There is 1 product.");
    }

    @Test
    @Order(10)
    public void AddTShirtToCart() {
        tShirtsPage.addTShirtToCart();
    }

    @Test
    @Order(11)
    public void OpenCart() {
        mainPage.openCart();
    }

    @Test
    @Order(12)
    public void CheckCart() {
        mainPage.checkCart("Blouse", "Printed Dress", "Faded Short Sleeve T-shirts");
    }

    @Test
    @Order(13)
    public void DeletePrece() {
        mainPage.deletePreceFromCart();
    }

    @Test
    @Order(14)
    public void FindThing() {
        mainPage.findThing("Blouse");
    }



}
