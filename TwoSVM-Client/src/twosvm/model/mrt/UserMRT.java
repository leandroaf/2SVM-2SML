package twosvm.model.mrt;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("usermrt")
public class UserMRT implements Serializable {
	
	private String userID;
	
	private String userType;
	private String userName;
	
	private String appType;
	private String app;
	
	private String deviceType;
	private String deviceName;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 85L;
	
	/**
	 * 
	 * @return
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * 
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * 
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
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

	/**
	 * 
	 * @return
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * 
	 * @param appType
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * 
	 * @return
	 */
	public String getApp() {
		return app;
	}

	/**
	 * 
	 * @param app
	 */
	public void setApp(String app) {
		this.app = app;
	}

	/**
	 * 
	 * @return
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * 
	 * @param deviceType
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * 
	 * @return
	 */
	public String getDevice() {
		return deviceName;
	}

	/**
	 * 
	 * @param device
	 */
	public void setDeviceName(String device) {
		this.deviceName = device;
	}

	@Override
	public String toString() {
		return "UserMRT [userID=" + userID + ", userType=" + userType
				+ ", userName=" + userName + ", appType=" + appType + ", app="
				+ app + ", deviceType=" + deviceType + ", device=" + deviceName
				+ "]";
	}

}