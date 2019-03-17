package twosvm.model.behavioralpolicy;

import java.io.Serializable;

public class BehEvent implements Serializable {
	
	private String eventName;
	private String description;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;

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
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BehaviouralEvent [eventName=" + eventName + ", description="
				+ description + "]";
	}
		
}
