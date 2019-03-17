package twosvm.uctwosmiddleware.modelinterpreter;

import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

import twosvm.model.behavioralpolicy.BehAction;
import twosvm.model.behavioralpolicy.BehCondition;
import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.contextchange.ContextChangeGroovy;
import twosvm.model.instance.resource.Resource;
import twosvm.model.instance.user.User;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.macro.reader.MacroReader;
import twosvm.model.models.ModelRecorder;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.UserMRT;
import twosvm.model.mrt.recorder.MrtRecorder;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;
import twosvm.uctwosmiddleware.modelinterpreter.ModelInterpreter;
import twosvm.uctwosmiddleware.modelmanager.ModelManager;
import twosvm.uctwosmiddleware.rmi.communication.RemoteCommunication;

public class ModelInterpreter {

	private static ModelInterpreter instance = null;

	ModelRecorder modelRecorder;

	MrtRecorder mrtRecorder = new MrtRecorder();
	RemoteCommunication remoteCommunication = new RemoteCommunication();

	ModelManager modelManager = new ModelManager();

	/**
	 * Construtor
	 */
	public ModelInterpreter() {
	}

	/**
	 * 
	 * @return
	 */
	public static ModelInterpreter getInstance() {
		if (instance == null) {
			instance = new ModelInterpreter();
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
	 * Metodo para tratar mudancas de contexto no SS
	 * 
	 * @param cChange
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void contextChange(ContextChange contChange) throws RemoteException,
			NotBoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		ContextChangeGroovy conGroovy;
		ContextChange contextChange = new ContextChange();
		contextChange = contChange;

		// variavel para auxiliar na validacao da condicao
		String result = new String();

		BehCondition behCondition;

		// Lista de elementos do modelo, do tipo BehPolicy
		ArrayList<BehPolicy> behPolicyAL = new ArrayList<BehPolicy>();

		// Lista de politicas
		behPolicyAL = modelManager.getBehPoliciesModels();

		// recebe lista de modelos do tipo BehaviourPolicy
		// bPolModelDescriptionAL =
		// modelList.listModelElementsBehPol(modelListAL);

		// objeto BehaviourPolicy
		BehPolicy behPolicy = new BehPolicy();

		// Politica selecionada
		BehPolicy selectedBehPolicy = new BehPolicy();

		// Verifica se existe algum modelo de politicas comportamentais para o
		// evento detectado

		// quantidade de politicas comportamentais
		int amountBehPol = behPolicyAL.size();

		// Avaliacao da politica
		for (int indexBPolModelList = 0; indexBPolModelList < amountBehPol; indexBPolModelList++) {

			// verifica cada uma das politicas, a partir dos modelos instalados
			// na camada de middleware
			behPolicy = behPolicyAL.get(indexBPolModelList);

			// verifica quantidade de eventos e percorre cada uma deles para
			// verificar se ha uma politica para ele
			int amountBehEvent = behPolicy.getBehEventAL().size();
			for (int indexBehEvent = 0; indexBehEvent < amountBehEvent; indexBehEvent++) {
				// busca por script da politica, relacionada a mudanca de
				// contexto
				if (behPolicy.getBehEventAL().get(indexBehEvent).getEventName()
						.equals(contextChange.getEventName())) {

					// condicao
					behCondition = new BehCondition();
					behCondition = behPolicy.getBehCondition();

					// avalia condicao
					conGroovy = new ContextChangeGroovy();
					String condition = behCondition.getDescription();
					result = conGroovy.interpreterCtx(contextChange, condition);

					selectedBehPolicy = behPolicy;

				} // fim do if
			} // fim do for que verifica quantidade de eventos

		} // fim do for que avalia a politica

		// verifica se o resultado da avaliacao das condicoes foi verdadeiro
		// para executar acao
		if (result.equals("true")) {

			ArrayList<BehAction> behActions = selectedBehPolicy
					.getBehActionAL();
			// Executar acao
			// Cria macro
			ApplicationMacro applicationMacro;
			ApplicationMRT applicationMRT;
			int amountBehAction = behActions.size();
			for (int indexBehAct = 0; indexBehAct < amountBehAction; indexBehAct++) {
				BehAction behAction = behActions.get(indexBehAct);
				// verificar o tipo de acao e selecionar a macro adequada para
				// ser executada
				String actionDescription = behAction.getDescription();
				switch (behAction.getActionName()) {
				case ("moveApplication"):
					System.out.println("Movendo aplicacao ubiqua...");
					String appType = actionDescription.substring(1,
							actionDescription.indexOf(","));
					String devType = actionDescription.substring(
							actionDescription.indexOf(",") + 1,
							actionDescription.indexOf(")"));
					// substitui espacos em branco
					appType = appType.replaceAll(" ", "");
					devType = devType.replaceAll(" ", "");

					// checar o M@RT dos dois dispositivos
					// verificar se o outro dispositivo nao esta ocupado
					// le M@RT de devices
					// acessa M@RT de usuario
					ModelManager modelManager = new ModelManager();

					// Obtem as macros do repositorio de macros
					MacroReader macroReader;

					// le M@RT de smart object
					ArrayList<SmartObjectMRT> smartObjectMRTs = new ArrayList<SmartObjectMRT>();
					smartObjectMRTs = modelManager.queryMrtElementSO();

					// verificar se o dispositivo, para o qual o estado da
					// aplicacao sera transferido, esta ocupado
					// se estiver ocupado, nao transferir

					// percorre todos os M@RTs dos dispositivo
					int amountDevMrt = smartObjectMRTs.size();
					for (int index = 0; index < amountDevMrt; index++) {
						// verifica se determinado dispositivo nao esta ocupado
						SmartObjectMRT deviceMRT = smartObjectMRTs.get(index);
						if ((deviceMRT.getSmartObjectType().equals(devType))
								&& (!deviceMRT.isBusy())) {

							String destinationIP;
							String contChangeDestinationIP;

							applicationMRT = new ApplicationMRT();
							// MRT referente a aplicacao que tera seu estado
							// movido
							applicationMRT.setApplicationID(contextChange
									.getUser().applicationID());
							applicationMRT.setApplicationName(contextChange
									.getUser().applicationNameSS());
							applicationMRT.setApplicationType(contextChange
									.getUser().appTypeSS());
							applicationMRT.setActive(true);
							// endereco IP para o qual o estado da aplicacao
							// sera enviado
							contChangeDestinationIP = smartObjectMRTs
									.get(index).getSmartObjectIP();
							applicationMRT.setDeviceIP(contChangeDestinationIP);
							// endereco IP da maquina que sofreu a mudanca de
							// contexto
							destinationIP = contextChange.getUser().deviceIP();
							// M@RT referente ao usuario que passara a utilizar
							// o
							// novo smart object
							UserMRT userMRT = new UserMRT();
							userMRT.setUserType(contextChange.getUser()
									.userTypeSS());
							userMRT.setUserName(contextChange.getUser()
									.userNameSS());
							userMRT.setDeviceType(deviceMRT
									.getSmartObjectType());
							userMRT.setDeviceName(deviceMRT
									.getSmartObjectName());
							userMRT.setDeviceIP(contChangeDestinationIP);
							// Objeto Macro Reader
							macroReader = new MacroReader();
							// macro a ser executada no smart object onde
							// encontra-se a aplicacao
							applicationMacro = new ApplicationMacro();
							applicationMacro = macroReader
									.readApplicationMacro("moveUbiApp");
							// envia M@RT de App para 2SVM-Client do dispositivo
							// de
							// destino
							remoteCommunication.sendLocalMrtUA(applicationMRT);
							// envia M@RT de User para 2SVM-Client do
							// dispositivo de
							// destino
							remoteCommunication.sendLocalMrtUR(userMRT);
							// envia primeira macro para 2SVM-Client com IP de
							// origem da aplicacao
							System.out.println("Conteudo da Macro: "
									+ applicationMacro);
							remoteCommunication.sendMacroUAContextChange(
									applicationMacro, destinationIP,
									contChangeDestinationIP);
							// macro a ser executada no smart object onde a
							// aplicacao sera movida
							applicationMacro = new ApplicationMacro();
							applicationMacro = macroReader
									.readApplicationMacro("sendUbiApp");
							System.out.println("Conteudo da Macro: "
									+ applicationMacro);
							// envia segunda macro para 2SVM-Client com IP
							// de origem da aplicacao
							remoteCommunication.sendMacroUAContextChange(
									applicationMacro, contextChange.getUser()
											.deviceIP(),
									contChangeDestinationIP);
						}
					}
					break;
				case ("startApplication"):
					// Executar acao
					applicationMRT = new ApplicationMRT();
					applicationMRT.setApplicationID(contextChange.getUser()
							.applicationID());

					applicationMRT.setApplicationName(contextChange.getUser()
							.applicationNameSS());
					applicationMRT.setApplicationType(contextChange.getUser()
							.appTypeSS());
					applicationMRT.setActive(true);
					applicationMRT.setDeviceIP(contextChange.getUser()
							.deviceIP());

					// Objeto Macro Reader
					macroReader = new MacroReader();

					// Obtem macro do repositorio
					applicationMacro = new ApplicationMacro();
					applicationMacro = macroReader
							.readApplicationMacro("startUbiApp");
					// envia MRT para 2SVM-Client
					remoteCommunication.sendLocalMrtUA(applicationMRT);
					// envia macro para 2SVM-Client
					remoteCommunication.sendMacroUA(applicationMacro,
							contextChange.getUser().deviceIP());
					break;
				case ("destroyApplication"):
					// Executar acao
					// Cria macro
					applicationMacro = new ApplicationMacro();
					applicationMRT = new ApplicationMRT();
					applicationMRT.setApplicationID(contextChange.getUser()
							.applicationID());

					applicationMRT.setApplicationName(contextChange.getUser()
							.applicationNameSS());
					applicationMRT.setApplicationType(contextChange.getUser()
							.appTypeSS());
					applicationMRT.setActive(true);
					applicationMRT.setDeviceIP(contextChange.getUser()
							.deviceIP());
					// Objeto Macro Reader
					macroReader = new MacroReader();
					applicationMacro = macroReader
							.readApplicationMacro("destroyUbiApp");
					// envia MRT para 2SVM-Client
					remoteCommunication.sendLocalMrtUA(applicationMRT);
					// envia macro para 2SVM-Client
					remoteCommunication.sendMacroUA(applicationMacro,
							contextChange.getUser().deviceIP());
					break;
				default:
					break;
				}

			}

		}

	} // fim do metodo para tratar mudanca de contexto`

	/**
	 * 
	 * @param smartObject
	 * @param resource
	 * @throws NotBoundException
	 * @throws IOExceptionpo
	 */
	public void interpretMrtElementSO(SmartObject smartObject, Resource resource)
			throws NotBoundException, IOException {
		RemoteCommunication remoteCommunication = new RemoteCommunication();

		// Objeto Macro Reader
		MacroReader macroReader = new MacroReader();

		// cria o M@RT para device
		SmartObjectMacro smartObjectMacro = new SmartObjectMacro();
		// alterei para final
		final SmartObjectMRT smartObjectMRT = new SmartObjectMRT();

		smartObjectMRT.setSmartObjectID(Integer.toString(generatorID()));
		smartObjectMRT.setDeviceType(smartObject.getSmartObjectType());

		smartObjectMRT.setSmartObjectName(resource.getResourceName());
		smartObjectMRT.setSmartObjectIP(resource.getResourceIP());
		smartObjectMRT.setFeatureAL(smartObject.getFeatureAL());

		smartObjectMRT.setUserName(resource.getUserName());

		// se tiver usuario associado ao dispositivo, coloca como o dispositivo
		// bloqueado
		if (!resource.getUserName().equals("")) {
			smartObjectMRT.setBusy(true);
		}

		// atualiza o M@RT de Smart Object
		Thread threadName = new Thread() {
			public void run() {
				if (smartObjectMRT != null) {
					modelManager.mrtElementUpdatesSO(smartObjectMRT);

					System.out.println("Tempo ATUALIZAR MRT SO: "+System.currentTimeMillis());
				}
			}
		};
		threadName.setName("threadMrtUpdatesSO");
		threadName.start();

		// Obtem macro do repositorio de macros
		smartObjectMacro = macroReader.readSmartObjectMacro("addSmartObject");

		System.out.println("Tempo SELECIONAR MACRO SO: "+System.currentTimeMillis());

		// envia MRT para 2SVM-Client
		remoteCommunication.sendLocalMrtSO(smartObjectMRT);
		
		// envia macro para 2SVM-Client
		remoteCommunication.sendMacroSO(smartObjectMacro,
				smartObjectMRT.getSmartObjectIP());
		
	} // fim do metodo sendModelSO

	/**
	 * 
	 * @param modelDescriptionUR
	 * @param user
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void interpretMrtElementUR(UserRole userRole, User user)
			throws RemoteException, NotBoundException {
		RemoteCommunication remoteCommunication = new RemoteCommunication();

		// Objeto Macro Reader
		MacroReader macroReader = new MacroReader();

		// cria o M@RT para device
		UserMacro userMacro = new UserMacro();
		UserMRT userMRT = new UserMRT();

		userMRT.setUserID(Integer.toString(generatorID()));
		userMRT.setUserName(user.userNameSS());
		userMRT.setUserType(userRole.getUserRoleType());
		userMRT.setDeviceIP(user.deviceIP());

		// le M@RT de devices
		// acessa M@RT de usuario
		ModelManager modelManager = new ModelManager();

		// le M@RT de device
		ArrayList<SmartObjectMRT> devMRTs = new ArrayList<SmartObjectMRT>();
		devMRTs = modelManager.queryMrtElementSO();

		// adiciona ao M@RT do usuario informacoes relativas ao dispositivo
		int amountDevMrt = devMRTs.size();
		for (int indexDevMrt = 0; indexDevMrt < amountDevMrt; indexDevMrt++) {
			// encontra qual dispositivo pertence a esse usuario
			if (devMRTs.get(indexDevMrt).getUserName()
					.equals(userMRT.getUserName())) {
				userMRT.setDeviceName(devMRTs.get(indexDevMrt)
						.getSmartObjectName());
				userMRT.setDeviceType(devMRTs.get(indexDevMrt)
						.getSmartObjectType());
			}
		}

		// atualiza M@RT User
		modelManager.mrtElementUpdatesUR(userMRT);

		System.out.println("Tempo ATUALIZAR MRT UR: "+System.currentTimeMillis());
		
		// Obtem macro do repositorio de macros
		userMacro = macroReader.readUserMacro("addUser");
		

		System.out.println("Tempo SELECIONAR MACRO UR: "+System.currentTimeMillis());

		// envia MRT para 2SVM-Client
		remoteCommunication.sendLocalMrtUR(userMRT);

		// envia macro para 2SVM-Client
		remoteCommunication.sendMacroUR(userMacro, user.deviceIP());

	} // fim do metodo sendModelUR

	/**
	 * 
	 * @param ubiApps
	 * @param index
	 * @param user
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void interpretMrtElementUA(ArrayList<UbiApp> ubiApps,
			String deviceIP, String userName, int index)
			throws RemoteException, NotBoundException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		// Objeto Macro Reader
		MacroReader macroReader = new MacroReader();

		// cria o M@RT para application
		RemoteCommunication remoteCommunication = new RemoteCommunication();
		ApplicationMacro applicationMacro = new ApplicationMacro();
		ApplicationMRT applicationMRT = new ApplicationMRT();

		applicationMRT.setApplicationID(Integer.toString(generatorID()));

		applicationMRT.setApplicationType(ubiApps.get(index).getUbiAppType());

		applicationMRT.setDeviceIP(deviceIP);

		// salva o M@RT de device localmente
		MrtRecorder mrtRecorder = new MrtRecorder();
		mrtRecorder.recordMrtApp(applicationMRT, userName);

		// Obtem macro do repositorio de macros
		applicationMacro = macroReader.readApplicationMacro("addUbiApp");

		// envia MRT para 2SVM-Client
		remoteCommunication.sendLocalMrtUA(applicationMRT);

		// envia macro para 2SVM-Client
		remoteCommunication.sendMacroUA(applicationMacro,
				applicationMRT.getDeviceIP());

	} // fim do metodo sendModelUA

	/**
	 * Metodo que recebe evento relacionado a inicializacao de uma aplicacao
	 * ubiqua em determinado smart obcjet de usuario
	 * 
	 * @param contextChange
	 */
	public void newUbiApp(ContextChange contextChange) {
		// Atualiza MRT global
		ApplicationMRT applicationMRT = new ApplicationMRT();
		// obtem MRT referente a aplicacao
		applicationMRT = modelManager.queryMrtElementUA(contextChange.getUser()
				.appTypeSS());
		applicationMRT.setApplicationName(contextChange.getUser()
				.applicationNameSS());
		modelManager.mrtElementUpdatesUA(applicationMRT, contextChange
				.getUser().userNameSS());

		// envia macro para 2SVM-Client iniciar a aplicacao
		MacroReader macroReader = new MacroReader();

		// cria o M@RT para application
		RemoteCommunication remoteCommunication = new RemoteCommunication();
		ApplicationMacro applicationMacro = new ApplicationMacro();

		// Obtem macro do repositorio de macros
		applicationMacro = macroReader.readApplicationMacro("startUbiApp");

		// envia macro para 2SVM-Client
		try {
			remoteCommunication.sendMacroUA(applicationMacro, contextChange
					.getUser().deviceIP());
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // fim do metodo newUbiApp

	/**
	 * Metodo para remover comandos e MRTs
	 * 
	 * @param path
	 */
	public void removeModel(String path) {
		File file = null;
		boolean bool = false;
		try {
			// create new file
			file = new File(path);
			// tries to delete a non-existing file
			bool = file.delete();
			// creates file in the system
			file.createNewFile();
			// tries to delete the newly created file
			bool = file.delete();
		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	} // fim do metodo removeModel

}
