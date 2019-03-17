package twosvm.model.macro.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import twosvm.model.macro.Macro;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class MacroReader {
	
	public Macro readMacro(String macroName) {

		Macro macro = new Macro();

		try {
			XStream xStream = new XStream(new Dom4JDriver());
			xStream.alias(macroName, Macro.class);
			xStream.processAnnotations(Macro.class);

			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					"./src/twosvm/uctwosmiddleware/macrosrepository/"
							+ macroName));
			macro = (Macro) xStream.fromXML(bufferedReader);
			bufferedReader.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return macro;

	} // fim do metodo readMacro

}
