package twosvm.model.models;

import java.io.File;
import java.util.ArrayList;

import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.controlschema.ControlSchemaReaderBehPol;
import twosvm.model.controlschema.ControlSchemaReaderSO;
import twosvm.model.controlschema.ControlSchemaReaderSer;
import twosvm.model.controlschema.ControlSchemaReaderUA;
import twosvm.model.controlschema.ControlSchemaReaderUR;
import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

/**
 * Classe que le pasta de modelos
 * 
 * @author leandroalexandre
 *
 */
public class ModelsList {

	private ArrayList<String> scriptListName;

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getScriptListName() {
		return scriptListName;
	}

	/**
	 * 
	 * @param scriptListName
	 */
	public void setScriptListName(ArrayList<String> scriptListName) {
		this.scriptListName = scriptListName;
	}

	/**
	 * Cria uma lista (no formato de ArrayList<String>) dos scripts que deverao
	 * ser instalados e os adiciona no scriptList
	 * 
	 * @return
	 */
	public ArrayList<String> createScriptList(String path) {

		File folder = new File(path);

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> scriptListAL = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				scriptListAL.add(listOfFiles[i].getName());
			}
		}
		return scriptListAL;
	}

	/**
	 * Metodo para retornar a lista de submodelos do tipo UserRole
	 * @param path
	 * @return
	 */
	public ArrayList<UserRole> readModelsListUR() {

		ControlSchemaReaderUR controlSchemaReadUR = new ControlSchemaReaderUR();

		ArrayList<UserRole> userRoleAL = new ArrayList<UserRole>();
		ArrayList<String> commandListAL;
		
		String path = "./src/twosvm/synthesisengine/repository/userrole/";

		// Obtem a lista de scripts em uma ArrayList<String>
		commandListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = commandListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			userRoleAL.add(controlSchemaReadUR.readControlSchemaUR(commandListAL
					.get(i).toString()));
		}
		return userRoleAL;
	} // fim do metodo readModelsListUR
	
	/**
	 * Metodo para retornar a lista de submodelos do tipo SmartObject
	 * @param path
	 * @return
	 */
	public ArrayList<SmartObject> readModelsListSO() {

		ControlSchemaReaderSO controlSchemaReadSO = new ControlSchemaReaderSO();

		ArrayList<SmartObject> smartObjectAL = new ArrayList<SmartObject>();
		ArrayList<String> commandListAL;
		
		String path = "./src/twosvm/synthesisengine/repository/smartObject/";

		// Obtem a lista de scripts em uma ArrayList<String>
		commandListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = commandListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			smartObjectAL.add(controlSchemaReadSO.readControlSchemaSO(commandListAL
					.get(i).toString()));
		}
		return smartObjectAL;
	} // fim do metodo readModelsListSO

	/**
	 * Metodo para retornar a lista de submodelos do tipo UbiApp
	 * @param path
	 * @return
	 */
	public ArrayList<UbiApp> readModelsListUA() {

		ControlSchemaReaderUA controlSchemaReadUA = new ControlSchemaReaderUA();

		ArrayList<UbiApp> ubiAppAL = new ArrayList<UbiApp>();
		ArrayList<String> commandListAL;
		
		String path = "./src/twosvm/synthesisengine/repository/ubiapp/";

		// Obtem a lista de scripts em uma ArrayList<String>
		commandListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = commandListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			ubiAppAL.add(controlSchemaReadUA.readControlSchemaUA(commandListAL
					.get(i).toString()));
		}
		return ubiAppAL;
	} // fim do metodo readModelsListUA

	/**
	 * Metodo para retornar a lista de submodelos do tipo Service
	 * @param path
	 * @return
	 */
	public ArrayList<Service> readModelsListSer() {

		ControlSchemaReaderSer controlSchemaReadSer = new ControlSchemaReaderSer();

		ArrayList<Service> serviceAL = new ArrayList<Service>();
		ArrayList<String> commandListAL;
		
		String path = "./src/twosvm/synthesisengine/repository/service/";

		// Obtem a lista de scripts em uma ArrayList<String>
		commandListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = commandListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			serviceAL.add(controlSchemaReadSer.readControlSchemaSer(commandListAL
					.get(i).toString()));
		}
		return serviceAL;
	} // fim do metodo readModelsListSer
	
	/**
	 * Metodo para retornar a lista de submodelos do tipo BehaviourPolicy
	 * @return
	 */
	public ArrayList<BehPolicy> readModelsListBehPol() {

		ControlSchemaReaderBehPol controlSchemaReadBehPol = new ControlSchemaReaderBehPol();

		ArrayList<BehPolicy> behPolicyAL = new ArrayList<BehPolicy>();
		ArrayList<String> commandListAL;
		
		String path = "./src/twosvm/synthesisengine/repository/smartspace/behaviourpolicy/";

		// Obtem a lista de scripts em uma ArrayList<String>
		commandListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = commandListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			behPolicyAL.add(controlSchemaReadBehPol.readControlSchemaBehPol(commandListAL
					.get(i).toString()));
		}
		
		return behPolicyAL;
		
	}// fim do metodo readModelsListSer
	
}
