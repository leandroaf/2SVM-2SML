package twosvm.model.behavioralpolicy;

import java.io.Serializable;
import java.util.ArrayList;

import twosvm.model.behavioralpolicy.BehAction;
import twosvm.model.behavioralpolicy.BehCondition;
import twosvm.model.behavioralpolicy.BehEvent;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("behaviourpolicy")
public class BehPolicy implements Serializable {
	
	private String policyName;
	private String policyType;
	private String policyPriority;

	private ArrayList<BehEvent> behEventAL = new ArrayList<BehEvent>();
	private ArrayList<BehCondition> behConditionAL = new ArrayList<BehCondition>();
	private ArrayList<BehAction> behActionAL = new ArrayList<BehAction>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	/**
	 * 
	 * @return
	 */
	public String getPolicyName() {
		return policyName;
	}

	/**
	 * 
	 * @param policyName
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	/**
	 * 
	 * @return
	 */
	public String getPolicyType() {
		return policyType;
	}

	/**
	 * 
	 * @param policyType
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyPriority() {
		return policyPriority;
	}

	public void setPolicyPriority(String policyPriority) {
		this.policyPriority = policyPriority;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<BehEvent> getBehEventAL() {
		return behEventAL;
	}

	/**
	 * 
	 * @param behEvent
	 */
	public void setBehEventAL(ArrayList<BehEvent> behEventAL) {
		this.behEventAL = behEventAL;
	}
	
	/**
	 * 
	 * @param behEvent
	 */
	public void setBehEvent(BehEvent behEvent) {
		this.behEventAL.add(behEvent);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<BehCondition> getBehConditionAL() {
		return behConditionAL;
	}

	/**
	 * 
	 * @param behCondition
	 */
	public void setBehConditionAL(ArrayList<BehCondition> behConditionAL) {
		this.behConditionAL = behConditionAL;
	}

	/**
	 * 
	 * @param behCondition
	 */
	public void setBehCondition(BehCondition behCondition) {
		this.behConditionAL.add(behCondition);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<BehAction> getBehActionAL() {
		return behActionAL;
	}

	/**
	 * 
	 * @param behAction
	 */
	public void setBehActionAL(ArrayList<BehAction> behActionAL) {
		this.behActionAL = behActionAL;
	}
	
	/**
	 * 
	 * @param behAction
	 */
	public void setBehAction(BehAction behAction) {
		this.behActionAL.add(behAction);
	}

	/**
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BehaviouralPolicy [policyName=" + policyName + ", policyType="
				+ policyType + ", policyPriority=" + policyPriority
				+ ", behEvent=" + behEventAL + ", behCondition=" + behConditionAL
				+ ", behAction=" + behActionAL + "]";
	}
	
}
