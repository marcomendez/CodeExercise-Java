package Elements;

import Elements.interfaces.ITable;
import org.openqa.selenium.By;

public class Table extends BaseElement implements ITable {
    public Table(By webElement) {
        super(webElement);
    }
}
