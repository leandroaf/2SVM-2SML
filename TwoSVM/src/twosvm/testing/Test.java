package twosvm.testing;

import twosvm.modelprocessing.conformancechecking.ConformanceChecking;
import twosvm.modelprocessing.internalconsistency.InternalConsistency;

public class Test {

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		String engineerModelPath = "/mnt/hgfs/Dropbox/PhD/runtime-EclipseApplication/EngineerModel/engineer.twosml";
		
		String userModelPath = "/mnt/hgfs/Dropbox/PhD/runtime-EclipseApplication/UserModel/user.twosml";
		
		String evlPath = "/mnt/hgfs/Dropbox/PhD/workspace-Epsilon/twosml.validation/validation/twosml.evl";

		ConformanceChecking conformanceChecking = new ConformanceChecking();

		InternalConsistency internalConsistency = new InternalConsistency();

		// Checagem de conformidade
		// gerador de regras EVL
		//cChecking.complianceChecking(engineerModelPath, evlPath);
		
		// Checagem da consistencia interna do modelo
		//cChecking.complianceCheckingPolicy(engineerModelPath);
		// checagem das politicas no modelo do usuario
	
		

	}

}
