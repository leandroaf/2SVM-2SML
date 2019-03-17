package twosvm.testing;

import java.net.UnknownHostException;
import java.rmi.RemoteException;

import twosvm.uctwosmiddleware.manager.UcTwosMiddlewareFacade;

public class StartTwoSvmController {

	public static void main(String args[]) throws UnknownHostException,
			RemoteException {

		System.out.println("|------- 2SVM-Controller Iniciada ------|");

		UcTwosMiddlewareFacade ucTwosMiddlewareFacade = new UcTwosMiddlewareFacade();
		ucTwosMiddlewareFacade.startMiddlewareLayer();
		
	}

}
