package twosvm.testing;

import java.io.IOException;
import java.rmi.NotBoundException;

import twosvm.model.manipulatorlanguage.LoadModel;
import twosvm.modelprocessing.facade.Facade;

/**
 * Classe de Testes
 * 
 * @author leandroalexandre
 *
 */
public class CheckModelTest {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws NotBoundException 
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws IOException, NotBoundException, InterruptedException {

		Facade facade = new Facade();
		
		// Modelo do ES criado pela 2SML
		Twosml.ControlSchema engineerModel = (Twosml.ControlSchema) LoadModel
				.loadFirst(
						"/mnt/hgfs/Dropbox/PhD/runtime-EclipseApplication/EngineerModel/engineer.twosml",
						Twosml.ControlSchema.class);
		// Modelo do US criado pela 2SML
		Twosml.ControlSchema userModel = (Twosml.ControlSchema) LoadModel
				.loadFirst(
						"/mnt/hgfs/Dropbox/PhD/runtime-EclipseApplication/ClassroomUserModel/user.twosml",
						//"/mnt/hgfs/Dropbox/PhD/runtime-EclipseApplication/MeetingUserModel/default.twosml",
						Twosml.ControlSchema.class);

		// Processamento dos modelos
		facade.checkModel(engineerModel, "engineerModel");	
		facade.checkModel(userModel, "userModel");
		
		// submete o modelo para ser comparado e executado
		facade.submit();
		
	} // fim do metodo main

}
