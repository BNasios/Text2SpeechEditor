package commands;


public class Invoker {
	private Object[] data = null;
	
	public Invoker() {}
	public Invoker(Object[] data) {
		this.data = data;
	}
	
	public void performedAction(String commandid) {
		if(commandid.equals("Open")) {
			Open open = new Open(data);
			open.execute();
		}
		if(commandid.equals("Save")) {
			Save save = new Save(data);
			save.execute();
		}
		if(commandid.equals("Create")) {
			Create create = new Create(data);
			create.execute();
		}
		if(commandid.equals("PlayDocument")) {
			DocumentToSpeech dts = new DocumentToSpeech(data);
			dts.execute();
		}
		if(commandid.equals("PlayReverseDocument")) {
			ReverseDocumentToSpeech rdts = new ReverseDocumentToSpeech(data);
			rdts.execute();
		}
		if(commandid.equals("PlayLine")) {
			LineToSpeech lts = new LineToSpeech(data);
			lts.execute();
		}
		if(commandid.equals("PlayReverseLine")) {
			ReverseLineToSpeech rlts = new ReverseLineToSpeech(data);
			rlts.execute();
		}
		if(commandid.equals("PlayEncodedDocument")) {
			EncodedDocumentToSpeech edts = new EncodedDocumentToSpeech(data);
			edts.execute();		
		}
		if(commandid.equals("PlayEncodedLine")) {
			EncodedLineToSpeech elts = new EncodedLineToSpeech(data);
			elts.execute();		
		}	
	}
}
