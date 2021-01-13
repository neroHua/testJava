package jmx.instrument.bean;

public interface CentralHeater {
	
	public String getCentralHeaterProvider();

	public int getCurrentTemperature();

	public void setCurrentTemperature(int newTemperature);

	public void turnOn();

	public void turnOff();

}
