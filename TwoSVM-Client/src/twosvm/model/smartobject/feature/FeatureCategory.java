package twosvm.model.smartobject.feature;

import java.io.Serializable;

public enum FeatureCategory implements Serializable {

	IO_RESOURCE("IOResource"), SENSOR("Sensor"), ACTUATOR("Actuator");

	private final String featureCategory;

	FeatureCategory(String featureCategory) {
		this.featureCategory = featureCategory;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeatureCategory() {
		return featureCategory;
	}

}
