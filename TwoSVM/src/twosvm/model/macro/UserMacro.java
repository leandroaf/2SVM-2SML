package twosvm.model.macro;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.mrt.UserMRT;

@XStreamAlias("usermacro")
public class UserMacro implements Serializable {

	private String name;
	private ArrayList<String> commandAL = new ArrayList<String>();
	private ArrayList<String> parameters = new ArrayList<String>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 91L;
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getParameters() {
		return parameters;
	}

	/**
	 * 
	 * @param parameters
	 */
	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getCommandAL() {
		return commandAL;
	}

	/**
	 * 
	 * @param commandAL
	 */
	public void setCommandAL(ArrayList<String> commandAL) {
		this.commandAL = commandAL;
	}

	/**
	 * 
	 * @param command
	 */
	public void setCommand(String command) {
		this.commandAL.add(command);
	}

	@Override
	public String toString() {
		return "UserMacro [name=" + name + ", commandAL=" + commandAL
				+ ", parameters=" + parameters + "]";
	}
	
}
