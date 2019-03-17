package twosvm.model.behavioralpolicy;

import java.util.ArrayList;

public class BehCondition {
	
	private String conditionName;
	private String description;
	private ArrayList<String> descriptionAL = new ArrayList<String>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	/**
	 * 
	 * @return
	 */
	public String getConditionName() {
		return conditionName;
	}
	
	/**
	 * 
	 * @param conditionName
	 */
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
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
	public ArrayList<String> getDescriptionAL() {
		return descriptionAL;
	}

	/**
	 * 
	 * @param descriptionAL
	 */
	public void setDescriptionAL(ArrayList<String> descriptionAL) {
		this.descriptionAL = descriptionAL;
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
		return "BehaviouralCondition [conditionName=" + conditionName
				+ ", description=" + description + ", descriptionAL="
				+ descriptionAL + "]";
	}

}
