package twosvm.uctwosmiddleware.localeventhandler.newsmartspace;

import twosvm.uctwosmiddleware.localeventhandler.newsmartspace.NewSmartSpaceMsg;

//CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.

public class NewSmartSpaceMsg {

	// instance variables
	public String deviceName;
	public String deviceIP;
	public String softwareResource;
	public String hardwareResource;
	public String userName;

	// constructors
	public NewSmartSpaceMsg() {
	}

	public NewSmartSpaceMsg(String __f1, String __f2, String __f3, String __f4, String __f5) {
		deviceName = __f1;
		deviceIP = __f2;
		softwareResource = __f3;
		hardwareResource = __f4;
		userName = __f5;
	}

	public NewSmartSpaceMsg init() {
		deviceName = new String();
		deviceIP = new String();
		softwareResource = new String();
		hardwareResource = new String();
		userName = new String();
		return this;
	}

	public void clear() {
		deviceName = null;
		deviceIP = null;
		softwareResource = null;
		hardwareResource = null;
		userName = null;
	}

	public void copy(NewSmartSpaceMsg from) {
		this.deviceName = from.deviceName;
		this.deviceIP = from.deviceIP;
		this.softwareResource = from.softwareResource;
		this.hardwareResource = from.hardwareResource;
		this.userName = from.userName;
	}

}; // StringMsg
