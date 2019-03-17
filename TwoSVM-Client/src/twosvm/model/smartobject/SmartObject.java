package twosvm.model.smartobject;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.smartobject.feature.Feature;

@XStreamAlias("smartobject")
public class SmartObject implements Serializable {
	
	private String smartObjectType;
	private String superType;
	
	private ArrayList<Feature> featureAL;
	private ArrayList<String> policyAL;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20L;
	
	/**
	 * Construtor
	 */
	public SmartObject() {
		this.featureAL = new ArrayList<Feature>();
		this.policyAL = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSmartObjectType() {
		return smartObjectType;
	}

	/**
	 * 
	 * @param smartObjectName
	 */
	public void setSmartObjectName(String smartObjectName) {
		this.smartObjectType = smartObjectName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSuperType() {
		return superType;
	}

	/**
	 * 
	 * @param superType
	 */
	public void setSuperType(String superType) {
		this.superType = superType;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Feature> getFeatureNameAL() {
		return featureAL;
	}

	/**
	 * 
	 * @param indexFeature
	 * @return
	 */
	public Feature getFeature(int indexFeature) {
		return featureAL.get(indexFeature);
	}
	
	/**
	 * 
	 * @param featureAL
	 */
	public void setFeatureAL(ArrayList<Feature> featureAL) {
		this.featureAL = featureAL;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getPolicyAL() {
		return policyAL;
	}
	
	/**
	 * 
	 * @param policyAL
	 */
	public void setPolicyAL(ArrayList<String> policyAL) {
		this.policyAL = policyAL;
	}

	@Override
	public String toString() {
		return "SmartObject [smartObjectName=" + smartObjectType
				+ ", superType=" + superType + ", featureAL=" + featureAL
				+ ", policyAL=" + policyAL + "]";
	}

}
