package twosvm.model.controlschema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.smartspace.SmartSpace;

import com.thoughtworks.xstream.XStream;

public class ControlSchemaRecorderSS {
	
	/**
	 * Grava uma modelos no formato XML 
	 */
	public void recordControlSchema(SmartSpace smartSpaceTable, String smartSpaceName) {

		SmartSpace sSpaceTable = new SmartSpace();
		sSpaceTable = smartSpaceTable;
		
		XStream xStream = new XStream();
		xStream.alias("smartspace", SmartSpace.class);
		
		File file = new File("./src/twosvm/synthesisengine/repository/smartspace/" +smartSpaceName+ ".xml");
	    FileOutputStream record;
	    
	    try {
	    	record = new FileOutputStream(file);
	        record.write(xStream.toXML(sSpaceTable).getBytes());
	        record.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
		
	}

}
