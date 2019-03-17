package twosvm.model.behavioralpolicy;

public enum EventType {

	CHANGE_LOCATION("ChangeLocation"), CHANGE_TEMPERATURE("ChangeTemperature"), CHANGE_HUMIDITY(
			"ChangeHumidity"), LIGHT_LEVEL("LightLevel"), SMOKE_DETECTOR(
			"SmokeDetector"), GAS_DETECTOR("GasDetector"), NOISE_LEVEL(
			"NoiseLevel"), TIME("Time"), BATTERY_LEVEL("Battery_Level"), USER_PRESSURE_LEVEL(
			"UserPressureLevel"), HEART_RATE_MONITOR("HeartRateMonitor");

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
