package twosvm.model.manipulatorlanguage;

import java.io.File;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import twosvm.model.behavioralpolicy.BehEvent;
import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.modelelement.reader.ModelElementReaderBehEve;
import twosvm.model.modelelement.reader.ModelElementReaderBehPol;
import twosvm.model.modelelement.reader.ModelElementReaderSO;
import twosvm.model.modelelement.reader.ModelElementReaderSS;
import twosvm.model.modelelement.reader.ModelElementReaderSer;
import twosvm.model.modelelement.reader.ModelElementReaderUA;
import twosvm.model.modelelement.reader.ModelElementReaderUR;
import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.smartspace.SmartSpace;
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
	 * 
	 * @return
	 */
	public SmartSpace readModelSS(String modelType) {

		ModelElementReaderSS controlSchemaReadUR = new ModelElementReaderSS();

		SmartSpace smartSpace = new SmartSpace();
		ArrayList<String> scriptListAL;

		String path = "./src/twosvm/synthesisengine/mrt/smartspace/";

		// Obtem a lista de scripts em uma ArrayList<String>
		scriptListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = scriptListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			smartSpace = controlSchemaReadUR.readModelElement(
					scriptListAL.get(i).toString(), modelType);
		}
		return smartSpace;
	} // fim do metodo readModelSS

	/**
	 * Metodo para retornar a lista de submodelos do tipo UserRole
	 * 
	 * @param path
	 * @return
	 */
	public ArrayList<UserRole> readModelsListUR(String modelType) {

		ModelElementReaderUR controlSchemaReadUR = new ModelElementReaderUR();

		ArrayList<UserRole> userRoleAL = new ArrayList<UserRole>();
		ArrayList<String> scriptListAL;

		String path = "./src/twosvm/synthesisengine/mrt/userrole/";

		// Obtem a lista de scripts em uma ArrayList<String>
		scriptListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = scriptListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			userRoleAL.add(controlSchemaReadUR.readModelElement(scriptListAL
					.get(i).toString(), modelType));
		}
		return userRoleAL;
	} // fim do metodo readModelsListUR

	/**
	 * Metodo para retornar a lista de submodelos do tipo SmartObject
	 * 
	 * @param path
	 * @return
	 */
	public ArrayList<SmartObject> readModelsListSO(String modelType) {

		ModelElementReaderSO controlSchemaReadSO = new ModelElementReaderSO();

		ArrayList<SmartObject> smartObjectAL = new ArrayList<SmartObject>();
		ArrayList<String> scriptListAL;

		String path = "./src/twosvm/synthesisengine/mrt/smartObject/";

		// Obtem a lista de scripts em uma ArrayList<String>
		scriptListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = scriptListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			smartObjectAL.add(controlSchemaReadSO.readModelElement(scriptListAL
					.get(i).toString(), modelType));
		}
		return smartObjectAL;
	} // fim do metodo readModelsListSO

	/**
	 * Metodo para retornar a lista de submodelos do tipo UbiApp
	 * 
	 * @param path
	 * @return
	 */
	public ArrayList<UbiApp> readModelsListUA(String modelType) {

		ModelElementReaderUA controlSchemaReadUA = new ModelElementReaderUA();

		ArrayList<UbiApp> ubiAppAL = new ArrayList<UbiApp>();
		ArrayList<String> scriptListAL;

		String path = "./src/twosvm/synthesisengine/mrt/ubiapp/";

		// Obtem a lista de scripts em uma ArrayList<String>
		scriptListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = scriptListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			ubiAppAL.add(controlSchemaReadUA.readModelElement(
					scriptListAL.get(i).toString(), modelType));
		}
		return ubiAppAL;
	} // fim do metodo readModelsListUA

	/**
	 * Metodo para retornar a lista de submodelos do tipo Service
	 * 
	 * @param path
	 * @return
	 */
	public ArrayList<Service> readModelsListSer(String modelType) {

		ModelElementReaderSer controlSchemaReadSer = new ModelElementReaderSer();

		ArrayList<Service> serviceAL = new ArrayList<Service>();
		ArrayList<String> scriptListAL;

		String path = "./src/twosvm/synthesisengine/mrt/service/";

		// Obtem a lista de scripts em uma ArrayList<String>
		scriptListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = scriptListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			serviceAL.add(controlSchemaReadSer.readModelElement(scriptListAL
					.get(i).toString(), modelType));
		}
		return serviceAL;
	} // fim do metodo readModelsListSer

	/**
	 * Metodo para retornar a lista de submodelos do tipo BehaviouralPolicy
	 * 
	 * @return
	 */
	public ArrayList<BehPolicy> readModelsListBehPol(String modelType) {

		ModelElementReaderBehPol controlSchemaReadBehPol = new ModelElementReaderBehPol();

		ArrayList<BehPolicy> behPolicyAL = new ArrayList<BehPolicy>();
		ArrayList<String> scriptListAL;

		String path = "./src/twosvm/synthesisengine/mrt/smartspace/behavioralpolicy/";

		// Obtem a lista de scripts em uma ArrayList<String>
		scriptListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = scriptListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			behPolicyAL.add(controlSchemaReadBehPol.readModelElement(
					scriptListAL.get(i).toString(), modelType));
		}

		return behPolicyAL;

	} // fim do metodo readModelsListBehPol

	/**
	 * Metodo para retornar a lista de submodelos do tipo BehaviouralEvent
	 * 
	 * @return
	 */
	public ArrayList<BehEvent> readModelsListBehEve(String modelType) {

		ModelElementReaderBehEve controlSchemaReadBehEve = new ModelElementReaderBehEve();

		ArrayList<BehEvent> behEventAL = new ArrayList<BehEvent>();
		ArrayList<String> scriptListAL;

		String path = "./src/twosvm/synthesisengine/mrt/smartspace/behavioralpolicy/behaviouralevent/";

		// Obtem a lista de scripts em uma ArrayList<String>
		scriptListAL = createScriptList(path);

		// Le cada ControlSchema de ModelsList
		int size = scriptListAL.size();

		for (int i = 1; i < size; i++) { // A leitura comeca de 1, pois existe
											// um arquivo oculto na pasta
											// chamado .DS_STORE, que não pode
											// ser lido
			behEventAL.add(controlSchemaReadBehEve.readModelElement(
					scriptListAL.get(i).toString(), modelType));
		}

		return behEventAL;

	} // fim do metodo readModelsListBehEve

}
