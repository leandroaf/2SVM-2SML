package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.smartobject.SmartObject;

@XStreamAlias("scriDescriptionSO")
public class ModelDescriptionSO implements Serializable {
	
	private String scriptName;
	private SmartObject smartObject;
	
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

	@Override
	public String toString() {
		return "ScriptDescriptionSO [scriptName=" + scriptName
				+ ", smartObject=" + smartObject + "]";
	}

}
