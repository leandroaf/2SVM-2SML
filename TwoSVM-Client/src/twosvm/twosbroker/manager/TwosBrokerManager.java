package twosvm.twosbroker.manager;

import java.io.IOException;
import java.util.ArrayList;

import twosvm.model.applications.ApplicationState;
import twosvm.model.applications.interf.UbiquitousApplicationInterface;
import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.twosbroker.applicationmanager.ApplicationManager;
import twosvm.twosbroker.devicemanager.deviceinstance.DeviceInstance;
import twosvm.twosbroker.usermanager.UserManager;
import twosvm.uctwosmiddleware.localmodelmanager.LocalModelManager;

public class TwosBrokerManager {

	private static TwosBrokerManager instance = null;

	UserManager userManager = new UserManager();
	DeviceInstance deviceInstance = new DeviceInstance();
	ApplicationManager applicationManager = new ApplicationManager();

	ApplicationState applicationState = new ApplicationState();

	UbiquitousApplicationInterface ubiquitousApplicationInterface = null;

	/**
	 * Construtor
	 */
	public TwosBrokerManager() {
	}

	/**
	 * 
	 * @return
	 */
	public synchronized static TwosBrokerManager getInstance() {
		if (instance == null) {
			instance = new TwosBrokerManager();
		}
		return instance;
	}

	/**
	 * 
	 * @param applicationType
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public UbiquitousApplicationInterface executeCommandStartApplication(
			String applicationType) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		return applicationManager.executeStartApplication(applicationType);
	}

	/**
	 * Inicia Application Manager
	 */
	public void startApplicationManager() {
		applicationManager.startApplicationManager();
	} // fim do metodo startApplicationManager

	/**
	 * Encaminha evento de mudanca de contexto para TwosBrokerFacade
	 * 
	 * @param contextChange
	 * @throws Exception
	 */
	public void sendEvent(ContextChange contextChange) throws Exception {
		TwosBrokerFacade twosBrokerFacade = new TwosBrokerFacade();
		twosBrokerFacade.sendEvent(contextChange);
	} // fim do metodo sendEvent

	/**
	 * 
	 * @param smartObjectMacro
	 * @throws IOException
	 */
	public void sendMacroSO(SmartObjectMacro smartObjectMacro)
			throws IOException {
		ArrayList<String> commandAL = new ArrayList<String>();
		DeviceInstance deviceInformation = new DeviceInstance();
		LocalModelManager localModelManager = new LocalModelManager();

		// obter informacoes de smartObjectMRT
		SmartObjectMRT smartObjectMRT = new SmartObjectMRT();

		commandAL = smartObjectMacro.getCommandAL();

		int amountCom = commandAL.size();
		for (int indexCom = 0; indexCom < amountCom; indexCom++) {
			switch (commandAL.get(indexCom)) {
			case "startListenerSmartObject":
				System.out.println("Iniciando listeners do smart object...");
				deviceInformation.startListeners();
				break;
			case "activeSmartObject":
				System.out
						.println("Smart Object ativo no espaco inteligente...");
				smartObjectMRT = localModelManager.queryMrtElementSO();
				deviceInformation.activateSmartObject(smartObjectMRT);
				break;
			default:
				break;
			}
		}

	} // fim do metodo sendMacroSO

	/**
	 * 
	 * @param userMacro
	 * @throws IOException
	 */
	public void sendMacroUR(UserMacro userMacro) throws IOException {
		ArrayList<String> commandAL = new ArrayList<String>();

		commandAL = userMacro.getCommandAL();

		int amountCom = commandAL.size();
		for (int indexCom = 0; indexCom < amountCom; indexCom++) {
			switch (commandAL.get(indexCom)) {
			// colocar comandos da macro de User
			case "activeUser":
				// TODO
				break;
			default:
				break;
			}
		}

	} // fim do metodo sendMacroUR

	/**
	 * 
	 * @param applicationMacro
	 * @param appType
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void sendMacroUA(ApplicationMacro applicationMacro,
			String applicationType) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		ArrayList<String> commandAL = new ArrayList<String>();
		commandAL = applicationMacro.getCommandAL();
	
		System.out
				.println("\nMacro selecionada: " + applicationMacro.getName());
		System.out.println("Comandos da macro: " + commandAL.toString());

		// se a macro selecionada for moveUbiApp, executar no dispositivo local
		// caso contrario, enviar para o dispositivo remoto
		int amountCom = commandAL.size();
		for (int indexCom = 0; indexCom < amountCom; indexCom++) {
			switch (commandAL.get(indexCom)) {
			case "activeUbiApp":
				System.out.println("Aplicacao ativa no smart object!");
				// TODO
				break;
			case "startListenerApp":
				System.out
						.println("Iniciando listener relacionado a eventos de inicializacao de aplicacoes ubiquas...");
				applicationManager.startApplicationManager();
				break;
			case "startApp":
				System.out.println("Aplicacao iniciada!");
				ubiquitousApplicationInterface = executeCommandStartApplication(applicationType);
				break;
			case "pauseApp":
				System.out.println("Aplicacao pausada!");
				// ubiquitousApplicationInterface.pauseApplication();
				break;
			case "saveAppState":
				System.out.println("Estado da aplicacao salvo!");
				applicationState = ubiquitousApplicationInterface
						.saveApplicationState();
				break;
			case "destroyApp":
				System.out.println("Aplicacao finalizada!");
				ubiquitousApplicationInterface = null;
				//ubiquitousApplicationInterface.destroyApplication();
				break;
			case "notifyUser":
				System.out.println("Notificacao enviada para usuario!");
				ubiquitousApplicationInterface.notifyUser();
				break;
			case "restoreAppState":
				System.out.println("Restaurando estado da aplicacao!");
				ubiquitousApplicationInterface
						.restoreApplicationState(applicationState);
				break;
			default:
				break;
			}
		}

	} // fim de sendMacroUA

	/**
	 * 
	 * @param applicationMacro
	 * @return
	 */
	public ApplicationState getApplicationState(
			ApplicationMacro applicationMacro) {

		ArrayList<String> commandAL = new ArrayList<String>();
		commandAL = applicationMacro.getCommandAL();

		System.out
				.println("\nMacro selecionada: " + applicationMacro.getName());
		System.out.println("Comandos da macro: " + commandAL.toString());
		// se a macro selecionada for moveUbiApp, executar no dispositivo local
		// caso contrario, enviar para o dispositivo remoto
		int amountCom = commandAL.size();
		for (int indexCom = 0; indexCom < amountCom; indexCom++) {
			switch (commandAL.get(indexCom)) {
			case "saveAppState":
				System.out.println("Estado da aplicacao salvo!");
				applicationState = ubiquitousApplicationInterface
						.saveApplicationState();
				break;
			case "destroyApp":
				System.out.println("Aplicacao finalizada!");
				// ubiquitousApplicationInterface.destroyApplication();
				break;
			}
		}
		return applicationState;
	} // fim do metodo getApplicationState
	
	/**
	 * 
	 * @param applicationMacro
	 * @param applicationState
	 */
	public void sendMacroUAAppState(ApplicationMacro applicationMacro,
			ApplicationState appState, String appType) {
		
		applicationState = appState;
		
		ArrayList<String> commandAL = new ArrayList<String>();

		commandAL = applicationMacro.getCommandAL();

		System.out.println("\nMacro selecionada: " + applicationMacro.getName());
		System.out.println("Comandos da macro: " + commandAL.toString());

		// se a macro selecionada for moveUbiApp, executar no dispositivo local
		// caso contrario, enviar para o dispositivo remoto
		int amountCom = commandAL.size();
		for (int indexCom = 0; indexCom < amountCom; indexCom++) {
			switch (commandAL.get(indexCom)) {
			case "restoreAppState":
				System.out.println("Restaurando o estado da aplicacao!");
				try {
					ubiquitousApplicationInterface = executeCommandStartApplication(appType);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException e) {
					e.printStackTrace();
				}
				ubiquitousApplicationInterface.restoreApplicationState(applicationState);
				break;
			case "resumeApp":
				System.out.println("Resumindo aplicacao!");
				ubiquitousApplicationInterface.resumeApplication();
			default:
				break;
			}
		}
		
	} // fim do metodo sendMacroUAAppState

	/**
	 * 
	 * @param contextChange
	 */
	public void startApplicationInDevice(ContextChange contextChange) {
		TwosBrokerFacade twosBrokerFacade = new TwosBrokerFacade();
		twosBrokerFacade.startApplicationInDevice(contextChange);
	} // fim de startApplicationInDevice

}
