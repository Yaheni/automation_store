import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        features = "src/test/java/Features",
        glue = {"Steps"},
        tags = "@store",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)


public class CucumberTests {

    @BeforeClass
    public static void setUp() {

        Configuration.remote="http://localhost:4444/wd/hub/";
        Configuration.browser = "chrome";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.timeout = 7000;
    }

    @AfterClass

    public static void shutDown() {
        Selenide.closeWebDriver();
    }

}
