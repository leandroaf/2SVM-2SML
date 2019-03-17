package twosvm.model.macro.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.Macro;
import twosvm.model.macro.ServiceMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.mrt.SmartSpaceMRT;
import twosvm.model.ubiapp.UbiApp;

import com.thoughtworks.xstream.XStream;

public class MacroRecorder {
	
	/**
	 * 
	 * @param userMacro
	 */
	public void recordMacroUR(UserMacro userMacro) {
		
		String path = "./src/twosvm/uctwosmiddleware/macrosrepository/";

		XStream xStream = new XStream();
		xStream.alias("usermacro", UserMacro.class);

		File file = new File(path + "" + userMacro.getName() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(userMacro).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMacroUR
	
	/**
	 * 
	 * @param smartObjectMacro
	 */
	public void recordMacroSO(SmartObjectMacro smartObjectMacro) {
		
		String path = "./src/twosvm/uctwosmiddleware/macrosrepository/";

		XStream xStream = new XStream();
		xStream.alias("devicemacro", SmartObjectMacro.class);

		File file = new File(path + "" + smartObjectMacro.getName() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(smartObjectMacro).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMacroSO
	
	/**
	 * 
	 * @param applicationMacro
	 */
	public void recordMacroUA(ApplicationMacro applicationMacro) {
		
		String path = "./src/twosvm/uctwosmiddleware/macrosrepository/";

		XStream xStream = new XStream();
		xStream.alias("applicationmacro", ApplicationMacro.class);

		File file = new File(path + "" + applicationMacro.getName() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(applicationMacro).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMacroUA
	
	/**
	 * 
	 * @param serviceMacro
	 */
	public void recordMacroSer(ServiceMacro serviceMacro) {
		
		String path = "./src/twosvm/uctwosmiddleware/macrosrepository/";

		XStream xStream = new XStream();
		xStream.alias("servicemacro", ServiceMacro.class);

		File file = new File(path + "" + serviceMacro.getName() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(serviceMacro).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMacroSer


}
