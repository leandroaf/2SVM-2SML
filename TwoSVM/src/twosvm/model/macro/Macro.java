package twosvm.model.macro;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("macro")
public class Macro implements Serializable {
	
	private String name;
	private ArrayList<String> parameters = new ArrayList<String>();
	private ArrayList<String> commands = new ArrayList<String>();
	
	private static final long serialVersionUID = 99L;
	
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
	 * @param parameter
	 */
	public void setParameter(String parameter) {
		this.parameters.add(parameter);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getCommands() {
		return commands;
	}
	
	/**
	 * 
	 * @param commands
	 */
	public void setCommands(ArrayList<String> commands) {
		this.commands = commands;
	}
	
	/**
	 * 
	 * @param command
	 */
	public void setCommand(String command) {
		this.commands.add(command);
	}

	@Override
	public String toString() {
		return "Macro [name=" + name + ", parameters=" + parameters
				+ ", commands=" + commands + "]";
	}
	
}
