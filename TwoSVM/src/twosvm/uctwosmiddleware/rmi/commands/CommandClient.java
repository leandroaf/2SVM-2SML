package twosvm.uctwosmiddleware.rmi.commands;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import twosvm.model.behavioralpolicy.BehAction;

public class CommandClient {

	public void sendCommand(BehAction behAction) throws RemoteException, NotBoundException {
		
		Registry registry  = LocateRegistry.getRegistry("localhost",CommandConstant.RMI_PORT);
		
		final CommandRemoteInterf remote = (CommandRemoteInterf) registry.lookup(CommandConstant.RMI_ID);      
        
        remote.runRemoteCommand(behAction);
        
	}
	
}
