package commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;
import java.io.File;


public class Open implements ICommand {

	private String filepath;
	private JTextArea txtArea;
		
	public Open() {}
	
	public Open(Object[] data) {
		filepath = (String)data[0];
		txtArea = (JTextArea) data[1];
	}
	

	public int execute() {	
		File file = new File(filepath);   
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		* The first 5 lines are the document properties
		* The rest of the file are the contexts
		* There is one empty line between lastSavedDate and contexts
		*/
		for(int i = 0; i < 5; i++) {
			sc.nextLine(); 	
		}
		
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			txtArea.append(sc.nextLine()+"\n");
		}
		return 0;
	}
	
	/*
	 *  For testing purposes used by FakeInvoker
	 */
	public ArrayList<String> test() {
		ArrayList<String> lines = new ArrayList<String>();
		File file = new File(filepath);  
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		return lines;
	}	
}
