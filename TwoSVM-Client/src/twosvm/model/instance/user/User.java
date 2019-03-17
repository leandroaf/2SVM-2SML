package twosvm.model.instance.user;

import java.util.ArrayList;

public class User {

	private String usID;
	private String usName;
	private String usType;

	private String usLocation;

	private String appID;
	private String appName;
	private ArrayList<String> appTypeAL = new ArrayList<String>();

	private String devID;
	private String devName;
	private String devLocation;
	private String devIP;
	private String softwareResource;
	private String hardwareResource;

	private ArrayList<String> devTypeAL;

	private double batteryLevel;
	private double userPressureLevel;
	private double heartRate;
	
	public User () {
		usID = new String();
		usName = new String();
		usType = new String();

		usLocation  = new String();

		appID = new String();
		appName = new String();
		appTypeAL = new ArrayList<String>();

		devID = new String();
		devName = new String();
		devLocation = new String();
		devIP = new String();

		devTypeAL = new ArrayList<String>();
		
		batteryLevel = 0.0;
		userPressureLevel = 0.0;
		heartRate = 0.0;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String userID() {
		return usID;
	}

	/**
	 * 
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.usID = userID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String userNameSS() {
		return usName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.usName = userName;
	}

	/**
	 * 
	 * @return
	 */
	public String userTypeSS() {
		return usType;
	}

	/**
	 * 
	 * @param userRole
	 */
	public void setUserType(String userRole) {
		this.usType = userRole;
	}

	/**
	 * 
	 * @return
	 */
	public String userLocationSS() {
		return usLocation;
	}

	/**
	 * 
	 * @param userLocation
	 */
	public void setUserLocation(String userLocation) {
		this.usLocation = userLocation;
	}

	/**
	 * 
	 * @return
	 */
	public String softwareResourceSS() {
		return softwareResource;
	}

	/**
	 * 
	 * @param softwareResource
	 */
	public void setSoftwareResource(String softwareResource) {
		this.softwareResource = softwareResource;
	}

	/**
	 * 
	 * @return
	 */
	public String hardwareResourceSS() {
		return hardwareResource;
	}

	/**
	 * 
	 * @param hardwareResource
	 */
	public void setHardwareResource(String hardwareResource) {
		this.hardwareResource = hardwareResource;
	}

	/**
	 * 
	 * @return
	 */
	public String applicationID() {
		return appID;
	}

	/**
	 * 
	 * @param appID
	 */
	public void setAppID(String appID) {
		this.appID = appID;
	}

	/**
	 * 	
	 * @return
	 */
	public String applicationNameSS() {
		return appName;
	}
	
	/**
	 * 
	 * @param applicationAL
	 */
	public void setAppName(String app) {
		this.appName = app;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> appTypeAL() {
		return appTypeAL;
	}

	/**
	 * 
	 * @return
	 */
	public String appTypeSS() {
		int amountApp = appTypeAL.size();
		for (int indexUbiApp = 0; indexUbiApp < amountApp; indexUbiApp++) {
			return appTypeAL.get(indexUbiApp);
		}
		return null;
	}

	/**
	 * 
	 * @param appApp
	 */
	public void setAppType(String appApp) {
		this.appTypeAL.add(appApp);
	}

	/**
	 * Este metodo faz uma consulta ao M@RT e retorna true ou false, caso o
	 * usuario tenha ou nao modelado o ubiApp
	 * 
	 * @return
	 */
	public boolean hasAppType(String appType) {
		// le o M@RT para checar se ha aquele tipo de app (ou UbiApp) definido
		// no modelo
		int amountAType = appTypeAL.size();
		for (int indexAType = 0; indexAType < amountAType; indexAType++) {
			if (appTypeAL.get(indexAType).equals(appType)) {
				return true;
			}
		}
		return false;
	} // fim do metodo hasUbiApp

	/**
	 * 
	 * @return
	 */
	public String deviceNameSS() {
		return devName;
	}

	/**
	 * 
	 * @param devName
	 */
	public void setDeviceName(String devName) {
		this.devName = devName;
	}
	
	public String deviceID() {
		return devID;
	}

	/**
	 * 
	 * @param devName
	 */
	public void setDeviceID(String devID) {
		this.devID = devID;
	}
	

	/**
	 * 
	 * @return
	 */
	public String deviceLocationSS() {
		return devLocation;
	}

	/**
	 * 
	 * @param deviceLocation
	 */
	public void setDeviceLocation(String deviceLocation) {
		this.devLocation = deviceLocation;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> deviceTypeAL() {
		return devTypeAL;
	}

	/**
	 * 
	 * @param devType
	 * @return
	 */
	public String deviceTypeAL(String devType) {
		int amountDevType = devTypeAL.size();
		for(int indexDevType = 0; indexDevType < amountDevType; indexDevType++) {
			if (devTypeAL.get(indexDevType).equals(devType)) {
				return devTypeAL.get(indexDevType);
			}
		}
		return null;
	}
	
	/**
	 * Este metodo faz uma consulta ao M@RT e retorna true ou false, caso o
	 * usuario tenha ou nao modelado o smartobject
	 * 
	 * @return
	 */
	public boolean hasSmartObject(String smartObjectName) {
		// le o M@RT para checar se ha aquele tipo de device (ou smartObject)
		// definido no modelo
		int amountSObj = devTypeAL.size();
		for (int indexSObj = 0; indexSObj < amountSObj; indexSObj++) {
			if (devTypeAL.get(indexSObj).equals(smartObjectName)) {
				return true;
			}
		}
		return false;
	} // fim do metodo hasSmartObject

	/**
	 * 
	 * @param devType
	 */
	public void setDeviceType(String devType) {
		this.devTypeAL.add(devType);
	}

	/**
	 * 
	 * @return
	 */
	public String deviceIP() {
		return devIP;
	}

	/**
	 * 
	 * @param devIP
	 */
	public void setDeviceIP(String devIP) {
		this.devIP = devIP;
	}
	
	/**
	 * 
	 * @return
	 */
	public double deviceBatteryLevel() {
		return batteryLevel;
	}

	/**
	 * 
	 * @param batteryLevel
	 */
	public void setBatteryLevel(double batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	
	/**
	 * 
	 * @return
	 */
	public double userPressureLevel() {
		return userPressureLevel;
	}

	/**
	 * 
	 * @param userPressureLevel
	 */
	public void setUserPressureLevel(double userPressureLevel) {
		this.userPressureLevel = userPressureLevel;
	}

	/**
	 * 
	 * @return
	 */
	public double heartRate() {
		return heartRate;
	}

	/**
	 * 
	 * @param heartRate
	 */
	public void setHeartRate(double heartRate) {
		this.heartRate = heartRate;
	}

	@Override
	public String toString() {
		return "User [usID=" + usID + ", usName=" + usName + ", usType="
				+ usType + ", usLocation=" + usLocation + ", appID=" + appID
				+ ", appName=" + appName + ", appTypeAL=" + appTypeAL + ", devID="
				+ devID + ", devName=" + devName + ", devLocation="
				+ devLocation + ", devIP=" + devIP + ", devTypeAL=" + devTypeAL
				+ ", batteryLevel=" + batteryLevel + ", userPressureLevel="
				+ userPressureLevel + ", heartRate=" + heartRate + "]";
	}
	
}
