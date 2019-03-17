package twosvm.model.ubiapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.behavioralpolicy.BehPolicy;

@XStreamAlias("ubiapp")
public class UbiApp implements Serializable {
	
	private String ubiAppType;
	private String progLanguage;
	private String operatingSystem;
	private String superType;
	
	private ArrayList<String> ubiAppFeatures = new ArrayList<String>();
	private ArrayList<String> policyUbiAppAL = new ArrayList<String>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 47L;
	
	
	/**
	 * 
	 * @return
	 */
	public String getUbiAppType() {
		return ubiAppType;
	}
	
	/**
	 * 
	 * @param ubiAppName
	 */
	public void setUbiAppName(String ubiAppName) {
		this.ubiAppType = ubiAppName;
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
	public String getProgLanguage() {
		return progLanguage;
	}

	/**
	 * 
	 * @param progLanguage
	 */
	public void setProgLanguage(String progLanguage) {
		this.progLanguage = progLanguage;
	}

	/**
	 * 
	 * @return
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * 
	 * @param operatingSystem
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getUbiAppFeatures() {
		return ubiAppFeatures;
	}

	/**
	 * 
	 * @param ubiAppFeature
	 */
	public void setUbiAppFeatures(String ubiAppFeature) {
		this.ubiAppFeatures.add(ubiAppFeature);
	}
	
	/**
	 * 
	 * @param ubiAppFeatures
	 */
	public void setUbiAppFeatures(ArrayList<String> ubiAppFeatures) {
		this.ubiAppFeatures = ubiAppFeatures;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getPolicyUbiAppAL() {
		return policyUbiAppAL;
	}

	/**
	 * 
	 * @param policyUbiAppAL
	 */
	public void setPolicyUbiAppAL(ArrayList<String> policyUbiAppAL) {
		this.policyUbiAppAL = policyUbiAppAL;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getPolicyUbiApp() {
		return policyUbiAppAL;
	}

	/**
	 * 
	 * @param policyUbiApp
	 */
	public void setPolicyUbiApp(ArrayList<String> policyUbiApp) {
		this.policyUbiAppAL = policyUbiApp;
	}

	@Override
	public String toString() {
		return "UbiApp [ubiAppName=" + ubiAppType + ", progLanguage="
				+ progLanguage + ", operatingSystem=" + operatingSystem
				+ ", superType=" + superType + ", ubiAppFeatures="
				+ ubiAppFeatures + ", policyUbiAppAL=" + policyUbiAppAL + "]";
	}
	
}
