package Elements;

import Elements.interfaces.IClickable;
import org.openqa.selenium.By;

public class LabelLink extends BaseElement implements IClickable {

    public LabelLink(By webElement) {
        super(webElement);
    }

    @Override
    public void Click() {
        webElement.click();
    }
}
