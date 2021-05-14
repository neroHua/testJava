package beanValidate.validator;

import beanValidate.constraint.NotNull;
import beanValidate.exception.BeanValidateException;

public class NotNullValidator implements ConstraintValidator<NotNull, Object> {
	
	private String message;
	
	@Override
	public void initialize(NotNull notNull) {
		message = notNull.message();
	}

	@Override
	public void isValid(String fieldName, Object fieldValue) {
		if (null == fieldValue) {
			throw new BeanValidateException(String.format(message, fieldName));
		}
	}

}
