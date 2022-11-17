package Elements;

import Elements.interfaces.ITextable;
import core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;

public class TextField extends BaseElement implements ITextable {
    public TextField(By webElement) {
        super(webElement);
    }

    @Override
    public void set(String value) {
       webElement.clear();
        // sending Ctrl+a by Keys.Chord()
        String s = Keys.chord(Keys.CONTROL, "a");
        webElement.sendKeys(s);
        // sending DELETE key
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(value);
    }
}
