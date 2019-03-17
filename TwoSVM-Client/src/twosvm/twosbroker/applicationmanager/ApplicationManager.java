package twosvm.twosbroker.applicationmanager;

import twosvm.model.applications.interf.UbiquitousApplicationInterface;
import twosvm.twosbroker.applicationmanager.startapplication.StartApplicationSub;

public class ApplicationManager {

	private static ApplicationManager instance = null;

	/**
	 * Construtor
	 */
	public ApplicationManager() {
	}

	/**
	 * 
	 * @return
	 */
	public static ApplicationManager getInstance() {
		if (instance == null) {
			instance = new ApplicationManager();
		}
		return instance;
	}

	/**
	 * Metodo para iniciar aplicacao
	 * 
	 * @param application
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public UbiquitousApplicationInterface executeStartApplication(
			String application) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		// Tratando a String
		String app = application.toLowerCase();
		char first = Character.toTitleCase(app.charAt(0));
		app = first + app.substring(1);
		
		String path = "twosvm.model.applications.";
		path = path.concat(app);

		Class c = Class.forName(path);
		Object o = c.newInstance();

		UbiquitousApplicationInterface uApplicationInterface = (UbiquitousApplicationInterface) o;

		uApplicationInterface.startApplication();

		return uApplicationInterface;

	} // fim do metodo executeStartApplication

	/**
	 * Metodo responsavel por iniciar o servico relacionado as aplicacoes
	 * ubiquas
	 */
	public void startApplicationManager() {

		// Servico responsavel por receber eventos relacionados a inicializacao
		// da aplicacao
		new Thread() {
			public void run() {
				StartApplicationSub startApplicationSub = new StartApplicationSub();
				startApplicationSub.startApplication();
			}
		}.start();

	} // fim do metodo startApplicationManager

}
