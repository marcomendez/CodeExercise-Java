package Annotations.customAnnotations;

import Annotations.enums.EnumElementType;
import Annotations.enums.EnumLocatorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Locator {

    String Name();
    EnumElementType ElementType () ;
    EnumLocatorType LocatorType () ;
    String LocatorValue() ;
}
