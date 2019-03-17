package twosvm.twosbroker.usermanager;

import java.io.IOException;

import twosvm.model.database.DatabaseWriter;
import twosvm.twosbroker.adapter.Adapter;

public class UserManager {
	
	private static UserManager instance = null;
	
	Adapter adapter = new Adapter();

	/**
	 * Construtor
	 */
	public UserManager() {
	}

	/**
	 * 
	 * @return
	 */
	public static UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	public void startUserManager() throws IOException {
		String userName = adapter.queryUserData();
		DatabaseWriter databaseWriter = new DatabaseWriter();
		databaseWriter.writeUserDatabase(userName);
	} // fim do metodo startUserManager

}
