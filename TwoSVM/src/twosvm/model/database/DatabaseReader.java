package twosvm.model.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.database.DatabaseReader;

public class DatabaseReader {

	/**
	 * Metodo para ler base de dados
	 * 
	 * @param path
	 * @throws IOException
	 */
	public String dBaseReader(String uName) throws IOException {

		// User user = new User();
		// user = us;
		String userName = uName;
		String line = "";
		String strUserRole = "";

		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/database/database.txt"));
			
			while ((line = in.readLine()) != null) {
				if (line.contains(userName)) {
					// extrair papel do usuario
					strUserRole = line.substring(0, line.indexOf(":"));
					// retorna papel do usuario
					return strUserRole;
				}
			}
			
			return "guest";
		} catch (Exception e) {
			return "Erro na abertura do arquivo";
		}

	} // fim do metodo para ler base de dados

	/**
	 * Metodo main
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		DatabaseReader dbDatabaseReader = new DatabaseReader();
		System.out
				.println(dbDatabaseReader.dBaseReader("Lucas Alves Oliveira"));

	}

}
