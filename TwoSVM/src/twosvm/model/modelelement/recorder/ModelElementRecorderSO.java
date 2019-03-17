package twosvm.model.modelelement.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.smartobject.SmartObject;
import twosvm.model.ubiapp.UbiApp;

import com.thoughtworks.xstream.XStream;

public class ModelElementRecorderSO {
	
	/**
	 * Grava uma modelos no formato XML 
	 */
	public void saveModelElement(SmartObject smartObject, String smartObjectType, String modelType) {

		SmartObject sObject = new SmartObject();
		sObject = smartObject;
		
		XStream xStream = new XStream();
		xStream.alias("smartobject", SmartObject.class);
		
		File file = new File("./src/twosvm/" +modelType+ "/smartobject/" +smartObjectType+ ".xml");
	    FileOutputStream record;
	    
	    try {
	    	record = new FileOutputStream(file);
	        record.write(xStream.toXML(sObject).getBytes());
	        record.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
		
	}

}
