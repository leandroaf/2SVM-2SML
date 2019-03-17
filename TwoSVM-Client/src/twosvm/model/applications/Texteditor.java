package twosvm.model.applications;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import twosvm.model.applications.interf.UbiquitousApplicationInterface;

/*
 * A simple Text Editor.  This demonstrates the use of a 
 * JFileChooser for the user to select a file to read from or write to.
 * It also demonstrates reading and writing text files.
 */
public class Texteditor implements ActionListener, Serializable,
		UbiquitousApplicationInterface {

	private static Texteditor instance;

	public String text;
	public String textSave;

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	// Size of editing text area.
	public static final int NUM_ROWS = 15;
	public static final int NUM_COLS = 30;

	public static Texteditor getInstance() {
		if (instance == null) {
			instance = new Texteditor();
		}
		return instance;
	}

	public Texteditor() {

	}

	// Buttons to save and load files.
	public JButton saveButton, loadButton;

	// Area where the user does the editing
	public JTextArea textArea;

	public String getText() {
		return text;
	}

	public void setText(String textArea) {
		this.text = textArea;
	}

	// Creates the GUI
	public void createGUI() {
		JFrame frame = new JFrame();
		JPanel buttonPanel = new JPanel();
		saveButton = new JButton("Save File");
		loadButton = new JButton("Load File");
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);

		textArea = new JTextArea(NUM_ROWS, NUM_COLS);
		textArea.setFont(new Font("System", Font.PLAIN, 24));
		JScrollPane textScroller = new JScrollPane(textArea);
		Container contentPane = frame.getContentPane();
		contentPane.add(textScroller, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.NORTH);

		saveButton.addActionListener(this);
		loadButton.addActionListener(this);

		frame.pack();
		frame.setVisible(true);
	}

	// Listener for button clicks that loads the
	// specified files and puts it in the
	// editor.
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == saveButton) {
			saveFile();
		} else {
			if (event.getSource() == loadButton) {
				loadFile();
			} else {
				printText();
			}

		}
	}

	// Display a file chooser so the user can select a file
	// to save to. Then write the contents of the text area
	// to that file. Does nothing if the user cancels out
	// of the file chooser.
	private void saveFile() {
		File file;

		// create and display dialog box to get file name
		JFileChooser dialog = new JFileChooser();

		// Make sure the user didn't cancel the file chooser
		if (dialog.showSaveDialog(textArea) == JFileChooser.APPROVE_OPTION) {

			// Get the file the user selected
			file = dialog.getSelectedFile();

			try {
				// Now write to the file
				PrintWriter output = new PrintWriter(new FileWriter(file));
				output.println(textArea.getText());
				output.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(textArea,
						"Can't save file " + e.getMessage());
			}
		}
	}

	// Display a file chooser so the user can select a file to load.
	// Then load the file into the editing area. Does nothing if
	// the user cancels the file chooser.
	private void loadFile() {
		String line;
		File file;

		// create and display dialog box to get file name
		JFileChooser dialog = new JFileChooser();

		// Make sure the user did not cancel.
		if (dialog.showOpenDialog(textArea) == JFileChooser.APPROVE_OPTION) {
			// Find out which file the user selected.
			file = dialog.getSelectedFile();

			try {
				// Open the file.
				BufferedReader input = new BufferedReader(new FileReader(file));

				// Clear the editing area
				textArea.setText("");

				// Fill up the ediitng area with the contents of the file being
				// read.
				line = input.readLine();
				while (line != null) {
					textArea.append(line + "\n");
					line = input.readLine();
				}

				// Close the file
				input.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(textArea,
						"Can't load file " + e.getMessage());
			}
		}
	}
	
	/**
	 * 
	 */
	public void printText() {
		System.out.println(textArea.getText());
	}

	/**
	 * Inicia a aplicacao
	 */
	public void startApplication() {
		createGUI();
	}

	/**
	 * Pausa a aplicacao
	 */
	public void pauseApplication() {
		// TODO Auto-generated method stub
	} // fim do metodo pauseApplication

	/**
	 * Resume a aplicacao
	 */
	public void resumeApplication() {
		startApplication();
		textArea.setText(textSave);
	} // fim do metodo resumeApplication

	/**
	 * Para a aplicacao
	 */
	public void stopApplication() {
		// TODO Auto-generated method stub
	} // fim do metodo stopApplication

	/**
	 * Finaliza a aplicacao
	 */
	public void destroyApplication() {
		System.exit(0);
	} // fim do metodo destroyApplication

	/**
	 * Salva o estado da aplicacao
	 * 
	 * @return
	 */
	public ApplicationState saveApplicationState() {
		// textSave = textArea.getText();
		ApplicationState applicationState = new ApplicationState();
		applicationState.setText(textArea.getText());
		return applicationState;
	} // fim do metodo saveApplicationState

	/**
	 * Restaura o estado da aplicacao
	 * 
	 * @param applicationState
	 */
	public void restoreApplicationState(ApplicationState applicationState) {
		textSave = applicationState.getText();
	} // fim do metodo restoreApplicationState

	/**
	 * 
	 */
	public void notifyUser() {
	}

}