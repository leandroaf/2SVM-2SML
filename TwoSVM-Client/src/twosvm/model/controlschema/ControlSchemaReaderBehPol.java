package twosvm.model.controlschema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ControlSchemaReaderBehPol {

	/**
	 * Metodo para ler ControlSchemaBehPol
	 * @param behPolicyName
	 * @return
	 */
	public BehPolicy readControlSchemaBehPol(String behPolicyName) {

		BehPolicy behPolicy = new BehPolicy();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(behPolicyName, BehPolicy.class);
			xStream.processAnnotations(BehPolicy.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/synthesisengine/repository/smartspace/behaviouralpolicy/"
							+ behPolicyName));
			behPolicy = (BehPolicy) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return behPolicy;
	} // fim do metodo readControlSchemaBehPol

}
