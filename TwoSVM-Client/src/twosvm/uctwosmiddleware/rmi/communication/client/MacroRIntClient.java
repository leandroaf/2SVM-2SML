package twosvm.uctwosmiddleware.rmi.communication.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import twosvm.model.applications.interf.UbiquitousApplicationInterface;

public interface MacroRIntClient extends Remote {

	public void sendApplication(UbiquitousApplicationInterface tEditor)
			throws RemoteException;

}
