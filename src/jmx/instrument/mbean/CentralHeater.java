package jmx.insturemnt.mbean;

public class CentralHeater implements CentralHeaterMBean {
	
	private final jmx.instrument.bean.CentralHeater centralHeater;
	
	public CentralHeater(jmx.instrument.bean.CentralHeater centralHeater) {
		this.centralHeater = centralHeater;
	}
	
	@Override
	public String getCentralHeaterProvider() {
		return centralHeater.getCentralHeaterProvider();
	}

	@Override
	public int getCurrentTemperature() {
		return centralHeater.getCurrentTemperature();
	}

	@Override
	public void setCurrentTemperature(int newTemperature) {
		centralHeater.setCurrentTemperature(newTemperature);
	}

	@Override
	public void turnOn() {
		centralHeater.turnOn();
	}

	@Override
	public void printCurrentTemperature() {
		System.out.println("current temperature is " + centralHeater.getCentralHeaterProvider());
	}

}
