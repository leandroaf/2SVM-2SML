package twosvm.twosbroker.manager;

import java.io.IOException;

import twosvm.model.applications.ApplicationState;
import twosvm.model.applications.interf.UbiquitousApplicationInterface;
import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.uctwosmiddleware.localeventhandler.LocalEventHandler;

public class TwosBrokerFacade {

	private static TwosBrokerFacade instance = null;

	TwosBrokerManager twosBrokerManager = new TwosBrokerManager();
	LocalEventHandler localEventHandler = new LocalEventHandler();

	/**
	 * Construtor
	 */
	public TwosBrokerFacade() {
	}

	/**
	 * 
	 * @return
	 */
	public synchronized static TwosBrokerFacade getInstance() {
		if (instance == null) {
			instance = new TwosBrokerFacade();
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
		return twosBrokerManager
				.executeCommandStartApplication(applicationType);
	}

	/**
	 * Inicia Application Manager
	 */
	public void startApplicationManager() {
		twosBrokerManager.startApplicationManager();
	} // fim do metodo startApplicationManager

	/**
	 * Metodo para identificar tipo do evento local ocorrido
	 * 
	 * @param contextChange
	 * @throws Exception
	 */
	public void sendEvent(ContextChange contextChange) throws Exception {
		localEventHandler.sendEvent(contextChange);
	} // fim do metodo sendEvent

	/**
	 * 
	 * @param smartObjectMacro
	 * @throws IOException
	 */
	public void sendMacroSO(SmartObjectMacro smartObjectMacro)
			throws IOException {
		twosBrokerManager.sendMacroSO(smartObjectMacro);
	} // fim do metodo sendMacroSO

	/**
	 * 
	 * @param userMacro
	 * @throws IOException
	 */
	public void sendMacroUR(UserMacro userMacro) throws IOException {
		twosBrokerManager.sendMacroUR(userMacro);
	} // fim do metodo sendMacroUR

	/**
	 * 
	 * @param applicationMacro
	 * @param appName
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void sendMacroUA(ApplicationMacro applicationMacro, String applicationType)
			throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		twosBrokerManager.sendMacroUA(applicationMacro, applicationType);
	} // fim do metodo sendMacroUA

	/**
	 * 
	 * @param applicationMacro
	 * @param applicationState
	 */
	public void sendMacroUAAppState(ApplicationMacro applicationMacro,
			ApplicationState applicationState, String appType) {
		twosBrokerManager.sendMacroUAAppState(applicationMacro,
				applicationState, appType);
	} // fim do metodo sendMacroUAAppState
	
	/**
	 * 
	 * @param applicationMacro
	 * @return
	 */
	public ApplicationState getApplicationState(
			ApplicationMacro applicationMacro) {
		return twosBrokerManager.getApplicationState(applicationMacro);
	} // fim do metodo getApplicastionState
	
	/**
	 * 
	 * @param contextChange
	 */
	public void startApplicationInDevice(ContextChange contextChange) {
		try {
			localEventHandler.sendEvent(contextChange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // fim de startApplicationInDevice

}
