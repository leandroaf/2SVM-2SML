package twosvm.model.modelelement.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.ubiapp.UbiApp;

import com.thoughtworks.xstream.XStream;

public class ModelElementRecorderUA {

	/**
	 * Grava uma modelos no formato XML
	 */
	public void saveModelElement(UbiApp ubiApp, String ubiAppType,
			String modelType) {

		UbiApp uApp = new UbiApp();
		uApp = ubiApp;

		XStream xStream = new XStream();
		xStream.alias("ubiapp", UbiApp.class);

		File file = new File("./src/twosvm/"
				+ modelType + "/ubiapp/" + ubiAppType + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(uApp).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
