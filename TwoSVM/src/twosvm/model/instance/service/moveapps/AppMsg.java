package twosvm.model.instance.service.moveapps;

// CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.

public class AppMsg {

	// instance variables
	public String identificador;
	public String msg;
	public String softwareResource;
	public String hardwareResource;

	// constructors
	public AppMsg() {
	}

	public AppMsg(String __f1, String __f2, String __f3, String __f4) {
		identificador = __f1;
		msg = __f2;
		softwareResource = __f3;
		hardwareResource = __f4;
	}

	public AppMsg init() {
		identificador = new String();
		msg = new String();
		softwareResource = new String();
		hardwareResource = new String();
		return this;
	}

	public void clear() {
		identificador = null;
		msg = null;
		softwareResource = null;
		hardwareResource = null;
	}

	public void copy(AppMsg from) {
		this.identificador = from.identificador;
		this.msg = from.msg;
		this.softwareResource = from.softwareResource;
		this.hardwareResource = from.hardwareResource;
	}

}; // StringMsg
