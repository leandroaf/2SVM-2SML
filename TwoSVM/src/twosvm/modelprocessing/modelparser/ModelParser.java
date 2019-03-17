package twosvm.modelprocessing.modelparser;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import twosvm.model.behavioralpolicy.BehAction;
import twosvm.model.behavioralpolicy.BehCondition;
import twosvm.model.behavioralpolicy.BehEvent;
import twosvm.model.modelelement.reader.ModelElementReaderSO;
import twosvm.model.modelelement.recorder.ModelElementRecorderSS;
import twosvm.model.modelelement.recorder.ModelRecordsTable;
import twosvm.model.newmodeldescription.NewModelDescription;
import twosvm.model.service.Service;
import twosvm.model.smartobject.feature.Feature;
import twosvm.model.smartspace.SmartSpace;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;
import Twosml.ControlSchema;
import Twosml.FeatureCategory;
import Twosml.FeatureType;
import Twosml.SmartObject;

/**
 * Esta classe faz o parsing de todo o modelo
 * 
 * @author leandroalexandre
 *
 */
public class ModelParser {

	ModelCacheRecord modelCacheRecord = new ModelCacheRecord();

	private static ModelParser instance = null;

	ControlSchema userModel;
	ControlSchema engineerModel;

	UserRole uRoleNewModel = new UserRole();

	SmartSpace smartSpace = new SmartSpace();

	ArrayList<String> sObjectNames;
	ArrayList<String> sObjectCanUse;
	ArrayList<String> sObjectIsOwnerOf;
	ArrayList<String> sObjectNameSTs;
	ArrayList<String> uAppNames;
	ArrayList<String> uAppNameSTs;

	Map<String, ArrayList<String>> userRoleCU = new HashMap<String, ArrayList<String>>();
	Map<String, ArrayList<String>> userRoleIoF = new HashMap<String, ArrayList<String>>();

	NewModelDescription newModelDescriptionUR = new NewModelDescription();

	boolean isNewModel = false;

	/**
	 * Construtor
	 */
	public ModelParser() {
	}

	/**
	 * 
	 * @return
	 */
	public static ModelParser getInstance() {
		if (instance == null) {
			instance = new ModelParser();
		}
		return instance;
	}

	/**
	 * Parsing do modelo do ES
	 * 
	 * @param engineerModel
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void parsingEngineerModel(ControlSchema engineerModel)
			throws IOException, NotBoundException, InterruptedException {
		this.engineerModel = engineerModel;

		String modelType = "modelprocessing/modelcache/engineermodel";

		// limpa Cache Model do engenheiro
		cleanModelCache(modelType, "userrole/");
		cleanModelCache(modelType, "smartobject/");
		cleanModelCache(modelType, "feature/");
		cleanModelCache(modelType, "ubiapp/");
		cleanModelCache(modelType, "service/");
		cleanModelCache(modelType, "behaviouralpolicy/");

		// le SmartObject associado a SmartSpace
		parsingSmartObject(engineerModel, modelType);

		// le UbiApp associado a SmartSpace
		parsingUbiApp(engineerModel, modelType);

		// le Service associado a SmartSpace
		parsingService(engineerModel, modelType);

		// le apenas Policies associadas a SmartSpace
		parsingBehPolicy(engineerModel, modelType);

	} // fim do metodo parsingEngineerModel

	/**
	 * Parsing do modelo do US
	 * 
	 * @param userModel
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void parsingUserModel(ControlSchema userModel) throws IOException,
			NotBoundException, InterruptedException {
		this.userModel = userModel;

		String smartSpaceName;
		String modelType = "modelprocessing/modelcache/usermodel";

		// limpa Cache Model do usuario
		cleanModelCache(modelType, "smartspace/");
		cleanModelCache(modelType, "userrole/");
		cleanModelCache(modelType, "smartobject/");
		cleanModelCache(modelType, "feature/");
		cleanModelCache(modelType, "ubiapp/");
		cleanModelCache(modelType, "service/");
		cleanModelCache(modelType, "behaviouralpolicy/");

		// le SmartSpace
		smartSpaceName = userModel.getCsSmartSpace().getName();

		// le UserRole associado a SmartSpace
		parsingUserRole(userModel, modelType);

		// le SmartObject associado a SmartSpace
		parsingSmartObject(userModel, modelType);

		// le UbiApp associado a SmartSpace
		parsingUbiApp(userModel, modelType);

		// le Service associado a SmartSpace
		parsingService(userModel, modelType);

		// le apenas Policies associadas a SmartSpace
		parsingBehPolicy(userModel, modelType);

		// Cria um sub-modelo para SmartSpace
		ModelElementRecorderSS modelElementRecorderSS = new ModelElementRecorderSS();
		modelElementRecorderSS.saveModelElement(smartSpace, smartSpaceName,
				modelType);

	} // fim do metodo parsingUserModel

	/**
	 * Metodo para fazer o parsing de UserRole
	 * 
	 * @throws IOException
	 */
	public void parsingUserRole(ControlSchema model, String modelType)
			throws IOException {

		// lista de nomes de smartObject
		sObjectNames = new ArrayList<String>();
		sObjectNameSTs = new ArrayList<String>();
		uAppNames = new ArrayList<String>();
		uAppNameSTs = new ArrayList<String>();

		String uRoleName;
		String superTypeUR;

		// quantidade de URs associados à SS
		int amountUR = model.getCsSmartSpace().getHUR_SS().size();

		// le todos os nomes de UR
		for (int indexUR = 0; indexUR < amountUR; indexUR++) {

			// obtem o nome de um UserRole
			uRoleName = model.getCsSmartSpace().getHUR_SS().get(indexUR)
					.getTarget().getName();

			// obtem type de UserRole
			superTypeUR = model.getCsSmartSpace().getHUR_SS().get(indexUR)
					.getTarget().getSuperType();

			// quantidade de SOs associados a determinado UR (associacao canUse)
			int amountCanUse = model.getCsSmartSpace().getHUR_SS().get(indexUR)
					.getTarget().getCuSO_UR().size();

			// quantidade de SOs associados a determinado UR (associacao
			// isOwnerOf)
			int amountIsOwnerOf = model.getCsSmartSpace().getHUR_SS()
					.get(indexUR).getTarget().getIsoSO_UR().size();

			// le SmartObjects associados diretamente a UserRole
			sObjectNames = parsingSmartObjectUR(uRoleName, indexUR,
					amountCanUse, amountIsOwnerOf);

			// le SmartObjects associados ao supertipo de SmartObject
			// obtem o superType de UserRole
			String uRoleSuperType = model.getCsSmartSpace().getHUR_SS()
					.get(indexUR).getTarget().getSuperType();

			// le SmartObjects associados ao supertipo de SmartObject
			sObjectNameSTs = parsingSmartObjectSTUR(uRoleSuperType);
			int amountSONameST = sObjectNameSTs.size();
			for (int indexSO = 0; indexSO < amountSONameST; indexSO++) {
				sObjectNames.add(sObjectNameSTs.get(indexSO));
			}

			// le UbiApps associados diretamente a UserRole
			uAppNames = parsingUbiAppUR(indexUR);

			// le UbiApps associados ao supertipo de SmartObject
			uAppNameSTs = parsingSmartObjectSTUA(uRoleSuperType);
			int amountUSNameST = uAppNameSTs.size();
			for (int indexUA = 0; indexUA < amountUSNameST; indexUA++) {
				uAppNames.add(uAppNameSTs.get(indexUA));
			}

			// adicionando as chaves de userRole na tabela SmartSpace
			smartSpace.setUserRoleKeyAL(uRoleName);

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildUserRoleModel(uRoleName, superTypeUR,
					sObjectNames, uAppNames, amountCanUse, amountIsOwnerOf,
					modelType);

		} // fim do loop que le todos os nomes de UR

	} // fim do metodo parsingUserRole

	/**
	 * Metodo que faz o parsing de UbiApps relacionados a SmartSpace
	 * 
	 * @param model
	 * @throws IOException
	 */
	public void parsingUbiApp(ControlSchema model, String modelType)
			throws IOException {

		ArrayList<String> ubiAppNameAL = new ArrayList<String>();

		UbiApp uApp = new UbiApp();

		String ubiAppName;
		String ubiAppSupertype;

		// quantidade de UbiApp de determinado UserRole
		int amountUbiApp = model.getCsUbiApplication().size();

		// le todas UbiApp
		for (int ubiAppPosition = 0; ubiAppPosition < amountUbiApp; ubiAppPosition++) {

			// obtendo nomes de UbiApp
			ubiAppName = model.getCsUbiApplication().get(ubiAppPosition)
					.getName();

			// obtem supertipo
			ubiAppSupertype = model.getCsUbiApplication().get(ubiAppPosition)
					.getSuperType();

			// configura objeto UbiApp
			uApp.setUbiAppName(ubiAppName);
			uApp.setSuperType(ubiAppSupertype);

			// adiciona ubiAppName a lista ubiAppNameAL
			ubiAppNameAL.add(ubiAppName);

			// adicionando as chaves de ubiApp na tabela SmartSpace
			smartSpace.setUbiAppKeyAL(ubiAppName);

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildUbiAppModel(uApp, modelType);

		} // fim de le todas UbiApp

	} // fim do metodo parsingUbiApp

	/**
	 * Metodo para fazer o parsing de SmartObjects
	 * 
	 * @param model
	 * @throws IOException
	 */
	public void parsingSmartObject(ControlSchema model, String modelType)
			throws IOException {

		String sObjectName;
		String sObjectSuperType;
		sObjectNames = new ArrayList<String>();
		SmartObject smartObject;
		SmartObject smartObjectTemp;
		boolean canUse;
		boolean isOwnerOf;

		String pathEngineerModel = "modelprocessing/modelcache/engineermodel";

		ModelElementReaderSO modelElementReaderSO = new ModelElementReaderSO();

		// quantidade de SOs
		int amountSO = model.getCsSmartObject().size();

		// le SmartObjects
		for (int sObjPosition = 0; sObjPosition < amountSO; sObjPosition++) {
			canUse = false;
			isOwnerOf = false;

			smartObject = model.getCsSmartObject().get(sObjPosition);

			// obtem nome de SOs
			sObjectName = smartObject.getName();

			// obtem supertipo
			sObjectSuperType = model.getCsSmartObject().get(sObjPosition)
					.getSuperType();

			// adicionado os nomes de SO a lista sObjectNameAL
			sObjectNames.add(sObjectName);

			// Lista de Features
			ArrayList<Feature> featureAL = new ArrayList<Feature>();
			if (modelType.equals(pathEngineerModel)) {
				featureAL = parsingFeature(model, sObjPosition, modelType);
			} else {
				// obter todas as features de user model a partir do engineer
				// model
				featureAL = modelElementReaderSO.readModelElement(
						sObjectSuperType, pathEngineerModel).getFeatureAL();
				modelCacheRecord.buildFeaturesModel(featureAL, modelType);
			}

			// adicionando as chaves de ubiApp na tabela SmartSpace
			smartSpace.setSmartObjectKeyAL(sObjectName);

			// verifica se existe alguma associacao do tipo canUse para o
			// smartObject
			if (userRoleCU.get(sObjectName) != null) {
				canUse = true;
			}

			// verifica se existe alguma associacao do tipo isOwnerOf para o
			// smartObject
			if (userRoleIoF.get(sObjectName) != null) {
				isOwnerOf = true;
			}

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildSmartObjectModel(sObjectName,
					sObjectSuperType, featureAL, userRoleCU.get(sObjectName),
					userRoleIoF.get(sObjectName), canUse, isOwnerOf, modelType);

		} // fim do loop le SmartObjects associados a UR

	} // fim do metodo parsingSmartObjectES

	/**
	 * Metodo que faz o parsing de Services associados a SmartSpace
	 * 
	 * @throws IOException
	 */
	public void parsingService(ControlSchema model, String modelType)
			throws IOException {

		ArrayList<String> sNameAL = new ArrayList<String>();
		Service service = new Service();

		String serviceName;
		String serviceSupertype;

		// quantidade de service associada a userRole
		int amountService = model.getCsService().size();

		// loop que le Services
		for (int index = 0; index < amountService; index++) {

			// obtendo os nomes de services associados a UserRole
			serviceName = model.getCsService().get(index).getName();

			// obtendo os supertipos de services associados a UserRole
			serviceSupertype = model.getCsService().get(index).getSuperType();

			service.setServiceName(serviceName);
			service.setSuperType(serviceSupertype);

			sNameAL.add(serviceName);

			// adiciona Service a SmartSpace
			smartSpace.setServiceKeyAL(serviceName);

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildServiceModel(service, modelType);

		} // fim do loop que le Services

	} // fim do metodo parsingService

	/**
	 * 
	 * @param iUserRole
	 * @return
	 */
	public ArrayList<String> parsingSmartObjectUR(String userRoleName,
			int iUserRole, int amountCU, int amountIoO) {

		int indexUserRole = iUserRole;
		String sObjectName;
		sObjectNames = new ArrayList<String>();

		ArrayList<String> sObjectTemp;

		// Associacao canUse
		// quantidade de SOs associados a determinado UR (associacao canUse)
		int amountCanUse = amountCU;

		// le SmartObjects associados a UR (canUse)
		for (int indexSO = 0; indexSO < amountCanUse; indexSO++) {

			sObjectTemp = new ArrayList<String>();

			// obtem nome de SOs
			sObjectName = userModel.getCsSmartSpace().getHUR_SS()
					.get(indexUserRole).getTarget().getCuSO_UR().get(indexSO)
					.getTarget().getName();

			// cria hashMap de smartObjects
			if (userRoleCU.get(sObjectName) == null) {
				sObjectTemp.add(userRoleName);
				userRoleCU.put(sObjectName, sObjectTemp);
			} else {
				sObjectTemp = userRoleCU.get(sObjectName);
				sObjectTemp.add(userRoleName);
				userRoleCU.put(sObjectName, sObjectTemp);
			}

			// adicionado os nomes de SO a lista sObjectNameAL
			sObjectNames.add(sObjectName);

		} // fim do for que le SmartObjects

		// Associacao isOwnerOf
		// quantidade de SOs associados a determinado UR (associacao canUse)
		int amountIsOwnerOf = amountIoO;

		// le SmartObjects associados a UR (isOwnerOf)
		for (int indexSO = 0; indexSO < amountIsOwnerOf; indexSO++) {

			sObjectTemp = new ArrayList<String>();

			// obtem nome de SOs
			sObjectName = userModel.getCsSmartSpace().getHUR_SS()
					.get(indexUserRole).getTarget().getIsoSO_UR().get(indexSO)
					.getTarget().getName();

			// cria hashMap de smartObjects
			if (userRoleIoF.get(sObjectName) == null) {
				sObjectTemp.add(userRoleName);
				userRoleIoF.put(sObjectName, sObjectTemp);
			} else {
				sObjectTemp = userRoleIoF.get(sObjectName);
				sObjectTemp.add(userRoleName);
				userRoleIoF.put(sObjectName, sObjectTemp);
			}

			// adicionado os nomes de SO a lista sObjectNameAL
			sObjectNames.add(sObjectName);

		} // fim do for que le SmartObjects

		// adicionando as chaves de smartObject na tabela SmartSpace
		smartSpace.setSmartObjectKeyAL(sObjectNames);

		return sObjectNames;

	} // fim do metodo parsingSmartObject

	/**
	 * Metodo para retornar SmartObjects de determinado UserRole SuperType
	 * 
	 * @param uRSuperType
	 * @return
	 */
	public ArrayList<String> parsingSmartObjectSTUR(String uRSuperType) {

		// quantidade de papeis do usuario definida no modelo do engenheiro
		int amountUR = engineerModel.getCsUserRole().size();
		ArrayList<String> smartObjectTypes = new ArrayList<String>();

		for (int indexUR = 0; indexUR < amountUR; indexUR++) {
			// quantidade de papeis do usuario relacionadas a CanUse
			int amountSO = engineerModel.getCsUserRole().get(indexUR)
					.getCuSO_UR().size();
			for (int indexSO = 0; indexSO < amountSO; indexSO++) {
				if ((engineerModel.getCsUserRole().get(indexUR).getName()
						.equals(uRSuperType))) {
					smartObjectTypes.add(engineerModel.getCsUserRole()
							.get(indexUR).getCuSO_UR().get(indexSO).getTarget()
							.getName());
				}
			}
		}
		return smartObjectTypes;
	} // fim do metodo parsingSmartObjectSTUR

	/**
	 * Metodo para retornar UbiApps de determinado UserRole SuperType
	 * 
	 * @param uRSuperType
	 * @return
	 */
	public ArrayList<String> parsingSmartObjectSTUA(String uRSuperType) {

		int amountUR = engineerModel.getCsUserRole().size();
		ArrayList<String> ubiAppNames = new ArrayList<String>();

		for (int indexUR = 0; indexUR < amountUR; indexUR++) {
			int amountUA = engineerModel.getCsUserRole().get(indexUR)
					.getCuUA_UR().size();
			for (int indexUA = 0; indexUA < amountUA; indexUA++) {
				if ((engineerModel.getCsUserRole().get(indexUR).getName()
						.equals(uRSuperType))) {
					ubiAppNames.add(engineerModel.getCsUserRole().get(indexUR)
							.getCuUA_UR().get(indexUA).getTarget().getName());
				}
			}
		}

		return ubiAppNames;
	} // fim do metodo parsingSmartObjectSTUR

	/**
	 * Metodo para fazer o parsing de UbiApp
	 * 
	 * @param indexURPosition
	 * @return
	 */
	public ArrayList<String> parsingUbiAppUR(int indexURPosition) {

		ArrayList<String> ubiAppNameAL = new ArrayList<String>();

		int indexUserRole = indexURPosition;
		String ubiAppName;

		// quantidade de UbiApp de determinado UserRole
		int amountUbiApp = userModel.getCsSmartSpace().getHUR_SS()
				.get(indexUserRole).getTarget().getCuUA_UR().size();

		// le todas UbiApp
		for (int indexUbiApp = 0; indexUbiApp < amountUbiApp; indexUbiApp++) {

			// obtendo nomes de UbiApp
			ubiAppName = userModel.getCsSmartSpace().getHUR_SS()
					.get(indexUserRole).getTarget().getCuUA_UR()
					.get(indexUbiApp).getTarget().getName();

			// adiciona ubiAppName a lista ubiAppNameAL
			ubiAppNameAL.add(ubiAppName);

		} // fim de le todas UbiApp

		return ubiAppNameAL;

	} // fim do metodo parsingUbiApp

	/**
	 * Metodo para fazer o parsing de Service
	 * 
	 * @param uRolePosition
	 * @return
	 */
	public ArrayList<String> parsingServiceSS() {

		ArrayList<String> sNameAL = new ArrayList<String>();

		Service service = new Service();

		String serviceName;
		String serviceSuperType;
		String modelType = "modelprocessing/modelcache/usermodel";

		// quantidade de service associada a userRole
		int amountService = userModel.getCsSmartSpace().getHSer_SS().get(0)
				.getFromSS_Ser().size();

		for (int servicePosition = 0; servicePosition < amountService; servicePosition++) {

			// obtendo os nomes de services associados a UserRole
			serviceName = userModel.getCsSmartSpace().getHSer_SS().get(0)
					.getFromSS_Ser().get(servicePosition).getName();

			serviceSuperType = userModel.getCsSmartSpace().getHSer_SS().get(0)
					.getFromSS_Ser().get(servicePosition).getSuperType();

			service.setServiceName(serviceName);
			service.setSuperType(serviceSuperType);

			sNameAL.add(serviceName);

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildServiceModel(service, modelType);

		}

		// retorna lista de services associadas a userRole
		return sNameAL;

	} // fim do metodo parsingService

	/**
	 * Metodo para fazer o parsing de BehPolicy de SmartSpace
	 */
	public void parsingBehPolicy(ControlSchema model, String modelType) {

		int amountBehPolicy = model.getCsPolicy().size();
		String behPolicyName;

		// le todas policies associadas a smartSpace
		for (int policyPosition = 0; policyPosition < amountBehPolicy; policyPosition++) {
			// adicionando as chaves de policy na tabela SmartSpace
			behPolicyName = model.getCsPolicy().get(policyPosition).getName();
			smartSpace.setPolicyKeyAL(behPolicyName);

			// Faz a leitura de events relacionados as politicas
			BehEvent behEvent;
			behEvent = parsingBehEvent(model, policyPosition);

			// Faz a leitura dos conditions relacionados as politicas
			BehCondition behContition;
			behContition = parsingBehCondition(model, policyPosition);

			// Faz a leitura dos actions relacionados as politicas
			BehAction behAction;
			behAction = parsingBehaviourAction(model, policyPosition);

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildPolicyModel(behPolicyName, behEvent,
					behContition, behAction, modelType);

		} // fim de le todas policies associadas a smartSpace

	} // fim do metodo parsingPolicy

	/**
	 * 
	 * @param userRolePos
	 * @param sObjPosition
	 * @return
	 */
	public ArrayList<Feature> parsingFeature(ControlSchema model,
			int sObjPosition, String modelType) {

		int sObjectPosition = sObjPosition;
		String featureName;
		FeatureCategory featureCategory;
		FeatureType featureType;
		String featureDescription;

		Feature feature;
		ArrayList<Feature> featureAL = new ArrayList<Feature>();

		// quantidade de feature associado a smartObject
		int amountFeat = model.getCsSmartObject().get(sObjectPosition)
				.getIcoFeat_SO().size();

		// verificando se existe alguma feature associada a smartObject
		for (int featPosition = 0; featPosition < amountFeat; featPosition++) {

			feature = new Feature();

			featureName = model.getCsSmartObject().get(sObjectPosition)
					.getIcoFeat_SO().get(featPosition).getTarget().getName();

			feature.setFeatureName(featureName);

			featureCategory = model.getCsSmartObject().get(sObjectPosition)
					.getIcoFeat_SO().get(featPosition).getTarget()
					.getFeatureCategory();

			feature.setFeatureCategory(featureCategory.getName());

			featureType = model.getCsSmartObject().get(sObjectPosition)
					.getIcoFeat_SO().get(featPosition).getTarget()
					.getFeatureType();

			feature.setFeatureType(featureType.getLiteral());

			featureDescription = model.getCsSmartObject().get(sObjectPosition)
					.getIcoFeat_SO().get(featPosition).getTarget()
					.getFeatureDescription();

			feature.setFeatureDescription(featureDescription);

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildFeatureModel(feature, modelType);

			featureAL.add(feature);
		}
		return featureAL;

	} // fim do metodo parsingFeature

	/**
	 * 
	 * @param pPosition
	 * @return
	 */
	public BehEvent parsingBehEvent(ControlSchema model, int pPosition) {

		int policyPosition = pPosition;
		String eventName;
		String description;
		BehEvent behEvent = new BehEvent();

		eventName = model.getCsPolicy().get(policyPosition).getHasPol_BehEv()
				.get(0).getTarget().getName();

		description = model.getCsPolicy().get(policyPosition).getHasPol_BehEv()
				.get(0).getTarget().getDescription();

		behEvent.setEventName(eventName);
		behEvent.setDescription(description);

		return behEvent;

	} // fim do metodo parsingBehaviourEvent

	/**
	 * 
	 * @param pPosition
	 * @return
	 */
	public BehCondition parsingBehCondition(ControlSchema model, int pPosition) {

		int policyPosition = pPosition;
		String conditionName;
		String description;
		BehCondition behaviouralCondition = new BehCondition();

		conditionName = model.getCsPolicy().get(policyPosition)
				.getHasBehCon_Po().get(0).getTarget().getName();

		description = model.getCsPolicy().get(policyPosition).getHasBehCon_Po()
				.get(0).getTarget().getDescription();

		behaviouralCondition.setConditionName(conditionName);
		behaviouralCondition.setDescription(description);

		return behaviouralCondition;

	} // fim do metodo parsingBehaviourCondition

	/**
	 * 
	 * @param pPosition
	 * @return
	 */
	public BehAction parsingBehaviourAction(ControlSchema model, int pPosition) {

		int policyPosition = pPosition;
		String actionName;
		String description;
		BehAction behaviourAction = new BehAction();

		actionName = model.getCsPolicy().get(policyPosition).getHasBehAct_Po()
				.get(0).getTarget().getName();

		description = model.getCsPolicy().get(policyPosition).getHasBehAct_Po()
				.get(0).getTarget().getDescription();

		behaviourAction.setActionName(actionName);
		behaviourAction.setDescription(description);

		return behaviourAction;

	} // fim do metodo parsingBehaviourAction

	/**
	 * Metodo para adicionar MRT para UserRole
	 * 
	 * @param userRole
	 * @throws IOException
	 */
	public void parsingNewModelUserRole(Twosml.UserRole userRole,
			String modelType) throws IOException {

		// lista de nomes de smartObject
		sObjectNames = new ArrayList<String>();
		sObjectNameSTs = new ArrayList<String>();
		uAppNames = new ArrayList<String>();
		uAppNameSTs = new ArrayList<String>();

		String uRoleName;
		String superTypeUR;

		// obtem o nome de um UserRole
		uRoleName = userRole.getName();

		// obtem type de UserRole
		superTypeUR = userRole.getSuperType();

		// quantidade de SOs associados a determinado UR (associacao canUse)
		int amountCanUse = userRole.getCuSO_UR().size();

		// quantidade de SOs associados a determinado UR (associacao
		// isOwnerOf)
		int amountIsOwnerOf = userRole.getIsoSO_UR().size();

		// le SmartObjects associados diretamente a UserRole
		sObjectNames = parsingNewModelSmartObjectUR(userRole, amountCanUse,
				amountIsOwnerOf);

		// le SmartObjects associados ao supertipo de SmartObject
		// obtem o superType de UserRole
		String uRoleSuperType = userRole.getSuperType();

		// le SmartObjects associados ao supertipo de SmartObject
		sObjectNameSTs = parsingSmartObjectSTUR(uRoleSuperType);
		int amountSONameST = sObjectNameSTs.size();
		for (int indexSO = 0; indexSO < amountSONameST; indexSO++) {
			sObjectNames.add(sObjectNameSTs.get(indexSO));
		}

		// le UbiApps associados diretamente a UserRole
		uAppNames = parsingNewModelUbiAppUR(userRole);

		// le UbiApps associados ao supertipo de SmartObject
		uAppNameSTs = parsingSmartObjectSTUA(uRoleSuperType);
		int amountUSNameST = uAppNameSTs.size();
		for (int indexUA = 0; indexUA < amountUSNameST; indexUA++) {
			uAppNames.add(uAppNameSTs.get(indexUA));
		}

		// adicionando as chaves de userRole na tabela SmartSpace
		smartSpace.setUserRoleKeyAL(uRoleName);

		// envia elementos do modelo para Model Cache
		modelCacheRecord.buildUserRoleModel(uRoleName, superTypeUR,
				sObjectNames, uAppNames, amountCanUse, amountIsOwnerOf,
				modelType);

	} // fim do metodo parsingUserRole

	/**
	 * 
	 * @param userRole
	 * @param amountCU
	 * @param amountIoO
	 * @return
	 */
	public ArrayList<String> parsingNewModelSmartObjectUR(
			Twosml.UserRole userRole, int amountCU, int amountIoO) {

		String sObjectName;
		sObjectNames = new ArrayList<String>();
		ArrayList<String> sObjectTemp;

		// Associacao canUse
		// quantidade de SOs associados a determinado UR (associacao canUse)
		int amountCanUse = amountCU;

		// le SmartObjects associados a UR (canUse)
		for (int indexSO = 0; indexSO < amountCanUse; indexSO++) {

			sObjectTemp = new ArrayList<String>();

			// obtem nome de SOs
			sObjectName = userRole.getCuSO_UR().get(indexSO).getTarget()
					.getName();

			// adicionado os nomes de SO a lista sObjectNameAL
			sObjectNames.add(sObjectName);

		} // fim do loop que le SmartObjects

		// Associacao isOwnerOf
		// quantidade de SOs associados a determinado UR (associacao canUse)
		int amountIsOwnerOf = amountIoO;

		// le SmartObjects associados a UR (isOwnerOf)
		for (int indexSO = 0; indexSO < amountIsOwnerOf; indexSO++) {

			sObjectTemp = new ArrayList<String>();

			// obtem nome de SOs
			sObjectName = userRole.getIsoSO_UR().get(indexSO).getTarget()
					.getName();

			// adicionado os nomes de SO a lista sObjectNameAL
			sObjectNames.add(sObjectName);

		} // fim do for que le SmartObjects

		// adicionando as chaves de smartObject na tabela SmartSpace
		smartSpace.setSmartObjectKeyAL(sObjectNames);

		return sObjectNames;

	} // fim do metodo parsingSmartObjectNewModel

	/**
	 * 
	 * @param userRoleName
	 * @param iUserRole
	 * @param amountCU
	 * @param amountIoO
	 * @param sObjectNameAL
	 */
	public void parsingNewModelSmartObject(String userRoleName, int iUserRole,
			int amountCU, int amountIoO, ArrayList<String> sObjectNameAL) {

		int indexUserRole = iUserRole;
		String sObjectName;

		ArrayList<String> sObjectTemp;

		// Associacao canUse
		// quantidade de SOs associados a determinado UR (associacao canUse)
		int amountCanUse = amountCU;

		// le SmartObjects associados a UR (canUse)
		for (int indexSO = 0; indexSO < amountCanUse; indexSO++) {

			sObjectTemp = new ArrayList<String>();

			// obtem nome de SOs
			sObjectName = userModel.getCsSmartSpace().getHUR_SS()
					.get(indexUserRole).getTarget().getCuSO_UR().get(indexSO)
					.getTarget().getName();

			// cria hashMap de smartObjects
			if (userRoleCU.get(sObjectName) == null) {
				sObjectTemp.add(userRoleName);
				userRoleCU.put(sObjectName, sObjectTemp);
			} else {
				sObjectTemp = userRoleCU.get(sObjectName);
				sObjectTemp.add(userRoleName);
				userRoleCU.put(sObjectName, sObjectTemp);
			}

		} // fim do for que le SmartObjects

		// Associacao isOwnerOf
		// quantidade de SOs associados a determinado UR (associacao canUse)
		int amountIsOwnerOf = amountIoO;

		// le SmartObjects associados a UR (isOwnerOf)
		for (int indexSO = 0; indexSO < amountIsOwnerOf; indexSO++) {

			sObjectTemp = new ArrayList<String>();

			// obtem nome de SOs
			sObjectName = userModel.getCsSmartSpace().getHUR_SS()
					.get(indexUserRole).getTarget().getIsoSO_UR().get(indexSO)
					.getTarget().getName();

			// cria hashMap de smartObjects
			if (userRoleIoF.get(sObjectName) == null) {
				sObjectTemp.add(userRoleName);
				userRoleIoF.put(sObjectName, sObjectTemp);
			} else {
				sObjectTemp = userRoleIoF.get(sObjectName);
				sObjectTemp.add(userRoleName);
				userRoleIoF.put(sObjectName, sObjectTemp);
			}

		} // fim do for que le SmartObjects

	} // fim do metodo parsingSmartObjectNewModel

	/**
	 * Metodo para adicionar MRT para UbiApp
	 * 
	 * @param userRole
	 * @return
	 */
	public ArrayList<String> parsingNewModelUbiAppUR(Twosml.UserRole userRole) {

		ArrayList<String> ubiAppNameAL = new ArrayList<String>();

		String ubiAppName;

		// quantidade de UbiApp de determinado UserRole
		int amountUbiApp = userRole.getCuUA_UR().size();

		// le todas UbiApp
		for (int indexUbiApp = 0; indexUbiApp < amountUbiApp; indexUbiApp++) {

			// obtendo nomes de UbiApp
			ubiAppName = userRole.getCuUA_UR().get(indexUbiApp).getTarget()
					.getName();

			// adiciona ubiAppName a lista ubiAppNameAL
			ubiAppNameAL.add(ubiAppName);

		} // fim de le todas UbiApp

		return ubiAppNameAL;

	} // fim do metodo parsingUbiAppNewModelUR

	/**
	 * Metodo para adicionar MRT para SmartObject
	 * 
	 * @param smartObject
	 * @throws IOException
	 */
	public void parsingNewModelSmartObject(Twosml.SmartObject smartObject,
			String modelType) throws IOException {

		String sObjectName;
		String sObjectSupertype;
		boolean canUse = false;
		boolean isOwnerOf = false;

		// obtem nome de SOs
		sObjectName = smartObject.getName();

		// ontem supertipo
		sObjectSupertype = smartObject.getSuperType();

		// Lista de Features
		ArrayList<Feature> featureAL;

		featureAL = parsingNewModelFeature(smartObject, modelType);

		// verifica se existe alguma associacao do tipo canUse para o
		// smartObject
		if (userRoleCU.get(sObjectName) != null) {
			canUse = true;
		}

		// verifica se existe alguma associacao do tipo isOwnerOf para o
		// smartObject
		if (userRoleIoF.get(sObjectName) != null) {
			isOwnerOf = true;
		}

		// envia elementos do modelo para armazenar em Model Cache
		modelCacheRecord.buildSmartObjectModel(sObjectName, sObjectSupertype,
				featureAL, userRoleCU.get(sObjectName),
				userRoleIoF.get(sObjectName), canUse, isOwnerOf, modelType);

	} // fim do metodo parsingSmartObjectNewModel

	/**
	 * Metodo para adicionar MRT para Feature
	 * 
	 * @param smartObject
	 * @return
	 */
	public ArrayList<Feature> parsingNewModelFeature(
			Twosml.SmartObject smartObject, String modelType) {

		String featureName;
		FeatureCategory featureCategory;
		FeatureType featureType;
		String featureDescription;

		Feature feature;
		ArrayList<Feature> featureAL = new ArrayList<Feature>();

		// quantidade de feature associado a smartObject
		int amountFeat = smartObject.getIcoFeat_SO().size();

		// verificando se existe alguma feature associada a smartObject
		for (int index = 0; index < amountFeat; index++) {

			feature = new Feature();

			featureName = smartObject.getIcoFeat_SO().get(index).getTarget()
					.getName();

			feature.setFeatureName(featureName);

			featureCategory = smartObject.getIcoFeat_SO().get(index)
					.getTarget().getFeatureCategory();

			feature.setFeatureCategory(featureCategory.getName());

			featureType = smartObject.getIcoFeat_SO().get(index).getTarget()
					.getFeatureType();

			feature.setFeatureType(featureType.getLiteral());

			featureDescription = smartObject.getIcoFeat_SO().get(index)
					.getTarget().getFeatureDescription();

			feature.setFeatureDescription(featureDescription);

			// envia elementos do modelo para armazenar em Model Cache
			modelCacheRecord.buildFeatureModel(feature, modelType);

			featureAL.add(feature);
		}
		return featureAL;

	} // fim do metodo parsingFeatureNewModel

	/**
	 * Metodo para adicionar MRT para UbiApp
	 * 
	 * @param ubiApp
	 * @throws IOException
	 */
	public void parsingNewModelUbiApp(
			Twosml.UbiquitousApplication ubiApplication, String modelType)
			throws IOException {

		UbiApp ubiApp = new UbiApp();

		ArrayList<String> ubiAppNameAL = new ArrayList<String>();

		String ubiAppName;
		String ubiAppSuperType;

		// obtem nome
		ubiAppName = ubiApplication.getName();

		// obtem supertipo
		ubiAppSuperType = ubiApplication.getSuperType();

		// configura objeto UbiApp
		ubiApp.setUbiAppName(ubiAppName);
		ubiApp.setSuperType(ubiAppSuperType);

		// adiciona ubiAppName a lista ubiAppNameAL
		ubiAppNameAL.add(ubiAppName);

		// adicionando as chaves de ubiApp na tabela SmartSpace
		smartSpace.setUbiAppKeyAL(ubiAppName);

		// envia elementos do modelo para armazenar em Model Cache
		modelCacheRecord.buildUbiAppModel(ubiApp, modelType);

	} // fim do metodo parsingUbiAppNewModel

	/**
	 * Metodo para adicionar MRT para Service
	 * 
	 * @param service
	 * @throws IOException
	 */
	public void parsingNewModelService(Twosml.Service service, String modelType)
			throws IOException {

		Service serv = new Service();

		String serviceName;
		String serviceType;

		// obtem nome
		serviceName = service.getName();

		// obtem supertipo
		serviceType = service.getSuperType();

		// configura objeto UbiApp
		serv.setServiceName(serviceName);
		serv.setSuperType(serviceType);

		// adicionando as chaves de ubiApp na tabela SmartSpace
		smartSpace.setUbiAppKeyAL(serviceName);

		// envia elementos do modelo para armazenar em Model Cache
		modelCacheRecord.buildServiceModel(serv, modelType);

	} // fim do metodo parsingUbiAppNewModel

	/**
	 * Metodo para adicionar MRT para BehPol
	 * 
	 * @param behPol
	 */
	public void parsingNewModelBehPol(Twosml.BehavioralPolicy behPol,
			String modelType) {

		String behPolicyName;

		// adicionando as chaves de policy na tabela SmartSpace
		behPolicyName = behPol.getName();
		smartSpace.setPolicyKeyAL(behPolicyName);

		// Faz a leitura de events relacionados as politicas
		BehEvent behEvent = null;
		if (behPol.getHasPol_BehEv().size() > 0) {
			behEvent = new BehEvent();
			behEvent = parsingNewModelBehEvent(behPol);
		}

		// Faz a leitura dos conditions relacionados as politicas
		BehCondition behCondition = null;
		if (behPol.getHasBehCon_Po().size() > 0) {
			behCondition = new BehCondition();
			behCondition = parsingNewModelBehCondition(behPol);
		}

		// Faz a leitura dos actions relacionados as politicas
		BehAction behAction = null;
		if (behPol.getHasBehAct_Po().size() > 0) {
			behAction = new BehAction();
			behAction = parsingNewModelBehaviourAction(behPol);
		}

		// envia elementos do modelo para armazenar em Model Cache
		modelCacheRecord.buildPolicyModel(behPolicyName, behEvent,
				behCondition, behAction, modelType);

	} // fim do metodo parsingPolicyNewModel

	/**
	 * Metodo para adicionar MRT para BehEvent
	 * 
	 * @param behPol
	 * @return
	 */
	public BehEvent parsingNewModelBehEvent(Twosml.BehavioralPolicy behPol) {

		String eventName;
		String description;
		BehEvent behEvent = new BehEvent();

		eventName = behPol.getHasPol_BehEv().get(0).getTarget().getName();

		description = behPol.getHasPol_BehEv().get(0).getTarget()
				.getDescription();

		behEvent.setEventName(eventName);
		behEvent.setDescription(description);

		return behEvent;

	} // fim do metodo parsingBehEventNewModel

	/**
	 * Metodo para adicionar MRT para BehCond
	 * 
	 * @param behPol
	 * @return
	 */
	public BehCondition parsingNewModelBehCondition(
			Twosml.BehavioralPolicy behPol) {

		String conditionName;
		String description;
		BehCondition behCondition = new BehCondition();

		conditionName = behPol.getHasBehCon_Po().get(0).getTarget().getName();

		description = behPol.getHasBehCon_Po().get(0).getTarget()
				.getDescription();

		behCondition.setConditionName(conditionName);
		behCondition.setDescription(description);

		return behCondition;

	} // fim do metodo parsingBehConditionNewModel

	/**
	 * Metodo para adicionar MRT para BehAction
	 * 
	 * @param behPol
	 * @return
	 */
	public BehAction parsingNewModelBehaviourAction(
			Twosml.BehavioralPolicy behPol) {

		String actionName;
		String description;
		BehAction behaviourAction = new BehAction();

		actionName = behPol.getHasBehAct_Po().get(0).getTarget().getName();

		description = behPol.getHasBehAct_Po().get(0).getTarget()
				.getDescription();

		behaviourAction.setActionName(actionName);
		behaviourAction.setDescription(description);

		return behaviourAction;

	} // fim do metodo parsingBehaviourActionNewModel

	/**
	 * Metodo para limpar elementos de Model Cache
	 * 
	 * @param path
	 */
	public void cleanModelCache(String modelType, String elementTypes) {

		String path = "./src/twosvm/" + modelType + "/" + elementTypes;

		// System.out.println(path);

		File folder = new File(path);
		if (folder.isDirectory()) {
			File[] sun = folder.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}

	} // fim do metodo removeModel

}
