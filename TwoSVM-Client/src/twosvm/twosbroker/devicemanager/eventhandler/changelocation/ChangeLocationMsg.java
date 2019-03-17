package twosvm.twosbroker.devicemanager.eventhandler.changelocation;

// CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.

public class ChangeLocationMsg {

	// instance variables
	public String eventName;
	public String newLocation;

	// constructors
	public ChangeLocationMsg() {
	}

	public ChangeLocationMsg(String __f1, String __f2) {
		eventName = __f1;
		newLocation = __f2;
	}

	public ChangeLocationMsg init() {
		eventName = new String();
		newLocation = new String();
		return this;
	}

	public void clear() {
		eventName = null;
		newLocation = null;
	}

	public void copy(ChangeLocationMsg from) {
		this.eventName = from.eventName;
		this.newLocation = from.newLocation;
	}

}; // StringMsg
