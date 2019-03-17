package twosvm.uctwosmiddleware.rmi.commands;

import java.rmi.Remote;
import java.rmi.RemoteException;

import twosvm.model.behavioralpolicy.BehAction;

public interface CommandRemoteInterf extends Remote {

	public void runRemoteCommand(BehAction behAction)
			throws RemoteException;

}
