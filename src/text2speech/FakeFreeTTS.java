package text2speech;

import java.io.FileWriter;
import java.io.IOException;

import com.sun.speech.freetts.VoiceManager;

public class FakeFreeTTS implements ITextToSpeech {

	private String name;
	private com.sun.speech.freetts.Voice voice;
	private float volume;
	private float rate;
	private float pitch;
	private float range;
	private String filepath;
	private int timeFlag;
		
	public FakeFreeTTS() {}
	
	public FakeFreeTTS(String name) {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.name = name;
		this.voice = VoiceManager.getInstance().getVoice(this.name);
		this.voice.allocate();
		this.filepath = null;
		this.timeFlag = 0;
	}
	
	@Override
	/*
	 * 	Writes all the arguments of each user action to file 'test audio commands' 
	 */
	public void playAudio(String str) {
		if(timeFlag == 1) {
			return;
		}
		
		String testfilepath = "./testfiles/test audio commands";
		
		String [] lines = str.split("\n");
		
		FileWriter fw = null;
		
		try {
    		fw = new FileWriter(testfilepath);
    		if(filepath != null) {
    			fw.write(filepath +"\n");
    		}
    		fw.write(volume +"\n");
    		fw.write(rate   +"\n");
    		fw.write(pitch  +"\n");
    		fw.write(range  +"\n");
    		
    		for(String line: lines){
    			fw.write(line + "\n");
    		}
    		fw.close();
    	} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}


	@Override
	public void setVolume(float volume) {
		this.volume = volume;
	}

	@Override
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	@Override
	public void setRange(float range) {
		this.range = range;
	}

	@Override
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	public void setFilepath(String filepath) {
		this.filepath= filepath;
	}
	
	public void setTimeFlag(int time) {
		this.timeFlag = time;
	}
}
