package twosvm.model.mrt;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("smartobjectmrt")
public class SmartSpaceMRT implements Serializable {

	private String smartSpaceID;
	
	private String smartSpaceType;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 84L;
	
	/**
	 * 
	 * @return
	 */
	public String getSmartSpaceType() {
		return smartSpaceType;
	}
	
	/**
	 * 
	 * @param smartSpaceType
	 */
	public void setSmartSpaceType(String smartSpaceType) {
		this.smartSpaceType = smartSpaceType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSmartSpaceID() {
		return smartSpaceID;
	}
	
	/**
	 * 
	 * @param smartSpaceID
	 */
	public void setSmartSpaceID(String smartSpaceID) {
		this.smartSpaceID = smartSpaceID;
	}

	@Override
	public String toString() {
		return "SmartSpaceMRT [smartSpaceType=" + smartSpaceType
				+ ", smartSpaceID=" + smartSpaceID + "]";
	}
	
}
