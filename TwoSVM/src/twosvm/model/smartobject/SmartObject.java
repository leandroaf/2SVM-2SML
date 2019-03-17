package twosvm.model.smartobject;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.smartobject.feature.Feature;

@XStreamAlias("smartobject")
public class SmartObject implements Serializable {
	
	private String smartObjectType;
	private String superType;
	
	private boolean canUse;
	private boolean isOwnerOf;
	
	private ArrayList<Feature> featureAL  = new ArrayList<Feature>();

	private ArrayList<String> userRoleCU = new ArrayList<String>();
	private ArrayList<String> userRoleIoF = new ArrayList<String>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20L;
	
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
	public boolean isCanUse() {
		return canUse;
	}

	/**
	 * 
	 * @param canUse
	 */
	public void setCanUse(boolean canUse) {
		this.canUse = canUse;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isOwnerOf() {
		return isOwnerOf;
	}

	/**
	 * 
	 * @param isOwnerOf
	 */
	public void setIsOwnerOf(boolean isOwnerOf) {
		this.isOwnerOf = isOwnerOf;
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
	public ArrayList<Feature> getFeatureAL() {
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
	 * @param feature
	 */
	public void setFeature(Feature feature) {
		this.featureAL.add(feature);
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
	public ArrayList<String> getUserRoleCU() {
		return userRoleCU;
	}

	/**
	 * 
	 * @param userRoleCU
	 */
	public void setUserRoleCU(ArrayList<String> userRoleCU) {
		this.userRoleCU = userRoleCU;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getUserRoleIoF() {
		return userRoleIoF;
	}

	/**
	 * 
	 * @param userRoleIoF
	 */
	public void setUserRoleIoF(ArrayList<String> userRoleIoF) {
		this.userRoleIoF = userRoleIoF;
	}

	@Override
	public String toString() {
		return "SmartObject [smartObjectName=" + smartObjectType
				+ ", superType=" + superType + ", canUse=" + canUse
				+ ", isOwnerOf=" + isOwnerOf + ", featureAL=" + featureAL
				+ ", userRoleCU=" + userRoleCU + ", userRoleIoF=" + userRoleIoF
				+ "]";
	}


}
