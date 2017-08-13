package javaenhance.part02.annotation0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
	String ID();
	String name();
	String gender() default "female";
	int[] arr() default {1, 2, 3};
	MetaAnnotation annotationAttr() default @MetaAnnotation(value="Lee");
}
