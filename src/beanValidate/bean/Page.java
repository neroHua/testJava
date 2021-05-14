package beanValidate.bean;

import java.util.List;
import java.util.Map;

import beanValidate.constraint.Validate;

public class Page {

	private Integer pageSize;
	private Integer currentPage;
	
	@Validate
	private List<House> houseList;
	
//	@Valid
	private Map<String, House> houseMap;
	
//	@Validate
	private House house;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public List<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
}
