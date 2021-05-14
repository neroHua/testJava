package beanValidate;

import java.util.ArrayList;
import java.util.List;

import beanValidate.bean.House;
import beanValidate.bean.MusicHouse;
import beanValidate.bean.Page;
import beanValidate.bean.User;
import beanValidate.enumeration.SexEnum;
import beanValidate.enumeration.StatusEnum;
import beanValidate.validator.Validator;
import beanValidate.validator.ValidatorImpl;

public class Test {

	public static void main(String[] args) {
//		simpleTest();
		complexTest();
	}
	
	private static void complexTest() {
		List<House> houseList = new ArrayList<House>();
		MusicHouse musicHouse = new MusicHouse();
//		musicHouse.setAddress("address");
		musicHouse.setMusic("music");
		
		House house = new House();
//		house.setAddress("address");
		
		houseList.add(musicHouse);
		houseList.add(house);
		
		Page page = new Page();
		page.setPageSize(1);
		page.setCurrentPage(1);
		page.setHouseList(houseList);
//		page.setHouse(musicHouse);
		
		Validator validator = new ValidatorImpl();
		validator.validate(page);
	}
	
	private static void simpleTest() {
		User user = new User();
		user.setId(4L);
		user.setName("21");
		user.setName(null);
		user.setSex(SexEnum.FEMALE);
		
		user.setStatus(StatusEnum.START);
		user.setStatusCode("iNIT");
//		String[] nickName = {"tom", "lues", "nero"};
		String[] nickName = {"tom", "jeery"};
		user.setNickname(nickName);
		
		Validator validator = new ValidatorImpl();
		validator.validate(user);
	}

}
