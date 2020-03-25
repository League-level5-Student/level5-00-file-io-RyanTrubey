package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	public ArrayList<String> taskList = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("add task");
	JButton view = new JButton("view tasks");
	JButton remove = new JButton("remove tasks");
	JButton save = new JButton("save list");
	JButton load = new JButton("load list");
	
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.loadLastList();
		tdl.display();
	}
	
	public void display() {
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	
	public void loadLastList() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/ryantrubey/Desktop/taskList.txt"));
			String line = br.readLine();
			while(line != null){
				taskList.add(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			String newtask = JOptionPane.showInputDialog("Enter a task.");
			taskList.add(newtask);
		}
		if(e.getSource() == view) {
			String temp = "";
			for(int i = 0; i < taskList.size(); i++) {
				temp+=taskList.get(i);
				temp+="\n";
			}
			JOptionPane.showMessageDialog(null, temp);
		}
		if(e.getSource() == remove) {
			String remove = JOptionPane.showInputDialog("Which task should be removed?");
			int index = -1;
			for(int i = 0; i < taskList.size(); i++) {
				if(taskList.get(i).equalsIgnoreCase(remove)) {
					index = i;
				}
			}
			if(index >= 0) {
				JOptionPane.showMessageDialog(null, taskList.get(index) + " has been removed.");
				taskList.remove(index);
			} else {
				JOptionPane.showMessageDialog(null, "There is no task called " + remove + " in the list.");
			}
		}
		if(e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("/Users/ryantrubey/Desktop/taskList.txt");
				fw.write(taskList.get(0) + "\n");
				for(int i = 1; i < taskList.size(); i++) {
					fw.append(taskList.get(i) + "\n");
				}
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == load) {
			taskList.clear();
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(jfc.getSelectedFile().getAbsolutePath()));
					String line = br.readLine();
					while(line != null){
						taskList.add(line);
						line = br.readLine();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
