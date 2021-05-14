package beanValidate.bean;

import beanValidate.constraint.NotNull;

public class MusicHouse extends House {
	
	@NotNull
	private String color;
	
	private String music;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}
	
	

}
