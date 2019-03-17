package twosvm.uctwosmiddleware.localmodelinterpreter;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.UserMRT;
import twosvm.model.applications.ApplicationState;
import twosvm.model.applications.interf.UbiquitousApplicationInterface;
import twosvm.twosbroker.manager.TwosBrokerFacade;
import twosvm.uctwosmiddleware.localeventhandler.contextchange.ContextChangePub;
import twosvm.uctwosmiddleware.localmodelmanager.LocalModelManager;
import twosvm.uctwosmiddleware.rmi.communication.RemoteCommunication;
import twosvm.uctwosmiddleware.rmi.communication.client.MacroConstantClient;
import twosvm.uctwosmiddleware.rmi.communication.client.MacroRIntClient;

public class LocalModelInterpreter {

	private static LocalModelInterpreter instance = null;

	UbiquitousApplicationInterface ubiquitousApplicationInterface = null;

	ApplicationMRT applicationMRT = new ApplicationMRT();
	TwosBrokerFacade twosBrokerFacade = new TwosBrokerFacade();
	ContextChangePub contextChangePub = new ContextChangePub();
	ApplicationState applicationState = new ApplicationState();
	RemoteCommunication remoteCommunication = new RemoteCommunication();

	/**
	 * Construtor
	 * 
	 * @throws Exception
	 */
	public LocalModelInterpreter() {
	}

	/**
	 * Construtor
	 * 
	 * @throws Exception
	 */
	public LocalModelInterpreter(String name) {
	}

	/**
	 * Construtor
	 * 
	 * @return
	 */
	public synchronized static LocalModelInterpreter getInstance() {
		if (instance == null) {
			instance = new LocalModelInterpreter("");
		}
		return instance;
	}

	/**
	 * Metodo para tratar mudanca de contexto. Este metodo tem por objetivo
	 * enriquecer o evento e enviar para o Controlador do espaco inteligente
	 * Para fazer isso, ele recebe o evento, e acessa o M@RT local para
	 * enriquece-lo com as demais informacoes
	 * 
	 * @param cChange
	 */
	public ContextChange enrichingEvent(ContextChange cChange) {

		// Atributos de ContextChange
		ContextChange contextChange = new ContextChange();
		contextChange = cChange;

		User user = new User();
		user = contextChange.getUser();

		// acessa M@RT
		LocalModelManager localModelManager = new LocalModelManager();

		// le M@RT de user
		UserMRT userMRT = new UserMRT();
		userMRT = localModelManager.queryMrtElementUR();

		user.setUserID(userMRT.getUserID());
		user.setUserName(userMRT.getUserName());
		user.setUserType(userMRT.getUserType());

		user.setUserLocation(contextChange.getUser().userLocationSS());

		// le M@RT de device
		SmartObjectMRT smartObjectMRT = new SmartObjectMRT();
		smartObjectMRT = localModelManager.queryMrtElementSO();

		user.setDeviceID(smartObjectMRT.getSmartObjectID());
		user.setDeviceName(smartObjectMRT.getSmartObjectName());
		user.setDeviceType(smartObjectMRT.getSmartObjectType());
		user.setDeviceIP(smartObjectMRT.getSmartObjectIP());

		// le M@RT de application
		ArrayList<ApplicationMRT> applicationMRTs = new ArrayList<ApplicationMRT>();
		applicationMRTs = localModelManager.queryMrtElementUA();

		// Identifica todas as aplicacoes em execucao
		int amountApp = applicationMRTs.size();
		for (int index = 0; index < amountApp; index++) {
			// Obtem as informacoes relativas a aplicacao ativa, ou seja, em
			// execucao
			if (applicationMRTs.get(index).isActive()) {
				user.setAppID(applicationMRTs.get(index).getApplicationID());
				user.setAppName(applicationMRTs.get(index).getApplicationName());
				user.setAppType(applicationMRTs.get(index).getApplicationType());
			}
		}

		// context change
		contextChange.setEventName(cChange.getEventName());
		contextChange.setUser(user);

		// executa Pub de Middleware
		return contextChange;

	} // fim do metodo para tratar mudanca de contexto

	/**
	 * 
	 * @param smartObjectMacro
	 * @throws IOException
	 */
	public void sendMacroSO(SmartObjectMacro smartObjectMacro)
			throws IOException {
		// interpreta deviceMacro
		twosBrokerFacade.sendMacroSO(smartObjectMacro);
	} // fim do metodo sendMacroSO

	/**
	 * Metodo para atualizar modelo em tempo de execucao local
	 * 
	 * @param smartObjectMRT
	 */
	public void sendLocalMrtSO(SmartObjectMRT smartObjectMRT) {
		// envia para componente Local Model Manager atualizar
		// o MRT
		LocalModelManager localModelManager = new LocalModelManager();
		localModelManager.mrtElementUpdatesSO(smartObjectMRT);
	} // fim do metodo sendLocalMrtSO

	/**
	 * 
	 * @param userMacro
	 * @throws IOException
	 */
	public void sendMacroUR(UserMacro userMacro) throws IOException {
		twosBrokerFacade.sendMacroUR(userMacro);
	} // fim do metodo sendMacroUR

	/**
	 * 
	 * @param userMRT
	 */
	public void sendLocalMrtUR(UserMRT userMRT) {
		// envia para componente Local Model Manager atualizar
		// o MRT
		LocalModelManager localModelManager = new LocalModelManager();
		localModelManager.mrtElementUpdatesUR(userMRT);
	} // fim do metodo sendLocalMrtUR

	/**
	 * Metodo que recebe macros relacionadas a funcionalidades basicas da
	 * aplicacao, tais como, iniciar listener, iniciar aplicacao, entre outros
	 * 
	 * @param appMacro
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void sendMacroUA(ApplicationMacro appMacro)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NotBoundException, InterruptedException,
			IOException {
		// interpreta appMacro
		String applicationType = applicationMRT.getApplicationType();
		interpretMacroUA(appMacro, applicationType);
	} // fim do metodo interpreterUserMacro

	/**
	 * Metodo que recebe macros relacionadas a mudancas de contexto no ambiente
	 * que envolvem a aplicacao ubiqua
	 * 
	 * @param appMacro
	 * @param destinationIP
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void sendMacroUAContextChange(ApplicationMacro applicationMacro,
			String destinationIP, String contChangeDestinationIP)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NotBoundException, InterruptedException,
			IOException {
		// interpreta appMacro para mudancas de contexto
		interpretMacroUAContextChange(applicationMacro, destinationIP,
				contChangeDestinationIP);
	} // fim do metodo interpreterUserMacro

	/**
	 * Metodo que recebe a macro e o estado da aplicacao movida de outro smart
	 * object
	 * 
	 * @param applicationMacro
	 * @param applicationState
	 */
	public void sendMacroUAAppState(ApplicationMacro applicationMacro,
			ApplicationState applicationState) {
		String appType = applicationMRT.getApplicationType();
		interpretMacroUAAppState(applicationMacro, applicationState, appType);
	} // fim do metodo sendMacroUAAppState

	/**
	 * Metodo para atualizar modelo em tempo de execucao de UbiApp
	 * 
	 * @param appMRT
	 */
	public void sendLocalMrtUA(ApplicationMRT appMRT) {
		LocalModelManager localModelManager = new LocalModelManager();
		localModelManager.mrtElementUpdatesUA(appMRT);
		this.applicationMRT = appMRT;
	} // fim do metodo sendLocalMrtUA

	/**
	 * Interpretador da macro
	 * 
	 * @param appMacro
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void interpretMacroUA(ApplicationMacro applicationMacro,
			String applicationType) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, NotBoundException,
			InterruptedException, IOException {
		twosBrokerFacade.sendMacroUA(applicationMacro, applicationType);
	} // fim do metodo interpreterComDevMacro

	/**
	 * 
	 * @param applicationMacro
	 * @param destinationIP
	 * @param contChangeDestinationIP
	 */
	public void interpretMacroUAContextChange(
			ApplicationMacro applicationMacro, String destinationIP,
			String contChangeDestinationIP) {
		switch (applicationMacro.getName()) {
		case "moveUbiApp":
			applicationState = twosBrokerFacade
					.getApplicationState(applicationMacro);
			break;
		case "sendUbiApp":
			// envia para dispositivo no qual o estado da aplicacao sera movido
			try {
				remoteCommunication.sendMacroUAAppState(applicationMacro,
						contChangeDestinationIP, applicationState);
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	} // fim do metodo interpretMacroUAContextChange

	/**
	 * Metodo que interpreta a macro e inicia a aplicacao com seu estado
	 * anterior vindo de outro smart object
	 * 
	 * @param applicationMacro
	 * @param applicationState
	 */
	public void interpretMacroUAAppState(ApplicationMacro applicationMacro,
			ApplicationState applicationState, String appType) {
		twosBrokerFacade.sendMacroUAAppState(applicationMacro,
				applicationState, appType);
	} // fim do metodo interpretMacroUAAppState

}
