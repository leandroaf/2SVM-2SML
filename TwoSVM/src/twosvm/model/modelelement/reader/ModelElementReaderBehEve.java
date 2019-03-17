package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.behavioralpolicy.BehEvent;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ModelElementReaderBehEve {

	/**
	 * Metodo para ler ControlSchemaBehPol
	 * @param behEventName
	 * @return
	 */
	public BehEvent readModelElement(String behEventName, String modelType) {

		BehEvent behEvent = new BehEvent();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(behEventName, BehEvent.class);
			xStream.processAnnotations(BehEvent.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/" + modelType
							+ "/behaviouralpolicy/behaviouralevent/"
							+ behEventName));
			behEvent = (BehEvent) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return behEvent;
	} // fim do metodo readControlSchemaBehPol

}
