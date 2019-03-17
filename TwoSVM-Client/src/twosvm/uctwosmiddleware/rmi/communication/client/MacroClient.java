package twosvm.uctwosmiddleware.rmi.communication.client;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MacroClient {

	public static void main(String [] args) throws RemoteException, AlreadyBoundException{
	    
	    MacroRImplClient impl = new MacroRImplClient();
	    Registry registry = LocateRegistry.createRegistry(MacroConstantClient.RMI_PORT); 
		registry.bind(MacroConstantClient.RMI_ID, impl );
	  
		System.out.println("Esperando macros...");
		
	}
}
