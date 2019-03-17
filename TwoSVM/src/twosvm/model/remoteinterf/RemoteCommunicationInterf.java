package twosvm.model.remoteinterf;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import twosvm.model.applications.ApplicationState;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.ServiceMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.ServiceMRT;
import twosvm.model.mrt.UserMRT;

public interface RemoteCommunicationInterf extends Remote {

	public void sendMacroSO(SmartObjectMacro smartObjectMacro)
			throws RemoteException;

	public void sendLocalMrtSO(SmartObjectMRT smartObjectMRT)
			throws RemoteException;

	public void sendMacroUR(UserMacro userMacro) throws RemoteException,
			IOException;

	public void sendLocalMrtUR(UserMRT userMRT) throws RemoteException;

	public void sendMacroUA(ApplicationMacro appMacro) throws RemoteException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException;

	public void sendMacroUAContextChange(ApplicationMacro applicationMacro, String destinationIP,
			String contChangeDestinationIP) throws RemoteException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException;
	
	public void sendMacroUAAppState(final ApplicationMacro appMacro,
			final String destinationIP, final ApplicationState applicationState) throws RemoteException;

	public void sendLocalMrtUA(ApplicationMRT appMRT) throws RemoteException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException;

	public void sendMacroSer(ServiceMacro serviceMacro) throws RemoteException;

	public void sendLocalMrtSer(ServiceMRT serviceMRT) throws RemoteException;

}
