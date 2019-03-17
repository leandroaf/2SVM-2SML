package twosvm.model.applications;

import java.io.Serializable;

public class ApplicationState  implements Serializable {

	String text;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 99L;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "ApplicationState [text=" + text + "]";
	}
	
}
