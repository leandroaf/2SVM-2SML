package twosvm.model.macro.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.ServiceMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.UserMacro;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class MacroReader {
	
	
	/**
	 * 
	 * @param macroName
	 * @return
	 */
	public UserMacro readUserMacro(String macroName) {

		UserMacro userMacro = new UserMacro();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(macroName, UserMacro.class);
			xStream.processAnnotations(UserMacro.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/macrosrepository/"
							+ macroName + ".xml"));
			userMacro = (UserMacro) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return userMacro;

	} // fim do metodo readUserMacro

	/**
	 * 
	 * @param macroName
	 * @return
	 */
	public SmartObjectMacro readSmartObjectMacro(String macroName) {

		SmartObjectMacro smartObjectMacro = new SmartObjectMacro();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(macroName, SmartObjectMacro.class);
			xStream.processAnnotations(SmartObjectMacro.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/macrosrepository/"
							+ macroName + ".xml"));
			smartObjectMacro = (SmartObjectMacro) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return smartObjectMacro;

	} // fim do metodo readSmartObjectMacro

	/**
	 * 
	 * @param macroName
	 * @return
	 */
	public ApplicationMacro readApplicationMacro(String macroName) {

		ApplicationMacro applicationMacro = new ApplicationMacro();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(macroName, ApplicationMacro.class);
			xStream.processAnnotations(ApplicationMacro.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/macrosrepository/"
							+ macroName + ".xml"));
			applicationMacro = (ApplicationMacro) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return applicationMacro;

	} // fim do metodo readApplicationMacro
	
	/**
	 * 
	 * @param macroName
	 * @return
	 */
	public ServiceMacro readServiceMacro(String macroName) {

		ServiceMacro serviceMRT = new ServiceMacro();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(macroName, ServiceMacro.class);
			xStream.processAnnotations(ServiceMacro.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/macrosrepository/"
							+ macroName + ".xml"));
			serviceMRT = (ServiceMacro) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return serviceMRT;

	} // fim do metodo readServiceMacro
	
}