package twosvm.twosbroker.devicemanager.eventhandler.newsmartspace;

// CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.

public class SmartSpaceMsg {

	// instance variables
	public String eventName;
	public String location;

	// constructors
	public SmartSpaceMsg() {
	}

	public SmartSpaceMsg(String __f1, String __f2) {
		eventName = __f1;
		location = __f2;
	}

	public SmartSpaceMsg init() {
		eventName = new String();
		location = new String();
		return this;
	}

	public void clear() {
		eventName = null;
		location = null;
	}

	public void copy(SmartSpaceMsg from) {
		this.eventName = from.eventName;
		this.location = from.location;
	}

}; // StringMsg
