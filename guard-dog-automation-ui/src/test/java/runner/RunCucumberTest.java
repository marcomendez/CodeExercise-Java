package runner;

import core.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = "src/test/resources/",
        glue = {"steps"},
        plugin = {"pretty", "json:build/cucumber/cucumber.json", "rerun:build/cucumber/rerun.txt",}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @AfterTest
    public void close() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}