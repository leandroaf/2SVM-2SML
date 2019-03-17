package twosvm.uctwosmiddleware.manager;

import java.io.IOException;
import java.rmi.RemoteException;

import twosvm.model.macro.ApplicationMacro;
import twosvm.model.models.ModelDescriptionBehEve;
import twosvm.model.models.ModelDescriptionBehPol;
import twosvm.model.models.ModelDescriptionSO;
import twosvm.model.models.ModelDescriptionSer;
import twosvm.model.models.ModelDescriptionUA;
import twosvm.model.models.ModelDescriptionUR;
import twosvm.model.models.ModelDescriptionURoAssociateToSOb;

public class UcTwosMiddlewareFacade {

	private static UcTwosMiddlewareFacade instance = null;

	UcTwosMiddlewareManager ucTwosMiddlewareManager = new UcTwosMiddlewareManager();

	/**
	 * Construtor
	 */
	public UcTwosMiddlewareFacade() {
	}

	/**
	 * 
	 * @return
	 */
	public static UcTwosMiddlewareFacade getInstance() {
		if (instance == null) {
			instance = new UcTwosMiddlewareFacade();
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
		ucTwosMiddlewareManager.interpreterAppMacro(applicationMacro);
	} // fim do metodo sendRemoteSerMacro
	
}
