package commands;

import java.util.ArrayList;

public class FakeInvoker {

	private Object[] data = null;
	
	public FakeInvoker() {}
	public FakeInvoker(Object[] data) {
		this.data = data;
	}
	
	public ArrayList<String> testOpen(){
		Open open = new Open(data);
		return open.test();
	}
	
	public void testSave(String inputLines){
		Save save = new Save(data);
		save.test(inputLines);
	}
	
	public void testCreate(){
		Create create = new Create(data);
		create.execute();
	}
	
	public void testDocument(){
		DocumentToSpeech dts = new DocumentToSpeech(data);
		dts.execute();
	}
	
	public void testReverseDocument(){
		ReverseDocumentToSpeech rdts = new ReverseDocumentToSpeech(data);
		rdts.execute();
	}
	
	public void testEncodedDocument(){
		EncodedDocumentToSpeech edts = new EncodedDocumentToSpeech(data);
		edts.execute();
	}
	
	public void testLine(){
		LineToSpeech lts = new LineToSpeech(data);
		
		lts.execute();
	}
	
	public void testReverseLine(){
		ReverseLineToSpeech rlts = new ReverseLineToSpeech(data);
		rlts.execute();
	}
	
	public void testEncodedLine(){
		EncodedLineToSpeech elts = new EncodedLineToSpeech(data);
		elts.execute();
	}	
}
