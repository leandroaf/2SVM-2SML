package twosvm.model.modelelement.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.userrole.UserRole;

import com.thoughtworks.xstream.XStream;

public class ModelElementRecorderUR {

	/**
	 * Grava elemento do modelo UserRole
	 */
	public void saveModelElement(UserRole userRole, String userRoleType,
			String modelType) {

		UserRole uRole = new UserRole();
		uRole = userRole;

		XStream xStream = new XStream();
		xStream.alias("userrole", UserRole.class);

		File file = new File("./src/twosvm/"
				+ modelType + "/userrole/" + userRoleType + ".xml");
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
