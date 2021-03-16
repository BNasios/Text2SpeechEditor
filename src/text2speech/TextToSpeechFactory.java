package text2speech;

public class TextToSpeechFactory {

	public ITextToSpeech createFreeTTS() {
		return new FreeTTS("kevin16");
	}
	
	public ITextToSpeech createFakeFreeTTS() {
		return new FakeFreeTTS("kevin16");
	}	
}
