package beanValidate.validator;

import java.util.Collection;

import beanValidate.constraint.NotEmpty;
import beanValidate.exception.BeanValidateException;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, Collection<?>> {
	
	private String message;
	
	@Override
	public void initialize(NotEmpty notEmpty) {
		message = notEmpty.message();
	}

	@Override
	public void isValid(String fieldName, Collection<?> fieldValue) {
		if (fieldValue.size() <= 0) {
			throw new BeanValidateException(String.format(message, fieldName));
		}
	}

}
