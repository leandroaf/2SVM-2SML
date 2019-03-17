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

public class ModelRecorder {

	/**
	 * 
	 * @param sDescriptionSS
	 * @param scriptType
	 * @param smartSpaceName
	 */
	public void recordModelSS(ModelDescriptionSS sDescriptionSS,
			String scriptType, String smartSpaceName) {

		ModelDescriptionSS scriptDescriptionSS = new ModelDescriptionSS();
		scriptDescriptionSS = sDescriptionSS;
		
		sDescriptionSS.setCommandName(scriptType + "_" + smartSpaceName);

		XStream xStream = new XStream();
		xStream.alias("scrDescriptionSS", ModelDescriptionSS.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/smartspace/"
						+ scriptType + "_" + smartSpaceName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriptDescriptionSS).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptSS
	
	/**
	 * Grava scripts de UserRole
	 * 
	 * @param sDescriptionUR
	 * @param scriptType
	 * @param userRoleName
	 */
	public void recordModelUR(ModelDescriptionUR sDescriptionUR,
			String scriptType, String userRoleName) {

		ModelDescriptionUR scriptDescriptionUR = new ModelDescriptionUR();
		scriptDescriptionUR = sDescriptionUR;
		sDescriptionUR.setScriptName(scriptType + "_" + userRoleName);

		XStream xStream = new XStream();
		xStream.alias("scrDescriptionUR", ModelDescriptionUR.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/userrole/"
						+ scriptType + "_" + userRoleName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriptDescriptionUR).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptUR

	/**
	 * Grava scripts de SmartObject
	 * 
	 * @param sDescriptionSO
	 * @param scriptType
	 * @param scriptName
	 */
	public void recordModelSO(ModelDescriptionSO sDescriptionSO,
			String scriptType, String scriptName) {
		
		ModelDescriptionSO scriptDescriptionSO = new ModelDescriptionSO();
		scriptDescriptionSO = sDescriptionSO;
		scriptDescriptionSO.setScriptName(scriptType + "_" + scriptName);

		XStream xStream = new XStream();
		xStream.alias("scriDescriptionSO", ModelDescriptionSO.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/smartobject/"
						+ scriptType + "_" + scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriptDescriptionSO).getBytes());
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
	public void recordScriptURoAssociateSOb(
			ModelDescriptionURoAssociateToSOb sDescURoAssSObj,
			String scriptType, String scriptName) {

		ModelDescriptionURoAssociateToSOb scriptDescURoAssSO = new ModelDescriptionURoAssociateToSOb();
		scriptDescURoAssSO = sDescURoAssSObj;
		scriptDescURoAssSO.setSmartObjectName(scriptType + "_" + scriptName);

		XStream xStream = new XStream();
		xStream.alias("scripDescURoAssSO",
				ModelDescriptionURoAssociateToSOb.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/userrole/associatesobj/"
						+ scriptType + "_" + scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriptDescURoAssSO).getBytes());
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
	public void recordModelUA(ModelDescriptionUA scriptDescriptionUA,
			String scriptType, String scriptName) {
		
		ModelDescriptionUA scriDescriptionUA = new ModelDescriptionUA();
		scriDescriptionUA = scriptDescriptionUA;
		scriptDescriptionUA.setScriptName(scriptType + "_" + scriptName);

		XStream xStream = new XStream();
		xStream.alias("scriDescriptionUA", ModelDescriptionSer.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/ubiapp/"
						+ scriptType + "_" + scriptName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriDescriptionUA).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordScriptSer

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
		
		scriptDescUA.setScriptName(scriptType + "_" + scriptName);

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
	 * @param scriptName
	 */
	public void recordModelSer(ModelDescriptionSer scriptDescriptionSer,
			String scriptType, String scriptName) {

		ModelDescriptionSer scriDescriptionSer = new ModelDescriptionSer();
		scriDescriptionSer = scriptDescriptionSer;
		
		scriDescriptionSer.setScriptName(scriptType + "_" + scriptName);

		XStream xStream = new XStream();
		xStream.alias("scriDescriptionSer", ModelDescriptionSer.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/service/"
						+ scriptType + "_" + scriptName);
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
			ModelDescriptionBehPol scriptDescriptionBehPol, String scriptType,
			String behPolName) {

		ModelDescriptionBehPol scriBehPol = new ModelDescriptionBehPol();
		scriBehPol = scriptDescriptionBehPol;

		XStream xStream = new XStream();
		xStream.alias("scriBehPol", ModelDescriptionBehPol.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/behavioralpolicy/"
						+ scriptType + "_" + behPolName);
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
	 * @param sDescriptionBehEve
	 * @param sType
	 * @param sName
	 */
	public void recordScriptBehEve(ModelDescriptionBehEve sDescriptionBehEve,
			String sType, String sName) {
		
		ModelDescriptionBehEve scriBehEve = new ModelDescriptionBehEve();
		scriBehEve = sDescriptionBehEve;
		
		XStream xStream = new XStream();
		xStream.alias("scriBehEve", ModelDescriptionBehPol.class);

		File file = new File(
				"./src/twosvm/uctwosmiddleware/repository/behaviouralpolicy/behaviouralevent/"
						+ sType + "_" + sName);
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(scriBehEve).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	} // fim do metodo recordScriptBehEve

}
