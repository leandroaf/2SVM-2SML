package twosvm.model.mrt.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.ServiceMRT;
import twosvm.model.mrt.SmartSpaceMRT;
import twosvm.model.mrt.UserMRT;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class MrtReader {

	/**
	 * 
	 * @param sSpaceID
	 * @return
	 */
	public SmartSpaceMRT readSmartSpaceMRT(String sSpaceID) {

		SmartSpaceMRT sSpaceMRT = new SmartSpaceMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(sSpaceID, SmartSpaceMRT.class);
			xStream.processAnnotations(SmartSpaceMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/smartspace/"
							+ sSpaceID));
			sSpaceMRT = (SmartSpaceMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return sSpaceMRT;

	} // fim do metodo readSmartSpaceMRT

	/**
	 * 
	 * @param appName
	 * @return
	 */
	public ApplicationMRT readApplicationMRT(String appName) {

		ApplicationMRT applicationMRT = new ApplicationMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(appName, ApplicationMRT.class);
			xStream.processAnnotations(ApplicationMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/application/"
							+ appName));
			applicationMRT = (ApplicationMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return applicationMRT;

	} // fim do metodo readApplicationMRT

	/**
	 * 
	 * @param smartObjectID
	 * @return
	 */
	public SmartObjectMRT readSmartObjectMRT(String smartObjectID) {

		SmartObjectMRT smartObjectMRT = new SmartObjectMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(smartObjectID, SmartObjectMRT.class);
			xStream.processAnnotations(SmartObjectMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/smartobject/"
							+ smartObjectID));
			smartObjectMRT = (SmartObjectMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return smartObjectMRT;

	} // fim do metodo readDeviceMRT

	/**
	 * 
	 * @param userID
	 * @return
	 */
	public UserMRT readUserMRT(String userID) {

		UserMRT userMRT = new UserMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(userID, UserMRT.class);
			xStream.processAnnotations(UserMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/user/"
							+ userID));
			userMRT = (UserMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return userMRT;

	} // fim do metodo readUserMRT

	/**
	 * 
	 * @param serviceID
	 * @return
	 */
	public ServiceMRT readServiceMRT(String serviceID) {

		ServiceMRT serviceMRT = new ServiceMRT();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(serviceID, ServiceMRT.class);
			xStream.processAnnotations(ServiceMRT.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/service/"
							+ serviceID));
			serviceMRT = (ServiceMRT) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return serviceMRT;

	} // fim do metodo readServiceMRT

}
