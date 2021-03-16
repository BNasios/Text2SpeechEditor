package commands;

import java.io.FileWriter;
import java.io.IOException;


public class Create implements ICommand {

	private String filepath;
	private String author;
	private String title;
	private String creationDate;  
	private String lastSavedDate; 
	
	public Create() {}
	
	public Create(Object[] data) {
		filepath = (String)data[0];
		author = (String) data[1];
		title = (String) data[2];
		creationDate = (String) data[3];
		lastSavedDate = (String) data[4];
	}
	
	@Override
	public int execute() {
		FileWriter fw = null;
		try {
    		fw = new FileWriter(filepath);
    		fw.write(author+"\n");
    		fw.write(title+"\n");
    		fw.write(creationDate+"\n");
    		fw.write(lastSavedDate+"\n\n");
			fw.close();
			
    	} catch (IOException e1) {
			e1.printStackTrace();
		}
		return 0;
	}
}
