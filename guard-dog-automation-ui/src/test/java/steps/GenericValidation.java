package steps;

import Elements.Image;
import Elements.Slider;
import Elements.interfaces.ICheckable;
import Elements.interfaces.IElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GenericValidation extends BaseStep {

    @And("^I verify that ([^']+?) field contains '([^']+?)'(?: on ([^']+?) page|)$")
    public void VerifyThatElementContainsText(String elementName, String expectedResult, String pageName) {
        IElement iElement = (IElement) getElement(pageName, elementName);
        String actualResult = iElement.getText();
        assertTrue(actualResult.contains(expectedResult), "Actual result is not equals to Expect result :" + actualResult);
    }

    @And("^I verify that (.*) field is displayed(?: on ([^']+?) page|)$")
    public void verifyThaFieldIsDisplayed(String elementName, String pageName) {
        IElement iElement = (IElement) getElement(pageName, elementName);
        assertTrue(iElement.isDisplayed(), "Locator was not displayed.");
    }

    @And("^I verify that ([^']+?) is checked(?: on ([^']+?) page|)$")
    public void verifyThatElementIsChecked(String elementName, String pageName) {
        ICheckable iCheckable = (ICheckable) getElement(pageName, elementName);
        assertTrue(iCheckable.isChecked(), "Locator was not checked.");
    }

    @And("^I verify that the following fields are displayed(?: on ([^']+?) page|)$")
    public void verifyThatFieldsIsDisplayed(String pageName, DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
            IElement iElement = (IElement) getElement(pageName, columns.get(0));
            assertTrue(iElement.isDisplayed(), "Element : " + columns.get(0) + " is not displayed");
        }
    }

    @And("^I verify that ([^']+?) contains the following value(?: on ([^']+?) page|)$")
    public void verifyThatFieldsIsDisplayed(String elementName, String pageName, String text) {
        IElement iElement = (IElement) getElement(pageName, elementName);
        String actualResult = iElement.getText();
        assertTrue(actualResult.contains(text), "Actual result is not equals to Expect result :" + actualResult);
    }
}
