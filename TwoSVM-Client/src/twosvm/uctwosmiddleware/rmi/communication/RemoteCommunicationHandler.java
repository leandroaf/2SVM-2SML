package twosvm.uctwosmiddleware.rmi.communication;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteCommunicationHandler {
	
	public static void main(String [] args) throws RemoteException, AlreadyBoundException{
	    
		RemoteCommunicationImplement impl = new RemoteCommunicationImplement();
	    Registry registry = LocateRegistry.createRegistry(1099); 
	    
		registry.bind(RemoteCommunicationConstant.RMI_ID, (Remote) impl );
		
	}

}
