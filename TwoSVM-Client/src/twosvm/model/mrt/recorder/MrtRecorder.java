package twosvm.model.mrt.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.ServiceMRT;
import twosvm.model.mrt.SmartSpaceMRT;
import twosvm.model.mrt.UserMRT;

import com.thoughtworks.xstream.XStream;

public class MrtRecorder {
	
	/**
	 * 
	 * @param sSpaceMRT
	 * @param sSpaceName
	 */
	public void recordMrtSS(SmartSpaceMRT sSpaceMRT) {
		
		SmartSpaceMRT smartSpaceMRT = new SmartSpaceMRT();
		smartSpaceMRT = sSpaceMRT;
		String path = "./src/twosvm/uctwosmiddleware/localmrt/smartspace/";

		XStream xStream = new XStream();
		xStream.alias("smartobjectmrt", SmartSpaceMRT.class);

		File file = new File(path + "" + sSpaceMRT.getSmartSpaceType() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(smartSpaceMRT).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMrtSS
	
	/**
	 * 
	 * @param uMRT
	 */
	public void recordMrtUser(UserMRT uMRT) {
		
		UserMRT userMRT = new UserMRT();
		userMRT = uMRT;
		String path = "./src/twosvm/uctwosmiddleware/localmrt/user/";

		XStream xStream = new XStream();
		xStream.alias("usermrt", UserMRT.class);

		File file = new File(path + "" + userMRT.getUserType() + "_" + userMRT.getUserName() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(userMRT).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMrtUser
	
	/**
	 * 
	 * @param devMRT
	 */
	public void recordMrtSmartObject(SmartObjectMRT devMRT) {
		
		SmartObjectMRT deviceMRT = new SmartObjectMRT();
		deviceMRT = devMRT;
		String path = "./src/twosvm/uctwosmiddleware/localmrt/device/";

		XStream xStream = new XStream();
		xStream.alias("devicemrt", SmartObjectMRT.class);

		File file = new File(path + "" + deviceMRT.getSmartObjectType() + "_" + deviceMRT.getSmartObjectName() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(deviceMRT).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMrtDevice

	/**
	 * 
	 * @param appMRT
	 */
	public void recordMrtApp(ApplicationMRT appMRT) {
		
		ApplicationMRT applicationMRT = new ApplicationMRT();
		applicationMRT = appMRT;
		String path = "./src/twosvm/uctwosmiddleware/localmrt/application/";

		XStream xStream = new XStream();
		xStream.alias("applicationmrt", ApplicationMRT.class);

		File file = new File(path + "" + applicationMRT.getApplicationType() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(applicationMRT).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMrtApp

	/**
	 * 
	 * @param serMRT
	 */
	public void recordMrtSer(ServiceMRT serMRT) {
		
		ServiceMRT serviceMRT = new ServiceMRT();
		serviceMRT = serMRT;
		String path = "./src/twosvm/uctwosmiddleware/localmrt/service/";

		XStream xStream = new XStream();
		xStream.alias("servicemrt", ServiceMRT.class);

		File file = new File(path + "" + serMRT.getServiceType() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(serviceMRT).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMrtSer
	
}
