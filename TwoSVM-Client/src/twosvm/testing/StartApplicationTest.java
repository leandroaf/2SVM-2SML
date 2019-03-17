package twosvm.testing;

import twosvm.twosbroker.applicationmanager.startapplication.StartApplicationPub;

public class StartApplicationTest {

	public static void main(String[] args) {

		// Evento de inicializacao da aplicacao
		new Thread() {
			public void run() {
				StartApplicationPub startApplicationPub = new StartApplicationPub();
				startApplicationPub.startApplication();
			}
		}.start();

	}

}
