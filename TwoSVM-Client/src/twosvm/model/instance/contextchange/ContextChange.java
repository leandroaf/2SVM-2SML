package twosvm.model.instance.contextchange;

import java.util.ArrayList;

import twosvm.model.instance.service.Serv;
import twosvm.model.instance.user.User;


public class ContextChange {
	
	private String eventName;

	private User user = new User();
	private ArrayList<Serv> serviceAL = new ArrayList<Serv>();
	
	private double noiseLevel;
	private double temperature;
	private double humidity;
	private double lightLevel;
	private double smokeDetector;
	private double time;

	/**
	 * 
	 * @return
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * 
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Serv> getService() {
		return serviceAL;
	}
	
	/**
	 * 
	 * @param service
	 */
	public void setServiceAL(Serv service) {
		this.serviceAL.add(service);
	}
	
	/**
	 * 
	 * @param serviceName
	 * @return
	 */
	public boolean hasService(String serviceName) {
		// le o M@RT para checar se ha aquele tipo de device (ou smartObject)
		// definido no modelo
		int amountSer = serviceAL.size();
		for (int indexSer = 0; indexSer < amountSer; indexSer++) {
			if (serviceAL.get(indexSer).equals(serviceName)) {
				return true;
			}
		}
		return false;
	} // fim do metodo hasSmartObject

	/**
	 * 
	 * @return
	 */
	public double noiseLevelSS() {
		return noiseLevel;
	}

	/**
	 * 
	 * @param noiseLevel
	 */
	public void setNoiseLevel(double noiseLevel) {
		this.noiseLevel = noiseLevel;
	}

	/**
	 * 
	 * @return
	 */
	public double temperatureSS() {
		return temperature;
	}

	/**
	 * 
	 * @param temperature
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * 
	 * @return
	 */
	public double humiditySS() {
		return humidity;
	}

	/**
	 * 
	 * @param humidity
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	/**
	 * 
	 * @return
	 */
	public double lightLevelSS() {
		return lightLevel;
	}

	/**
	 * 
	 * @param lightLevel
	 */
	public void setLightLevel(double lightLevel) {
		this.lightLevel = lightLevel;
	}

	/**
	 * 
	 * @return
	 */
	public double smokeDetectorSS() {
		return smokeDetector;
	}

	/**
	 * 
	 * @param smokeDetector
	 */
	public void setSmokeDetector(double smokeDetector) {
		this.smokeDetector = smokeDetector;
	}

	/**
	 * 
	 * @return
	 */
	public double timeSS() {
		return time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ContextChange [eventName=" + eventName + ", user=" + user
				+ ", serviceAL=" + serviceAL + ", noiseLevel=" + noiseLevel
				+ ", temperature=" + temperature + ", humidity=" + humidity
				+ ", lightLevel=" + lightLevel + ", smokeDetector="
				+ smokeDetector + ", time=" + time + "]";
	}

}
