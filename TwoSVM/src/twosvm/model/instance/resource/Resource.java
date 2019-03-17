package twosvm.model.instance.resource;

import java.util.ArrayList;

import twosvm.model.instance.resource.Hardware;
import twosvm.model.instance.resource.Software;

public class Resource {
	
	private String resourceID;
	
	private String resourceIP;
	
	private String resourceName;
	
	private String resourceType;

	private boolean hasHardware = false;
	private boolean hasSoftware = false;

	private ArrayList<Hardware> hardwareAL = new ArrayList<Hardware>();
	private ArrayList<Software> softwareAL = new ArrayList<Software>();
	
	private String userName;
	private String userRoleName;

	/**
	 * 
	 * @return
	 */
	public String getResourceID() {
		return resourceID;
	}

	/**
	 * 
	 * @param resourceID
	 */
	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}

	/**
	 * 
	 * @return
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * 
	 * @param resourceName
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * 
	 * @return
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * 
	 * @param resourceType
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Hardware> getHardwareResourceAL() {
		return hardwareAL;
	}

	/**
	 * 
	 * @param hardwareResourceAL
	 */
	public void setHardwareResource(
			ArrayList<Hardware> hardwareResourceAL) {
		setHasHardware(true);
		this.hardwareAL = hardwareResourceAL;
	}

	/**
	 * 
	 * @param hardwareResource
	 */
	public void setHardwareResource(Hardware hardwareResource) {
		setHasHardware(true);
		hardwareAL.add(hardwareResource);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Software> getSoftwareResourceAL() {
		return softwareAL;
	}

	/**
	 * 
	 * @param softwareResourceAL
	 */
	public void setSoftwareResource(
			ArrayList<Software> softwareResourceAL) {
		setHasSoftware(true);
		this.softwareAL = softwareResourceAL;
	}

	/**
	 * 
	 * @param softwareResource
	 */
	public void setSoftwareResource(Software softwareResource) {
		setHasSoftware(true);
		softwareAL.add(softwareResource);
	}

	/**
	 * 
	 * @return
	 */
	public boolean getHasHardware() {
		return hasHardware;
	}

	/**
	 * 
	 * @param hasHardware
	 */
	public void setHasHardware(boolean hasHardware) {
		this.hasHardware = hasHardware;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getHasSoftware() {
		return hasSoftware;
	}

	/**
	 * 
	 * @param hasSoftware
	 */
	public void setHasSoftware(boolean hasSoftware) {
		this.hasSoftware = hasSoftware;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * 
	 * @param resourceIP
	 */
	public void setResourceIP(String resourceIP) {
		this.resourceIP = resourceIP;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getResourceIP() {
		return resourceIP;
	}

	/**
	 * 
	 * @param userRoleName
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	@Override
	public String toString() {
		return "Resource [resourceID=" + resourceID + ", resourceIP="
				+ resourceIP + ", resourceName=" + resourceName
				+ ", resourceType=" + resourceType + ", hasHardware="
				+ hasHardware + ", hasSoftware=" + hasSoftware
				+ ", hardwareAL=" + hardwareAL + ", softwareAL=" + softwareAL
				+ ", userName=" + userName + ", userRoleName=" + userRoleName
				+ "]";
	}
	
}
