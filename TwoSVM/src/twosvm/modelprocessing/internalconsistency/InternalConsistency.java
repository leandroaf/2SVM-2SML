package twosvm.modelprocessing.internalconsistency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import twosvm.model.modelelement.reader.ModelElementReaderBehPol;
import twosvm.model.modelelement.reader.ModelElementReaderSO;
import twosvm.model.modelelement.reader.ModelElementReaderSer;
import twosvm.model.modelelement.reader.ModelElementReaderUA;
import twosvm.model.modelelement.reader.ModelElementReaderUR;

public class InternalConsistency {

	HashMap<String, String> entitiesModelHM = new HashMap<String, String>();

	/**
	 * Obtem todos os userRole do modelo
	 */
	public void getUserRoleHM(String modelType) {
		ModelElementReaderUR modelElementReaderUR = new ModelElementReaderUR();
		entitiesModelHM.putAll(modelElementReaderUR.createUserRoleMap(modelType));
	} // fim do metodo getUserRoleHM

	/**
	 * Obtem todos os smartObjects do modelo
	 * 
	 * @param model
	 */
	public void getSmartObjectHM(String modelType) {
		ModelElementReaderSO modelElementReaderSO = new ModelElementReaderSO();
		entitiesModelHM.putAll(modelElementReaderSO.createSmartObjectMap(modelType));
	} // fim do metodo getSmartObjectHM

	/**
	 * Obtem todas as ubiApps do modelo
	 */
	public void getUbiAppHM(String modelType) {
		ModelElementReaderUA modelElementReaderUA = new ModelElementReaderUA();
		entitiesModelHM.putAll(modelElementReaderUA.createUbiAppMap(modelType));
	} // fim do metodo getUbiAppHM

	/**
	 * Obtem todos os services do modelo
	 */
	public void getServiceHM(String modelType) {
		ModelElementReaderSer modelElementReaderSer = new ModelElementReaderSer();
		entitiesModelHM = modelElementReaderSer.createServiceMap(modelType);
	} // fim do metodo getServiceHM

	/**
	 * Metodo checkConsistency
	 * 
	 * @param modelType
	 */
	public ArrayList<String> checkConsistency(String modelType) {

		ArrayList<String> errors = new ArrayList<String>();

		ModelElementReaderBehPol modelElementReaderBehPol = new ModelElementReaderBehPol();
		ArrayList<String> policyConditions = new ArrayList<String>();
		policyConditions = modelElementReaderBehPol.getConditionList(modelType);

		// extrai as expressoes da condicao
		ArrayList<String> conditions = new ArrayList<String>();
		int amountPolicies = policyConditions.size();
		for (int index = 0; index < amountPolicies; index++) {
			conditions = checkPolicy(policyConditions.get(index));
		}

		// identifica todos os elementos do modelo
		getUserRoleHM(modelType);
		getSmartObjectHM(modelType);
		getUbiAppHM(modelType);

		int amountCondition = conditions.size();
		for (int index = 0; index < amountCondition; index++) {
			if (!entitiesModelHM.containsKey(conditions.get(index))) {
				errors.add(conditions.get(index));
				System.out.println("O elemento " + conditions.get(index)
						+ " nao existe no modelo!\n Corrija a politica!");
			}
		}
		return errors;

	}// fim do metodo checkConsistency

	/**
	 * Extrai as entidades usadas na condicoes
	 * 
	 * @param condition
	 */
	public ArrayList<String> checkPolicy(String condition) {

		ArrayList<String> condiciontEntities = new ArrayList<String>();

		StringTokenizer sTokenizer = new StringTokenizer(condition);
		String tempString;

		while (sTokenizer.hasMoreTokens()) {
			tempString = sTokenizer.nextToken().toString();
			if (tempString.substring(0, 1).equals("\"")) {
				condiciontEntities
						.add(tempString.substring(tempString.indexOf("\"") + 1,
								tempString.indexOf("\")")));

			}
		}
		return condiciontEntities;
	} // fim do metodo checkingPolicy
	
}
