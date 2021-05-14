package beanValidate.validator;

import beanValidate.constraint.Length;
import beanValidate.exception.BeanValidateException;

public class LengthValidator implements ConstraintValidator<Length, String> {
	
	private int maxLength;
	private int minLength;
	private String message;

	@Override
	public void initialize(Length length) {
		this.maxLength = length.maxLength();
		this.minLength = length.minLength();
		this.message = length.message();
	}

	@Override
	public void isValid(String fieldName, String fieldValue) {
		if (fieldValue.length() > maxLength || fieldValue.length() < minLength) {
			throw new BeanValidateException(String.format(message, fieldName, minLength, maxLength));
		}
	}

}
