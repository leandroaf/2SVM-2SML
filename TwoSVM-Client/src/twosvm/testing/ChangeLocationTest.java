package twosvm.testing;

import twosvm.twosbroker.devicemanager.eventhandler.changelocation.ChangeLocationPub;

public class ChangeLocationTest {

	public static void main(String[] args) {
		
		final String eventName = "changeLocation";
		final String newLocation = "smartwhite";

		// Evento de mudanca de localizacao
		new Thread() {
			public void run() {
				ChangeLocationPub changeLocationPub = new ChangeLocationPub();
				changeLocationPub.changeLocation(eventName, newLocation);
			}
		}.start();
		
	}

}
