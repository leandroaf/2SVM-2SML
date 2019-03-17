package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.smartobject.SmartObject;

@XStreamAlias("scriDescriptionSS")
public class ModelDescriptionSS implements Serializable {
	
	private String scriptName;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 70L;

	/**
	 * 
	 * @return
	 */
	public String getCommandName() {
		return scriptName;
	}

	/**
	 * 
	 * @param scriptName
	 */
	public void setCommandName(String scriptName) {
		this.scriptName = scriptName;
	}

	@Override
	public String toString() {
		return "CommandDescriptionSS [commandName=" + scriptName + "]";
	}	
	
}
