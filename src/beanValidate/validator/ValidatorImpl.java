package beanValidate.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;

import beanValidate.constraint.Constraint;
import beanValidate.constraint.Validate;
import beanValidate.exception.BeanValidateException;

public class ValidatorImpl implements Validator {

	@Override
	public <T> void validate(T object) {
		Class<?> clazz = object.getClass();
		while (clazz != Object.class) {
			try {
				validateForOneClass(object, clazz);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
				throw new BeanValidateException(e);
			}
			
			clazz = clazz.getSuperclass();
		}
	}

	private <T> void validateForOneClass(T object, Class<?> clazz)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException {
		Field[] declaredFields = clazz.getDeclaredFields();
		
		for (Field field : declaredFields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				field.setAccessible(true);
				validateThisFieldForThisAnnotation(annotation, field.getName(), field.get(object), field.getType());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private <A extends Annotation, B> void validateThisFieldForThisAnnotation(Annotation annotation, String filedName, Object fieldvalue, Class<B> fieldClass)
			throws InstantiationException, IllegalAccessException {
		if (Validate.class == annotation.annotationType()) {
			recurseValidate(fieldvalue, fieldClass);
		}
		
		Class<? extends Annotation> annotationType =  annotation.annotationType();
		Constraint constraint = annotationType.getAnnotation(Constraint.class);
		Class<? extends ConstraintValidator<?, ?>> constraintValidatorClass = constraint.validatedBy();

		ConstraintValidator<A, B> constraintValidator = (ConstraintValidator<A, B>) constraintValidatorClass.newInstance();
		constraintValidator.initialize((A) annotation);
		constraintValidator.isValid(filedName, (B) fieldvalue);
	}

	private <B> void recurseValidate(Object fieldvalue, Class<B> fieldClass) {
		if (Collection.class.isAssignableFrom(fieldClass)) {
			Collection<?> fieldCollection = (Collection<?>) fieldvalue;
			Iterator<?> iterator = fieldCollection.iterator();
			while (iterator.hasNext()) {
				Object next = iterator.next();
				validate(next);
			}
			return;
		}
		
		validate(fieldvalue);
	}

}
