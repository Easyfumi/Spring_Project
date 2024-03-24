package ru.marinin.defaultPackage;

import ru.marinin.NeedToString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultAnnotation {
    Class value() default Reset.class;
}
