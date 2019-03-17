package twosvm.model.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.models.ModelDescriptionBehEve;
import twosvm.model.models.ModelDescriptionBehPol;
import twosvm.model.models.ModelDescriptionSO;
import twosvm.model.models.ModelDescriptionSer;
import twosvm.model.models.ModelDescriptionUA;
import twosvm.model.models.ModelDescriptionUR;
import twosvm.model.models.ModelDescriptionURoAssociateToSOb;

import com.thoughtworks.xstream.XStream;

public class ModelsRecorder {

	/**
	 * Grava scripts de UserRole
	 * 
	 * @param scriptDescriptionUR
	 * @param scriptType
	 * @param userRoleNameAL
	 */
	public void recordModelUR(ModelDescriptionUR scriptDescriptionUR) {

		ModelDescriptionUR scrDescriptionUR = new ModelDescriptionUR();
		scrDescriptionUR = scriptDescriptionUR;

		String userRoleName = scrDescriptionUR.getScriptName();

		XStream xStream = new XStream();
		xStream.alias("scrDescriptionUR", ModelDescriptionUR.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/userrole/"
						+ userRoleName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scrDescriptionUR).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptUR

	/**
	 * Grava scripts de SmartObject
	 * 
	 * @param scriptDescriptionSO
	 * @param scriptType
	 * @param scriptName
	 */
	public void recordModelSO(ModelDescriptionSO sDescriptionSO) {

		ModelDescriptionSO scriptDescriptionSO = new ModelDescriptionSO();
		scriptDescriptionSO = sDescriptionSO;

		String scriptName = scriptDescriptionSO.getScriptName();

		ModelDescriptionSO scriDescriptionSO = new ModelDescriptionSO();
		scriDescriptionSO = scriptDescriptionSO;

		XStream xStream = new XStream();
		xStream.alias("scriDescriptionSO", ModelDescriptionSO.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/smartobject/"
						+ scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriDescriptionSO).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptSO

	/**
	 * Grava scripts de associacao de UserRole a smartObject
	 * 
	 * @param sDescURoAssSObj
	 * @param scriptType
	 * @param scriptName
	 */
	public void recordModelURoAssociateSOb(
			ModelDescriptionURoAssociateToSOb sDescURoAssSObj,
			String scriptType, String scriptName) {

		ModelDescriptionURoAssociateToSOb scripDescURoAssSO = new ModelDescriptionURoAssociateToSOb();
		scripDescURoAssSO = sDescURoAssSObj;

		XStream xStream = new XStream();
		xStream.alias("scripDescURoAssSO",
				ModelDescriptionURoAssociateToSOb.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/userrole/associatesobj/"
						+ scriptType + "_" + scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scripDescURoAssSO).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptURoAssociateSOb

	/**
	 * Grava scripts de UbiApp
	 * 
	 * @param sDescUbiApp
	 * @param scriptType
	 * @param scriptName
	 */
	public void recordModelUA(ModelDescriptionUA sDescUbiApp) {

		ModelDescriptionUA scriptDescUA = new ModelDescriptionUA();
		scriptDescUA = sDescUbiApp;

		String scriptName = scriptDescUA.getScriptName();

		XStream xStream = new XStream();
		xStream.alias("scriptDescUA", ModelDescriptionSO.class);

		File file = new File("./src/twosvm/uctwosmiddleware/repository/ubiapp/"
				+ scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriptDescUA).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptUA

	/**
	 * Grava scripts de associacao de userRole a ubiApp
	 * 
	 * @param sDescUbiApp
	 * @param scriptType
	 * @param scriptName
	 */
	public void recordScriptURoAssociateUbA(ModelDescriptionUA sDescUbiApp,
			String scriptType, String scriptName) {

		ModelDescriptionUA scriptDescUA = new ModelDescriptionUA();
		scriptDescUA = sDescUbiApp;

		XStream xStream = new XStream();
		xStream.alias("scriptDescUA", ModelDescriptionUA.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/userrole/"
						+ scriptType + "_" + scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriptDescUA).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptURoAssociateUbA

	/**
	 * Grava scripts de Service
	 * 
	 * @param scriptDescriptionSer
	 * @param scriptType
	 * @param serviceName
	 */
	public void recordModelSer(ModelDescriptionSer scriptDescriptionSer) {

		ModelDescriptionSer scriDescriptionSer = new ModelDescriptionSer();
		scriDescriptionSer = scriptDescriptionSer;

		String scriptName = scriDescriptionSer.getScriptName();

		XStream xStream = new XStream();
		xStream.alias("scriDescriptionSer", ModelDescriptionSer.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/service/"
						+ scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriDescriptionSer).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptSer

	/**
	 * 
	 * @param scriptDescriptionBehPol
	 * @param scriptType
	 * @param behPolName
	 */
	public void recordModelBehPol(
			ModelDescriptionBehPol scriptDescriptionBehPol) {

		ModelDescriptionBehPol scriBehPol = new ModelDescriptionBehPol();
		scriBehPol = scriptDescriptionBehPol;

		String scriptName = scriBehPol.getScriptName();

		XStream xStream = new XStream();
		xStream.alias("scriBehPol", ModelDescriptionBehPol.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/behaviourpolicy/"
						+ scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriBehPol).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptBehPol
	
	/**
	 * 
	 * @param sDescriptionBebEve
	 */
	public void recordScriptBehEvent(
			ModelDescriptionBehEve sDescriptionBebEve) {

		ModelDescriptionBehEve scriptDescriptionBebEve = new ModelDescriptionBehEve();
		scriptDescriptionBebEve = sDescriptionBebEve;
		
		String scriptName = scriptDescriptionBebEve.getScriptName();

		XStream xStream = new XStream();
		xStream.alias("scriBehPol", ModelDescriptionBehPol.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/behaviourpolicy/"
						+ scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriptName).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptBehPol
	

}
