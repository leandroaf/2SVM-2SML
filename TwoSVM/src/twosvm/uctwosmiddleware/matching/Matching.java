package twosvm.uctwosmiddleware.matching;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Random;

import twosvm.model.database.DatabaseReader;
import twosvm.model.instance.resource.Resource;
import twosvm.model.instance.user.User;
import twosvm.model.modelelement.reader.ModelElementReaderSO;
import twosvm.model.modelelement.reader.ModelElementReaderUA;
import twosvm.model.modelelement.reader.ModelElementReaderUR;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;
import twosvm.uctwosmiddleware.modelinterpreter.ModelInterpreter;
import twosvm.uctwosmiddleware.modelmanager.ModelManager;

/**
 * Classe que faz o matching do tipo com a instância
 * 
 * @author leandroalexandre
 *
 */
public class Matching {

	private static Matching instance = null;

	ModelInterpreter modelInterpreter = ModelInterpreter.getInstance();
	
	ModelManager modelManager = new ModelManager();

	/**
	 * Construtor
	 */
	public Matching() {
	}

	/**
	 * 
	 * @return
	 */
	public static Matching getInstance() {
		if (instance == null) {
			instance = new Matching();
		}
		return instance;
	}

	/**
	 * Gerador de indenticadores
	 * 
	 * @return
	 */
	public int generatorID() {
		Random random = new Random();
		return random.nextInt();
	} // fim do metodo generatorID

	/**
	 * Identifica o tipo do smart object
	 * 
	 * @param resource
	 * @return
	 */
	public SmartObject matchingSmartObject(Resource resource) {

		// Objeto Smart Object selecionado
		SmartObject sObjectSelected = new SmartObject();

		// Objeto Smart Object
		SmartObject smartObject = new SmartObject();

		// Lista de elementos do tipo Smart Object
		ArrayList<SmartObject> smartObjects = new ArrayList<SmartObject>();

		// lista de elementos do tipo smart object
		smartObjects = modelManager.getSmartObjectsModels();

		// verifica a quantidade de smart objects
		int amountSO = smartObjects.size();

		// contadores de HW e SW maximos, utilizados para escolher o comando com
		// maior numero de caracteristicas
		int countMax = 0;

		// le cada um dos elementos do tipo smart object
		for (int indexSO = 0; indexSO < amountSO; indexSO++) {

			// contador de caracteristicas de HW
			int countHW = 0;
			// contador de caracteristicas de SW
			int countSW = 0;

			smartObject = smartObjects.get(indexSO);

			int amountFeature = smartObject.getFeatureAL().size();

			// loop para feature
			for (int indexFeature = 0; indexFeature < amountFeature; indexFeature++) {

				// Verifica se a feature de SmartObject tem Hardware
				if (smartObject.getFeature(indexFeature).getFeatureType()
						.equals("HARDWARE")) {

					// matchingHardware
					countHW = countHW
							+ matchingHardware(smartObject, indexFeature,
									resource);

				} // fim do if que verifica se a feature de SmartObject tem
					// Hardware
				// Verifica se a feature de SmartObject tem Software
				if (smartObject.getFeature(indexFeature).getFeatureType()
						.equals("SOFTWARE")) {

					// matchingSoftware
					countSW = countSW
							+ matchingSoftware(smartObject, indexFeature,
									resource);

				} // Fim do if que verifica se a feature de SmartObject tem
					// Software

			} // fim do loop para feature

			// mensagem notificando sobre a existencia de comando
			if ((countHW > 0) || (countSW > 0)) {

				// faz a checagem para escolher o comando com maior numero de
				// caracteristicas
				if (countHW + countSW > countMax) {
					countMax = countHW + countSW;
					// este comando selecionado possui o maior numero de
					// caracteristicas
					sObjectSelected = smartObjects.get(indexSO);
				}

			} // fim do if para mensagem notificando sobre a existencia de
				// comando

		} // fim do loop

		// Mensagem exibindo o comando selecionado
		if (countMax > 0) {
			System.out
					.println("O smart object que entrou no ambiente é do tipo '"
							+ sObjectSelected.getSmartObjectType()
							+ "' e pode ser adicionado ao espaço inteligente.");
		}

		// retorna smart object selecionado
		return sObjectSelected;

	} // fim do metodo matchingSmartObject

	/**
	 * Metodo para identificar tipo de Resource
	 * 
	 * @param resource
	 * @throws NotBoundException
	 * @throws IOException
	 */
	public void matchingResource(Resource resource) throws NotBoundException,
			IOException {

		SmartObject smartObject = new SmartObject();

		// Faz o matching de Resource com o SmartObject
		smartObject = matchingSmartObject(resource);

		// se existir um comando relacionado, enviar macro para dispositivo
		if (smartObject != null) {
			System.out.println("Tempo identificar SO: "+System.currentTimeMillis());
			modelInterpreter.interpretMrtElementSO(smartObject, resource);
		}

	} // fim do metodo matchingResource

	/**
	 * Metodo para fazer o matching de Hardware
	 * 
	 * @param sObject
	 * @param iFeature
	 * @param res
	 * @return
	 */
	public int matchingHardware(SmartObject sObject, int iFeature, Resource res) {

		SmartObject smartObject = sObject;
		int indexFeature = iFeature;
		Resource resource = res;
		int countHW = 0;

		// quantidade de HW para resource
		int amountHW = resource.getHardwareResourceAL().size();

		// loop para percorrer todos HW de resource
		for (int indexHardware = 0; indexHardware < amountHW; indexHardware++) {
			if (smartObject
					// compara featureDescription com hardwareName
					.getFeature(indexFeature)
					.getFeatureDescription()
					.equals(resource.getHardwareResourceAL().get(indexHardware)
							.getHardwareName())
					&& (smartObject
							// compara featureDescription com
							// numericalFeature e/ou literalFeature
							.getFeature(indexFeature)
							.getFeatureDescription()
							.equals(resource.getHardwareResourceAL()
									.get(indexHardware).getNumericalFeature()) || smartObject
							.getFeature(indexFeature)
							.getFeatureDescription()
							.equals(resource.getHardwareResourceAL()
									.get(indexHardware).getLiteralFeature()))) {

				// adiciona 1 ao contador de DW
				countHW++;
			}

		} // fim loop para percorrer todos HW de resource

		return countHW;

	} // fim do metodo para fazer o matching de Hardware

	/**
	 * Metodo para fazer o matching de Software
	 * 
	 * @param sObject
	 * @param iFeature
	 * @param res
	 * @return
	 */
	public int matchingSoftware(SmartObject sObject, int iFeature, Resource res) {

		SmartObject smartObject = sObject;
		int indexFeature = iFeature;
		Resource resource = res;
		int countSW = 0;

		// quantidade de SW para resource
		int amountSW = resource.getSoftwareResourceAL().size();

		// loop para percorrer todos SW de resource
		for (int indexSoftware = 0; indexSoftware < amountSW; indexSoftware++) {
			if (smartObject
					// compara featureDescription com hardwareName
					.getFeature(indexFeature)
					.getFeatureDescription()
					.equals(resource.getSoftwareResourceAL().get(indexSoftware)
							.getSoftwareName())
					&& (smartObject
							// compara featureDescription com
							// numericalFeature e/ou literalFeature
							.getFeature(indexFeature)
							.getFeatureDescription()
							.equals(resource.getSoftwareResourceAL()
									.get(indexSoftware).getNumericalFeature()) || smartObject
							.getFeature(indexFeature)
							.getFeatureDescription()
							.equals(resource.getSoftwareResourceAL()
									.get(indexSoftware).getLiteralFeature()))) {

				// adiciona 1 ao contador de SW
				countSW++;
			}

		} // fim loop para percorrer todos SW de resource

		return countSW;

	} // fim do metodo para fazer o matching de Software

	/**
	 * 
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public UserRole matchingUserRole(User user) throws IOException,
			NotBoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		// ler se usuario esta cadastrado na base de dados
		DatabaseReader dReader = new DatabaseReader();
		String userName = user.userNameSS();
		String strUserRole = dReader.dBaseReader(userName);

		// Lista de elementos do tipo UserRole
		ArrayList<UserRole> userRoles = new ArrayList<UserRole>();

		// recebe lista de elementos do tipo UserRole
		userRoles = modelManager.getUseRolesModels();

		// objeto UserRole
		UserRole userRole = new UserRole();

		// verifica a quantidade
		int amountUR = userRoles.size();

		for (int indexUR = 0; indexUR < amountUR; indexUR++) {
			userRole = userRoles.get(indexUR);

			// verifica se existe modelo de papel do usuario para comparar com o
			// papel do usuario encontrado no SS
			if (strUserRole.equals(userRole.getUserRoleType())) {

				// comando selecionado para adicionar usuario no SS
				userRole = userRoles.get(indexUR);
				

				System.out.println("Tempo identificar UR: "+System.currentTimeMillis());

				System.out.println("O usuário '" + userName
						+ "' possui papel do usuário '"
						+ userRole.getUserRoleType()
						+ "' e pode ser adicionado no espaço inteligente.");

				// seleciona UbiApps de UserRole
				ArrayList<String> ubiAppAL = new ArrayList<String>();
				ubiAppAL = userRole.getUbiAppAL();

				// Lista de UbiApp
				ArrayList<UbiApp> ubiApps = new ArrayList<UbiApp>();
				ubiApps = matchingUbiAppAL(ubiAppAL);

				int amountUA = ubiAppAL.size();

				// enviar lista de das ubiApp
				for (int index = 0; index < amountUA; index++) {
					modelInterpreter.interpretMrtElementUA(ubiApps,
							user.deviceIP(), user.userNameSS(), index);
				}
				// retorna userRole
				return userRole;
			}

		}
		return userRole;
	} // fim do metodo para fazer o matching de User

	/**
	 * 
	 * @param user
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void matchingUser(User user) throws IOException, NotBoundException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		// UserRole
		UserRole userRole = new UserRole();

		// Faz o matching de user com UserRole
		userRole = matchingUserRole(user);

		// envia para Model Interpreter
		if (userRole != null) {
			modelInterpreter.interpretMrtElementUR(userRole, user);
		}

	} // fim do metodo para identificar papel do usuario

	/**
	 * 
	 * @param uAppAL
	 */
	public ArrayList<UbiApp> matchingUbiAppAL(ArrayList<String> uAppAL) {

		ModelElementReaderUA modelElementReaderUA = new ModelElementReaderUA();

		// Lista de nomes de todas UbiApps
		ArrayList<String> ubiAppALs = new ArrayList<String>();
		ubiAppALs = modelManager.createModelElementsListUA();

		// Lista de UbiApps
		ArrayList<UbiApp> ubiApps = new ArrayList<UbiApp>();
		ubiApps = modelElementReaderUA
				.getUbiAppList("uctwosmiddleware/globalmrt/typelevelmrt/usermodel");

		ArrayList<UbiApp> ubiAppS = new ArrayList<UbiApp>();

		// Lista de comandos de ubiApps relacionadas a UserRole identificado
		ArrayList<String> ubiAppAL = new ArrayList<String>();
		ubiAppAL = uAppAL;

		// quantidade de comandos de ubiApp
		int amountUAppCommands = ubiApps.size();

		// quantidade de ubiApps
		int amountUbiAppAL = ubiAppAL.size();

		for (int indexUbiApp = 0; indexUbiApp < amountUAppCommands; indexUbiApp++) {
			for (int indexUbiAppAL = 0; indexUbiAppAL < amountUbiAppAL; indexUbiAppAL++) {
				// identifica o comando de ubiApp
				if (ubiApps.get(indexUbiApp).getUbiAppType()
						.equals(ubiAppAL.get(indexUbiAppAL))) {
					// retorna comando de UbiApp identificado
					ubiAppS.add(ubiApps.get(indexUbiApp));

				}
			}
		}

		return ubiAppS;

	} // fim do metodo de matchingUbiAppAL

	/**
	 * 
	 * @param uAppAL
	 * @return
	 */
	public UbiApp matchingUbiApp(ArrayList<String> uAppAL) {

		// Criar a lista de comandos de UbiApp e apos isso, identificar aqueles
		// que estao relacionados a UserRole identificado
		ModelElementReaderUA modelElementReaderUA = new ModelElementReaderUA();

		// Lista de nomes de todos os comandos de UbiApps
		ArrayList<String> ubiAppALs = new ArrayList<String>();
		ubiAppALs = modelManager.createModelElementsListUA();

		// Lista de
		ArrayList<UbiApp> ubiApps = new ArrayList<UbiApp>();
		ubiApps = modelElementReaderUA.getUbiAppList(ubiAppALs, "usermodel");

		// Lista de comandos de ubiApps relacionadas a UserRole identificado
		ArrayList<String> ubiAppAL = new ArrayList<String>();
		ubiAppAL = uAppAL;

		// quantidade de comandos de ubiApp
		int amountUbiApp = ubiApps.size();

		// quantidade de ubiApps
		int amountUbiAppAL = ubiAppAL.size();

		for (int indexScUbiApp = 0; indexScUbiApp < amountUbiApp; indexScUbiApp++) {
			for (int indexUbiAppAL = 0; indexUbiAppAL < amountUbiAppAL; indexUbiAppAL++) {
				// identifica o comando de ubiApp
				if (ubiApps.get(indexScUbiApp).getUbiAppType()
						.equals(ubiAppAL.get(indexUbiAppAL))) {
					// retorna coamndo de UbiApp identificado
					return ubiApps.get(indexScUbiApp);
				}
			}
		}

		return null;

	} // fim do metodo de matchingUbiApp

}
