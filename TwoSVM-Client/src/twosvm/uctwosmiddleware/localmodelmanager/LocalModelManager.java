package twosvm.uctwosmiddleware.localmodelmanager;

import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.UserMRT;
import twosvm.model.mrt.reader.MrtReader;
import twosvm.model.mrt.recorder.MrtRecorder;

public class LocalModelManager {
	
	/**
	 * 
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
	public void mrtElementUpdatesUA(ApplicationMRT appMRT) {
		MrtRecorder mrtRecorder = new MrtRecorder();
		mrtRecorder.recordMrtApp(appMRT);
	} // fim do metodo mrtElementUpdatesUA
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createListDev() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/localmrt/device/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> deviceList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				deviceList.add(listOfFiles[i].getName());
			}
		}

		return deviceList;

	} // fim do metodo createListDev

	/**
	 * 
	 * @return
	 */
	public SmartObjectMRT queryMrtElementSO() {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Cria uma lista
		ArrayList<String> listAL = createListDev();

		// M@RT do tipo device
		SmartObjectMRT smartObjectMRTs = new SmartObjectMRT();

		int size = listAL.size(); // verifica o tamanho da lista

		for (int i = 0; i < size; i++) {
			if (!listAL.get(i).toString().equals(".DS_Store"))  {
				smartObjectMRTs = mrtReader
						.readSmartObjectMRT(listAL.get(i).toString());
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
				"./src/twosvm/uctwosmiddleware/localmrt/application/");

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
	public ArrayList<ApplicationMRT> queryMrtElementUA() {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Cria lista
		ArrayList<String> listAL = createListApp();

		// Lista de M@RT do tipo app
		ArrayList<ApplicationMRT> appMRTs = new ArrayList<ApplicationMRT>();

		int size = listAL.size(); // verifica o tamanho da lista

		for (int i = 0; i < size; i++) {
			
			if (!listAL.get(i).toString().equals(".DS_Store"))  {
				appMRTs.add(mrtReader
						.readApplicationMRT(listAL.get(i).toString()));
			}
			
		}

		return appMRTs;

	} // fim do metodo queryMrtElementListUA

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> createListUser() {

		File folder = new File(
				"./src/twosvm/uctwosmiddleware/localmrt/user/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> appList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				appList.add(listOfFiles[i].getName());
			}
		}

		return appList;

	} // fim do metodo createListUser

	/**
	 * 
	 * @return
	 */
	public UserMRT queryMrtElementUR() {

		// MrtReader
		MrtReader mrtReader = new MrtReader();

		// Cria lista
		ArrayList<String> listAL = createListUser();

		// MRT de user
		UserMRT userMRT = new UserMRT();

		int size = listAL.size(); // verifica o tamanho da lista

		for (int i = 0; i < size; i++) {
			if (!listAL.get(i).toString().equals(".DS_Store"))  {
				userMRT = mrtReader
						.readUserMRT(listAL.get(i).toString());
			}
		}

		return userMRT;

	} // fim do metodo queryMrtElementUR
	
	/**
	 * 
	 * @param contextChange
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void startApplicationInDevice(ContextChange contextChange)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NotBoundException, InterruptedException,
			IOException {

		User user = new User();
		user = contextChange.getUser();

		// le M@RT de application
		ArrayList<ApplicationMRT> applicationMRTs = new ArrayList<ApplicationMRT>();
		applicationMRTs = queryMrtElementUA();

		int amountAppMRT = applicationMRTs.size();
		for (int index = 0; index < amountAppMRT; index++) {
			// se houver uma aplicacao daquele tipo, atualizar o M@RT dela
			if (applicationMRTs.get(index).getApplicationType()
					.equals(user.appTypeSS())) {

				// define a aplicacao como ativa no dispositivo, ou seja, esta
				// sendo executada
				ApplicationMRT appMRT = new ApplicationMRT();
				appMRT = applicationMRTs.get(index);
				appMRT.setApplicationName(user.applicationNameSS());
				appMRT.setActive(true);

				MrtRecorder mrtRecorder = new MrtRecorder();
				mrtRecorder.recordMrtApp(appMRT);
				
				mrtElementUpdatesUA(applicationMRTs.get(index));

			} // fim do if
		} // fim do loop

	} // fim do metodo startApplicationInDevice


}
