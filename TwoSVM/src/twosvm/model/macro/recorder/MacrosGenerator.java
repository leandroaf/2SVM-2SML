package twosvm.model.macro.recorder;

import twosvm.model.macro.ApplicationMacro;
import twosvm.model.macro.SmartObjectMacro;
import twosvm.model.macro.UserMacro;

public class MacrosGenerator {
	
	public static void main(String args[]) {
		
		MacroRecorder macroRecorder = new MacroRecorder();
		
		// Macro do usuario
		UserMacro userMacro = new UserMacro();
		userMacro.setName("addUser");
		userMacro.setCommand("activeUser");
		macroRecorder.recordMacroUR(userMacro);
		
		// Macro do SmartObject
		SmartObjectMacro smartObjectMacro = new SmartObjectMacro();
		smartObjectMacro.setName("addSmartObject");
		smartObjectMacro.setCommand("startListenerSmartObject");
		smartObjectMacro.setCommand("activeSmartObject");
		macroRecorder.recordMacroSO(smartObjectMacro);
		
		// Macros de UbiApp
		ApplicationMacro applicationMacro = new ApplicationMacro();
		applicationMacro.setName("addUbiApp");
		applicationMacro.setCommand("startListenerApp");
		macroRecorder.recordMacroUA(applicationMacro);
		
		applicationMacro = new ApplicationMacro();
		applicationMacro.setName("actUbiApp");
		applicationMacro.setCommand("activeUbiApp");
		macroRecorder.recordMacroUA(applicationMacro);
		
		applicationMacro = new ApplicationMacro();
		applicationMacro.setName("moveUbiApp");
		applicationMacro.setCommand("pauseApp");
		applicationMacro.setCommand("saveStateApp");
		applicationMacro.setCommand("activeUbiApp");
		applicationMacro.setCommand("destroyApp");
		macroRecorder.recordMacroUA(applicationMacro);
		
		applicationMacro = new ApplicationMacro();
		applicationMacro.setName("sendUbiApp");
		applicationMacro.setCommand("restoreStateApp");
		applicationMacro.setCommand("startApp");
		macroRecorder.recordMacroUA(applicationMacro);
		
		applicationMacro = new ApplicationMacro();
		applicationMacro.setName("startUbiApp");
		applicationMacro.setCommand("startApp");
		macroRecorder.recordMacroUA(applicationMacro);
		
		applicationMacro = new ApplicationMacro();
		applicationMacro.setName("pauseUbiApp");
		applicationMacro.setCommand("pauseApp");
		macroRecorder.recordMacroUA(applicationMacro);

		applicationMacro = new ApplicationMacro();
		applicationMacro.setName("resumeUbiApp");
		applicationMacro.setCommand("resumeApp");
		macroRecorder.recordMacroUA(applicationMacro);

		applicationMacro = new ApplicationMacro();
		applicationMacro.setName("destroyUbiApp");
		applicationMacro.setCommand("destroyApp");
		macroRecorder.recordMacroUA(applicationMacro);
		
	}

}
