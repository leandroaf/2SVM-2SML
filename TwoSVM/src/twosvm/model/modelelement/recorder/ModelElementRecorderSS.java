package twosvm.model.modelelement.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.smartspace.SmartSpace;

import com.thoughtworks.xstream.XStream;

public class ModelElementRecorderSS {

	/**
	 * Grava uma modelos no formato XML
	 */
	public void saveModelElement(SmartSpace sSpace, String smartSpaceType,
			String modelType) {

		SmartSpace smartSpace = new SmartSpace();
		smartSpace = sSpace;

		smartSpace.setSmartSpaceName(smartSpaceType);

		XStream xStream = new XStream();
		xStream.alias("smartspace", SmartSpace.class);

		File file = new File("./src/twosvm/"
				+ modelType + "/smartspace/" + smartSpaceType + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(smartSpace).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
