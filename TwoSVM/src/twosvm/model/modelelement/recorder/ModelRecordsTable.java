package twosvm.model.modelelement.recorder;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe responsavel por criar tabelas com Maps de cada um dos tipos definidos
 * no modelo do usuario
 * Estas tabelas serao utilizadas para comparar novos modelos submetidos pelos usuarios
 * com a aqueles modelos em execucao na maquina
 * 
 * @author leandroalexandre
 *
 */
public class ModelRecordsTable {

	/**
	 * 
	 * @param element
	 * @throws IOException
	 */
	public void saveTable(String element, String path) throws IOException {

		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			bw.write(element);

			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Falha ao escrever!");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
				}
			}
		}

	} // fim do metodo recordTable
		
}
