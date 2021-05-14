package beanValidate.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import beanValidate.validator.LengthValidator;

@Constraint(validatedBy = LengthValidator.class)
@Documented
@Retention(RUNTIME)
@Target({FIELD})
public @interface Length {
	
	int minLength() default Integer.MIN_VALUE;
	
	int maxLength() default Integer.MAX_VALUE;
	
	String message() default "%s length must >= %s and <= %s";
	
}
