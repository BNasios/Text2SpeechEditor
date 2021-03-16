package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import commands.FakeInvoker;

public class DocumentToSpeechTest {

	@Test
	public void test() {
		String documentFilepath = "./testfiles/document";
		String testFilepath = "./testfiles/test audio commands";
		String volume = "10.0";
		String rate   = "150.0";
		String pitch  = "100.0";
		String range  = "11.0";
		
		Object[] ob = new Object[6];
		ob[0] = documentFilepath;
		ob[1] = volume;       		
		ob[2] = rate; 	  			
		ob[3] = pitch;     			
		ob[4] = range;      							
		ob[5] = "test";
		
		FakeInvoker inv = new FakeInvoker(ob);
		inv.testDocument();
		
		
		File dfile = new File(documentFilepath);  
		Scanner dsc = null;
		try {
			dsc = new Scanner(dfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		File tfile = new File(testFilepath);  
		Scanner tsc = null;
		try {
			tsc = new Scanner(tfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		for(int i=0; i<5; i++) {
			dsc.nextLine();
		}
				
		assertEquals(tsc.nextLine(),documentFilepath);
		assertEquals(tsc.nextLine(),volume);
		assertEquals(tsc.nextLine(),rate);
		assertEquals(tsc.nextLine(),pitch);
		assertEquals(tsc.nextLine(),range);
		
		while(dsc.hasNextLine()) {
			assertEquals(dsc.nextLine(),tsc.nextLine());
		}	
	}
}
