package twosvm.model.controlschema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.behavioralpolicy.BehEvent;
import twosvm.model.behavioralpolicy.BehPolicy;

import com.thoughtworks.xstream.XStream;

public class ControlSchemaRecorderBehEve {

	/**
	 * Grava uma modelos no formato XML
	 */
	public void recordControlSchema(BehEvent eve, String eventName) {
		
		BehEvent event = new BehEvent();
		event = eve;
		String path = "./src/twosvm/synthesisengine/repository/smartspace/behaviouralpolicy/behaviouralevent/";

		XStream xStream = new XStream();
		xStream.alias("behaviourevent", BehPolicy.class);

		File file = new File(path + "" + eventName + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(event).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
