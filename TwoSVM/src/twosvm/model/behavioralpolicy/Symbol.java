package twosvm.model.behavioralpolicy;


public enum Symbol {
	
	GREATER("greater"), LESS("less"), EQUAL("equal"), NOT_EQUAL("notEqual");

	private final String symbol;

	Symbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * 
	 * @return
	 */
	public String getSymbol() {
		return symbol;
	}

}
