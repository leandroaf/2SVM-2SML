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
	public String readHardwareDatabase() throws IOException {

		String line = "";
		String hwResource = "";

		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/twosbroker/userresourcedatabase/HardwareDatabase.txt"));
			line = in.readLine();
			hwResource = line;
			while (((line = in.readLine()) != null) && (!line.equals(" "))) {
				hwResource = hwResource + "+" + line;
			}

			return hwResource;
		} catch (Exception e) {
			return "Erro na abertura do arquivo";
		}

	} // fim do metodo para ler base de dados
	
	/**
	 * Metodo para ler base de dados
	 * 
	 * @param path
	 * @throws IOException
	 */
	public String readSoftwareDatabase() throws IOException {

		String line = "";
		String hwResource = "";

		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/twosbroker/userresourcedatabase/SoftwareDatabase.txt"));
			line = in.readLine();
			hwResource = line;
			while (((line = in.readLine()) != null) && (!line.equals(" "))) {
				hwResource = hwResource + "+" + line;
			}

			return hwResource;
		} catch (Exception e) {
			return "Erro na abertura do arquivo";
		}

	} // fim do metodo para ler base de dados
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readUserDatabase() throws IOException {

		String line = "";
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/twosbroker/userresourcedatabase/UserDatabase.txt"));
			line = in.readLine();

			return line;
		} catch (Exception e) {
			return "Erro na abertura do arquivo";
		}

	} // fim do metodo para ler base de dados
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readDeviceDatabase() throws IOException {

		String line = "";
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/twosbroker/userresourcedatabase/DeviceDatabase.txt"));
			line = in.readLine();

			return line;
		} catch (Exception e) {
			return "Erro na abertura do arquivo";
		}

	} // fim do metodo para ler base de dados
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readDeviceIPDatabase() throws IOException {

		String line = "";
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							"./src/twosvm/twosbroker/userresourcedatabase/DeviceIPDatabase.txt"));
			line = in.readLine();

			return line;
		} catch (Exception e) {
			return "Erro na abertura do arquivo";
		}

	} // fim do metodo para ler base de dados

	public static void main(String args[]) throws IOException {

		DatabaseReader db = new DatabaseReader();
		System.out.println(db.readHardwareDatabase());

	}

}
