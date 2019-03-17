package twosvm.model.behavioralpolicy;

public enum EventType {

	CHANGE_LOCATION("changeLocation"), CHANGE_AMBIENT_TEMPERATURE(
			"changeAmbientTemperature"), CHANGE_USER_TEMPERATURE(
			"changeUserTemperature"), CHANGE_HUMIDITY("changeHumidity"), LIGHT_LEVEL(
			"lightLevel"), SMOKE_DETECTOR("smokeDetector"), GAS_DETECTOR(
			"gasDetector"), NOISE_LEVEL("noiseLevel"), EMPTY_AMBIENT(
			"emptyAmbient"), CURRENT_TIME("currentTime"), SPEED("speed"), USER_MOTION(
			"userMotion"), SOLO_MOTION("soloMotion"), VOLTAGE_DETECTOR(
			"voltageDetector"), USER_PRESSURE_LEVEL("userPressureLevel"), ELECTRICITY_CONSUMPTION(
			"electricityConsumption"), WATER_CONSUMPTION(
					"waterConsumption"), BATTERRY_LOW("batteryLow");

	private final String eventType;

	EventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * 
	 * @return
	 */
	public String getEventType() {
		return eventType;
	}

}
