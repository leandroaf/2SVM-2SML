package twosvm.model.behavioralpolicy;

import java.io.Serializable;

import twosvm.model.behavioralpolicy.ActionType;

public class BehAction implements Serializable {
	
	private String actionName;
	private ActionType actionType;
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

	/**
	 * 
	 * @return
	 */
	public ActionType getActionType() {
		return actionType;
	}

	/**
	 * 
	 * @param actionType
	 */
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	@Override
	public String toString() {
		return "BehAction [actionName=" + actionName + ", actionType="
				+ actionType + ", description=" + description + "]";
	}
	
}
