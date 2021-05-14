package beanValidate.enumeration;

public enum SexEnum {

	FEMALE("FEMALE", "女性"),
	MALE("MALE", "男性");
	
	private String code;
	private String description;
	
	SexEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
}
