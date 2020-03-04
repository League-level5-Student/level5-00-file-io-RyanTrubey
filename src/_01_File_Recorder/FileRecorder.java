package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		FileRecorder fr = new FileRecorder();
		fr.saveMessage();
	}
	
	public void saveMessage() {
		String input = JOptionPane.showInputDialog("Enter a message");
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/usermessage.txt");
			fw.write(input);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
