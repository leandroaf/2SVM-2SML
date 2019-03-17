package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ModelElementReaderSer {

	/**
	 * 
	 * @param serviceType
	 * @return
	 */
	public Service readModelElement(String serviceType, String modelType) {

		Service service = new Service();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(serviceType, Service.class);
			xStream.processAnnotations(Service.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/" +modelType+ "/service/"
							+ serviceType + ".xml"));
			service = (Service) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return service;
	} // fim do metodo readModelElement

	/**
	 * Metodo que cria lista de tipos de aplicacoes ubiquas
	 * 
	 * @return
	 */
	public HashMap<String, String> createServiceMap(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/service/");

		File[] listOfFiles = folder.listFiles();

		HashMap<String, String> serviceList = new HashMap<String, String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				serviceList.put(listOfFiles[i].getName().replace(".xml", ""),
						listOfFiles[i].getName().replace(".xml", ""));
			}
		}

		return serviceList;

	} // fim do metodo createServiceMap

	public ArrayList<String> createServiceList(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/service/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> serviceList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				serviceList.add(listOfFiles[i].getName().replace(".xml", ""));
			}
		}

		return serviceList;

	} // fim do metodo createServiceList

	/**
	 * 
	 * @param modelType
	 * @return
	 */
	public ArrayList<Service> getServiceList(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/service/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<Service> services = new ArrayList<Service>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				services.add(readModelElement(
						listOfFiles[i].getName().replace(".xml", ""), modelType));
			}
		}

		return services;

	} // fim do metodo getServiceList

}
