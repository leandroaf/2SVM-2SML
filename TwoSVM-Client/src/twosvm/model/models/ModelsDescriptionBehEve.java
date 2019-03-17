package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.behavioralpolicy.BehEvent;

@XStreamAlias("scriBehEve")
public class ModelsDescriptionBehEve implements Serializable {
	
	private String scriptName;
	private BehEvent behEvent = new BehEvent();

	/**
	 * 
	 */
	private static final long serialVersionUID = 42L;
	
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
	public BehEvent getBehaviourEvent() {
		return behEvent;
	}

	/**
	 * 
	 * @param behPolicy
	 */
	public void setBehEvent(BehEvent behEvent) {
		this.behEvent = behEvent;
	}

	@Override
	public String toString() {
		return "ScriptDescriptionBehPol [scriptName=" + scriptName
				+ ", behEvent=" + behEvent.toString() +"]";
	}
	
}
