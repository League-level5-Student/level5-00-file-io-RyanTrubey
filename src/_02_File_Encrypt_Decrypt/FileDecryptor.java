package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		FileDecryptor fd = new FileDecryptor();
		fd.decryptMessage();
	}

	public void decryptMessage() {
		String message = "";
		
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encryptedfile.txt");
			try {
				int c = fr.read();
				while(c != -1) {
					message+=(char)c;
					c = fr.read();
				}
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		JOptionPane.showMessageDialog(null, message);
	}
}
