package beanValidate.bean;

import beanValidate.constraint.NotNull;

public class House {
	
//	@NotNull
	private String address;
	
	private Integer area;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	
}
