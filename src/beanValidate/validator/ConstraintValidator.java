package beanValidate.validator;

import java.lang.annotation.Annotation;

public interface ConstraintValidator<A extends Annotation, T> {
	
    void initialize(A constraintAnnotation);

    void isValid(String fieldName, T fieldValue);
    
}
