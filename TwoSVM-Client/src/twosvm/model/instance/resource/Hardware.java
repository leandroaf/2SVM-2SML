package twosvm.model.instance.resource;

public class Hardware {
	
	private String hardwareName;
	
	private String literalFeature;
	private String numericalFeature;
	
	private boolean hasNumericalFeature = false;
	private boolean hasLiteralFeature = false;
	
	/**
	 * 
	 * @return
	 */
	public String getHardwareName() {
		return hardwareName;
	}
	
	/**
	 * 
	 * @param hardwareName
	 */
	public void setHardwareName(String hardwareName) {
		this.hardwareName = hardwareName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLiteralFeature() {
		return literalFeature;
	}
	
	/**
	 * 
	 * @param literalFeature
	 */
	public void setLiteralFeature(String literalFeature) {
		setHasLiteralFeature(true);
		this.literalFeature = literalFeature;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNumericalFeature() {
		return numericalFeature;
	}
	
	/**
	 * 
	 * @param numericalFeature
	 */
	public void setNumericalFeature(String numericalFeature) {
		setHasNumericalFeature(true);
		this.numericalFeature = numericalFeature;
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasNumericalFeature() {
		return hasNumericalFeature;
	}

	/**
	 * 
	 * @param hasNumericalFeature
	 */
	public void setHasNumericalFeature(boolean hasNumericalFeature) {
		this.hasNumericalFeature = hasNumericalFeature;
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasLiteralFeature() {
		return hasLiteralFeature;
	}

	/**
	 * 
	 * @param hasLiteralFeature
	 */
	public void setHasLiteralFeature(boolean hasLiteralFeature) {
		this.hasLiteralFeature = hasLiteralFeature;
	}


}
