package twosvm.uctwosmiddleware.manager;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.resource.Resource;
import twosvm.model.instance.user.User;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.models.ModelDescriptionBehEve;
import twosvm.model.models.ModelDescriptionBehPol;
import twosvm.model.models.ModelDescriptionSO;
import twosvm.model.models.ModelDescriptionSer;
import twosvm.model.models.ModelDescriptionUA;
import twosvm.model.models.ModelDescriptionUR;
import twosvm.model.models.ModelDescriptionURoAssociateToSOb;
import twosvm.twosbroker.startmachine.StartMachine;
import twosvm.uctwosmiddleware.localmodelinterpreter.LocalModelInterpreter;

public class UcTwosMiddlewareManager {
	
	private static UcTwosMiddlewareManager instance = null;

	LocalModelInterpreter modelInterpreter = LocalModelInterpreter.getInstance();
	StartMachine virtualMachineManager = new StartMachine();
	
	/**
	 * Construtor
	 */
	public UcTwosMiddlewareManager() {
	}
	
	/**
	 * 
	 * @return
	 */
	public static UcTwosMiddlewareManager getInstance() {
		if (instance == null) {
			instance = new UcTwosMiddlewareManager();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param applicationMacro
	 * @throws RemoteException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void interpreterAppMacro(ApplicationMacro applicationMacro)
			throws RemoteException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		try {
			try {
				modelInterpreter.sendMacroUA(applicationMacro);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NotBoundException | InterruptedException e) {
			e.printStackTrace();
		}
	} // fim do metodo interpreterAppMacro
	


}
