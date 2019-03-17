package twosvm.model.modelelement.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ModelElementReadTable {

	/**
	 * 
	 * @param uName
	 * @return
	 * @throws IOException
	 */
	public Collection<String> readUserRoleCol() throws IOException {

		Collection<String> uRoleCollection = new ArrayList<String>();

		String line = "";

		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/userRoleTypes.txt"));

			// loop para obter todos os papeis do usuario
			while ((line = in.readLine()) != null) {
				uRoleCollection.add(line);
			}
			return uRoleCollection;
		} catch (Exception e) {
			return null;
		}

	} // fim do metodo readUserRoleCol

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public Collection<String> readUbiAppCol() throws IOException {

		String line = "";
		Collection<String> uAppCollection = new ArrayList<String>();

		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/ubiAppTypes.txt"));

			// loop para obter todos as aplicacoes ubiquas
			while ((line = in.readLine()) != null) {
				uAppCollection.add(line);
			}
			return uAppCollection;
		} catch (Exception e) {
			return null;
		}

	} // fim do metodo readUbiAppCol

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public Collection<String> readSmartObjectCol() throws IOException {

		String line = "";
		Collection<String> sObjectCollection = new ArrayList<String>();

		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/smartObjectTypes.txt"));

			// loop para obter todos os smart objects
			while ((line = in.readLine()) != null) {
				sObjectCollection.add(line);
			}
			return sObjectCollection;
		} catch (Exception e) {
			return null;
		}

	} // fim do metodo readSmartObjectCol

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public Collection<String> readServiceCol() throws IOException {

		String line = "";
		Collection<String> serviceCollection = new ArrayList<String>();

		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/serviceTypes.txt"));

			// loop para obter todos os servicos
			while ((line = in.readLine()) != null) {
				serviceCollection.add(line);
			}
			return serviceCollection;
		} catch (Exception e) {
			return null;
		}

	} // fim do metodo readPolicyCol

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public Collection<String> readPolicyCol() throws IOException {

		String line = "";
		Collection<String> policyCollection = new ArrayList<String>();

		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/uctwosmiddleware/globalmrt/typelevelmrt/table/policyTypes.txt"));

			// loop para obter todos as politicas
			while ((line = in.readLine()) != null) {
				policyCollection.add(line);
			}
			return policyCollection;
		} catch (Exception e) {
			return null;
		}

	} // fim do metodo readPolicyCol

}
