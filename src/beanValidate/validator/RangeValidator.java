package beanValidate.validator;

import beanValidate.constraint.Range;
import beanValidate.exception.BeanValidateException;

public class RangeValidator implements ConstraintValidator<Range, Object> {
	
	private double minValue;
	private double maxValue;
	private String message;

	@Override
	public void initialize(Range range) {
		this.minValue = range.minValue();
		this.maxValue = range.maxValue();
		this.message = range.message();
	}

	@Override
	public void isValid(String fieldName, Object fieldValue) {
		double value = Double.parseDouble(fieldValue.toString());
		if (value > maxValue || value < minValue) {
			throw new BeanValidateException(String.format(message, fieldName, minValue, maxValue));
		}
	}

}
