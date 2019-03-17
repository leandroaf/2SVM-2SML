package twosvm.model.macro.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.macro.Macro;
import twosvm.model.mrt.SmartSpaceMRT;

import com.thoughtworks.xstream.XStream;

public class MacroRecorder {
	
	/**
	 * 
	 * @param macro
	 */
	public void recordMacro(Macro macro) {
		
		String path = "./src/twosvm/uctwosmiddleware/macrosrepository/";

		XStream xStream = new XStream();
		xStream.alias("macro", SmartSpaceMRT.class);

		File file = new File(path + "" + macro.getName() + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(macro).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim do metodo recordMacro


}
