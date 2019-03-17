package twosvm.twosbroker.startmachine;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import twosvm.twosbroker.applicationmanager.ApplicationManager;
import twosvm.twosbroker.devicemanager.deviceinstance.DeviceInstance;
import twosvm.twosbroker.manager.TwosBrokerFacade;
import twosvm.twosbroker.usermanager.UserManager;
import twosvm.uctwosmiddleware.rmi.communication.RemoteCommunicationHandler;
import twosvm.uctwosmiddleware.rmi.communication.client.MacroClient;


public class StartMachine {
	
	private static StartMachine instance = null;
	
	DeviceInstance deviceInformation = new DeviceInstance();
	UserManager userManager = new UserManager();
	ApplicationManager applicationManager = new ApplicationManager();
	
	/**
	 * Construtor
	 */
	public StartMachine() {
	}
	
	/**
	 * 
	 * @return
	 */
	public synchronized static StartMachine getInstance() {
		if (instance == null) {
			instance = new StartMachine();
		}
		return instance;
	}

	/**
	 * Inicia a maquina
	 * @throws IOException 
	 */
	public void startTwoSVMClient() throws IOException {
		System.out.println("|------- 2SVM-Client Iniciada ------|");
		deviceInformation.startDeviceManager();
		userManager.startUserManager();
		startServicesMiddlewareLayer();
		//applicationManager.startApplicationManager();
	}
	
	/**
	 * Inicia servicos da camada de Middleware
	 */
	public void startServicesMiddlewareLayer() {
		
		final String args[] = null;
		
		// Inicia servico responsavel por receber macros
		new Thread() {
			public void run() {
				try {
					RemoteCommunicationHandler.main(args);
				} catch (RemoteException | AlreadyBoundException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		// Servico responsavel por receber macros
		new Thread() {
			public void run() {
				try {
					MacroClient.main(args);
				} catch (RemoteException | AlreadyBoundException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	} // fim do metodo startServicesMiddlewareLayer

}
