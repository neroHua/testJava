package beanValidate.validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import beanValidate.constraint.InEnumCode;
import beanValidate.exception.BeanValidateException;

public class InEnumCodeValidator implements ConstraintValidator<InEnumCode, String> {
	
	private static final String VALUES = "values";
	private static final String GET_CODE = "getCode";
	
	private String[] codeArray;
	private String message;
	
	@Override
	public void initialize(InEnumCode inEnumCode) {
		this.message = inEnumCode.message();
		
		Class<? extends Enum<?>> enumClass = inEnumCode.enumClass();
		
		Method valueMethod;
		Method codeMethod;
		try {
			valueMethod = enumClass.getMethod(VALUES);
			codeMethod = enumClass.getMethod(GET_CODE);
		} catch (NoSuchMethodException e) {
			throw new BeanValidateException(e);
		} catch (SecurityException e) {
			throw new BeanValidateException(e);
		}
		
		
		try {
			Enum<?>[] enumArray = (Enum<?>[]) valueMethod.invoke(null, null);
			codeArray = new String[enumArray.length];
			for (int i = 0; i < enumArray.length; i++) {
				String code = (String) codeMethod.invoke(enumArray[i], null);
				codeArray[i] = code;
			}
		} catch (IllegalAccessException e) {
			throw new BeanValidateException(e);
		} catch (IllegalArgumentException e) {
			throw new BeanValidateException(e);
		} catch (InvocationTargetException e) {
			throw new BeanValidateException(e);
		}
			
	}

	@Override
	public void isValid(String fieldName, String fieldValue) {
		for (String code : codeArray) {
			if (code.equals(fieldValue)) {
				return;
			}
		}

		throw new BeanValidateException(String.format(message, fieldName, Arrays.toString(codeArray)));
	}

}
