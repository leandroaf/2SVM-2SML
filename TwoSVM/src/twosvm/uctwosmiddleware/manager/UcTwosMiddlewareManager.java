package twosvm.uctwosmiddleware.manager;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.resource.Resource;
import twosvm.model.instance.user.User;
import twosvm.model.models.ModelDescriptionBehEve;
import twosvm.model.models.ModelDescriptionBehPol;
import twosvm.model.models.ModelDescriptionSO;
import twosvm.model.models.ModelDescriptionSS;
import twosvm.model.models.ModelDescriptionSer;
import twosvm.model.models.ModelDescriptionUA;
import twosvm.model.models.ModelDescriptionUR;
import twosvm.model.models.ModelDescriptionURoAssociateToSOb;
import twosvm.uctwosmiddleware.eventhandler.contextchange.ContextChangeSub;
import twosvm.uctwosmiddleware.eventhandler.newsmartspace.NewSmartSpaceSub;
import twosvm.uctwosmiddleware.eventhandler.ubiquitousappplication.UbiAppSub;
import twosvm.uctwosmiddleware.matching.Matching;
import twosvm.uctwosmiddleware.modelinterpreter.ModelInterpreter;

public class UcTwosMiddlewareManager {

	ModelInterpreter modelInterpreter = ModelInterpreter.getInstance();
	Matching matching = Matching.getInstance();

	/**
	 * 
	 * @param resourceName
	 * @param resource
	 * @throws NotBoundException
	 * @throws IOException 
	 */
	public void findResourceType(Resource resource) throws NotBoundException, IOException {
		matching.matchingResource(resource);
	} // fim do metodo findResourceType

	/**
	 * 
	 * @param user
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void findUserRole(User user) throws IOException, NotBoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		matching.matchingUser(user);
	} // fim do metodo findUserRole

	/**
	 * 
	 * @param userAL
	 * @param resourceAL
	 * @param applicationAL
	 * @param serviceAL
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void newContextChange(ContextChange contextChange)
			throws RemoteException, NotBoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		modelInterpreter.contextChange(contextChange);
	} // fim do metodo newContextChange
	
	/**
	 * Metodo responsavel por inicilizar os servicos da camada de Middleware
	 */
	public void startServicesMiddlewareLayer() {
		
		// Servico responsavel por receber novas entidades no espaco inteligente
		new Thread() {
			public void run() {
				NewSmartSpaceSub newEntitySub = new NewSmartSpaceSub();
				try {
					newEntitySub.newEntityInSmartSpace();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}
		}.start();

		// Servico responsavel por receber eventos relacionados a mudancas de
		// contexto no espaco inteligente
		new Thread() {
			public void run() {
				ContextChangeSub contextChangeSub = new ContextChangeSub();
				contextChangeSub.newEvents();
			}
		}.start();
		
		new Thread() {
			public void run() {
				UbiAppSub ubiAppSub = new UbiAppSub();
				ubiAppSub.newUbiApp();
			}
		}.start();

	} // fim do metodo startServicesMiddlewareLayer

}
