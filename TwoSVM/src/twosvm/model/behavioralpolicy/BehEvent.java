package twosvm.model.behavioralpolicy;

import java.io.Serializable;

import twosvm.model.behavioralpolicy.EventType;

public class BehEvent implements Serializable {
	
	private String eventName;
	
	private EventType eventType;
	
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
	public EventType getEventType() {
		return eventType;
	}

	/**
	 * 
	 * @param eventType
	 */
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
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
		return "BehEvent [eventName=" + eventName + ", eventType=" + eventType
				+ ", description=" + description + "]";
	}
		
}
