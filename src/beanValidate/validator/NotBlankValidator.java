package beanValidate.validator;

import beanValidate.constraint.NotBlank;
import beanValidate.exception.BeanValidateException;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {
	
	private String message;
	
	@Override
	public void initialize(NotBlank notBlank) {
		message = notBlank.message();
	}

	@Override
	public void isValid(String fieldName, String fieldValue) {
		if (fieldValue.trim().length() < 0) {
			throw new BeanValidateException(String.format(message, fieldName));
		}
	}

}
