package Elements;

import org.openqa.selenium.By;

public class Image extends  BaseElement{
    public Image(By byElement) {
        super(byElement);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isEnabled();
    }
}
