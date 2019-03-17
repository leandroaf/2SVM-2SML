package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import twosvm.model.smartobject.SmartObject;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ModelElementReaderSO {

	/**
	 * 
	 * @param sObjectType
	 * @return
	 */
	public SmartObject readModelElement(String sObjectType, String modelType) {

		SmartObject smartObject = new SmartObject();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(sObjectType, SmartObject.class);
			xStream.processAnnotations(SmartObject.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/" + modelType
							+ "/smartobject/" + sObjectType + ".xml"));
			smartObject = (SmartObject) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return smartObject;

	} // fim do metodo

	/**
	 * Metodo que cria lista de tipos de smart objects
	 * 
	 * @return
	 */
	public HashMap<String, String> createSmartObjectMap(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/smartobject/");

		File[] listOfFiles = folder.listFiles();

		HashMap<String, String> smartObjectList = new HashMap<String, String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				smartObjectList.put(listOfFiles[i].getName()
						.replace(".xml", ""),
						listOfFiles[i].getName().replace(".xml", ""));
			}
		}

		return smartObjectList;

	} // fim do metodo createSmartObjectMap

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createSmartObjectList(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/smartobject/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> smartObjectList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				smartObjectList.add(listOfFiles[i].getName()
						.replace(".xml", ""));
			}
		}

		return smartObjectList;

	} // fim do metodo createSmartObjectList

	/**
	 * 
	 * @param modelType
	 * @return
	 */
	public ArrayList<SmartObject> getSmartObjectList(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/smartobject/");
		
		File[] listOfFiles = folder.listFiles();

		ArrayList<SmartObject> smartObjects = new ArrayList<SmartObject>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				smartObjects.add(readModelElement(listOfFiles[i].getName()
						.replace(".xml", ""), modelType));
			}
		}

		return smartObjects;

	} // fim do metodo getSmartObjectList

}
