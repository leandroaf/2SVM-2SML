package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.ubiapp.UbiApp;

@XStreamAlias("scriptDescUA")
public class ModelsDescriptionUA implements Serializable {
	
	private String scriptName;
	private UbiApp ubiApp = new UbiApp();
	
	private String commands;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 44L;
	
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
	public UbiApp getUbiApp() {
		return ubiApp;
	}
	
	/**
	 * 
	 * @param ubiApp
	 */
	public void setUbiApp(UbiApp ubiApp) {
		this.ubiApp = ubiApp;
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
		return "ScriptDescriptionUA [scriptName=" + scriptName + ", ubiApp="
				+ ubiApp + ", commands=" + commands + "]";
	}
	
}
