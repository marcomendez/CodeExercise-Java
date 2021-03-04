package steps;

import Elements.Button;
import Elements.TextField;
import Elements.interfaces.ICheckable;
import Elements.interfaces.IClickable;
import Elements.interfaces.ITextable;
import core.WebDriverManager;
import helpers.PageName;
import helpers.UrlMap;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GenericSteps extends BaseStep {

    @Given("^I navigate to '([^']+?)' Page")
    public void NavigateToPage(final String pageName) {
        WebDriverManager.getInstance().getWebDriver().get(UrlMap.getUrl(pageName));
    }

    @And("^I click ([^']+?)(?: on ([^']+?) page|)$")
    public void Click(final String elementName, final String pageName) {
        IClickable iClickable = (IClickable) getElement(pageName, elementName);
        iClickable.Click();
    }

    @And("^I check ([^']+?)(?: on ([^']+?) page|)$")
    public void Check(final String elementName, final String pageName) {
        ICheckable iCheckable = (ICheckable) getElement(pageName, elementName);
        iCheckable.Check();
    }

    @And("^I set '([^']+?)' in ([^']+?)(?: on ([^']+?) page|)$")
    public void SetText(final String text, final String elementName, final String pageName) {
        ITextable iTextable = (ITextable) getElement(pageName, elementName);
        iTextable.set(text);
    }

    @And("^I am logged in on Guard Dog portal$")
    public void IamLoggedIn() {
        WebDriverManager.getInstance().getWebDriver().get(UrlMap.getUrl(PageName.Login));

        ((TextField) getElement(PageName.Login, "Email")).set("marticus123@gmail.com");

        ((TextField) getElement(PageName.Login, "Password")).set("1234567");

        ((Button) getElement(PageName.Login, "Log in Button")).Click();
    }

}
