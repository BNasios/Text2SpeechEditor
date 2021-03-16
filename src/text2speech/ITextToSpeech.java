package text2speech;

public interface ITextToSpeech {
	
	public void playAudio(String str);
	public void setVolume(float volume);
	public void setPitch(float pitch);
	public void setRange(float range);
	public void setRate(float rate);
}
