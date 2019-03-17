package twosvm.model.controlschema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;

public class ControlSchemaRecorderUR {

	/**
	 * Grava uma modelos no formato XML 
	 */
	public void recordControlSchema(UserRole userRole, String userRoleName) {

		UserRole uRole = new UserRole();
		uRole = userRole;
		
		XStream xStream = new XStream();
		xStream.alias("userrole", UserRole.class);
		
		File file = new File(
				"./src/twosvm/synthesisengine/repository/userrole/" + userRoleName + ".xml");
	    FileOutputStream record;
	    
	    try {
	    	record = new FileOutputStream(file);
	        record.write(xStream.toXML(uRole).getBytes());
	        record.close();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
		
	}

	
}
