package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	
	public static void main(String[] args) {
		FileEncryptor fe = new FileEncryptor();
		fe.encryptMessage();
	}
	
	public static void encryptMessage() {
		String message = JOptionPane.showInputDialog("Input message to be encrypted");
		char[] cmessage = message.toCharArray();
		message = "";
		for(int i = 0; i < cmessage.length/2; i++) {
			char a = cmessage[i];
			cmessage[i] = cmessage[cmessage.length-1-i];
			cmessage[cmessage.length-1-i] = a;
		}
		for(int i = 0; i < cmessage.length; i++) {
			message+=cmessage[i];
		}
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryptedfile.txt");
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
