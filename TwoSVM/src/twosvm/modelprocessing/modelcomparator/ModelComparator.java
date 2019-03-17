package twosvm.modelprocessing.modelcomparator;

import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.metatypes.Metatypes;
import twosvm.model.modelelement.reader.ModelElementReadTable;
import twosvm.model.modelelement.reader.ModelElementReaderBehPol;
import twosvm.model.modelelement.reader.ModelElementReaderSO;
import twosvm.model.modelelement.reader.ModelElementReaderSer;
import twosvm.model.modelelement.reader.ModelElementReaderUA;
import twosvm.model.modelelement.reader.ModelElementReaderUR;
import twosvm.model.modelelement.recorder.ModelElementRecorderBehPol;
import twosvm.model.modelelement.recorder.ModelElementRecorderFeat;
import twosvm.model.modelelement.recorder.ModelElementRecorderSO;
import twosvm.model.modelelement.recorder.ModelElementRecorderSer;
import twosvm.model.modelelement.recorder.ModelElementRecorderUA;
import twosvm.model.modelelement.recorder.ModelElementRecorderUR;
import twosvm.model.modelelement.recorder.ModelRecordsTable;
import twosvm.model.newmodeldescription.NewModelDescription;
import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;
import twosvm.modelprocessing.modelparser.ModelParser;

/**
 * Classe que faz a comparacao entre os modelos A comparacao e feita por tipos
 * 
 * @author leandroalexandre
 *
 */
public class ModelComparator {

	ModelParser modelParser = new ModelParser();
	ModelRecordsTable modelRecordTable = new ModelRecordsTable();
	ModelElementReadTable modelElementReadTable = new ModelElementReadTable();
	ModelElementReaderUR modelElementReaderUR = new ModelElementReaderUR();
	ModelElementReaderSO modelElementReaderSO = new ModelElementReaderSO();
	ModelElementRecorderFeat modelElementRecorderFeat = new ModelElementRecorderFeat();
	ModelElementReaderUA modelElementReaderUA = new ModelElementReaderUA();
	ModelElementReaderSer modelElementReaderSer = new ModelElementReaderSer();
	ModelElementReaderBehPol modelElementReaderBehPol = new ModelElementReaderBehPol();

	/**
	 * 
	 * @param newModel
	 * @param oldModel
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void submit() throws IOException, NotBoundException,
			InterruptedException {
		compareUserRoles();
		compareSmartObjects();
		compareUbiApps();
		compareServices();
		updatePolicies();
	} // fim do metodo sendNewModel

	/**
	 * Metodo para extrair String do objeto
	 * 
	 * @param object
	 * @return
	 */
	public String extractString(EObject object) {
		return object.toString().replaceAll(object.getClass().getName(), "")
				.replaceAll(Integer.toHexString(object.hashCode()), "");
	}

	/**
	 * Metodo para retornar um objeto contendo os elementos que devem ser
	 * adicionados e removidos do espaco inteligente
	 * 
	 * @param oldModelCollection
	 * @param newModelCollection
	 * @return
	 */
	public NewModelDescription getNewModel(Collection<String> oldModelCol,
			Collection<String> newModelCol) {

		// Lista dos elementos do modelo em execucao
		ArrayList<String> oldElementsModel = new ArrayList<String>(oldModelCol);
		// ArrayList<String> oldElementsModel = new ArrayList<String>();

		// Lista dos novos elementos do modelo
		ArrayList<String> newElementsModel = new ArrayList<String>(newModelCol);
		// ArrayList<String> newElementsModel = new ArrayList<String>();

		// Elementos do modelo em execucao
		oldElementsModel.removeAll(newModelCol);
		int amountOldElements = oldElementsModel.size();

		ArrayList<String> oldElements = new ArrayList<String>();
		for (int index = 0; index < amountOldElements; index++) {
			oldElements.add(oldElementsModel.get(index));
		}

		// Lista de elementos do modelo que se repetem
		ArrayList<String> elementsToBeMaintained = new ArrayList<String>();
		elementsToBeMaintained.addAll(newElementsModel);

		// lista de elementos que deverao ser adicionados
		// para esse lista
		newElementsModel.removeAll(oldModelCol);
		int amountNewElements = newElementsModel.size();
		ArrayList<String> elementsToBeAdded = new ArrayList<String>();
		for (int index = 0; index < amountNewElements; index++) {
			elementsToBeAdded.add(newElementsModel.get(index));
		}

		// elementos do modelo que devem ser mantidos
		elementsToBeMaintained.removeAll(newElementsModel);

		// Lista dos elementos a serem removidos
		ArrayList<String> elementsToBeRemoved = new ArrayList<String>(
				oldElements);
		elementsToBeRemoved.removeAll(elementsToBeAdded);

		// Objeto com elementos que devem ser adicionados, removidos e mantidos
		// no espaco
		// inteligente
		NewModelDescription newModelDescription = new NewModelDescription();
		newModelDescription.setElementsToBeAddeds(elementsToBeAdded);
		newModelDescription.setElementsToBeRemoveds(elementsToBeRemoved);
		newModelDescription.setElementsToBeMaintained(elementsToBeMaintained);

		// envia novo modelo juntamente com newModelDescription
		return newModelDescription;

	} // fim do metodo getNewModelDescription

	/**
	 * Metodo para comparar elementos dos modelos de UserRole
	 * 
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void compareUserRoles() throws IOException, NotBoundException,
			InterruptedException {

		// lista de userTypes
		ArrayList<UserRole> users = new ArrayList<UserRole>();
		users = modelElementReaderUR
				.getUserRoleList("modelprocessing/modelcache/usermodel");

		// lista de uRNewAL no AL de String
		Collection<String> collectionNewModel = new ArrayList<String>();
		// lista de uRNewAL no AL de String
		ArrayList<UserRole> newUserRoleAL = new ArrayList<UserRole>();
		UserRole userRole = null;
		int amountNewModel = users.size();
		for (int indexNM = 0; indexNM < amountNewModel; indexNM++) {
			userRole = new UserRole();
			userRole.setUserRoleName(users.get(indexNM).getUserRoleType());
			userRole.setSuperType(users.get(indexNM).getSuperType());
			// le todos ubiApp
			int amountUA = users.get(indexNM).getUbiAppAL().size();
			for (int indexUA = 0; indexUA < amountUA; indexUA++) {
				userRole.setUbiApp(users.get(indexNM).getUbiAppAL()
						.get(indexUA));
			}

			// ordena todas ubiApps
			Collections.sort(userRole.getUbiAppAL());

			// lista de smartObjects
			ArrayList<String> smartObjects = users.get(indexNM)
					.getSmartObjectNameAL();

			// identifica se o smart object teve uma associacao do tipo canUse
			// ou isOwnerOf
			ModelElementReaderSO modelElementReaderSO = new ModelElementReaderSO();
			int amountSO = smartObjects.size();
			SmartObject smartObject = new SmartObject();
			ArrayList<SmartObject> sObjectCU = new ArrayList<SmartObject>();
			ArrayList<SmartObject> sObjectIoF = new ArrayList<SmartObject>();
			for (int index = 0; index < amountSO; index++) {
				smartObject = modelElementReaderSO.readModelElement(
						smartObjects.get(index),
						"modelprocessing/modelcache/usermodel");
				// separa smartobjects com associacoes canUse e isOwnerOf
				if (smartObject.isCanUse()) { // canUse
					sObjectCU.add(smartObject);
				} else { // isOwnerOf
					sObjectIoF.add(smartObject);
				}
			}

			// smartObjects canUse
			int amountCUSO = sObjectCU.size();
			for (int indexSO = 0; indexSO < amountCUSO; indexSO++) {
				userRole.setSmartObjectName(sObjectCU.get(indexSO)
						.getSmartObjectType());
			}

			Collections.sort(userRole.getSmartObjectNameAL());

			userRole.setAmountCanUse(users.get(indexNM).getAmountCanUse());
			userRole.setAmountIsOwnerOf(users.get(indexNM).getAmountIsOwnerOf());

			newUserRoleAL.add(userRole);

			collectionNewModel.add(users.get(indexNM).getUserRoleType());
		}

		// colecao de UserRoles extraida de MRT
		Collection<String> uRoleCollection = new ArrayList<String>();

		// tabela de elementos de MRT
		uRoleCollection = modelElementReadTable.readUserRoleCol();

		// Objeto com elementos que devem ser adicionados e removidos do espaco
		// inteligente
		NewModelDescription newModelDescription = new NewModelDescription();
		newModelDescription = getNewModel(uRoleCollection, collectionNewModel);

		// verificar se a entidade UserRole sofreu alguma atualizacao quanto as
		// suas associacoes com SmartObjects e UbiApps
		ArrayList<String> elementsToBeMaintained = newModelDescription
				.getElementsToBeMaintained();
		int amount = elementsToBeMaintained.size();
		ModelElementReaderUR modelElementReaderURMRT = new ModelElementReaderUR();
		UserRole userRoleMRT;
		for (int index = 0; index < amount; index++) {
			// comparar modelo em execucao
			userRoleMRT = modelElementReaderURMRT.readModelElement(
					elementsToBeMaintained.get(index),
					"/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/");

			// Ordena ubiApps e smartObjects
			Collections.sort(userRoleMRT.getUbiAppAL());
			Collections.sort(userRoleMRT.getSmartObjectNameAL());

			int amountNewUR = newUserRoleAL.size();
			for (int indexNewUR = 0; indexNewUR < amountNewUR; indexNewUR++) {
				// userRole iguais
				if (newUserRoleAL.get(indexNewUR).getUserRoleType()
						.equals(userRoleMRT.getUserRoleType())) {
					// compara ubiApps e smartObjects
					if (!newUserRoleAL.get(indexNewUR).toString()
							.equals(userRoleMRT.toString())) {
						newModelDescription.setElementsToBeAdded(newUserRoleAL
								.get(indexNewUR).getUserRoleType());
					}
				}
			} // fim do loop
		} // fim do loop

		// atualizar o Type Level MRT
		updateGlobalMRT(newModelDescription, Metatypes.USER_ROLE);

	} // fim do metodo comparatorUserRoles

	/**
	 * Metodo para comparar elementos dos modelos de SmartObjects
	 *
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void compareSmartObjects() throws IOException, NotBoundException,
			InterruptedException {

		// lista de smartObjects de US
		ArrayList<SmartObject> userSmartObjects = new ArrayList<SmartObject>();
		userSmartObjects = modelElementReaderSO
				.getSmartObjectList("modelprocessing/modelcache/usermodel");

		// colecao de smartObjects
		Collection<String> collectionNewModel = new ArrayList<String>();
		int amountSONewModel = userSmartObjects.size();
		for (int indexNew = 0; indexNew < amountSONewModel; indexNew++) {
			collectionNewModel.add(userSmartObjects.get(indexNew)
					.getSmartObjectType());
		}

		// colecao de SmartObjects de M@RT
		Collection<String> sObjectCollection = new ArrayList<String>();
		sObjectCollection = modelElementReadTable.readSmartObjectCol();

		// Objeto com elementos que devem ser adicionados e removidos do espaco
		// inteligente
		NewModelDescription newModelDescription = new NewModelDescription();
		newModelDescription = getNewModel(sObjectCollection, collectionNewModel);

		updateGlobalMRT(newModelDescription, Metatypes.SMART_OBJECT);

	} // fim do metodo comparatorSmartObjects

	/**
	 * Metodo para comparar elementos dos modelos de UbiApp
	 * 
	 * @param engineerModel
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void compareUbiApps() throws IOException, NotBoundException,
			InterruptedException {

		// lista de ubiApp de US
		ArrayList<UbiApp> userUbiApps = new ArrayList<UbiApp>();
		userUbiApps = modelElementReaderUA
				.getUbiAppList("modelprocessing/modelcache/usermodel");

		// colecao de ubiApps
		Collection<String> collectionNewModel = new ArrayList<String>();
		int amountUANewModel = userUbiApps.size();
		for (int indexNew = 0; indexNew < amountUANewModel; indexNew++) {
			collectionNewModel.add(userUbiApps.get(indexNew).getUbiAppType());
		}

		Collection<String> ubiAppCol = new ArrayList<String>();
		ubiAppCol = modelElementReadTable.readUbiAppCol();

		// Objeto com elementos que devem ser adicionados e removidos do espaco
		// inteligente
		NewModelDescription newModelDescription = new NewModelDescription();
		newModelDescription = getNewModel(ubiAppCol, collectionNewModel);

		updateGlobalMRT(newModelDescription, Metatypes.UBI_APP);

	} // fim do metodo comparatorUbiApps

	/**
	 * Metodo para comparar elementos dos modelos de Service
	 * 
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void compareServices() throws IOException, NotBoundException,
			InterruptedException {

		// lista de services de ES
		ArrayList<Service> engineerServices = new ArrayList<Service>();
		engineerServices = modelElementReaderSer
				.getServiceList("modelprocessing/modelcache/engineermodel");

		// lista de services de US
		ArrayList<Service> userServices = new ArrayList<Service>();
		userServices = modelElementReaderSer
				.getServiceList("modelprocessing/modelcache/usermodel");

		// colecao de services
		Collection<String> collectionNewModel = new ArrayList<String>();
		int amountSerEModel = engineerServices.size();
		for (int indexEng = 0; indexEng < amountSerEModel; indexEng++) {
			collectionNewModel.add(engineerServices.get(indexEng)
					.getServiceType());
		}
		int amountSerNewModel = userServices.size();
		for (int indexNew = 0; indexNew < amountSerNewModel; indexNew++) {
			collectionNewModel.add(userServices.get(indexNew).getServiceType());
		}

		// colecao de services
		Collection<String> serviceCollection = new ArrayList<String>();
		serviceCollection = modelElementReadTable.readServiceCol();

		// Objeto com elementos que devem ser adicionados e removidos do espaco
		// inteligente
		NewModelDescription newModelDescription = new NewModelDescription();
		newModelDescription = getNewModel(serviceCollection, collectionNewModel);

		updateGlobalMRT(newModelDescription, Metatypes.SERVICE);

	} // fim do metodo comparatorServices

	/**
	 * 
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void updatePolicies() throws IOException, NotBoundException,
			InterruptedException {

		// lista de policies de ES
		ArrayList<BehPolicy> engineerPolicies = new ArrayList<BehPolicy>();
		engineerPolicies = modelElementReaderBehPol
				.getPolicyList("modelprocessing/modelcache/engineermodel");

		// lista de policies de US
		ArrayList<BehPolicy> userPolicies = new ArrayList<BehPolicy>();
		userPolicies = modelElementReaderBehPol
				.getPolicyList("modelprocessing/modelcache/usermodel");

		// colecao de policies
		Collection<String> collectionNewModel = new ArrayList<String>();
		int amountPolEModel = engineerPolicies.size();
		for (int indexEng = 0; indexEng < amountPolEModel; indexEng++) {
			collectionNewModel.add(engineerPolicies.get(indexEng)
					.getPolicyName());
		}
		int amountPolNewModel = userPolicies.size();
		for (int indexNew = 0; indexNew < amountPolNewModel; indexNew++) {
			collectionNewModel.add(userPolicies.get(indexNew).getPolicyName());
		}

		// colecao de politicas
		Collection<String> policyCollection = new ArrayList<String>();
		policyCollection = modelElementReadTable.readPolicyCol();

		// Objeto com elementos que devem ser adicionados e removidos do espaco
		// inteligente
		NewModelDescription newModelDescription = new NewModelDescription();
		newModelDescription = getNewModel(policyCollection, collectionNewModel);

		updateGlobalMRT(newModelDescription, Metatypes.BEH_POLICY);

	} // fim do metodo updatePolicies

	/**
	 * Metodo para receber novo modelo, e adicionar e remover partes do modelo
	 * que farao e nao farao mais parte do espaco inteligente
	 * 
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void updateGlobalMRT(NewModelDescription nModelDescription,
			String metatypes) throws IOException, NotBoundException,
			InterruptedException {

		// lista de userTypes
		ArrayList<UserRole> users = new ArrayList<UserRole>();
		users = modelElementReaderUR
				.getUserRoleList("modelprocessing/modelcache/usermodel");

		// lista de smartObjects de US
		ArrayList<SmartObject> userSmartObjects = new ArrayList<SmartObject>();
		userSmartObjects = modelElementReaderSO
				.getSmartObjectList("modelprocessing/modelcache/usermodel");

		// lista de ubiApp de US
		ArrayList<UbiApp> userUbiApps = new ArrayList<UbiApp>();
		userUbiApps = modelElementReaderUA
				.getUbiAppList("modelprocessing/modelcache/usermodel");

		// lista de services de US
		ArrayList<Service> userServices = new ArrayList<Service>();
		userServices = modelElementReaderSer
				.getServiceList("modelprocessing/modelcache/usermodel");

		// lista de policies de US
		ArrayList<BehPolicy> userPolicies = new ArrayList<BehPolicy>();
		userPolicies = modelElementReaderBehPol
				.getPolicyList("modelprocessing/modelcache/usermodel");

		String modelType = "/uctwosmiddleware/globalmrt/typelevelmrt/usermodel";

		NewModelDescription newModelDescription = new NewModelDescription();
		ArrayList<String> elements = new ArrayList<String>();
		newModelDescription = nModelDescription;

		int amountNewModelDesc;
		int amountNewModDesc;
		int amountNewModel;

		ModelElementRecorderUR modelElementRecorderUR = new ModelElementRecorderUR();
		ModelElementRecorderSO modelElementRecorderSO = new ModelElementRecorderSO();
		ModelElementRecorderUA modelElementRecorderUA = new ModelElementRecorderUA();
		ModelElementRecorderSer modelElementRecorderSer = new ModelElementRecorderSer();
		ModelElementRecorderBehPol modelElementRecorderBehPol = new ModelElementRecorderBehPol();

		NewModelDescription newModelDescriptionUR = new NewModelDescription();

		// Adiciona os elementos do modelo ao modelo em execucao
		// Remove todos os elementos do modelo em execucao
		switch (metatypes) {
		case "UserRole":

			// Adiciona
			amountNewModel = users.size();
			newModelDescriptionUR = newModelDescription;
			for (int index = 0; index < amountNewModel; index++) {

				amountNewModelDesc = newModelDescription
						.getElementsToBeAddeds().size();
				for (int indexNMD = 0; indexNMD < amountNewModelDesc; indexNMD++) {
					if (users
							.get(index)
							.getUserRoleType()
							.equals(newModelDescription.getElementsToBeAddeds()
									.get(indexNMD))) {
						UserRole userRole = users.get(index);

						// atualiza MRT
						modelElementRecorderUR.saveModelElement(userRole,
								userRole.getUserRoleType(), modelType);

					}
				}

			}

			// lista de elementos para serem adicionados a tabela de elementos
			// do espaco inteligente
			elements.addAll(newModelDescription.getElementsToBeAddeds());
			elements.addAll(newModelDescription.getElementsToBeMaintained());

			// atualiza a tabela de userRole para atualizacao
			updateTable(
					"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/userRoleTypes.txt",
					elements);

			// Remove modelo
			amountNewModDesc = newModelDescription.getElementsToBeRemoveds()
					.size();
			String userType;
			for (int index = 0; index < amountNewModDesc; index++) {
				userType = newModelDescription.getElementsToBeRemoveds().get(
						index);
				removeModel("./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/userrole/"
						+ userType + ".xml");
			}

			break;
		case "SmartObject":

			// Adiciona
			ArrayList<String> sObjectNameAL = new ArrayList<String>();

			// Obtem a lista de smartObjects a serem adicionados ao SmartSpace
			amountNewModel = userSmartObjects.size();
			for (int indexSO = 0; indexSO < amountNewModel; indexSO++) {
				amountNewModelDesc = newModelDescription
						.getElementsToBeAddeds().size();
				for (int indexNMD = 0; indexNMD < amountNewModelDesc; indexNMD++) {
					if (userSmartObjects
							.get(indexSO)
							.getSmartObjectType()
							.equals(newModelDescription.getElementsToBeAddeds()
									.get(indexNMD))) {
						SmartObject smartObject = userSmartObjects.get(indexSO);
						sObjectNameAL.add(smartObject.getSmartObjectType());
					}
				}
			}

			amountNewModel = userSmartObjects.size();
			for (int indexSO = 0; indexSO < amountNewModel; indexSO++) {
				amountNewModelDesc = newModelDescription
						.getElementsToBeAddeds().size();
				for (int indexNMD = 0; indexNMD < amountNewModelDesc; indexNMD++) {
					if (userSmartObjects
							.get(indexSO)
							.getSmartObjectType()
							.equals(newModelDescription.getElementsToBeAddeds()
									.get(indexNMD))) {
						SmartObject smartObject = userSmartObjects.get(indexSO);

						// atualiza MRT de smart object
						modelElementRecorderSO.saveModelElement(smartObject,
								smartObject.getSmartObjectType(), modelType);
						// atualiza MRT de feature
						modelElementRecorderFeat.saveModelElements(
								smartObject.getFeatureAL(), modelType);

					}
				}
			}

			// atualiza tabela contendo todos smartObjects
			// lista de elementos para serem adicionados a tabela de elementos
			// do espaco inteligente
			elements.addAll(newModelDescription.getElementsToBeAddeds());
			elements.addAll(newModelDescription.getElementsToBeMaintained());

			updateTable(
					"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/smartObjectTypes.txt",
					elements);

			// Remove modelo
			amountNewModDesc = newModelDescription.getElementsToBeRemoveds()
					.size();
			for (int index = 0; index < amountNewModDesc; index++) {
				String deviceType = newModelDescription
						.getElementsToBeRemoveds().get(index);
				removeModel("./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/smartobject/"
						+ deviceType + ".xml");
			}
			break;
		case "UbiquitousApplication":

			// Adiciona
			amountNewModel = userUbiApps.size();
			for (int index = 0; index < amountNewModel; index++) {
				amountNewModelDesc = newModelDescription
						.getElementsToBeAddeds().size();
				for (int indexNMD = 0; indexNMD < amountNewModelDesc; indexNMD++) {
					if (userUbiApps
							.get(index)
							.getUbiAppType()
							.equals(newModelDescription.getElementsToBeAddeds()
									.get(indexNMD))) {
						UbiApp ubiApp = userUbiApps.get(index);

						// atualiza MRT
						modelElementRecorderUA.saveModelElement(ubiApp,
								ubiApp.getUbiAppType(), modelType);
					}
				}
			}

			// lista de elementos para serem adicionados a tabela de elementos
			// do espaco inteligente
			elements.addAll(newModelDescription.getElementsToBeAddeds());
			elements.addAll(newModelDescription.getElementsToBeMaintained());
			// atualizar a tabela de userRole para atualizacao
			updateTable(
					"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/ubiAppTypes.txt",
					elements);

			// Remove modelo
			amountNewModDesc = newModelDescription.getElementsToBeRemoveds()
					.size();
			for (int index = 0; index < amountNewModDesc; index++) {
				String appType = newModelDescription.getElementsToBeRemoveds()
						.get(index);
				removeModel("./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/ubiapp/"
						+ appType + ".xml");
			}
			break;
		case "Service":

			// Adiciona
			amountNewModel = userServices.size();
			for (int index = 0; index < amountNewModel; index++) {

				amountNewModelDesc = newModelDescription
						.getElementsToBeAddeds().size();
				for (int indexNMD = 0; indexNMD < amountNewModelDesc; indexNMD++) {
					if (userServices
							.get(index)
							.getServiceType()
							.equals(newModelDescription.getElementsToBeAddeds()
									.get(indexNMD))) {
						Service service = userServices.get(index);
						// atualiza MRT
						modelElementRecorderSer.saveModelElement(service,
								service.getServiceType(), modelType);
					}
				}

			}

			// lista de elementos para serem adicionados a tabela de elementos
			// do espaco inteligente
			elements.addAll(newModelDescription.getElementsToBeAddeds());
			elements.addAll(newModelDescription.getElementsToBeMaintained());
			// atualizar a tabela de userRole para atualizacao
			updateTable(
					"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/serviceTypes.txt",
					elements);

			// Remove modelo
			amountNewModDesc = newModelDescription.getElementsToBeRemoveds()
					.size();
			for (int index = 0; index < amountNewModDesc; index++) {
				String serviceType = newModelDescription
						.getElementsToBeRemoveds().get(index);
				removeModel("./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/service/"
						+ serviceType + ".xml");
			}
			break;
		case "BehavioralPolicy":
			// Adiciona

			amountNewModel = userPolicies.size();
			for (int index = 0; index < amountNewModel; index++) {

				amountNewModelDesc = newModelDescription
						.getElementsToBeAddeds().size();
				for (int indexNMD = 0; indexNMD < amountNewModelDesc; indexNMD++) {
					if (userPolicies
							.get(index)
							.getPolicyName()
							.equals(newModelDescription.getElementsToBeAddeds()
									.get(indexNMD))) {
						BehPolicy behPol = userPolicies.get(index);
						modelElementRecorderBehPol.saveModelElement(behPol,
								behPol.getPolicyName(), modelType);

					}
				}
			}

			// lista de elementos para serem adicionados a tabela de elementos
			// do espaco inteligente
			elements.addAll(newModelDescription.getElementsToBeAddeds());
			elements.addAll(newModelDescription.getElementsToBeMaintained());
			// atualizar a tabela de userRole para atualizacao
			updateTable("./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/policyTypes.txt",
					elements);

			// Remove modelo
			amountNewModDesc = newModelDescription.getElementsToBeRemoveds()
					.size();
			for (int index = 0; index < amountNewModDesc; index++) {
				String policyType = newModelDescription
						.getElementsToBeRemoveds().get(index);
				removeModel("./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/usermodel/smartspace/behavioralpolicy/"
						+ policyType + ".xml");
			}
			break;
		default:
			break;
		}

	} // fim do metodo sendNewModel

	/**
	 * Metodo para remover modelos
	 * 
	 * @param path
	 */
	public void removeModel(String path) {
		File file = null;
		boolean bool = false;
		try {
			// create new file
			file = new File(path);
			// tries to delete a non-existing file
			bool = file.delete();
			// creates file in the system
			file.createNewFile();
			// tries to delete the newly created file
			bool = file.delete();
		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	} // fim do metodo removeModel

	/**
	 * Metodo para atualizar tabelas contento os elementos do ambiente
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void updateTable(String path, ArrayList<String> elements)
			throws IOException {

		// atualiza tabela
		File file = null;
		boolean bool = false;
		try {
			// create new file
			file = new File(path);
			// tries to delete a non-existing file
			bool = file.delete();
			// creates file in the system
			file.createNewFile();
			// tries to delete the newly created file
			// bool = file.delete();
		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}

		int amount = elements.size();
		for (int index = 0; index < amount; index++) {
			// cria nova tabela
			modelRecordTable.saveTable(elements.get(index), path);
		}

	} // fim do metodo updateTable

	public static void main(String args[]) throws IOException,
			NotBoundException, InterruptedException {

		ModelComparator modelComparator = new ModelComparator();
		modelComparator.updatePolicies();

	}

}
