package twosvm.uctwosmiddleware.rmi.communication;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import twosvm.uctwosmiddleware.localmodelinterpreter.LocalModelInterpreter;
import twosvm.model.applications.ApplicationState;
import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.ServiceMacro;
import twosvm.model.macro.UserMacro;
import twosvm.model.mrt.ApplicationMRT;
import twosvm.model.mrt.ServiceMRT;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.model.mrt.UserMRT;
import twosvm.model.remoteinterf.RemoteCommunicationInterf;

public class RemoteCommunicationImplement extends UnicastRemoteObject implements
		RemoteCommunicationInterf {

	LocalModelInterpreter localModelInterpreter = new LocalModelInterpreter();

	protected RemoteCommunicationImplement() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que recebe chamadas remotas da controladora para interpretar macro
	 * para deviceMacro
	 */
	public synchronized void sendMacroSO(SmartObjectMacro smartObjectMacro) {
		try {
			localModelInterpreter.sendMacroSO(smartObjectMacro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // fim do metodo saveLocalAppMRT

	/**
	 * Metodo que recebe chamadas remotas da controladora para interpretar macro
	 * para userMacro
	 * 
	 * @throws IOException
	 */
	public synchronized void sendMacroUR(UserMacro userMacro)
			throws IOException {
		localModelInterpreter.sendMacroUR(userMacro);
	} // fim do metodo sendRemoteUserMacro

	/**
	 * Metodo que recebe chamadas remotas da controladora para interpretar macro
	 * para applicationMacro
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * 
	 */
	public synchronized void sendMacroUA(ApplicationMacro applicationMacro)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException {
		try {
			localModelInterpreter.sendMacroUA(applicationMacro);
		} catch (NotBoundException | InterruptedException e) {
			e.printStackTrace();
		}
	} // fim do metodo sendMacroUA

	/**
	 * 
	 * @param applicationMacro
	 * @param destinationIP
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public synchronized void sendMacroUAContextChange(
			ApplicationMacro applicationMacro, final String destinationIP,
			final String contChangeDestinationIP)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException {
		try {
			localModelInterpreter.sendMacroUAContextChange(applicationMacro,
					destinationIP, contChangeDestinationIP);
		} catch (NotBoundException | InterruptedException e) {
			e.printStackTrace();
		}
	} // fim do metodo sendMacroUAContextChange
	
	/**
	 * 
	 * @param applicationMacro
	 * @param destinationIP
	 * @param applicationState
	 */
	public void sendMacroUAAppState(ApplicationMacro applicationMacro,
			String destinationIP, ApplicationState applicationState) {
		// envia para interpretador de macro que recebe estado da aplicacao
		localModelInterpreter.sendMacroUAAppState(applicationMacro, applicationState);
	} // fim do metodo sendMacroUAAppState

	/**
	 * Metodo que recebe chamadas remotas da controladora para interpretar macro
	 * para serviceMacro
	 */
	public void sendMacroSer(ServiceMacro serviceMacro) throws RemoteException {
	} // fim do metodo sendRemoteSerMacro

	/**
	 * Metodo remoto para atualizar MRT de Smart Object
	 */
	public void sendLocalMrtSO(SmartObjectMRT smartObjectMRT)
			throws RemoteException {
		localModelInterpreter.sendLocalMrtSO(smartObjectMRT);
	} // fim do metodo sendLocalMrtSO

	/**
	 * Metodo remoto para atualizar MRT de User
	 */
	public void sendLocalMrtUR(UserMRT userMRT) throws RemoteException {
		localModelInterpreter.sendLocalMrtUR(userMRT);
	} // fim do metodo sendLocalMrtUR

	/**
	 * Metodo remoto para atualizar MRT de Ubi App
	 */
	public void sendLocalMrtUA(ApplicationMRT appMRT) throws RemoteException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		localModelInterpreter.sendLocalMrtUA(appMRT);
	} // fim do metodo sendLocalMrtUA

	/**
	 * Metodo remoto para atualizar MRT de Service
	 */
	public void sendLocalMrtSer(ServiceMRT serviceMRT) throws RemoteException {
		// TODO Auto-generated method stub
	} // fim do metodo sendLocalMrtSer

}