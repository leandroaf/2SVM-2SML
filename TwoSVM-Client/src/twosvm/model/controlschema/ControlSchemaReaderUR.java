package twosvm.model.controlschema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ControlSchemaReaderUR {

	public UserRole readControlSchemaUR(String uRoleName) {

		UserRole userRole = new UserRole();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(uRoleName, UserRole.class);
			xStream.processAnnotations(UserRole.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/synthesisengine/repository/userrole/"
							+ uRoleName));
			userRole = (UserRole) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return userRole;

	}

}
