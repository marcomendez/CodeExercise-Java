package pages;

import Annotations.customAnnotations.Locator;
import Annotations.customAnnotations.ViewPage;
import Annotations.enums.EnumElementType;
import Annotations.enums.EnumLocatorType;
import Elements.CheckBox;
import Elements.Label;
import Elements.TextField;

@ViewPage(Name = "Sign Up")
public class SignUp extends BasePage {

    @Locator(Name = "I agree to the terms of service and privacy policy", ElementType = EnumElementType.TEXT_FIELD, LocatorType = EnumLocatorType.CSS, LocatorValue = "[name='policy']")
    public TextField policy;

    @Locator(Name = "I accept the End-user license agreement", ElementType = EnumElementType.CHECKBOX, LocatorType = EnumLocatorType.CSS, LocatorValue = "[name='eula']")
    public CheckBox eula;

}