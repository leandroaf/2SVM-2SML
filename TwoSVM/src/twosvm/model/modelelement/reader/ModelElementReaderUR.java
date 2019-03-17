package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ModelElementReaderUR {

	/**
	 * 
	 * @param uRoleType
	 * @return
	 */
	public UserRole readModelElement(String uRoleType, String modelType) {

		UserRole userRole = new UserRole();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(uRoleType, UserRole.class);
			xStream.processAnnotations(UserRole.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/" + modelType + "/userrole/" + uRoleType
							+ ".xml"));
			userRole = (UserRole) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return userRole;

	} // fim do metodo readModelElement

	/**
	 * Metodo que cria map de tipos de papeis do usuario
	 * 
	 * @return
	 */
	public HashMap<String, String> createUserRoleMap(String modelType) {

		File folder = new File("./src/twosvm/" + modelType + "/userrole/");

		File[] listOfFiles = folder.listFiles();

		HashMap<String, String> userList = new HashMap<String, String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				userList.put(listOfFiles[i].getName().replace(".xml", ""),
						listOfFiles[i].getName().replace(".xml", ""));
			}
		}
		return userList;

	} // fim do metodo createUserRoleMap

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createUserRoleList(String modelType) {

		File folder = new File("./src/twosvm/" + modelType + "/userrole/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> userList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				userList.add(listOfFiles[i].getName().replace(".xml", ""));
			}
		}
		return userList;

	} // fim do metodo createUserRoleList

	/**
	 * 
	 * @param modelType
	 * @return
	 */
	public ArrayList<UserRole> getUserRoleList(String modelType) {

		File folder = new File("./src/twosvm/" + modelType + "/userrole/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<UserRole> users = new ArrayList<UserRole>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				users.add(readModelElement(
						listOfFiles[i].getName().replace(".xml", ""), modelType));
			}
		}

		return users;

	} // fim do metodo getUserRoleList

}
