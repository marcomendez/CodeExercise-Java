package Elements;

import Elements.interfaces.IClickable;
import org.openqa.selenium.By;

public class Button extends BaseElement implements IClickable {
    public Button(By webElement) {
        super(webElement);
    }

    @Override
    public void Click() {
        webElement.isDisplayed();
        webElement.click();
    }
}
