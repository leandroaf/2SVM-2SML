package twosvm.model.userrole;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userrole")
public class UserRole implements Serializable {
	
	private String userRoleType;
	private String superType;
	
	private ArrayList<String> smartObjectNameAL = new ArrayList<String>();
	private ArrayList<String> ubiAppAL = new ArrayList<String>();
	private ArrayList<String> serviceAL = new ArrayList<String>();
	private ArrayList<String> policyNameAL = new ArrayList<String>();
	
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
	 * @return
	 */
	public ArrayList<String> getServiceAL() {
		return serviceAL;
	}

	/**
	 * 
	 * @param serviceAL
	 */
	public void setServiceAL(ArrayList<String> serviceAL) {
		this.serviceAL = serviceAL;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getPolicyNameAL() {
		return policyNameAL;
	}

	/**
	 * 
	 * @param policyNameAL
	 */
	public void setPolicyNameAL(ArrayList<String> policyNameAL) {
		this.policyNameAL = policyNameAL;
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

	@Override
	public String toString() {
		return "UserRole [userRoleName=" + userRoleType + ", superType=" + superType
				+ ", smartObjectNameAL=" + smartObjectNameAL + ", ubiAppAL="
				+ ubiAppAL + ", serviceAL=" + serviceAL + ", policyNameAL="
				+ policyNameAL + "]";
	}
	
}
