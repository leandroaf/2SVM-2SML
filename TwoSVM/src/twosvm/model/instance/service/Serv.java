package twosvm.model.instance.service;
import java.util.ArrayList;

public class Serv {
	
	private String serviceName;
	private String serviceType;
	private String superType;
	
	private ArrayList<String> serviceFeatures = new ArrayList<String>();
		
	/**
	 * 
	 * @return
	 */
	public String serviceName() {
		return serviceName;
	}
	
	/**
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * 
	 * @return
	 */
	public String serviceType() {
		return serviceType;
	}

	/**
	 * 
	 * @param serviceType
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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
	public ArrayList<String> getServiceFeatures() {
		return serviceFeatures;
	}

	/**
	 * 
	 * @param serviceFeatures
	 */
	public void setServiceFeatures(ArrayList<String> serviceFeatures) {
		this.serviceFeatures = serviceFeatures;
	}
	
	/**
	 * 
	 * @param serviceFeature
	 */
	public void setServiceFeature(String serviceFeature) {
		this.serviceFeatures.add(serviceFeature);
	}

	@Override
	public String toString() {
		return "Service [serviceName=" + serviceName + ", superType="
				+ superType + ", serviceFeatures=" + serviceFeatures + "]";
	}
	
}
