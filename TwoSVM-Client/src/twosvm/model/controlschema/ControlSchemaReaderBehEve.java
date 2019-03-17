package twosvm.model.controlschema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.behavioralpolicy.BehEvent;
import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ControlSchemaReaderBehEve {

	/**
	 * Metodo para ler ControlSchemaBehPol
	 * @param behEventName
	 * @return
	 */
	public BehEvent readControlSchemaBehEve(String behEventName) {

		BehEvent behEvent = new BehEvent();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(behEventName, BehEvent.class);
			xStream.processAnnotations(BehEvent.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/synthesisengine/repository/smartspace/behaviouralpolicy/behaviouralevent/"
							+ behEventName));
			behEvent = (BehEvent) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return behEvent;
	} // fim do metodo readControlSchemaBehPol

}
