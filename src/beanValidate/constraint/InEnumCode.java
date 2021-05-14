package beanValidate.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import beanValidate.validator.InEnumCodeValidator;

@Constraint(validatedBy = InEnumCodeValidator.class)
@Retention(RUNTIME)
@Target({FIELD})
public @interface InEnumCode {
	
	Class<? extends Enum<?>> enumClass();
	
	String message() default "%s must in %s";
	
}
