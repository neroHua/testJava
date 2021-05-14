/**
 * 
 */
package beanValidate.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import beanValidate.validator.NotNullValidator;

@Documented
@Retention(RUNTIME)
@Target({FIELD})
@Constraint(validatedBy = NotNullValidator.class)
public @interface NotNull {

	
	String message() default "%s cant't be null";
	
}
