package beanValidate.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import beanValidate.validator.InStringArrayValidator;

@Constraint(validatedBy = InStringArrayValidator.class)
@Documented
@Retention(RUNTIME)
@Target({FIELD})
public @interface InStringArray {
	
	String[] StringArray();
	
	String message() default "the String in %s must in %s";
	
}
