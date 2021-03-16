package text2speech;

import com.sun.speech.freetts.VoiceManager;


public class FreeTTS implements ITextToSpeech {
	private String name;
	private com.sun.speech.freetts.Voice voice;
	
	public FreeTTS() {}
	public FreeTTS(String name) {
		
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.name = name;
		this.voice = VoiceManager.getInstance().getVoice(this.name);
		this.voice.allocate();	
	}

	
	@Override
	public void playAudio(String str) {
		this.voice.speak(str);
	}

	@Override
	public void setVolume(float volume) {
		volume = volume/10;
		voice.setVolume(volume);		
	}

	@Override
	public void setPitch(float pitch) {
		voice.setPitch(pitch);
	}

	@Override
	public void setRange(float range) {
		voice.setPitchRange(range);
	}

	@Override
	public void setRate(float rate) {
		voice.setRate(rate);
	}
}
