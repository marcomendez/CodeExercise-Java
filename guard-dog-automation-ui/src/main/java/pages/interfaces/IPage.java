package pages.interfaces;

import Elements.interfaces.IElement;

public interface IPage {
    IElement findElement(String locatorName);
}
