package twosvm.model.controlschema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.behavioralpolicy.BehPolicy;

import com.thoughtworks.xstream.XStream;

public class ControlSchemaRecorderBehPol {

	/**
	 * Grava uma modelos no formato XML
	 */
	public void recordControlSchema(BehPolicy policy, String policyName) {

		BehPolicy pol = new BehPolicy();
		pol = policy;
		String path = "./src/twosvm/synthesisengine/repository/smartspace/behaviouralpolicy/";
		
		XStream xStream = new XStream();
		xStream.alias("behaviouralpolicy", BehPolicy.class);

		File file = new File(path + "" + policyName + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(pol).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
