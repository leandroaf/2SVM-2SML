package twosvm.modelprocessing.facade;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import twosvm.model.manipulatorlanguage.ModelsList;
import twosvm.modelprocessing.conformancechecking.ConformanceChecking;
import twosvm.modelprocessing.internalconsistency.InternalConsistency;
import twosvm.modelprocessing.modelcomparator.ModelComparator;
import twosvm.modelprocessing.modelparser.ModelParser;
import Twosml.ControlSchema;

public class Facade {

	private static Facade instance = null;

	private ModelParser modelParser = new ModelParser();
	private InternalConsistency internalConsistency = new InternalConsistency();
	private ConformanceChecking conformanceChecking = new ConformanceChecking();
	private ModelComparator modelComparator = new ModelComparator();

	public Facade() {
	}

	/**
	 * 
	 * @return
	 */
	public static Facade getInstance() {
		if (instance == null) {
			instance = new Facade();
		}
		return instance;
	}

	/**
	 * Metodo checkModel
	 * 
	 * @param controlSchema
	 * @throws IOException
	 * @throws NotBoundException
	 * @throws InterruptedException
	 */
	public void checkModel(ControlSchema model, String modelType)
			throws IOException, NotBoundException, InterruptedException {

		// Se o modelo do usuario do sistema estiver consistente, chame
		// Conformance Checking
		ArrayList<String> errors = new ArrayList<String>();
		if (modelType.equals("engineerModel")) {
			System.out.println("|----------------- Modelo do Engenheiro -----------------|");
			// Realiza o parsing do modelo do ES
			modelParser.parsingEngineerModel(model);
			// Checa a consistencia interna do modelo
			errors = internalConsistency.checkConsistency("modelprocessing/modelcache/" +modelType);
			if (errors.size() > 0) {
				System.out.println("Erros no Modelo do Engenheiro: " + errors.toString());
			} else {
				System.out.println("             Nenhum erro no Modelo do Engenheiro!");
			}
			System.out.println("|--------------------------------------------------------|\n");
		} else {
			if (modelType.equals("userModel")) {
				System.out.println("|------------------- Modelo do Usuario ------------------|");
				// Realiza o parsing do modelo do ES
				modelParser.parsingUserModel(model);
				errors = internalConsistency.checkConsistency("modelprocessing/modelcache/" +modelType);
				if (errors.size() == 0) {
					System.out.println("              Nenhum erro no Modelo do Usuario!");
					conformanceChecking.checkConformance();
				} else {
					System.out.println("Erros no Modelo do Usuario: " + errors.toString());					
				}
			}
			System.out.println("|--------------------------------------------------------|\n");
		}
	} // fim do metodo checkModel

	/**
	 * Submete modelo para ser comparado com o modelo em execucao
	 * 
	 * @throws InterruptedException
	 * @throws NotBoundException
	 * @throws IOException
	 */
	public void submit() throws IOException, NotBoundException,
			InterruptedException {
		//long tempoInicio = System.currentTimeMillis();
		modelComparator.submit();
		//System.out.println("Tempo total: "+(System.currentTimeMillis()-tempoInicio));

	} // fim do metodo submmit

}
