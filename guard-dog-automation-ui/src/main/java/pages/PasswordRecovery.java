package pages;

import Annotations.customAnnotations.Locator;
import Annotations.customAnnotations.ViewPage;
import Annotations.enums.EnumElementType;
import Annotations.enums.EnumLocatorType;
import Elements.Label;
import Elements.ReCaptcha;

@ViewPage(Name = "Password Recovery")
public class PasswordRecovery extends BasePage {

    @Locator(Name = "Title", ElementType = EnumElementType.LABEL, LocatorType = EnumLocatorType.CSS, LocatorValue = "h2[class='MuiTypography-root MuiTypography-h2 MuiTypography-colorTextPrimary']")
    public Label title;

    @Locator(Name = "Message", ElementType = EnumElementType.LABEL, LocatorType = EnumLocatorType.CSS, LocatorValue = "p[class='MuiTypography-root MuiTypography-body2 MuiTypography-colorTextSecondary MuiTypography-gutterBottom']")
    public Label message;


    @Locator(Name = "ReCaptcha", ElementType = EnumElementType.RECAPTCHA, LocatorType = EnumLocatorType.ID, LocatorValue = "recaptcha-anchor")
    public ReCaptcha reCaptcha;
}
