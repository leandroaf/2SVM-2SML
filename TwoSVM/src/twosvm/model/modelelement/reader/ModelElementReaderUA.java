package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import twosvm.model.models.ModelDescriptionUA;
import twosvm.model.models.ModelReader;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ModelElementReaderUA {

	/**
	 * 
	 * @param uAppName
	 * @return
	 */
	public UbiApp readModelElement(String uAppName, String modelType) {

		UbiApp ubiApp = new UbiApp();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(uAppName, UbiApp.class);
			xStream.processAnnotations(UbiApp.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/" + modelType + "/ubiapp/" + uAppName
							+ ".xml"));
			ubiApp = (UbiApp) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return ubiApp;
	} // fim do metodo readModelElement

	/**
	 * Metodo que cria map de tipos de ubiApp
	 * 
	 * @return
	 */
	public HashMap<String, String> createUbiAppMap(String modelType) {

		File folder = new File("./src/twosvm/" + modelType + "/ubiapp/");

		File[] listOfFiles = folder.listFiles();

		HashMap<String, String> ubiAppList = new HashMap<String, String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				ubiAppList.put(listOfFiles[i].getName().replace(".xml", ""),
						listOfFiles[i].getName().replace(".xml", ""));
			}
		}

		return ubiAppList;

	} // fim do metodo createUbiAppMap

	/**
	 * Metodo que cria lista de tipos de ubiApp
	 * 
	 * @return
	 */
	public ArrayList<String> createUbiAppList(String modelType) {

		File folder = new File("./src/twosvm/" + modelType + "/ubiapp/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> ubiAppList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				ubiAppList.add(listOfFiles[i].getName().replace(".xml", ""));
			}
		}

		return ubiAppList;

	} // fim do metodo createUbiAppList

	/**
	 * 
	 * @param modelType
	 * @return
	 */
	public ArrayList<UbiApp> getUbiAppList(String modelType) {

		File folder = new File("./src/twosvm/" + modelType + "/ubiapp/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<UbiApp> ubiApps = new ArrayList<UbiApp>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				ubiApps.add(readModelElement(
						listOfFiles[i].getName().replace(".xml", ""), modelType));
			}
		}

		return ubiApps;

	} // fim do metodo getUbiAppList

	/**
	 * 
	 * @param ubiAppAL
	 * @param modelType
	 * @return
	 */
	public ArrayList<UbiApp> getUbiAppList(ArrayList<String> ubiAppAL,
			String modelType) {

		// Lista de todos
		ArrayList<UbiApp> ubiApps = new ArrayList<UbiApp>();

		int size = ubiAppAL.size(); // verifica o tamanho da lista

		for (int index = 0; index < size; index++) { // A leitura comeca de 1,
														// pois existe
			// um arquivo oculto na pasta
			// chamado .DS_STORE, que não pode
			// ser lido
			ubiApps.add(readModelElement(ubiAppAL.get(index), modelType));
		}

		return ubiApps;
	} // fim do metodo getUbiAppList

}
