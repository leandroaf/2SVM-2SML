package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.userrole.UserRole;

@XStreamAlias("scrDescriptionUR")
public class ModelsDescriptionUR implements Serializable {
	
	private String scriptName;
	
	private UserRole userRole = new UserRole();
	private String commands;

	/**
	 * 
	 */
	private static final long serialVersionUID = 13L;
	
	/**
	 * 
	 * @return
	 */
	public String getScriptName() {
		return scriptName;
	}
	
	/**
	 * 
	 * @param scriptName
	 */
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	
	/**
	 * 
	 * @return
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * 
	 * @param userRole
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	/**
	 * 
	 * @return
	 */
	public String getCommands() {
		return commands;
	}
	
	/**
	 * 
	 * @param commands
	 */
	public void setCommands(String commands) {
		this.commands = commands;
	}	
	
}
