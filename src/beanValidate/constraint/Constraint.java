package beanValidate.constraint;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import beanValidate.validator.ConstraintValidator;

@Documented
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface Constraint {

    public Class<? extends ConstraintValidator<?, ?>> validatedBy();
    
}
