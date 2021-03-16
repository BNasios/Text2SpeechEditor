package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import encode.EncodingFactory;
import encode.IEncoding;
import text2speech.FakeFreeTTS;
import text2speech.ITextToSpeech;
import text2speech.TextToSpeechFactory;

public class Document {
	
	private String filepath;
	private float volume;
	private float rate;
	private float pitch;
	private float range;
	private String checkForTest;
	
	public Document() {}
	
	public Document(Object[] data) {
		this.filepath = (String)data[0];
		this.volume   = Float.parseFloat((String)data[1]);
		this.rate     = Float.parseFloat((String)data[2]);
		this.pitch    = Float.parseFloat((String)data[3]);
		this.range    = Float.parseFloat((String)data[4]);
		this.checkForTest = (String)data[5];
	}
	
	
	public void playContexts() {
		File file = new File(filepath);  
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		* The first 5 lines are the document properties
		* The rest of the file are the contexts
		* There is one empty line between lastSavedDate and contexts
		*/
		for(int i = 0; i < 5; i++) {
			sc.nextLine(); 
		}
		
		String toAudio = "";
		while (sc.hasNextLine()) {
			toAudio += sc.nextLine()+"\n"; 
		}
		
		/*
		 *  Only for testing purposes
		 */
		if(checkForTest == "test") {
			callFakeFreeTTS(toAudio);
			return;
		}
		
		callFreeTTS(toAudio);
	}
	
	
	public void playReverse() {
		File file = new File(filepath); 
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 5; i++) {
			sc.nextLine(); 
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			String reverseLine = "";
 
			String [] line = sc.nextLine().split(" ");

			for(String str: line) {
				reverseLine = str + " " + reverseLine;
			}			
			reverseLine += "\n";	
			
			lines.add(0, reverseLine);
			
		}
		
		String toAudio = "";
		for(String rline: lines) {
			toAudio += rline;
		}
		
		if(checkForTest == "test") {
			callFakeFreeTTS(toAudio);
			return;
		}
		callFreeTTS(toAudio);
	}
	
	public void playEncodedContexts(String method) {
		File file = new File(filepath);  
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			System.out.println("hi");
			e.printStackTrace();
		}
		
		for(int i = 0; i < 5; i++) {
			sc.nextLine(); 
		}
		
		String toAudio = "";
		while (sc.hasNextLine()) {
			toAudio += sc.nextLine()+"\n"; 
		}
		
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
		
		if(checkForTest == "time") {
			callFakeFreeTTSTime(encodedAudio);
			return;
		}
		callFreeTTS(encodedAudio);		
	}
	
		
	public void callFreeTTS(String input) {
		TextToSpeechFactory ftts = new TextToSpeechFactory();
		ITextToSpeech f = ftts.createFreeTTS();
		f.setVolume(volume);
		f.setRate(rate);
		f.setPitch(pitch);
		f.setRange(range);
		f.playAudio(input);
	}
	
	public void callFakeFreeTTS(String input) {
		FakeFreeTTS f = new FakeFreeTTS("kevin16");
		f.setFilepath(filepath);
		f.setVolume(volume);
		f.setRate(rate);
		f.setPitch(pitch);
		f.setRange(range);
		f.playAudio(input);
	}
	
	public void callFakeFreeTTSTime(String input) {
		FakeFreeTTS f = new FakeFreeTTS("kevin16");
		f.setFilepath(filepath);
		f.setTimeFlag(1);
		f.setVolume(volume);
		f.setRate(rate);
		f.setPitch(pitch);
		f.setRange(range);
		f.playAudio(input);
	}	
}
