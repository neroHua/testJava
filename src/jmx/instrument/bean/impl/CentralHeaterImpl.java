package jmx.instrument.bean.impl;

import jmx.instrument.bean.CentralHeater;

public class CentralHeaterImpl implements CentralHeater {

	public static final String HEATER_PROVIDER = "British Gas Company";

	int currentTemperature;

	@Override
	public String getCentralHeaterProvider() {
		return HEATER_PROVIDER;
	}

	@Override
	public int getCurrentTemperature() {
		return currentTemperature;
	}

	@Override
	public void setCurrentTemperature(int newTemperature) {
		currentTemperature = newTemperature;
	}

	@Override
	public void turnOff() {
		System.out.println("The heater is off. ");
	}

	@Override
	public void turnOn() {
		System.out.println("The heater is on. ");
	}

}
