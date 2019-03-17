package twosvm.model.smartobject.feature;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("feature")
public class Feature implements Serializable {

	private String featureName;
	private String featureCategory;
	private String featureType;
	private String featureDescription;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 21L;

	/**
	 * 
	 * @return
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * 
	 * @param featureName
	 */
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeatureCategory() {
		return featureCategory;
	}

	/**
	 * 
	 * @param featureCategory
	 */
	public void setFeatureCategory(String featureCategory) {
		this.featureCategory = featureCategory;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeatureType() {
		return featureType;
	}

	/**
	 * 
	 * @param featureType
	 */
	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeatureDescription() {
		return featureDescription;
	}

	/**
	 * 
	 * @param featureDescription
	 */
	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}
	
	@Override
	public String toString() {
		return "Feature [featureName=" + featureName + ", featureCategory="
				+ featureCategory + ", featureType=" + featureType
				+ ", featureDescription=" + featureDescription + "]";
	}
	
}
