package twosvm.uctwosmiddleware.rmi.communication;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import twosvm.model.applications.ApplicationState;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.ServiceMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.UserMRT;
import twosvm.model.remoteinterf.RemoteCommunicationInterf;

public class RemoteCommunication {

	/**
	 * 
	 * @param smartObjectMacro
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void sendMacroSO(SmartObjectMacro smartObjectMacro, String ipAddress)
			throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(ipAddress, 1099);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		remote.sendMacroSO(smartObjectMacro);

	} // fim do metodo sendMacroSO

	/**
	 * 
	 * @param smartObjectMRT
	 * @param smartObjectIP
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void sendLocalMrtSO(SmartObjectMRT smartObjectMRT)
			throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(
				smartObjectMRT.getSmartObjectIP(), 1099);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		remote.sendLocalMrtSO(smartObjectMRT);

	} // fim do metodo sendLocalMrtSO

	/**
	 * 
	 * @param userMacro
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void sendMacroUR(UserMacro userMacro, String ipAddress)
			throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(ipAddress,
				RemoteCommunicationConstant.RMI_PORT);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		try {
			remote.sendMacroUR(userMacro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param userMRT
	 * @param deviceIP
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void sendLocalMrtUR(UserMRT userMRT) throws RemoteException,
			NotBoundException {

		Registry registry = LocateRegistry.getRegistry(userMRT.getDeviceIP(),
				RemoteCommunicationConstant.RMI_PORT);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		remote.sendLocalMrtUR(userMRT);

	} // fim do metodo sendLocalMrtUR

	/**
	 * 
	 * @param appMacro
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void sendMacroUA(final ApplicationMacro appMacro, String ipAddress)
			throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(ipAddress,
				RemoteCommunicationConstant.RMI_PORT);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		Thread tName = new Thread() {
			public void run() {
				try {
					remote.sendMacroUA(appMacro);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		tName.setName("threadSendUA");
		tName.start();

	} // fim do metodo sendMacroUA

	/**
	 * 
	 * @param appMacro
	 * @param ipAddress
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void sendMacroUAContextChange(final ApplicationMacro appMacro,
			final String destinationIP, final String contChangeDestinationIP)
			throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(destinationIP,
				RemoteCommunicationConstant.RMI_PORT);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		Thread tName = new Thread() {
			public void run() {
				try {
					remote.sendMacroUAContextChange(appMacro, destinationIP,
							contChangeDestinationIP);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		tName.setName("threadSendUACC");
		tName.start();

	} // fim do metodo sendMacroUAContextChange

	public void sendMacroUAAppState(final ApplicationMacro appMacro,
			final String destinationIP, final ApplicationState applicationState)
			throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(destinationIP,
				RemoteCommunicationConstant.RMI_PORT);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		Thread tName = new Thread() {
			public void run() {
				try {
					remote.sendMacroUAAppState(appMacro, destinationIP,
							applicationState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		tName.setName("threadSendUAAppState");
		tName.start();

	} // fim do metodo sendMacroUAAppState

	/**
	 * 
	 * @param appMRT
	 * @param ipAddress
	 * @throws RemoteException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NotBoundException
	 */
	public void sendLocalMrtUA(ApplicationMRT appMRT) throws RemoteException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(appMRT.getDeviceIP(),
				RemoteCommunicationConstant.RMI_PORT);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);
		remote.sendLocalMrtUA(appMRT);
	} // fim do metodo sendLocalMrtUA

	/**
	 * 
	 * @param serviceMacro
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void sendMacroSer(ServiceMacro serviceMacro, String ipAddress)
			throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(ipAddress,
				RemoteCommunicationConstant.RMI_PORT);

		final RemoteCommunicationInterf remote = (RemoteCommunicationInterf) registry
				.lookup(RemoteCommunicationConstant.RMI_ID);

		remote.sendMacroSer(serviceMacro);
	} // fim do metodo sendMacroSer

}
