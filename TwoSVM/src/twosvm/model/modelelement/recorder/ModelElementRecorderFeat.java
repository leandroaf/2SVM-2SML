package twosvm.model.modelelement.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import twosvm.model.smartobject.feature.Feature;

import com.thoughtworks.xstream.XStream;

public class ModelElementRecorderFeat {

	/**
	 * Grava elemento do modelo de do tipo feature
	 */
	public void saveModelElement(Feature feature, String modelType) {

		Feature feat;
		feat = feature;
		String featureName = feature.getFeatureName();

		XStream xStream = new XStream();
		xStream.alias("feature", Feature.class);

		File file = new File("./src/twosvm/" + modelType + "/feature/"
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

	/**
	 * Grava elementos do modelo do tipo feature
	 * 
	 * @param features
	 * @param modelType
	 */
	public void saveModelElements(ArrayList<Feature> features, String modelType) {

		int amountFeat = features.size();
		for (int indexFeat = 0; indexFeat < amountFeat; indexFeat++) {
			saveModelElement(features.get(indexFeat), modelType);
		}
	}

}
