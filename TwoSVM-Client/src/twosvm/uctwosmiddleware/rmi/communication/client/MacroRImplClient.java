package twosvm.uctwosmiddleware.rmi.communication.client;

import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import twosvm.model.applications.interf.UbiquitousApplicationInterface;

public class MacroRImplClient extends UnicastRemoteObject implements
		MacroRIntClient {

	ObjectOutputStream obStream;

	protected MacroRImplClient() throws RemoteException {
		super();
	}

	@Override
	public void sendApplication(UbiquitousApplicationInterface uInterface) {
		System.out.println("Aplicacao recebida de outro dispositivo!");
		
		// TODO ARRUMAR ISSO!!!!!!!!
		
		//uInterface.restoreApplicationState();

	}

}
