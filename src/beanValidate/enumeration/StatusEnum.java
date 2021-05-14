package beanValidate.enumeration;

public enum StatusEnum {

	INIT("INIT", "初始化"),
	START("START", "启动ʼ"),
	WORKING("WORKING", "工作中"),
	FINISH("FINISH", "完成"),
	STOP("STOP", "ֹͣ停止"),
	DEAD("DEAD", "死亡");
	
	private String code;
	private String description;
	
	StatusEnum(String code, String description){
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
