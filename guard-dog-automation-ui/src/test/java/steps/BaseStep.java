package steps;

import Annotations.customAnnotations.Locator;
import Annotations.customAnnotations.ViewPage;
import Elements.*;
import Elements.interfaces.IElement;
import org.openqa.selenium.By;
import org.reflections.Reflections;
import pages.BasePage;
import pages.interfaces.IPage;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static Annotations.enums.EnumElementType.RECAPTCHA;

public class BaseStep {

    private static Map page = null;
    public String pageNameParam = "";

    static {
        Reflections reflections = new Reflections();
        Set<Class<?>> viewPageNameClasses = reflections.getTypesAnnotatedWith(ViewPage.class);
        Map challengeClassesMap = viewPageNameClasses
                .stream()
                .collect(Collectors.toMap(viewPageNameClass -> viewPageNameClass.getAnnotation(ViewPage.class).Name(),
                        BaseStep::createNewInstanceOfClass));
        page = challengeClassesMap;
    }

    public IPage findPage(String pageName) {
        return page.containsKey(pageName) ? (IPage) page.get(pageName) : new BasePage();
    }

    public IElement getElement(String pageName, String elementName) {
        IPage page = pageName == null ? findPage(pageNameParam) : findPage(pageName);
        pageNameParam = pageName == null ? pageNameParam : pageName;

        Locator locator = findLocator(page, elementName);
        return locator != null ? FactoryElement(locator) : page.findElement(elementName);
    }

    private static <T> T createNewInstanceOfClass(Class<T> someClass) {
        try {
            return someClass.newInstance();
        } catch (Exception e) {
            return null; //Bad idea but now it's waste of time
        }
    }

    private static <T> Locator createLocatorInstance(Field someClass) {
        try {
            return someClass.getAnnotation(Locator.class);
        } catch (Exception e) {
            return null;
        }
    }

    private Locator findLocator(final IPage cls, final String locatorName) {

        Map challengeClassesMap = Arrays.stream(cls.getClass().getDeclaredFields()).collect(
                Collectors.toMap(viewPageNameClass -> viewPageNameClass.getAnnotation(Locator.class).Name(), BaseStep::createLocatorInstance)
        );

        return challengeClassesMap.containsKey(locatorName) ? (Locator) challengeClassesMap.get(locatorName) : null;
    }

    private By FactoryBy(Locator locator) {
        switch (locator.LocatorType()) {
            case ID:
                return By.id(locator.LocatorValue());
            case XPATH:
                return By.xpath(locator.LocatorValue());
            case CSS:
                return By.cssSelector(locator.LocatorValue());
            case NAME:
                return By.name(locator.LocatorValue());
            case CLASSNAME:
                return By.className(locator.LocatorValue());
        }
        return null;
    }

    private IElement FactoryElement(Locator locator) {
        IElement element = null;
        switch (locator.ElementType()) {
            case BUTTON:
                element = new Button(FactoryBy(locator));
                break;
            case LABEL:
                element = new Label(FactoryBy(locator));
                break;
            case LABEL_LINK:
                element = new LabelLink(FactoryBy(locator));
                break;
            case TEXT_FIELD:
                element = new TextField(FactoryBy(locator));
                break;
            case TABLE:
                element = new Table(FactoryBy(locator));
                break;
            case CHECKBOX:
                element = new CheckBox(FactoryBy(locator), locator.LocatorValue());
                break;
            case RECAPTCHA:
                element = new ReCaptcha(FactoryBy(locator));
                break;
            case IMAGE:
                element = new Image(FactoryBy(locator));
                break;
            case SLIDER:
                element = new Slider(FactoryBy(locator));
                break;
        }
        return element;
    }
}

