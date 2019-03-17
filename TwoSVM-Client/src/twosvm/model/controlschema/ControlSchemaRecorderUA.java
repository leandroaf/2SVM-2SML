package twosvm.model.controlschema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.ubiapp.UbiApp;

import com.thoughtworks.xstream.XStream;

public class ControlSchemaRecorderUA {
	
	/**
	 * Grava uma modelos no formato XML 
	 */
	public void recordControlSchema(UbiApp ubiApp, String ubiAppName) {

		UbiApp uApp = new UbiApp();
		uApp = ubiApp;
		
		XStream xStream = new XStream();
		xStream.alias("ubiapp", UbiApp.class);
		
		File file = new File("./src/twosvm/synthesisengine/repository/ubiapp/" +ubiAppName+ ".xml");
	    FileOutputStream record;
	    
	    try {
	    	record = new FileOutputStream(file);
	        record.write(xStream.toXML(uApp).getBytes());
	        record.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
		
	}

}
