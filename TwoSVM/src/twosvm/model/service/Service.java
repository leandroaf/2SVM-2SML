package twosvm.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import twosvm.model.behavioralpolicy.BehPolicy;

@XStreamAlias("service")
public class Service {
	
	private String serviceType;
	private String superType;
	
	private ArrayList<String> serviceFeatures = new ArrayList<String>();

	/**
	 * 
	 * @return
	 */
	public String getServiceType() {
		return serviceType;
	}
	
	/**
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceType = serviceName;
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
		return "Service [serviceName=" + serviceType + ", superType="
				+ superType + ", serviceFeatures=" + serviceFeatures + "]";
	}
	
}
