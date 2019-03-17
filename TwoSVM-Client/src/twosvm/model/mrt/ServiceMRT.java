package twosvm.model.mrt;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("servicemrt")
public class ServiceMRT implements Serializable {

	private String serviceID;
	
	private String serviceType;
	private String serviceName;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 83L;
	
	/**
	 * 
	 * @return
	 */
	public String getServiceID() {
		return serviceID;
	}
	
	/**
	 * 
	 * @param serviceID
	 */
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getServiceType() {
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
	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "ServiceMRT [serviceID=" + serviceID + ", serviceType="
				+ serviceType + ", serviceName=" + serviceName + "]";
	}
	
}
