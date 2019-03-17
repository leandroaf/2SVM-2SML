package twosvm.modelprocessing.modelparser;

import java.util.ArrayList;

import twosvm.model.behavioralpolicy.BehAction;
import twosvm.model.behavioralpolicy.BehCondition;
import twosvm.model.behavioralpolicy.BehEvent;
import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.modelelement.recorder.ModelElementRecorderBehPol;
import twosvm.model.modelelement.recorder.ModelElementRecorderFeat;
import twosvm.model.modelelement.recorder.ModelElementRecorderSO;
import twosvm.model.modelelement.recorder.ModelElementRecorderSer;
import twosvm.model.modelelement.recorder.ModelElementRecorderUA;
import twosvm.model.modelelement.recorder.ModelElementRecorderUR;
import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.smartobject.feature.Feature;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

/**
 * Esta classe tem por objetivo salvar o Modelo em tempo de execucao
 * 
 * @author leandroalexandre
 *
 */
public class ModelCacheRecord {

	/**
	 * Metodo para construir elemento do modelo para determinado tipo UserRole
	 * 
	 * @param uRoleName
	 * @param sObjectAL
	 * @param polNameAL
	 */
	public void buildUserRoleModel(String uRoleName, String superType,
			ArrayList<String> sObjectNameAL, ArrayList<String> uAppNameAL,
			int amountCU, int amountIoO, String modelType) {

		UserRole userRole = new UserRole();
		String userRoleName = uRoleName;
		ArrayList<String> smartObjectNameAL = sObjectNameAL;
		ArrayList<String> ubiAppNameAL = uAppNameAL;

		userRole.setUserRoleName(userRoleName);
		userRole.setSuperType(superType);
		userRole.setSmartObjectNameAL(smartObjectNameAL);
		userRole.setUbiAppAL(ubiAppNameAL);

		userRole.setAmountCanUse(amountCU);
		userRole.setAmountIsOwnerOf(amountIoO);

		// Cria sub-modelos para UserRole
		ModelElementRecorderUR modelElementRecorderUR = new ModelElementRecorderUR();
		modelElementRecorderUR.saveModelElement(userRole, userRoleName,
				modelType);

	} // fim do metodo buildUserRoleModel

	/**
	 * Metodo para construir elemento do modelo para determinado tipo de
	 * SmartObject
	 * 
	 * @param sObjectName
	 * @param deviceNameAL
	 * @param featureAL
	 * @param pNameSmartObjectAL
	 */
	public void buildSmartObjectModel(String sObjectName, String sObjectType,
			ArrayList<Feature> fAL, ArrayList<String> userRoleCU,
			ArrayList<String> userRoleIoF, boolean canUse, boolean isOwnerOf,
			String modelType) {

		SmartObject smartObject = new SmartObject();
		String smartObjectName = sObjectName;
		String smartObjectSupertype = sObjectType;

		ArrayList<Feature> featureAL = new ArrayList<Feature>();
		featureAL = fAL;

		smartObject.setSmartObjectName(smartObjectName);
		smartObject.setSuperType(smartObjectSupertype);
		smartObject.setFeatureAL(featureAL);
		smartObject.setCanUse(canUse);
		smartObject.setIsOwnerOf(isOwnerOf);
		smartObject.setUserRoleCU(userRoleCU);
		smartObject.setUserRoleIoF(userRoleIoF);

		ModelElementRecorderSO modelElementRecorderSO = new ModelElementRecorderSO();
		modelElementRecorderSO.saveModelElement(smartObject, smartObjectName,
				modelType);

	} // fim do metodo buildSmartObjectModel

	/**
	 * Metodo para construir elemento do modelo para determinado tipo de UbiApp
	 * 
	 * @param uAppName
	 * @param pNameUbiAppAL
	 */
	public void buildUbiAppModel(UbiApp uApp, String modelType) {

		UbiApp ubiApp = new UbiApp();
		ubiApp = uApp;

		ubiApp.setUbiAppName(ubiApp.getUbiAppType());
		ubiApp.setSuperType(ubiApp.getSuperType());

		ModelElementRecorderUA modelElementRecorderUbiApp = new ModelElementRecorderUA();
		modelElementRecorderUbiApp.saveModelElement(ubiApp,
				ubiApp.getUbiAppType(), modelType);

	} // fim do metodo buildUbiAppModel

	/**
	 * Metodo para construir elemento do modelo para determinado tipo de Service
	 * 
	 * @param servName
	 * @param pNameServiceAL
	 */
	public void buildServiceModel(Service service, String modelType) {

		String serviceName = service.getServiceType();

		service.setServiceName(serviceName);

		ModelElementRecorderSer modelElementRecorderSer = new ModelElementRecorderSer();
		modelElementRecorderSer.saveModelElement(service, serviceName,
				modelType);

	} // fim do metodo buildServiceModel

	/**
	 * Metodo para construir elemento do modelo para determinado tipo de Policy
	 * 
	 * @param pName
	 * @param fPolicy
	 */
	public void buildPolicyModel(String pName, BehEvent bEvent,
			BehCondition bCondition, BehAction bAction, String modelType) {

		BehPolicy behPolicy = new BehPolicy();
		BehEvent behEvent = new BehEvent();
		BehCondition behCondition = new BehCondition();
		BehAction behAction = new BehAction();

		behEvent = bEvent;
		behCondition = bCondition;
		behAction = bAction;

		String policyName = pName;

		behPolicy.setPolicyName(policyName);
		behPolicy.setBehEvent(behEvent);
		behPolicy.setBehCondition(behCondition);
		behPolicy.setBehAction(behAction);

		ModelElementRecorderBehPol modelElementRecorderBehPol = new ModelElementRecorderBehPol();
		modelElementRecorderBehPol.saveModelElement(behPolicy, policyName,
				modelType);

	} // fim do metodo buildPolicyModel

	/**
	 * Metodo para construir elemento do modelo para determinado tipo de Feature
	 * 
	 * @param feature
	 */
	public void buildFeatureModel(Feature feature, String modelType) {

		// Constroi modelo para Feature
		ModelElementRecorderFeat modelElementRecorderFeat = new ModelElementRecorderFeat();
		modelElementRecorderFeat.saveModelElement(feature, modelType);

	} // fim do metodo buildFeatureModel
	
	/**
	 *  Metodo para construir elementos do modelo para Features
	 *  
	 * @param features
	 * @param modelType
	 */
	public void buildFeaturesModel(ArrayList<Feature> features, String modelType) {

		// Constroi elementos do modelo para Features
		ModelElementRecorderFeat modelElementRecorderFeat = new ModelElementRecorderFeat();
		int amountFeatures = features.size();
		for (int index = 0; index < amountFeatures; index++) {
			modelElementRecorderFeat.saveModelElement(features.get(index), modelType);
		}
		
	} // fim do metodo buildFeaturesModel

}
