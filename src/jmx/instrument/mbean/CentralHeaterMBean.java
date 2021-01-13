package jmx.insturemnt.mbean;

public interface CentralHeaterMBean {

	public String getCentralHeaterProvider();

	public int getCurrentTemperature();

	public void setCurrentTemperature(int newTemperature);

	public void turnOn();

	public void printCurrentTemperature();

}
