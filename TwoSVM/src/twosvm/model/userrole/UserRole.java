package twosvm.model.userrole;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userrole")
public class UserRole implements Serializable {
	
	private String userRoleType;
	private String superType;
	
	private int amountCanUse;
	private int amountIsOwnerOf;
	
	private ArrayList<String> smartObjectNameAL = new ArrayList<String>();
	private ArrayList<String> ubiAppAL = new ArrayList<String>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 22L;
	
	/**
	 * 
	 * @return
	 */
	public String getUserRoleType() {
		return userRoleType;
	}
	
	/**
	 * 
	 * @param userRoleName
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleType = userRoleName;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getSmartObjectNameAL() {
		return smartObjectNameAL;
	}

	/**
	 * 
	 * @param sObjectAL
	 */
	public void setSmartObjectNameAL(ArrayList<String> sObjectAL) {
		this.smartObjectNameAL = sObjectAL;
	}
	
	/**
	 * 
	 * @param sObject
	 */
	public void setSmartObjectName(String sObject) {
		this.smartObjectNameAL.add(sObject);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getUbiAppAL() {
		return ubiAppAL;
	}

	/**
	 * 
	 * @param ubiAppAL
	 */
	public void setUbiAppAL(ArrayList<String> ubiAppAL) {
		this.ubiAppAL = ubiAppAL;
	}
	
	/**
	 * 
	 * @param ubiApp
	 */
	public void setUbiApp(String ubiApp) {
		this.ubiAppAL.add(ubiApp);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSuperType() {
		return superType;
	}

	/**
	 * 
	 * @param superType
	 */
	public void setSuperType(String superType) {
		this.superType = superType;
	}

	/**
	 * 
	 * @return
	 */
	public int getAmountCanUse() {
		return amountCanUse;
	}

	/**
	 * 
	 */
	public void setAmountCanUse(int amountCanUse) {
		this.amountCanUse = amountCanUse;
	}

	/**
	 * 
	 * @return
	 */
	public int getAmountIsOwnerOf() {
		return amountIsOwnerOf;
	}

	/**
	 * 
	 */
	public void setAmountIsOwnerOf(int amountIsOwnerOf) {
		this.amountIsOwnerOf = amountIsOwnerOf;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleName=" + userRoleType + ", superType="
				+ superType + ", amountCanUse=" + amountCanUse
				+ ", amountIsOwnerOf=" + amountIsOwnerOf
				+ ", smartObjectNameAL=" + smartObjectNameAL + ", ubiAppAL="
				+ ubiAppAL + "]";
	}
	
}
