package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
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
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			String newtask = JOptionPane.showInputDialog("enter a task");
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
			String remove = JOptionPane.showInputDialog("Which item should be removed?");
			for(int i = 0; i < taskList.size(); i++) {
				if(taskList.get(i).equalsIgnoreCase(remove)) {
					taskList.remove(i);
				}
			}
		}
		if(e.getSource() == save) {
			
		}
	}
}
