package commands;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

public class Save implements ICommand {

	private String filepath;
	private JTextArea txtArea;
	private String author;
	private String title;
	private String creationDate;  
	private String lastSavedDate; 
	
	public Save(Object[] data) {
		filepath = (String)data[0];
		txtArea = (JTextArea) data[1];
		author = (String) data[2];
		title = (String) data[3];
		creationDate = (String) data[4];
		lastSavedDate = (String) data[5];
	}
	
	@Override
	public int execute() {
		FileWriter fw = null;
		try {
    		fw = new FileWriter(filepath);
    		String txt = txtArea.getText();
    		String [] lines = txt.split("\n");
    		fw.write(author+"\n");
    		fw.write(title+"\n");
    		fw.write(creationDate+"\n");
    		fw.write(lastSavedDate+"\n\n");
    		for(String line: lines){
    			fw.write(line+"\n");
    		}
			fw.close();
			
    	} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return 0;
	}
	
	/*
	 *  For testing purposes used by FakeInvoker
	 */
	public void test(String inputLines){
		FileWriter fw = null;
		try {
    		fw = new FileWriter(filepath);
    		String txt = inputLines;
    		String [] lines = txt.split("\n");
    		fw.write(author+"\n");
    		fw.write(title+"\n");
    		fw.write(creationDate+"\n");
    		fw.write(lastSavedDate+"\n\n");
    		for(String line: lines){
    			fw.write(line+"\n");
    		}
			fw.close();
			
    	} catch (IOException e1) {
			e1.printStackTrace();
		}
				
		return;
	}
}
