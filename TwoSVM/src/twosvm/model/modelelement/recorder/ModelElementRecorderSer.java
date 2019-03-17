package twosvm.model.modelelement.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.smartspace.SmartSpace;
import twosvm.model.ubiapp.UbiApp;

import com.thoughtworks.xstream.XStream;

public class ModelElementRecorderSer {

	/**
	 * Grava uma modelos no formato XML
	 */
	public void saveModelElement(Service service, String serviceType,
			String modelType) {

		Service serv = new Service();
		serv = service;

		XStream xStream = new XStream();
		xStream.alias("service", Service.class);

		File file = new File("./src/twosvm/"
				+ modelType + "/service/" + serviceType + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(serv).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
