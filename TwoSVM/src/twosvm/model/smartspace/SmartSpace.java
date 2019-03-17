package twosvm.model.smartspace;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("smartspace")
public class SmartSpace {

	private String smartSpaceName;

	private ArrayList<String> userRoleKeyAL = new ArrayList<String>();
	private ArrayList<String> ubiAppKeyAL = new ArrayList<String>();
	private ArrayList<String> smartObjectKeyAL = new ArrayList<String>();
	private ArrayList<String> serviceKeyAL = new ArrayList<String>();
	private ArrayList<String> policyKeyAL = new ArrayList<String>();

	/**
	 * 
	 * @return
	 */
	public String getSmartSpaceName() {
		return smartSpaceName;
	}

	/**
	 * 
	 * @param smartSpaceTableName
	 */
	public void setSmartSpaceName(String smartSpaceTableName) {
		this.smartSpaceName = smartSpaceTableName;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getUserRoleKeyAL() {
		return userRoleKeyAL;
	}

	/**
	 * 
	 * @param userRoleKey
	 * @return
	 */
	public boolean getUserRole(String userRoleKey) {
		int size = userRoleKeyAL.size();
		for (int i = 0; i < size; i++) {
			if (userRoleKeyAL.get(i).equals(userRoleKey)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param userRoleKey
	 */
	public void setUserRoleKeyAL(String userRoleKey) {
		this.userRoleKeyAL.add(userRoleKey);
	}

	/**
	 * 
	 * @param userRoleKeyAL
	 */
	public void setUserRoleKeyAL(ArrayList<String> userRoleKeyAL) {
		this.userRoleKeyAL = userRoleKeyAL;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getUbiAppKeyAL() {
		return ubiAppKeyAL;
	}

	/**
	 * 
	 * @param ubiAppKey
	 * @return
	 */
	public boolean getUbiAppKey(String ubiAppKey) {
		int size = ubiAppKeyAL.size();
		for (int i = 0; i < size; i++) {
			if (ubiAppKeyAL.get(i).equals(ubiAppKey)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param ubiAppKeyAL
	 */
	public void setUbiAppKeyAL(ArrayList<String> ubiAppKeyAL) {
		this.ubiAppKeyAL = ubiAppKeyAL;
	}

	/**
	 * 
	 * @param ubiAppKey
	 */
	public void setUbiAppKeyAL(String ubiAppKey) {
		this.ubiAppKeyAL.add(ubiAppKey);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getSmartObjectKeyAL() {
		return smartObjectKeyAL;
	}
	
	/**
	 * 
	 * @param smartObjectKey
	 * @return
	 */
	public boolean getSmartObjectKey(String smartObjectKey) {
		int size = smartObjectKeyAL.size();
		for (int i = 0; i < size; i++) {
			if (smartObjectKeyAL.get(i).equals(smartObjectKey)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param smartObjectKeyAL
	 */
	public void setSmartObjectKeyAL(ArrayList<String> smartObjectKeyAL) {
		this.smartObjectKeyAL = smartObjectKeyAL;
	}
	
	/**
	 * 
	 * @param smartObjectKey
	 */
	public void setSmartObjectKeyAL(String smartObjectKey) {
		this.smartObjectKeyAL.add(smartObjectKey);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getServiceKeyAL() {
		return serviceKeyAL;
	}
	
	/**
	 * 
	 * @param serviceKey
	 * @return
	 */
	public boolean getServiceKey(String serviceKey) {
		int size = serviceKeyAL.size();
		for (int i = 0; i < size; i++) {
			if (serviceKeyAL.get(i).equals(serviceKey)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param serviceKeyAL
	 */
	public void setServiceKeyAL(ArrayList<String> serviceKeyAL) {
		this.serviceKeyAL = serviceKeyAL;
	}

	/**
	 * 
	 * @param serviceKey
	 */
	public void setServiceKeyAL(String serviceKey) {
		this.serviceKeyAL.add(serviceKey);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getPolicyKeyAL() {
		return policyKeyAL;
	}

	/**
	 * 
	 * @param policyKey
	 * @return
	 */
	public boolean getPolicyKey(String policyKey) {
		int size = policyKeyAL.size();
		for (int i = 0; i < size; i++) {
			if (policyKeyAL.get(i).equals(policyKey)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param policyKeyAL
	 */
	public void setPolicyKeyAL(ArrayList<String> policyKeyAL) {
		this.policyKeyAL = policyKeyAL;
	}
	
	/**
	 * 
	 * @param policyKey
	 */
	public void setPolicyKeyAL(String policyKey) {
		this.policyKeyAL.add(policyKey);
	}
	
}
