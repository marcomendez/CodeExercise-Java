package pages;

import Annotations.customAnnotations.Locator;
import Annotations.customAnnotations.ViewPage;
import Annotations.enums.EnumElementType;
import Annotations.enums.EnumLocatorType;
import Elements.*;

@ViewPage(Name = "Login")
public class Login extends BasePage {

    @Locator(Name = "Keep me logged in", ElementType = EnumElementType.CHECKBOX, LocatorType = EnumLocatorType.CSS, LocatorValue = "[name='keepLogin']")
    public CheckBox keepMeLoggedIn;

    @Locator(Name = "Sign up", ElementType = EnumElementType.LABEL_LINK, LocatorType = EnumLocatorType.CSS, LocatorValue = "[href='/auth/sign-up']")
    public LabelLink signUp;

    @Locator(Name = "Forgot your password?", ElementType = EnumElementType.LABEL_LINK, LocatorType = EnumLocatorType.CSS, LocatorValue = "[class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiLink-button MuiTypography-h5 MuiTypography-colorPrimary']")
    public LabelLink forgotYourPassword;

    @Locator(Name = "Don't have an account?", ElementType = EnumElementType.LABEL, LocatorType = EnumLocatorType.XPATH, LocatorValue = "//*/div/form/div[7]/p")
    public Label doNotHaveAnAccount;


    @Locator(Name = "Title", ElementType = EnumElementType.LABEL, LocatorType = EnumLocatorType.CSS, LocatorValue = "h2[class='MuiTypography-root MuiTypography-h2 MuiTypography-colorTextPrimary']")
    public Label title;

    @Locator(Name = "Sub Title", ElementType = EnumElementType.LABEL, LocatorType = EnumLocatorType.CSS, LocatorValue = "p[class='MuiTypography-root MuiTypography-body2 MuiTypography-colorTextSecondary MuiTypography-gutterBottom']")
    public Label subTitle;

    @Locator(Name = "Slider", ElementType = EnumElementType.SLIDER, LocatorType = EnumLocatorType.CSS, LocatorValue = "[class='slider']")
    public Slider slider;

    @Locator(Name = "ReCaptcha", ElementType = EnumElementType.RECAPTCHA, LocatorType = EnumLocatorType.CSS, LocatorValue = "span[class^='recaptcha-checkbox']")
    public ReCaptcha reCaptcha;

    @Locator(Name = "Error", ElementType = EnumElementType.LABEL, LocatorType = EnumLocatorType.CSS, LocatorValue = "p[class='MuiFormHelperText-root Mui-error']")
    public Label error;

    @Locator(Name = "Next", ElementType = EnumElementType.BUTTON, LocatorType = EnumLocatorType.CSS, LocatorValue = " [aria-label='next']")
    public Button next;
}