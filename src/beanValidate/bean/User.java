package beanValidate.bean;

import beanValidate.constraint.InStringArray;
import beanValidate.constraint.InEnum;
import beanValidate.constraint.InEnumCode;
import beanValidate.constraint.Length;
import beanValidate.constraint.NotNull;
import beanValidate.constraint.Pattern;
import beanValidate.constraint.Range;
import beanValidate.enumeration.SexEnum;
import beanValidate.enumeration.StatusEnum;

public class User {
	
//	@Range(minValue = 1.0, maxValue = 2.0)
	private Long id;
	
	@NotNull
//	@Length(minLength = 2, maxLength = 10)
//	@Pattern(pattern = "^1*2*$")
	private String name;
	
//	@Sex(sexEnum = SexEnum.MALE)
	private SexEnum sex;
	
//	@InEnum(enumClass = StatusEnum.class)
	private StatusEnum status;
	
//	@InEnumCode
	@InEnumCode(enumClass = StatusEnum.class)
	private String statusCode;
	
//	@InStringArray(StringArray = {"tom", "jeery", "anna"})
	private String[] nickname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String[] getNickname() {
		return nickname;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}
	
}
