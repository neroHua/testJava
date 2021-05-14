package beanValidate.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import beanValidate.validator.PatternValidator;

@Documented
@Constraint(validatedBy = PatternValidator.class)
@Retention(RUNTIME)
@Target({FIELD})
public @interface Pattern {
	
	String pattern();
	
	String message() default "%s pattern must match %s";
	
}
