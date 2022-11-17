package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = "src/test/resources/",
        glue = "",
        plugin = {"pretty"}
)
public class RunCucumber extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void setUp() {
    }

}
