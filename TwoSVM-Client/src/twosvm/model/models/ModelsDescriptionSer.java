package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.service.Service;

@XStreamAlias("scriDescriptionSer")
public class ModelsDescriptionSer implements Serializable {
	
	private String scriptName;
	private Service service = new Service();
	
	private String commands;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 19L;
	
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
	public Service getService() {
		return service;
	}
	
	/**
	 * 
	 * @param service
	 */
	public void setService(Service service) {
		this.service = service;
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
