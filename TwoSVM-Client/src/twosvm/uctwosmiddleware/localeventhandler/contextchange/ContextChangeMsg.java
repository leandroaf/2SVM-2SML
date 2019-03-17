package twosvm.uctwosmiddleware.localeventhandler.contextchange;

import twosvm.uctwosmiddleware.localeventhandler.contextchange.ContextChangeMsg;

// CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.

public class ContextChangeMsg {

	// instance variables
	public String eventName;
	public String userLocationSS;
	public String devLocationSS;

	// Variaveis para papel do usuario e usuario
	public String userID;
	public String userNameSS;
	public String userTypeSS;

	// variaveis para tipo de ubiApp e aplicacao
	public String appID;
	public String appNameSS;
	public String appTypeSS;

	// variaveis para smartObject e device
	public String deviceID;
	public String deviceTypeSS;
	public String deviceNameSS;
	public String deviceIP;

	// variaveis para monitoramento do ambiente e do usuario
	public String noiseLevel;
	public String temperature;
	public String humidity;
	public String lightLevel;
	public String smokeDetector;
	public String time;
	public String batteryLevel;
	public String userPressureLevel;
	public String heartRate;

	// constructors
	public ContextChangeMsg() {
	}

	public ContextChangeMsg(String __f1, String __f2, String __f3, String __f4,
			String __f5, String __f6, String __f7, String __f8, String __f9,
			String __f10, String __f11, String __f12, String __f13, String __f14,
			String __f15, String __f16, String __f17, String __f18, String __f19,
			String __f20, String __f21, String __f22) {
		eventName = __f1;
		userLocationSS = __f2;
		devLocationSS = __f3;
		userTypeSS = __f4;
		userNameSS = __f5;
		appTypeSS = __f6;
		appNameSS = __f7;
		deviceTypeSS = __f8;
		deviceNameSS = __f9;
		deviceID = __f10;
		deviceIP = __f11;
		userID = __f12;
		appID = __f13;
		
		noiseLevel = __f14;
		temperature = __f15;
		humidity = __f16;
		lightLevel = __f17;
		smokeDetector = __f18;
		time = __f19;
		batteryLevel = __f20;
		userPressureLevel = __f21;
		heartRate = __f22;
	}

	public ContextChangeMsg init() {
		eventName = new String();
		userLocationSS = new String();
		devLocationSS = new String();
		userTypeSS = new String();
		userNameSS = new String();
		appTypeSS = new String();
		appNameSS = new String();
		deviceTypeSS = new String();
		deviceNameSS = new String();
		deviceID = new String();
		deviceIP = new String();
		userID = new String();
		appID = new String();
		
		noiseLevel = new String();
		temperature = new String();
		humidity = new String();
		lightLevel = new String();
		smokeDetector = new String();
		time = new String();
		batteryLevel = new String();
		userPressureLevel = new String();
		heartRate = new String();
		
		return this;
	}

	public void clear() {
		eventName = null;
		userLocationSS = null;
		devLocationSS = null;
		userTypeSS = null;
		userNameSS = null;
		appTypeSS = null;
		appNameSS = null;
		deviceTypeSS = null;
		deviceNameSS = null;
		deviceID = null;
		deviceIP = null;
		userID = null;
		appID = null;
		
		noiseLevel = null;
		temperature = null;
		humidity = null;
		lightLevel = null;
		smokeDetector = null;
		time = null;
		batteryLevel = null;
		userPressureLevel = null;
		heartRate = null;
	}

	public void copy(ContextChangeMsg from) {
		this.eventName = from.eventName;
		this.userLocationSS = from.userLocationSS;
		this.devLocationSS = from.devLocationSS;
		this.userTypeSS = from.userTypeSS;
		this.userNameSS = from.userNameSS;
		this.appTypeSS = from.appTypeSS;
		this.appNameSS = from.appNameSS;
		this.deviceTypeSS = from.deviceTypeSS;
		this.deviceNameSS = from.deviceNameSS;
		this.deviceID = from.deviceID;
		this.deviceIP = from.deviceIP;
		this.userID = from.userID;
		this.appID = from.appID;
		
		this.noiseLevel = from.noiseLevel;
		this.temperature = from.temperature;
		this.humidity = from.humidity;
		this.lightLevel = from.lightLevel;
		this.smokeDetector = from.smokeDetector;
		this.time = from.time;
		this.batteryLevel = from.batteryLevel;
		this.userPressureLevel = from.userPressureLevel;
		this.heartRate = from.heartRate;
	}

}; // StringMsg