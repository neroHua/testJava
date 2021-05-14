package beanValidate.validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import beanValidate.constraint.InEnum;
import beanValidate.exception.BeanValidateException;

public class InEnumValidator implements ConstraintValidator<InEnum, Enum<?>> {
	
	private static final String VALUES = "values";
	
	private Enum<?>[] enumArray;
	private String message;
	
	@Override
	public void initialize(InEnum inEnum) {
		this.message = inEnum.message();
		
		Class<? extends Enum<?>> enumClass = inEnum.enumClass();
		
		Method method;
		try {
			method = enumClass.getMethod(VALUES);
		} catch (NoSuchMethodException e) {
			throw new BeanValidateException(e);
		} catch (SecurityException e) {
			throw new BeanValidateException(e);
		}
		
		try {
			enumArray = (Enum[]) method.invoke(null, null);
		} catch (IllegalAccessException e) {
			throw new BeanValidateException(e);
		} catch (IllegalArgumentException e) {
			throw new BeanValidateException(e);
		} catch (InvocationTargetException e) {
			throw new BeanValidateException(e);
		}
	}

	@Override
	public void isValid(String fieldName, Enum<?> fieldValue) {
		for (Enum<?> enumTemp : enumArray) {
			if (enumTemp.equals(fieldValue)) {
				return;
			}
		}

		throw new BeanValidateException(String.format(message, fieldName, Arrays.toString(enumArray)));
	}

}
