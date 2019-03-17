package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.smartobject.SmartObject;

@XStreamAlias("scriDescriptionSO")
public class ModelDescriptionSO implements Serializable {
	
	private String scriptName;
	private SmartObject smartObject;
	
	private String commands;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;
	
	/**
	 * Construtor
	 */
	public ModelDescriptionSO() {
		this.smartObject = new SmartObject();
	}
	
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
	public SmartObject getSmartObject() {
		return smartObject;
	}
	
	/**
	 * 
	 * @param smartObject
	 */
	public void setSmartObject(SmartObject smartObject) {
		this.smartObject = smartObject;
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

	@Override
	public String toString() {
		return "ScriptDescriptionSO [scriptName=" + scriptName
				+ ", smartObject=" + smartObject + ", commands=" + commands
				+ "]";
	}

}
