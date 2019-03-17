package twosvm.model.controlschema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.smartobject.feature.Feature;

import com.thoughtworks.xstream.XStream;

public class ControlSchemaRecorderFeat {

	/**
	 * Grava uma modelos no formato XML
	 */
	public void recordControlSchema(Feature feature) {

		Feature feat;
		feat = feature;
		String featureName = feature.getFeatureName();

		XStream xStream = new XStream();
		xStream.alias("feature", Feature.class);

		File file = new File(
				"./src/twosvm/synthesisengine/repository/smartobject/feature/"
						+ featureName + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(feat).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
