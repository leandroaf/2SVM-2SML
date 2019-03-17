package twosvm.model.controlschema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.smartobject.SmartObject;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ControlSchemaReaderSO {

	public SmartObject readControlSchemaSO(String sObjectName) {

		SmartObject smartObject = new SmartObject();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(sObjectName, SmartObject.class);
			xStream.processAnnotations(SmartObject.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/synthesisengine/repository/smartobject/"
							+ sObjectName));
			smartObject = (SmartObject) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return smartObject;

	}

}
