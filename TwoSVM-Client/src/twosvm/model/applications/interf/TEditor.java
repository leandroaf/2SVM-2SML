package twosvm.model.applications.interf;
import javax.swing.*;

import java.awt.*;

public class TEditor {
	JTextArea area;
	JFrame f;

	TEditor() {
		f = new JFrame();

		area = new JTextArea(300, 300);
		area.setBounds(10, 30, 300, 300);

		area.setBackground(Color.black);
		area.setForeground(Color.white);

		f.add(area);

		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TEditor();
	}

}