package twosvm.uctwosmiddleware.localeventhandler;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.uctwosmiddleware.localeventhandler.contextchange.ContextChangePub;
import twosvm.uctwosmiddleware.localeventhandler.newsmartspace.NewSmartSpacePub;
import twosvm.uctwosmiddleware.localeventhandler.ubiquitousapplication.UbiAppPub;
import twosvm.uctwosmiddleware.localmodelmanager.LocalModelManager;

public class LocalEventHandler {

	private static LocalEventHandler instance = null;

	/**
	 * Construtor
	 */
	public LocalEventHandler() {
	}

	/**
	 * 
	 * @return
	 */
	public synchronized static LocalEventHandler getInstance() {
		if (instance == null) {
			instance = new LocalEventHandler();
		}
		return instance;
	}

	/**
	 * Identifica o tratador de eventos adequado, ContextChangeHandler ou
	 * NewSmartSpace
	 * 
	 * @param contextChange
	 * @throws Exception
	 */
	public void sendEvent(ContextChange contextChange) throws Exception {

		LocalModelManager localModelManager;

		switch (contextChange.getEventName()) {
		case "newSmartSpace":
			// envia evento para Event Handler da 2SVM-Controller
			NewSmartSpacePub newSmartSpacePub = new NewSmartSpacePub();
			newSmartSpacePub.newElement(contextChange);
			break;
		case "startApplication":
			localModelManager = new LocalModelManager();
			// atualiza M@RT local
			localModelManager.startApplicationInDevice(contextChange);
			// envia evento para Event Handler da 2SVM-Controller
			UbiAppPub ubiAppPub = new UbiAppPub();
			ubiAppPub.newEvent(contextChange);
			break;
		case "changeLocation":
			localModelManager = new LocalModelManager();
			System.out.println("Evento: " + contextChange.getEventName());
			// enriquece o evento
			User user = new User();
			user = contextChange.getUser();
			user.setUserType(localModelManager.queryMrtElementUR()
					.getUserType());
			user.setAppType(localModelManager.queryMrtElementUA().get(0)
					.getApplicationType());
			contextChange.setUser(user);
			// envia para Event Handler da 2SVM-Controller
			ContextChangePub contextChangePub = new ContextChangePub();
			contextChangePub.newEvent(contextChange);
			break;
		default:
			break;
		} // fim do switch

	} // fim do metodo sendEvent

}
