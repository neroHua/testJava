package beanValidate.validator;

public interface Validator {
	
	<T> void validate(T object);
	
}
