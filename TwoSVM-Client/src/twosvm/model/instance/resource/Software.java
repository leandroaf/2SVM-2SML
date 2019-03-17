package twosvm.model.instance.resource;

public class Software {
	
	private String softwareName;
	
	private String literalFeature;
	private double numericalFeature;
	
	private boolean hasNumericalFeature = false;
	private boolean hasLiteralFeature = false;
	
	/**
	 * 
	 * @return
	 */
	public String getSoftwareName() {
		return softwareName;
	}
	
	/**
	 * 
	 * @param softwareName
	 */
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
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
	public double getNumericalFeature() {
		return numericalFeature;
	}
	
	/**
	 * 
	 * @param numericalFeature
	 */
	public void setNumericalFeature(double numericalFeature) {
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
