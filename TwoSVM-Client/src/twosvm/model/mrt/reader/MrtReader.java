package twosvm.model.mrt.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.ServiceMRT;
import twosvm.model.mrt.SmartSpaceMRT;
import twosvm.model.mrt.UserMRT;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class MrtReader {

	/**
	 * 
	 * @param sSpaceMRTName
	 * @return
	 */
	public SmartSpaceMRT readSmartSpaceMRT(String sSpaceMRTName) {

		SmartSpaceMRT sSpaceMRT = new SmartSpaceMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(sSpaceMRTName, SmartSpaceMRT.class);
			xStream.processAnnotations(SmartSpaceMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/localmrt/smartspace/"
							+ sSpaceMRTName));
			sSpaceMRT = (SmartSpaceMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return sSpaceMRT;

	} // fim do metodo readSmartSpaceMRT

	/**
	 * 
	 * @param appMRTName
	 * @return
	 */
	public ApplicationMRT readApplicationMRT(String appMRTName) {

		ApplicationMRT appMRT = new ApplicationMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(appMRTName, ApplicationMRT.class);
			xStream.processAnnotations(ApplicationMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/localmrt/application/"
							+ appMRTName));
			appMRT = (ApplicationMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return appMRT;

	} // fim do metodo readApplicationMRT
	
	/**
	 * 
	 * @param devMRTName
	 * @return
	 */
	public SmartObjectMRT readSmartObjectMRT(String devMRTName) {

		SmartObjectMRT deviceMRT = new SmartObjectMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(devMRTName, SmartObjectMRT.class);
			xStream.processAnnotations(SmartObjectMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/localmrt/device/"
							+ devMRTName));
			deviceMRT = (SmartObjectMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return deviceMRT;

	} // fim do metodo readDeviceMRT
	
	/**
	 * 
	 * @param userMRTName
	 * @return
	 */
	public UserMRT readUserMRT(String userMRTName) {

		UserMRT userMRT = new UserMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(userMRTName, UserMRT.class);
			xStream.processAnnotations(UserMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/localmrt/user/"
							+ userMRTName));
			userMRT = (UserMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return userMRT;

	} // fim do metodo readUserMRT
	
	/**
	 * 
	 * @param serMRTName
	 * @return
	 */
	public ServiceMRT readServiceMRT(String serMRTName) {

		ServiceMRT serviceMRT = new ServiceMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(serMRTName, ServiceMRT.class);
			xStream.processAnnotations(ServiceMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/localmrt/service/"
							+ serMRTName));
			serviceMRT = (ServiceMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return serviceMRT;

	} // fim do metodo readServiceMRT
	
}
