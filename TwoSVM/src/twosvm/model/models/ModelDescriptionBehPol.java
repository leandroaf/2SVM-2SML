package twosvm.model.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.behavioralpolicy.BehPolicy;

@XStreamAlias("scriBehPol")
public class ModelDescriptionBehPol implements Serializable {
	
	private String scriptName;
	private BehPolicy behPolicy = new BehPolicy();

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
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
	public BehPolicy getBehaviourPolicy() {
		return behPolicy;
	}

	/**
	 * 
	 * @param behPolicy
	 */
	public void setPolicy(BehPolicy behPolicy) {
		this.behPolicy = behPolicy;
	}

	@Override
	public String toString() {
		return "ScriptDescriptionBehPol [scriptName=" + scriptName
				+ ", behPolicy=" + behPolicy.toString() +"]";
	}
	
}
