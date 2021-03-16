package commands;


import model.Document;

public class DocumentToSpeech implements ICommand {

	private Object[] data;
	
	public DocumentToSpeech() {}
	
	public DocumentToSpeech(Object[] data) {
		this.data = data;
	}
	
	public int execute() {
		
		Document d = new Document(data);
		d.playContexts();
		
		return 0;
	}
}
