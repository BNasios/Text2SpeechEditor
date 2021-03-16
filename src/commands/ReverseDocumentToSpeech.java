package commands;


import model.Document;

public class ReverseDocumentToSpeech implements ICommand {
	
	private Object[] data;
	
	public ReverseDocumentToSpeech() {}
	
	public ReverseDocumentToSpeech(Object[] data) {
		this.data = data;
	}
	
	public int execute() {
		Document d = new Document(data);
		d.playReverse();
		return 0;
	}
}
