package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import twosvm.model.smartspace.SmartSpace;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ModelElementReaderSS {

	/**
	 * 
	 * @param sSpaceName
	 * @return
	 */
	public SmartSpace readModelElement(String sSpaceName, String modelType) {

		SmartSpace smartSpace = new SmartSpace();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(sSpaceName, SmartSpace.class);
			xStream.processAnnotations(SmartSpace.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/" +modelType+ "/smartspace/"
							+ sSpaceName));
			smartSpace = (SmartSpace) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return smartSpace;
	} // fim do metodo readModelElement
	
	/**
	 * Metodo que cria lista de tipos de smartspaces, caso haja mais de um
	 * @return
	 */
	public HashMap<String, String> createSmartSpaceMap(String modelType) {

		File folder = new File("./src/twosvm/" +modelType+ "/smartspace/");

		File[] listOfFiles = folder.listFiles();

		HashMap<String, String> smartSpaceList = new HashMap<String, String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				smartSpaceList.put(listOfFiles[i].getName(), listOfFiles[i].getName());
			}
		}

		return smartSpaceList;

	} // fim do metodo createSmartSpaceMap
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createSmartSpaceList(String modelType) {

		File folder = new File("./src/twosvm/" +modelType+ "/smartspace/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> smartSpaceList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				smartSpaceList.add(listOfFiles[i].getName());
			}
		}

		return smartSpaceList;

	} // fim do metodo createSmartSpaceList

}
