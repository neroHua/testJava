package beanValidate.exception;

public class BeanValidateException extends RuntimeException {
	
	public BeanValidateException() {	
	}
	
	public BeanValidateException(Exception excetpion) {
		super(excetpion);
	}
	
	public BeanValidateException(String message) {
		super(message);
	}
}
