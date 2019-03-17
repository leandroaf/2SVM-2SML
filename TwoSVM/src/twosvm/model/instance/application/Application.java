package twosvm.model.instance.application;

public class Application {
	
	private String appName;
	
	private String appID;
	private String msg;
	
	private String progLanguage;
	private String operatingSystem;
	
	/**
	 * 
	 * @return
	 */
	public String getAppName() {
		return appName;
	}
	
	/**
	 * 
	 * @param appName
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAppID() {
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
	public String getMsg() {
		return msg;
	}

	/**
	 * 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
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

	@Override
	public String toString() {
		return "Application [appName=" + appName + ", appID=" + appID
				+ ", msg=" + msg + ", progLanguage=" + progLanguage
				+ ", operatingSystem=" + operatingSystem + "]";
	}
	
}
