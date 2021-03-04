package Elements;

import Elements.interfaces.ICheckable;
import Elements.interfaces.IClickable;
import core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CheckBox extends BaseElement implements IClickable, ICheckable {

    private String checkMark;
    public CheckBox(By webElement) {
        super(webElement);
    }

    public CheckBox(By webElement, String checkMark) {
        super(webElement);
        this.checkMark = checkMark;
    }

    @Override
    public void Click() {
        webElement.click();
    }

    @Override
    public boolean isDisplayed() {
        boolean result = false;
        try {
            WebDriverManager.getInstance().Wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(checkMark)));
            result = true;
        } catch(Exception exception) {
            result = false;
            WebDriverManager.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return result;
    }

    @Override
    public void Check() {
        if (isNotChecked()) {
            webElement.click();
        }
    }

    @Override
    public void unCheck() {
        if (isChecked()) {
            webElement.click();
        }
    }

    @Override
    public boolean isNotChecked() {
        By checkmarks = By.cssSelector("input:not(:checked)[type='checkbox']" +  checkMark);

        boolean result = false;
        try {
            WebDriverManager.getInstance().Wait.until(ExpectedConditions.presenceOfElementLocated(checkmarks));
            result = true;
        } catch(Exception exception) {
            result = false;
            WebDriverManager.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return result;
    }

    @Override
    public boolean isChecked() {
        By checkmarks = By.cssSelector("input:checked[type='checkbox']" +  checkMark);

        boolean result = false;
        try {
            WebDriverManager.getInstance().Wait.until(ExpectedConditions.presenceOfElementLocated(checkmarks));
            result = true;
        } catch(Exception exception) {
            result = false;
            WebDriverManager.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return result;
    }
}
