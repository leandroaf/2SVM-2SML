package twosvm.model.behavioralpolicy;

public enum ActionType {

	MOVE("Move"), TURN_ON("TurnOn"), TURN_OFF("TurnOff"), SEND_ALERT_FROM(
			"SendAlertFrom");

	private final String trigger;

	ActionType(String trigger) {
		this.trigger = trigger;
	}

	/**
	 * 
	 * @return
	 */
	public String getTrigger() {
		return trigger;
	}

}
