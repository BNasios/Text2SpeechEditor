package model;


import java.util.ArrayList;

import encode.EncodingFactory;
import encode.IEncoding;
import text2speech.FakeFreeTTS;
import text2speech.FreeTTS;

public class Line {

	private String contexts;
	private float volume;
	private float rate;
	private float pitch;
	private float range;
	private String checkForTest;
	
	public Line() {}
	
	public Line(Object[] data) {
		this.contexts = (String) data[0];
		this.volume   = Float.parseFloat((String)data[1]);
		this.rate     = Float.parseFloat((String)data[2]);
		this.pitch    = Float.parseFloat((String)data[3]);
		this.range    = Float.parseFloat((String)data[4]);
		this.checkForTest = (String)data[5];
	}
	
	public void playLine() {

		if(checkForTest == "test") {
			callFakeFreeTTS(contexts);
			return;
		}		
		callFreeTTS(contexts);
	}
	
	public void playReverseLine() {
		
		ArrayList<String> reverselines = new ArrayList<String>();	
		String [] lines = contexts.split("\n");
		
		for(String l: lines) {
			
			String reverseLine = "";
			String[] line = l.split(" ");
			for(String str: line) {
				reverseLine = str + " " + reverseLine;
			}
			
			reverseLine += "\n";
			reverselines.add(0,reverseLine);
		}
		
		String toAudio = "";
		for(String rline: reverselines) {
			toAudio += rline;	
		}
		
		if(checkForTest == "test") {
			callFakeFreeTTS(toAudio);
			return;
		}
		callFreeTTS(toAudio);
	}
	
	public void playEncodedLine(String method) {
		
		String toAudio = contexts;
		
		String encodedAudio = "";
		EncodingFactory ef = new EncodingFactory();
		if(method.equals("AtBash")) {	
			IEncoding atb = ef.createAtBash();
			encodedAudio = atb.encode(toAudio);		
		}
		if(method.equals("Rot13")) {
			IEncoding rot = ef.createRot13();
			encodedAudio = rot.encode(toAudio);
		}		
		
		if(checkForTest == "test") {
			callFakeFreeTTS(encodedAudio);
			return;
		}
		callFreeTTS(encodedAudio);
	}
	
	public void callFreeTTS(String input) {
		FreeTTS f = new FreeTTS("kevin16");
		f.setVolume(volume);
		f.setRate(rate);
		f.setPitch(pitch);
		f.setRange(range);
		f.playAudio(input);
	}
	
	public void callFakeFreeTTS(String input) {
		FakeFreeTTS f = new FakeFreeTTS("kevin16");
		f.setVolume(volume);
		f.setRate(rate);
		f.setPitch(pitch);
		f.setRange(range);
		f.playAudio(input);
	}
}
