package twosvm.model.database;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseGenerator {

	/**
	 * Metodo para criar arquivo contendo papeis do usuario e usuarios
	 * correspondentes
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void dBaseGenerator(String path) throws IOException {

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String text = "father: Alexandre Alves\n"
				+ "mother: Maria Alves Oliveira\n"
				+ "children: Lucas Alves Oliveira\n"
				+ "children: Fernanda Alves Oliveira\n";
		buffWrite.append(text + "\n");
		buffWrite.close();

		System.out.println("Base de dados criada com sucesso!");

	} // fim do metodo para criar arquivo contendo papeis do usuario e usuarios
		// correspondentes

	/**
	 * Metodo main
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		DatabaseGenerator dBDatabaseGenerator = new DatabaseGenerator();

		String path = "./src/twosvm/uctwosmiddleware/database/database.txt";

		dBDatabaseGenerator.dBaseGenerator(path);

	} // fim do metodo main

}
