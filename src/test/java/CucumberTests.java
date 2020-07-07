
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "Steps",
        tags = "@store",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTests {
}