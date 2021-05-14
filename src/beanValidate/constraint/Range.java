package beanValidate.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import beanValidate.validator.RangeValidator;

@Constraint(validatedBy = RangeValidator.class)
@Documented
@Retention(RUNTIME)
@Target({FIELD})
public @interface Range {
	
	double minValue() default Double.MIN_VALUE;
	
	double maxValue() default Double.MAX_VALUE;
	
	String message() default "%s value must >= %s and <= %s";
	
}
