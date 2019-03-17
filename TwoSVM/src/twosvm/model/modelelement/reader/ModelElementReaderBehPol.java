package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import twosvm.model.behavioralpolicy.BehPolicy;
import twosvm.model.service.Service;
import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;
import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ModelElementReaderBehPol {

	/**
	 * Metodo para ler ControlSchemaBehPol
	 * 
	 * @param behPolicyName
	 * @return
	 */
	public BehPolicy readModelElement(String behPolicyName, String modelType) {

		BehPolicy behPolicy = new BehPolicy();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(behPolicyName, BehPolicy.class);
			xStream.processAnnotations(BehPolicy.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/" + modelType
							+ "/behaviouralpolicy/" + behPolicyName));
			behPolicy = (BehPolicy) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return behPolicy;
	} // fim do metodo readModelElement

	/**
	 * Metodo que cria lista de tipos de policies
	 * 
	 * @return
	 */
	public ArrayList<String> createPolicyList(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/behaviouralpolicy/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> policyList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				policyList.add(listOfFiles[i].getName().replace(".xml", ""));
			}
		}

		return policyList;

	} // fim do metodo createPolicyList

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getConditionList(String modelType) {
		
		File folder = new File("./src/twosvm/"
				+ modelType + "/behaviouralpolicy/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<String> policyList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				policyList.add(listOfFiles[i].getName());
			}
		}

		ArrayList<String> conditions = new ArrayList<String>();

		for (int i = 0; i < policyList.size(); i++) {
			conditions.add(readModelElement(policyList.get(i), modelType)
					.getBehCondition().getDescription());
		}

		return conditions;

	} // fim do metodo getConditionList

	/**
	 * 
	 * @param modelType
	 * @return
	 */
	public ArrayList<BehPolicy> getPolicyList(String modelType) {

		File folder = new File("./src/twosvm/"
				+ modelType + "/behaviouralpolicy/");

		File[] listOfFiles = folder.listFiles();

		ArrayList<BehPolicy> policies = new ArrayList<BehPolicy>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].getName().equals(".DS_Store")
					&& listOfFiles[i].isFile()) {
				policies.add(readModelElement(
						listOfFiles[i].getName(), modelType));
			}
		}

		return policies;
	
	} // fim do metodo getPolicyList

	public static void main(String args[]) {

		ModelElementReaderBehPol modelElementReaderBehPol = new ModelElementReaderBehPol();

		System.out.println(modelElementReaderBehPol.getConditionList(""));

	}

}
