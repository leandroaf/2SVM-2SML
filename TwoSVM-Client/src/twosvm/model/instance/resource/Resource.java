package twosvm.model.instance.resource;

import java.util.ArrayList;

import twosvm.model.instance.resource.Hardware;
import twosvm.model.instance.resource.Software;

public class Resource {

	private String resourceName;

	private String resourceIP;

	private String resourceType;

	private boolean hasHardware = false;
	private boolean hasSoftware = false;

	private ArrayList<Hardware> hardwareAL = new ArrayList<Hardware>();
	private ArrayList<Software> softwareAL = new ArrayList<Software>();

	private String userRoleName;

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
	public void setHardwareResourceAL(ArrayList<Hardware> hardwareResourceAL) {
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
	 * @return
	 */
	public String getSoftwareResource() {
		int size = softwareAL.size();
		String software = "";
		if (size > 0) {
			software.concat(softwareAL.get(0).getLiteralFeature());
			for (int i = 1; i < size; i++) {
				software.concat("+" + softwareAL.get(i).getLiteralFeature());
			}	
		}
		return software;
	}

	/**
	 * 
	 * @return
	 */
	public String getHardwareResource() {
		int size = hardwareAL.size();
		String hardware = "";
		if (size > 0) {
			hardware.concat(hardwareAL.get(0).getLiteralFeature());
			for (int i = 1; i < size; i++) {
				hardware.concat("+" + hardwareAL.get(i).getLiteralFeature());
			}	
		}
		return hardware;
	}
	
	/**
	 * 
	 * @param softwareResourceAL
	 */
	public void setSoftwareResource(ArrayList<Software> softwareResourceAL) {
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
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * 
	 * @param userRoleName
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
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
	 * @param resourceIP
	 */
	public void setResourceIP(String resourceIP) {
		this.resourceIP = resourceIP;
	}

	@Override
	public String toString() {
		return "Resource [resourceName=" + resourceName + ", resourceIP="
				+ resourceIP + ", resourceType=" + resourceType
				+ ", hasHardware=" + hasHardware + ", hasSoftware="
				+ hasSoftware + ", hardwareAL=" + hardwareAL + ", softwareAL="
				+ softwareAL + ", userRoleName=" + userRoleName + "]";
	}

}
