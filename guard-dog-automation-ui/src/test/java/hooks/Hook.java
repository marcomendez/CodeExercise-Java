package hooks;

import core.WebDriverManager;
import io.cucumber.java.After;

public class Hook {

    @After(order = 9999)
    public void afterScenario() {
      //  WebDriverManager.getInstance().getWebDriver().close();
    }
}