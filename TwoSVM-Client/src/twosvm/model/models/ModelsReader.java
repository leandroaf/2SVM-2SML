package twosvm.model.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.models.ModelDescriptionBehPol;
import twosvm.model.models.ModelDescriptionSO;
import twosvm.model.models.ModelDescriptionUA;
import twosvm.model.models.ModelDescriptionUR;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class ModelsReader {

	/**
	 * Metodo para ler scripts do tipo SmartObject
	 * 
	 * @return
	 */
	public ModelDescriptionSO readSmartObjectScript(String scriptType) {

		ModelDescriptionSO sDescriptionSO = new ModelDescriptionSO();
		
		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(scriptType, ModelDescriptionSO.class);
			xStream.processAnnotations(ModelDescriptionSO.class);
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/repository/smartobject/"
							+ scriptType));
			
			sDescriptionSO = (ModelDescriptionSO) xStream
					.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return sDescriptionSO;

	} // fim do metodo readSmartObjectScript

	/**
	 * Metodo para ler scripts do tipo UserRole
	 * 
	 * @return
	 */
	public ModelDescriptionUR readUserRoleScript(String scriptType) {

		ModelDescriptionUR sDescriptionUR = new ModelDescriptionUR();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(scriptType, ModelDescriptionUR.class);
			xStream.processAnnotations(ModelDescriptionUR.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/repository/userrole/"
							+ scriptType));
			
			sDescriptionUR = (ModelDescriptionUR) xStream
					.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return sDescriptionUR;

	} // fim do metodo readUserRoleScript
	
	/**
	 * 
	 * @param scriptType
	 * @return
	 */
	public ModelDescriptionBehPol readBehPolScript(String scriptType) {

		ModelDescriptionBehPol sDescriptionBehPol = new ModelDescriptionBehPol();
	

		try {
			
			XStream xStream = new XStream(new Dom4JDriver());
			
			xStream.alias(scriptType, ModelDescriptionBehPol.class);
			xStream.processAnnotations(ModelDescriptionBehPol.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/repository/behaviourpolicy/"
							+ scriptType));
			
			sDescriptionBehPol = (ModelDescriptionBehPol) xStream
					.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return sDescriptionBehPol;

	} // fim do metodo readBehPolScript
	
	/**
	 * 
	 * @param scriptType
	 * @return
	 */
	public ModelDescriptionUA readUbiAppScript(String scriptType) {

		ModelDescriptionUA sDescriptionUA = new ModelDescriptionUA();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(scriptType, ModelDescriptionUA.class);
			xStream.processAnnotations(ModelDescriptionUA.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/repository/ubiapp/"
							+ scriptType));
			
			sDescriptionUA = (ModelDescriptionUA) xStream
					.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return sDescriptionUA;

	} // fim do metodo readUbiAppScript
	
}
