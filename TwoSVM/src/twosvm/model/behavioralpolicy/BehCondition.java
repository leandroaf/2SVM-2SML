package twosvm.model.behavioralpolicy;

public class BehCondition {
	
	private String conditionName;
	private String description;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BehCondition [conditionName=" + conditionName
				+ ", description=" + description + "]";
	}
	
}
