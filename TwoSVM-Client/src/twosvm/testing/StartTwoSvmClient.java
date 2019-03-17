package twosvm.testing;

import java.io.IOException;

import twosvm.twosbroker.startmachine.StartMachine;

public class StartTwoSvmClient {
	
	public static void main(String args[]) throws IOException {
		
		StartMachine startMachine = new StartMachine();
		startMachine.startTwoSVMClient();
		
	}

}
