package twosvm.twosbroker.applicationmanager.startapplication;

// CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.

public class StartApplicationMsgSA {

	// instance variables
	public String eventName;
	public String applicationName;
	public String applicationType;

	// constructors
	public StartApplicationMsgSA() {
	}

	public StartApplicationMsgSA(String __f1, String __f2, String __f3) {
		eventName = __f1;
		applicationName = __f2;
		applicationType = __f3;
	}

	public StartApplicationMsgSA init() {
		eventName = new String();
		applicationName = new String();
		applicationType = new String();
		return this;
	}

	public void clear() {
		eventName = null;
		applicationName = null;
		applicationType = null;
	}

	public void copy(StartApplicationMsgSA from) {
		this.eventName = from.eventName;
		this.applicationName = from.applicationName;
		this.applicationType = from.applicationType;
	}

}; // StringMsg
