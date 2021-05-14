package beanValidate.validator;

import java.util.Arrays;

import beanValidate.constraint.InStringArray;
import beanValidate.exception.BeanValidateException;

public class InStringArrayValidator implements ConstraintValidator<InStringArray, String[]> {
	
	private String message;
	private String[] acceptListValue;
	
	@Override
	public void initialize(InStringArray acceptListValue) {
		this.message = acceptListValue.message();
		this.acceptListValue = acceptListValue.StringArray();
	}

	@Override
	public void isValid(String fieldName, String[] fieldValue) {
		for (int i = 0; i < fieldValue.length; i++) {
			boolean in = false;
			for (int j = 0; j < acceptListValue.length; j++) {
				if (acceptListValue[j].equals(fieldValue[i])) {
					in = true;
					break;
				}
			}
			if (!in) {
				throw new BeanValidateException(String.format(message, fieldName, Arrays.deepToString(acceptListValue)));
			}
		}
	}

}
