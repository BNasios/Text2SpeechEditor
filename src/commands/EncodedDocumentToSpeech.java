package commands;

import model.Document;

public class EncodedDocumentToSpeech implements ICommand {

	private String method;
	private Object[] data2 = new Object[6];
	
	public EncodedDocumentToSpeech() {}
	
	/*
	 * Data[0] = encode strategy
	 * Data[1] = document filepath
	 * Data[2] = voice volume
	 * Data[3] = voice rate
	 * Data[4] = voice pitch
	 * Data[5] = voice range
	 * Data[6] = argument for testing purposes		if 'action' then user_story else testing mode
	 */
		
	public EncodedDocumentToSpeech(Object[] data) {
		this.method = (String) data[0];
		this.data2[0] = (String) data[1];
		this.data2[1] = (String) data[2];
		this.data2[2] = (String) data[3];
		this.data2[3] = (String) data[4];
		this.data2[4] = (String) data[5];
		this.data2[5] = (String) data[6];
	}
	

	public int execute() {
		Document d = new Document(data2);
		d.playEncodedContexts(method);
		return 0;
	}
}
