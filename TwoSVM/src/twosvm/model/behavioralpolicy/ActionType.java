package twosvm.model.behavioralpolicy;

public enum ActionType {

	MOVE_APP("MoveApp"), START_APP("StartApp"), START_SERVICE("StartService"), FINALIZE_APP(
			"FinalizaApp"), FINALIZE_SERVICE("FinalizeService"), SEND_ALERT("SendAlert");

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
