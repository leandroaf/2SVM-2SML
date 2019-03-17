package twosvm.model.controlschema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ControlSchemaReaderUA {

	public UbiApp readControlSchemaUA(String uAppName) {

		UbiApp ubiApp = new UbiApp();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(uAppName, UbiApp.class);
			xStream.processAnnotations(UbiApp.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/synthesisengine/repository/ubiapp/"
							+ uAppName));
			ubiApp = (UbiApp) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return ubiApp;
	}

}
