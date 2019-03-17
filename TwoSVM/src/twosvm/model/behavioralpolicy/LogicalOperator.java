package twosvm.model.behavioralpolicy;


public enum LogicalOperator {
	
	AND("and"), OR("or");

	private final String logicalOperator;

	LogicalOperator(String logicalOperator) {
		this.logicalOperator = logicalOperator;
	}

	/**
	 * 
	 * @return
	 */
	public String getLogicalOperator() {
		return logicalOperator;
	}

}
