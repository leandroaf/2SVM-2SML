package twosvm.testing;

import twosvm.twosbroker.devicemanager.eventhandler.newsmartspace.SmartSpacePub;

public class NewSmartSpaceTest {

	public static void main(String[] args) {
		
		SmartSpacePub newSmartSpacePub = new SmartSpacePub();
		newSmartSpacePub.enterSmartSpace("newSmartSpace", "classroom");
		

		System.out.println("Tempo inicio: "+System.currentTimeMillis());
		
	}

}
