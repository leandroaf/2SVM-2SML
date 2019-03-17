package twosvm.model.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("scripDescURoAssSO")
public class ModelsDescriptionURoAssociateToSOb {

	private String userRoleName;
	private String smartObjectName;
	
	private String commands;
	
	/**
	 * 
	 * @return
	 */
	public String getSmartObjectName() {
		return smartObjectName;
	}
	
	/**
	 * 
	 * @param smartObjectName
	 */
	public void setSmartObjectName(String smartObjectName) {
		this.smartObjectName = smartObjectName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * 
	 * @param userRoleName
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
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
