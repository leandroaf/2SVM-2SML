package twosvm.model.mrt;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("applicationmrt")
public class ApplicationMRT implements Serializable {

	private String applicationID;
	
	private String applicationType;
	private String applicationName;
	
	private String deviceIP;
	
	private boolean isActive;
	
	/**
	 * Construtor
	 */
	public ApplicationMRT() {
		applicationID = "";
		applicationType = "";
		applicationName = "";
		deviceIP = "";
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 81L;
	
	/**
	 * 
	 * @return
	 */
	public String getApplicationID() {
		return applicationID;
	}
	
	/**
	 * 
	 * @param applicationID
	 */
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getApplicationType() {
		return applicationType;
	}
	
	/**
	 * 
	 * @param applicationType
	 */
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getApplicationName() {
		return applicationName;
	}
	
	/**
	 * 
	 * @param applicationName
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * 
	 * @return
	 */
	public String getDeviceIP() {
		return deviceIP;
	}

	/**
	 * 
	 * @param deviceIP
	 */
	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * 
	 * @param isActive
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ApplicationMRT [applicationID=" + applicationID
				+ ", applicationType=" + applicationType + ", applicationName="
				+ applicationName + ", deviceIP=" + deviceIP + ", isActive="
				+ isActive + "]";
	}
	
}