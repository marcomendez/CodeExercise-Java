package Elements;

import Elements.interfaces.IElement;
import core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseElement implements IElement {
    public WebElement webElement = null;

    public BaseElement(By byElement) {
        WebDriverManager.getInstance().Wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
        webElement = WebDriverManager.getInstance().getWebDriver().findElement(byElement);
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }
}
