package twosvm.modelprocessing.conformancechecking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import twosvm.model.metatypes.Metatypes;
import twosvm.model.modelelement.reader.ModelElementReaderSO;
import twosvm.model.modelelement.reader.ModelElementReaderSer;
import twosvm.model.modelelement.reader.ModelElementReaderUA;
import twosvm.model.modelelement.reader.ModelElementReaderUR;
import Twosml.ControlSchema;
import twosvm.model.userrole.UserRole;

/**
 * Classe responsavel por fazer a checagem de conformidade entre o modelo do ES
 * e do US
 * 
 * @author leandroalexandre
 *
 */
public class ConformanceChecking {

	HashMap<String, String> entitiesModelHM = new HashMap<String, String>();

	/**
	 * 
	 * @param sourceSuperType
	 * @param superTypesTarget
	 * @param constr
	 * @param path
	 */
	public void createEVLRulesCannotAssociationUR(String sourceSuperType,
			ArrayList<String> superTypesTarget, String constr, String path) {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(path, true));

			bw.write("\n// Regra pre-definida");
			bw.write("\n// " + sourceSuperType + ": cria regra");

			bw.write("\ncontext CanUseSO {");
			bw.write("\n	constraint " + constr + "" + sourceSuperType + " {");
			bw.write("\n		check  {");
			String stringExpressions = "";
			// cria lista de superTypes
			int amountSuperTypes = superTypesTarget.size();
			if (amountSuperTypes > 0) {
				stringExpressions += "(self.source.superType = \""
						+ sourceSuperType + "\")";
				for (int indexST = 0; indexST < amountSuperTypes; indexST++) {
					stringExpressions += " and (self.target.superType <> \"";
					stringExpressions += (superTypesTarget.get(indexST) + "\")");
				}
			} else {
				stringExpressions.concat("(self.source.superType = \""
						+ sourceSuperType + "\")");
			}

			String stringIf = "if (" + stringExpressions + ") {";
			bw.write("\n    		" + stringIf);
			bw.write("\n    			 return false;");
			bw.write("\n    		}");
			bw.write("\n    		return true;");
			bw.write("\n    	}");
			bw.write("\n		message : \"Association not permitted! '\"+self.source.superType+ \"' can associate to: "
					+ superTypesTarget.toString() + "\"");
			bw.write("\n		fix {");
			bw.write("\n			title : \"Delete association!\"");
			bw.write("\n			do {");
			bw.write("\n				delete self;");
			bw.write("\n			}");
			bw.write("\n		}");
			bw.write("\n	}");
			bw.write("\n}");

			bw.newLine();
			bw.flush();
			// System.out.println("Restricoes salvas com sucesso!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Falha ao escrever!");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
				}
			}
		}
	} // fim do metodo createEVLRulesCannotAssociationUR

	/**
	 * 
	 * @param sourceSuperType
	 * @param superTypesTarget
	 * @param constr
	 * @param path
	 */
	public void createEVLRulesCannotAssociationUA(String sourceSuperType,
			ArrayList<String> superTypesTarget, String constr, String path) {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(path, true));

			bw.write("\n// Regra pre-definida");
			bw.write("\n// " + sourceSuperType + ": cria regra");

			bw.write("\ncontext CanUseUbiApp {");
			bw.write("\n	constraint " + constr + "" + sourceSuperType + " {");
			bw.write("\n		check  {");
			String stringExpressions = "";
			// cria lista de superTypes
			int amountSuperTypes = superTypesTarget.size();
			if (amountSuperTypes > 0) {
				stringExpressions += "(self.source.superType = \""
						+ sourceSuperType + "\")";
				for (int indexST = 0; indexST < amountSuperTypes; indexST++) {
					stringExpressions += " and (self.target.superType <> \"";
					stringExpressions += (superTypesTarget.get(indexST) + "\")");
				}
			} else {
				stringExpressions.concat("(self.source.superType = \""
						+ sourceSuperType + "\")");
			}

			String stringIf = "if (" + stringExpressions + ") {";
			bw.write("\n    		" + stringIf);
			bw.write("\n    			 return false;");
			bw.write("\n    		}");
			bw.write("\n    		return true;");
			bw.write("\n    	}");
			bw.write("\n		message : \"Association not permitted! '\"+self.source.superType+ \"' can associate to: "
					+ superTypesTarget.toString() + "\"");
			bw.write("\n		fix {");
			bw.write("\n			title : \"Delete association!\"");
			bw.write("\n			do {");
			bw.write("\n				delete self;");
			bw.write("\n			}");
			bw.write("\n		}");
			bw.write("\n	}");
			bw.write("\n}");

			bw.newLine();
			bw.flush();
			// System.out.println("Restricoes salvas com sucesso!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Falha ao escrever!");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
				}
			}
		}
	} // fim do metodo createEVLRulesST

	/**
	 * Metodo regras EVL para SuperTypes
	 * 
	 * @param superTypes
	 */
	public void createEVLRulesSuperTypes(ArrayList<String> superTypes,
			String metaType, String path) {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			bw.write("\n// Regra pre-definida");
			bw.write("\n// "
					+ metaType
					+ ": cria regra para que o US defina seus tipos com base naqueles definidos no modelo do ES");

			bw.write("\ncontext " + metaType + " {");
			bw.write("\n	constraint HasSuperType {");
			bw.write("\n		check  {");
			String stringExpressions = "";
			// cria lista de superTypes
			int amountSuperTypes = superTypes.size();
			if (amountSuperTypes > 0) {
				stringExpressions += "(self.superType <> \""
						+ superTypes.get(0) + "\")";
				for (int indexST = 1; indexST < amountSuperTypes; indexST++) {
					stringExpressions += " and (self.superType <> \"";
					stringExpressions += (superTypes.get(indexST) + "\")");
				}
			} else {
				stringExpressions.concat(superTypes.get(0));
			}

			String stringIf = "if (" + stringExpressions + ") {";
			bw.write("\n    		" + stringIf);
			bw.write("\n    			 return false;");
			bw.write("\n    		}");
			bw.write("\n    		return true;");
			bw.write("\n    	}");
			bw.write("\n		message : \" Supertype not found! Supertypes available: "
					+ superTypes.toString() + "\"");
			bw.write("\n		fix {");
			bw.write("\n			title : \"Supertype not found!\"");
			bw.write("\n			do {");
			bw.write("\n				delete self;");
			bw.write("\n			}");
			bw.write("\n		}");
			bw.write("\n	}");
			bw.write("\n}");

			bw.newLine();
			bw.flush();
			// System.out.println("Restricoes salvas com sucesso!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Falha ao escrever!");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
				}
			}
		}
	} // fim do metodo createEVLRulesST

	/**
	 * Metodo regras EVL para SuperTypes
	 * 
	 * @param superTypes
	 */
	public void createEVLRulesMakeAssociation(int am, String tp,
			List<String> ent, String path) {

		int amount = am;
		String type = tp;
		List<String> entities = ent;

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			bw.write("\n \\\\ UserRole: cria regra para garantir associacao");

			bw.write("\ncontext UserRole {");
			bw.write("\n	constraint MakeAssociation {");
			bw.write("\n		check  {");
			bw.write("\n    		var amount = " + amount + ";");
			bw.write("\n    		if ( (self.superType = \"" + type
					+ "\") and (self.cuSO_UR.size <= amount) ) {");
			bw.write("\n    			 return false;");
			bw.write("\n    		}");
			bw.write("\n    		return true;");
			bw.write("\n    	}");
			bw.write("\n		message : \"Make all associations of '\"+self.name+\"' with: "
					+ entities.toString() + "\"");
			bw.write("\n		fix {");
			bw.write("\n			title : \"Make an association!\"");
			bw.write("\n			do {");
			bw.write("\n				delete self;");
			bw.write("\n			}");
			bw.write("\n		}");
			bw.write("\n	}");
			bw.write("\n}");

			bw.newLine();
			bw.flush();
			// System.out.println("Restricoes salvas com sucesso!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Falha ao escrever!");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
				}
			}
		}
	} // fim do metodo createEVLRulesMakeAssociation

	/**
	 * Recebe um modelo como entrada e retorna os supertipos dele
	 * 
	 * @param model
	 * @param userModel
	 * @param objectType
	 * @return
	 */
	public ArrayList<String> objectsList(String objectType, String modelType) {

		ArrayList<String> superTypes = new ArrayList<String>();

		switch (objectType) {
		case ("UserRole"):

			ModelElementReaderUR modelElementReaderUR = new ModelElementReaderUR();
			ArrayList<String> users = new ArrayList<String>();
			users = modelElementReaderUR.createUserRoleList(modelType);

			int amountUR = users.size();
			for (int index = 1; index < amountUR; index++) {
				superTypes.add(modelElementReaderUR.readModelElement(
						users.get(index), modelType).getSuperType());
			}

			break;
		case ("SmartObject"):

			ModelElementReaderSO modelElementReaderSO = new ModelElementReaderSO();
			ArrayList<String> smartObjects = new ArrayList<String>();
			smartObjects = modelElementReaderSO.createSmartObjectList(modelType);
			
			int amountSO = smartObjects.size();
			for (int index = 0; index < amountSO; index++) {
				superTypes.add(modelElementReaderSO.readModelElement(
						smartObjects.get(index), modelType).getSuperType());
			}

			break;

		case ("UbiquitousApplication"):

			ModelElementReaderUA modelElementReaderUA = new ModelElementReaderUA();
			ArrayList<String> ubiApps = new ArrayList<String>();
			ubiApps = modelElementReaderUA.createUbiAppList(modelType);

			int amountUA = ubiApps.size();
			for (int index = 0; index < amountUA; index++) {
				superTypes.add(modelElementReaderUA.readModelElement(
						ubiApps.get(index), modelType).getSuperType());
			}

			break;

		case ("Service"):

			ModelElementReaderSer modelElementReaderSer = new ModelElementReaderSer();
			ArrayList<String> services = new ArrayList<String>();
			services = modelElementReaderSer.createServiceList(modelType);

			int amountSer = services.size();
			for (int index = 0; index < amountSer; index++) {
				superTypes.add(modelElementReaderSer.readModelElement(
						services.get(index), modelType).getSuperType());
			}

			break;

		default:
			break;
		}

		return superTypes;

	} // fim do metodo objectsList

	/**
	 * Obtem a lista de nomes UbiApps associados a determinado UserRole
	 * 
	 * @param model
	 * @param sType
	 * @return
	 */
	public ArrayList<String> getUbiAppFromUserRole(ControlSchema model,
			String sType) {

		String superType = sType;

		ArrayList<String> uAppsNames = new ArrayList<String>();

		// lista de userRoles
		EList<Twosml.UserRole> uRoleModel = model.getCsUserRole();

		int amountUR = uRoleModel.size();
		for (int indexUR = 0; indexUR < amountUR; indexUR++) {
			if (superType.equals(uRoleModel.get(indexUR).getName())) {
				int amountUA = uRoleModel.get(indexUR).getCuUA_UR().size();
				for (int indexUA = 0; indexUA < amountUA; indexUA++) {
					uAppsNames.add(uRoleModel.get(indexUR).getCuUA_UR()
							.get(indexUA).getTarget().getName());
				}
			}
		}

		return uAppsNames;

	} // fim do metodo getSmartObjectFromUserRole

	/**
	 * Obtem a lista de nomes SmartObjects associados a determinado UserRole
	 * 
	 * @param model
	 * @return
	 */
	public ArrayList<String> getSmartObjectFromUserRole(ControlSchema model,
			String sType) {

		String superType = sType;

		ArrayList<String> sObjectsNames = new ArrayList<String>();

		// lista de userRoles
		EList<Twosml.UserRole> uRoleModel = model.getCsUserRole();

		int amountUR = uRoleModel.size();
		for (int indexUR = 0; indexUR < amountUR; indexUR++) {
			if (superType.equals(uRoleModel.get(indexUR).getName())) {
				int amountSO = uRoleModel.get(indexUR).getCuSO_UR().size();
				for (int indexSO = 0; indexSO < amountSO; indexSO++) {
					sObjectsNames.add(uRoleModel.get(indexUR).getCuSO_UR()
							.get(indexSO).getTarget().getName());
				}
			}
		}

		return sObjectsNames;

	} // fim do metodo getSmartObjectFromUserRole

	/**
	 * 
	 * @param modelPath
	 * @param evlPath
	 */
	public void checkConformance() {

		// Caminho das regras EVL
		String evlPath = "/mnt/hgfs/Dropbox/PhD/workspace-Epsilon/twosml.validation/validation/twosml.evl";

		String modelType = "modelprocessing/modelcache/usermodel";
		
		// Obtem a lista de todos os UserRoles do modelo do ES
		ArrayList<String> userRoles = objectsList(Metatypes.USER_ROLE, modelType);

		// Obtem a lista de todos os SmartObjects do modelo do ES
		ArrayList<String> smartObjects = objectsList(Metatypes.SMART_OBJECT, modelType);

		// Obtem a lista de todos os UbiApps do modelo do ES
		ArrayList<String> ubiApps = objectsList(Metatypes.UBI_APP, modelType);

		// Obtem a lista de todos os Services do modelo do ES
		ArrayList<String> services = objectsList(Metatypes.SERVICE, modelType);

		// Todas essas regras sao criadas a partir do modelo do ES, fazendo uma
		// verificacao ao tipos definidos nele

		// Cria mecanismo de checagem para ver se foram definidos os
		// supertipos para UserRole no modelo do US
		if (userRoles.size() > 0) {
			createEVLRulesSuperTypes(userRoles, Metatypes.USER_ROLE, evlPath);
		}

		// Cria mecanismo de checagem para ver se foram definidos os
		// supertipos para SmartObject no modelo do US
		if (smartObjects.size() > 0) {
			createEVLRulesSuperTypes(smartObjects, Metatypes.SMART_OBJECT,
					evlPath);
		}

		// Cria mecanismo de checagem para ver se foram definidos os
		// supertipos para UbiApp no modelo do US
		if (ubiApps.size() > 0) {
			createEVLRulesSuperTypes(ubiApps, Metatypes.UBI_APP, evlPath);
		}

		// Cria mecanismo de checagem para ver se foram definidos os
		// supertipos para Service no modelo do US
		if (services.size() > 0) {
			createEVLRulesSuperTypes(services, Metatypes.SERVICE, evlPath);
		}

	} // fim do metodo complianceChecking

}
