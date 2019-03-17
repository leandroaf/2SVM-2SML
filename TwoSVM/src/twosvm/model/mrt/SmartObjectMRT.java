package twosvm.model.mrt;

import java.io.Serializable;
import java.util.ArrayList;

import twosvm.model.smartobject.feature.Feature;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("devicemrt")
public class SmartObjectMRT implements Serializable {
	
	private String smartObjectID;
	
	private String smartObjectIP;
	
	private String smartObjectType;
	private String smartObjectName;
	
	private ArrayList<Feature> featureAL;
	
	private boolean busy;
	
	private String userName;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 80L;
	
	/**
	 * 
	 * @return
	 */
	public String getSmartObjectID() {
		return smartObjectID;
	}
	
	/**
	 * 
	 * @param smartObjectID
	 */
	public void setSmartObjectID(String smartObjectID) {
		this.smartObjectID = smartObjectID;
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
	 * @param smartObjectType
	 */
	public void setDeviceType(String smartObjectType) {
		this.smartObjectType = smartObjectType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSmartObjectName() {
		return smartObjectName;
	}
	
	/**
	 * 
	 * @param smartObjectName
	 */
	public void setSmartObjectName(String smartObjectName) {
		this.smartObjectName = smartObjectName;
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
	 * @param featureAL
	 */
	public void setFeatureAL(ArrayList<Feature> featureAL) {
		this.featureAL = featureAL;
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
	 * @return
	 */
	public String getSmartObjectIP() {
		return smartObjectIP;
	}

	/**
	 * 
	 * @param smartObjectIP
	 */
	public void setSmartObjectIP(String smartObjectIP) {
		this.smartObjectIP = smartObjectIP;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isBusy() {
		return busy;
	}

	/**
	 * 
	 * @param busy
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "SmartObjectMRT [smartObjectID=" + smartObjectID
				+ ", smartObjectIP=" + smartObjectIP + ", smartObjectType="
				+ smartObjectType + ", smartObjectName=" + smartObjectName
				+ ", featureAL=" + featureAL + ", busy=" + busy + ", userName="
				+ userName + "]";
	}

}