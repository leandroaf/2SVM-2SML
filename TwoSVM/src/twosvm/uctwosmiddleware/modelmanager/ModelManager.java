package twosvm.uctwosmiddleware.modelmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.modelelement.reader.ModelElementReaderBehPol;
import twosvm.model.modelelement.reader.ModelElementReaderSO;
import twosvm.model.modelelement.reader.ModelElementReaderUR;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.ServiceMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.UserMRT;
import twosvm.model.mrt.reader.MrtReader;
import twosvm.model.mrt.recorder.MrtRecorder;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.userrole.UserRole;

public class ModelManager {

	private static ModelManager instance = null;

	/**
	 * Construtor
	 */
	public ModelManager() {
	}

	/**
	 * 
	 * @return
	 */
	public static ModelManager getInstance() {
		if (instance == null) {
			instance = new ModelManager();
		}
		return instance;
	}

	/**
	 * Metodo para atualizar o M@RT de Usuario
	 * @param userMRT
	 */
	public void mrtElementUpdatesUR(UserMRT userMRT) {
		MrtRecorder mrtRecorder = new MrtRecorder();
		mrtRecorder.recordMrtUser(userMRT);
	} // fim do metodo mrtElementUpdatesUR

	/**
	 * 
	 * @param smartObjectMRT
	 */
	public void mrtElementUpdatesSO(SmartObjectMRT smartObjectMRT) {
		MrtRecorder mrtRecorder = new MrtRecorder();
		mrtRecorder.recordMrtSmartObject(smartObjectMRT);
	} // fim do metodo mrtElementUpdatesSO

	/**
	 * 
	 * @param userMRT
	 */
	public void mrtElementUpdatesUA(ApplicationMRT appMRT, String userName) {
		MrtRecorder mrtRecorder = new MrtRecorder();
		mrtRecorder.recordMrtApp(appMRT, userName);
	} // fim do metodo mrtElementUpdatesUA

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createListSO() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/smartobject/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> deviceList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				deviceList.add(listOfFiles[i].getName());
			}
		}

		return deviceList;

	} // fim do metodo createListSO

	/**
	 * 
	 * @return
	 */
	public ArrayList<SmartObjectMRT> queryMrtElementSO() {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Cria uma lista
		ArrayList<String> listAL = createListSO();

		// Lista de M@RT do tipo device
		ArrayList<SmartObjectMRT> smartObjectMRTs = new ArrayList<SmartObjectMRT>();

		int size = listAL.size(); // verifica o tamanho da lista

		for (int i = 0; i < size; i++) {
			if (!listAL.get(i).toString().equals(".DS_Store")) {
				smartObjectMRTs.add(mrtReader.readSmartObjectMRT(listAL.get(i)
						.toString()));
			}
		}

		return smartObjectMRTs;

	} // fim do metodo queryMrtElementSO

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createListApp() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/application/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> appList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				appList.add(listOfFiles[i].getName());
			}
		}

		return appList;

	} // fim do metodo createListApp

	/**
	 * 
	 * @return
	 */
	public ArrayList<ApplicationMRT> queryMrtElementsUA() {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Cria lista
		ArrayList<String> listAL = createListApp();

		// Lista de M@RT do tipo app
		ArrayList<ApplicationMRT> appMRTs = new ArrayList<ApplicationMRT>();

		int size = listAL.size(); // verifica o tamanho da lista

		for (int i = 1; i < size; i++) {
			if (!listAL.get(i).toString().equals(".DS_Store")) {
				appMRTs.add(mrtReader.readApplicationMRT(listAL.get(i)
						.toString()));
			}
		}
		return appMRTs;

	} // fim do metodo queryMrtElementsUA

	/**
	 * Metodo para retornar determinado M@RT de App
	 * @param appType
	 * @return
	 */
	public ApplicationMRT queryMrtElementUA(String appType) {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Lista de M@RT do tipo app
		ArrayList<ApplicationMRT> appMRTs = new ArrayList<ApplicationMRT>();

		// M@RT do tipo app
		ApplicationMRT appMRT = new ApplicationMRT();

		// Cria lista
		ArrayList<String> listAL = createListApp();

		int size = listAL.size(); // verifica o tamanho da lista

		for (int i = 0; i < size; i++) {
			if ((!listAL.get(i).toString().equals(".DS_Store"))) {
				appMRTs.add(mrtReader.readApplicationMRT(listAL.get(i)
						.toString()));
				int amountAppMRT = appMRTs.size();
				for (int indexAppMrt = 0; indexAppMrt < amountAppMRT; indexAppMrt++) {
					if (appMRTs.get(indexAppMrt).getApplicationType()
							.equals(appType)) {
						appMRT = mrtReader.readApplicationMRT(listAL.get(i)
								.toString());
					}
				}
			}
		}
		return appMRT;

	} // fim do metodo queryMrtElementsUA

	/**
	 * Metodo para retornar determinado M@RT de User
	 * @param userType
	 * @return
	 */
	public UserMRT queryMrtElementUR(String userType) {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Lista de M@RT do tipo app
		ArrayList<UserMRT> userMRTs = new ArrayList<UserMRT>();

		// M@RT do tipo app
		UserMRT userMRT = new UserMRT();

		// Cria lista
		ArrayList<String> listAL = createListUser();

		int size = listAL.size(); // verifica o tamanho da lista

		for (int i = 0; i < size; i++) {
			if ((!listAL.get(i).toString().equals(".DS_Store"))) {
				userMRTs.add(mrtReader.readUserMRT(listAL.get(i)
						.toString()));
				int amountAppMRT = userMRTs.size();
				for (int indexAppMrt = 0; indexAppMrt < amountAppMRT; indexAppMrt++) {
					if (userMRTs.get(indexAppMrt).getUserType()
							.equals(userType)) {
						userMRT = mrtReader.readUserMRT(listAL.get(i)
								.toString());
					}
				}
			}
		}
		return userMRT;

	} // fim do metodo queryMrtElementUR

	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createListUser() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/user/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> userList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				userList.add(listOfFiles[i].getName());
			}
		}

		return userList;

	} // fim do metodo createListUser

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createListService() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/service/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> serviceList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				serviceList.add(listOfFiles[i].getName());
			}
		}

		return serviceList;

	} // fim do metodo createListService

	/**
	 * 
	 * @return
	 */
	public ArrayList<UserMRT> queryMrtElementUR() {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Cria uma lista
		ArrayList<String> listAL = createListUser();

		// Lista de M@RT do tipo user
		ArrayList<UserMRT> userMRTs = new ArrayList<UserMRT>();

		int size = listAL.size(); // verifica o tamanho da lista de

		for (int i = 1; i < size; i++) {
			if (!listAL.get(i).toString().equals(".DS_Store")) {
				userMRTs.add(mrtReader.readUserMRT(listAL.get(i).toString()));
			}
		}

		return userMRTs;

	} // fim do metodo mrtListUser

	/**
	 * 
	 * @return
	 */
	public ArrayList<ServiceMRT> queryMrtElementSer() {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Cria uma lista
		ArrayList<String> listAL = createListService();

		// Lista de M@RT do tipo service
		ArrayList<ServiceMRT> serviceMRTs = new ArrayList<ServiceMRT>();

		int size = listAL.size(); // verifica o tamanho da lista de

		for (int i = 0; i < size; i++) {
			if (!listAL.get(i).toString().equals(".DS_Store")) {
				serviceMRTs.add(mrtReader.readServiceMRT(listAL.get(i)
						.toString()));
			}
		}

		return serviceMRTs;

	} // fim do metodo queryMrtElementSer

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createListBehPol() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/instancelevelmrt/behaviouralpolicy/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> deviceList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				deviceList.add(listOfFiles[i].getName());
			}
		}

		return deviceList;

	} // fim do metodo createListBehPol

	/**
	 * Metodo que retorna lista de arquivos da pasta de elementos do tipo
	 * SmartObject
	 * 
	 * @return
	 */
	public ArrayList<String> createModelElementsListSO() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/smartobject/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> modelElementsSO = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				modelElementsSO.add(listOfFiles[i].getName());
			}
		}

		return modelElementsSO;

	} // fim do metodo createModelElementsListSO

	/**
	 * Metodo SmartObject
	 * 
	 * @return
	 */
	public ArrayList<String> createModelElementsListUA() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/ubiapp/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> modelElementsUA = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				modelElementsUA.add(listOfFiles[i].getName());
			}
		}

		return modelElementsUA;

	} // fim do metodo createModelElementsListUA

	/**
	 * Metodo que retorna lista de arquivos da pasta de scripts do tipo UserRole
	 * 
	 * @return
	 */
	public ArrayList<String> createModelElementsListUR() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/userrole/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> modelElementsUR = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				modelElementsUR.add(listOfFiles[i].getName());
			}
		}

		return modelElementsUR;

	} // fim do metodo createModelListUR

	/**
	 * Metodo que retorna lista de elementos do modelo do tipo behaviour policy
	 * 
	 * @return
	 */
	public ArrayList<String> createModelElementsListBehPol() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/behaviouralpolicy/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> bPolScriptListAL = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				bPolScriptListAL.add(listOfFiles[i].getName());
			}
		}

		return bPolScriptListAL;

	} // fim do metodo createModelListBehPol

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
					"./src/twosvm/" + modelType + "/smartobject/" + sObjectType
							+ ".xml"));
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

		File folder = new File("./src/twosvm/" + modelType + "/smartobject/");

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

		File folder = new File("./src/twosvm/" + modelType + "/smartobject/");

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

		File folder = new File("./src/twosvm/" + modelType + "/smartobject/");

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

	/**
	 * 
	 * @return
	 */
	public ArrayList<SmartObject> getSmartObjectsModels() {
		// leitor de elementos do modelo do tipo smart object
		ModelElementReaderSO modelElementReaderSO = new ModelElementReaderSO();
		// lista de elementos do tipo smart object
		return modelElementReaderSO
				.getSmartObjectList("uctwosmiddleware/globalmrt/typelevelmrt/usermodel");
	} // fim do metodo getSmartObjectsModels
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<UserRole> getUseRolesModels() {
		// leitor de elementos do modelo do tipo UserRole
		ModelElementReaderUR modelElementReaderUR = new ModelElementReaderUR();
		// lista de elementos do tipo UserRole
		return modelElementReaderUR
				.getUserRoleList("uctwosmiddleware/globalmrt/typelevelmrt/usermodel");
	} // fim do metodo getUseRoleModels
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<BehPolicy> getBehPoliciesModels() {
		// leitor de elementos do modelo do tipo UserRole
		ModelElementReaderBehPol modelElementReaderBehPol = new ModelElementReaderBehPol();
		// lista de elementos do tipo UserRole
		return modelElementReaderBehPol
				.getPolicyList("uctwosmiddleware/globalmrt/typelevelmrt/usermodel");
	} // fim do metodo getBehPoliciesModels

}
