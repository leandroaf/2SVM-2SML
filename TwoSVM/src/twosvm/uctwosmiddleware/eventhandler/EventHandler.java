package twosvm.uctwosmiddleware.eventhandler;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.resource.Resource;
import twosvm.model.instance.user.User;
import twosvm.uctwosmiddleware.eventhandler.EventHandler;
import twosvm.uctwosmiddleware.matching.Matching;
import twosvm.uctwosmiddleware.modelinterpreter.ModelInterpreter;

public class EventHandler {

	private static EventHandler instance = null;

	/**
	 * Construtor
	 */
	public EventHandler() {
	}

	/**
	 * 
	 * @return
	 */
	public synchronized static EventHandler getInstance() {
		if (instance == null) {
			instance = new EventHandler();
		}
		return instance;

	}

	/**
	 * Metodo utilizado para NewUserHandler e NewSmartObjectHandler
	 * 
	 * @param user
	 * @param resource
	 */
	public void newSmartSpace(User user, Resource resource) {
		Matching matching = Matching.getInstance();

		// Alerta de novo resource no SS
		System.err
				.println("\nNovo smart object encontrado no espaco inteligente!");

		try {
			matching.matchingResource(resource);
		} catch (NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Alerta de novo usuario no SS
		System.err.println("\nNovo usuario no espaco inteligente!");

		try {
			matching.matchingUser(user);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | IOException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} // fim do metodo newSmartSpace

	/**
	 * 
	 * @param contextChange
	 */
	public void newUbiApp(ContextChange contextChange) {
		// envia evento para Event Handler da 2SVM-Controller
		ModelInterpreter modelInterpreter = new ModelInterpreter();
		modelInterpreter.newUbiApp(contextChange);
	} // fim do metodo sendEventSmartApplication

	/**
	 * 
	 * @param contextChange
	 */
	public void contextChange(ContextChange contextChange) {
		// envia evento para Event Handler da 2SVM-Controller
		ModelInterpreter modelInterpreter = new ModelInterpreter();
		try {
			modelInterpreter.contextChange(contextChange);
		} catch (RemoteException | ClassNotFoundException
				| InstantiationException | IllegalAccessException
				| NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // fim do metodo sendEventContextChange

}
