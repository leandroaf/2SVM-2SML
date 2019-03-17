package twosvm.model.smartobject.feature;

import java.io.Serializable;

public enum FeatureType implements Serializable {
	
	SOFTWARE("Software"), HARDWARE("Hardware");

	private final String featureType;

	FeatureType(String featureType) {
		this.featureType = featureType;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeatureType() {
		return featureType;
	}

}
