package pages;

import Elements.*;
import Elements.interfaces.IElement;
import core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.interfaces.IPage;

public class BasePage implements IPage {

    public IElement findElement(String locatorName) {

        By locator = By.cssSelector("[automation-id='" + locatorName + "']");
        WebDriverManager.getInstance().Wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement webElement = WebDriverManager.getInstance().getWebDriver().findElement(locator);

        String automationType = webElement.getAttribute("automation-type");
        IElement element = null;
        switch (automationType) {
            case "TextField":
                element = new TextField(locator);
                break;
            case "Button":
                element = new Button(locator);
                break;
            case "Table":
                element = new Table(locator);
                break;
            case "Link":
                element = new LabelLink(locator);
                break;
            case "CheckBox":
                element = new CheckBox(locator);
                break;
            case "Recaptcha":
                element = new ReCaptcha(locator);
                break;
            case "Image":
                element = new Image(locator);
                break;
            case "Slider":
                element = new Slider(locator);
                break;
        }
        return element;
    }


}
