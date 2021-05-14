package beanValidate.validator;

import java.util.regex.Matcher;

import beanValidate.constraint.Pattern;
import beanValidate.exception.BeanValidateException;

public class PatternValidator implements ConstraintValidator<Pattern, String> {
	
	private java.util.regex.Pattern compilePattern;
	private String pattern;
	private String message;
	
	@Override
	public void initialize(Pattern pattern) {
		this.message = pattern.message();
		this.pattern = pattern.pattern();
		this.compilePattern = java.util.regex.Pattern.compile(pattern.pattern());
	}

	@Override
	public void isValid(String fieldName, String fieldValue) {
        Matcher matcher = compilePattern.matcher(fieldValue);
        if(!matcher.matches()) {
        	throw new BeanValidateException(String.format(message, fieldName, pattern));
        }
	}
	
}
