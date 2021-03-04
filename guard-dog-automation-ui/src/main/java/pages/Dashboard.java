package pages;

import Annotations.customAnnotations.Locator;
import Annotations.customAnnotations.ViewPage;
import Annotations.enums.EnumElementType;
import Annotations.enums.EnumLocatorType;
import Elements.Image;
import Elements.interfaces.IElement;

@ViewPage(Name = "Dashboard")
public class Dashboard extends BasePage {

    @Locator(Name = "Welcome label", ElementType = EnumElementType.LABEL, LocatorType = EnumLocatorType.XPATH, LocatorValue = "//*/div/div[1]/div/div/div[1]/h5[1]")
    public IElement welcomeLabel;

    @Locator(Name = "Guard Dog Logo", ElementType = EnumElementType.IMAGE, LocatorType = EnumLocatorType.CSS, LocatorValue = "img[alt='Logo']")
    public Image guardDogLogo;

    @Locator(Name = "Devices Tab", ElementType = EnumElementType.BUTTON, LocatorType = EnumLocatorType.XPATH, LocatorValue = "//*/div/div[1]/div/div/div[2]/ul/li[1]/a")
    public IElement devicesTab;

    @Locator(Name = "Device Logs Tab", ElementType = EnumElementType.BUTTON, LocatorType = EnumLocatorType.CSS, LocatorValue = "[href='/app/device-logs']")
    public IElement DevicesLogs;

    @Locator(Name = "Find Devices Tab", ElementType = EnumElementType.BUTTON, LocatorType = EnumLocatorType.CSS, LocatorValue = "[href='/app/find-devices']")
    public IElement findDevicesTab;

    @Locator(Name = "Account Tab", ElementType = EnumElementType.BUTTON, LocatorType = EnumLocatorType.CSS, LocatorValue = "[href='/app/account']")
    public IElement accountTab;

    @Locator(Name = "Support Tab", ElementType = EnumElementType.BUTTON, LocatorType = EnumLocatorType.CSS, LocatorValue = "[href='https://guarddog.ai/contact-3/contact/']")
    public IElement supportTab;

    @Locator(Name = "Log Out Tab", ElementType = EnumElementType.BUTTON, LocatorType = EnumLocatorType.CSS, LocatorValue = "[href='/#']")
    public IElement logOutTab;
}
