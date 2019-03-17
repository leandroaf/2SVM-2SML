package twosvm.model.behavioralpolicy;

import java.io.Serializable;

public class BehAction implements Serializable {
	
	private String actionName;
	private String description;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/**
	 * 
	 * @return
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * 
	 * @param actionName
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

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
		return "BehaviouralAction [actionName=" + actionName + ", description="
				+ description + "]";
	}
	
}
