package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import commands.FakeInvoker;

public class EncodedDocumentTest {

	@Test
	public void test() {
		String documentFilepath = "./testfiles/Encoded Document";
		String testFilepath = "./testfiles/test audio commands";
		String checkFile = "./testfiles/Document AtBash";
		String volume = "10.0";
		String rate   = "150.0";
		String pitch  = "100.0";
		String range  = "11.0";
		
		Object[] ob = new Object[7];
		ob[0] = "AtBash";
		ob[1] = documentFilepath;
		ob[2] = volume;       		 
		ob[3] = rate; 	  		
		ob[4] = pitch;     			
		ob[5] = range;      						
		ob[6] = "test";
		
		for(int i = 0; i<2; i++) {
		
			FakeInvoker inv = new FakeInvoker(ob);
			inv.testEncodedDocument();
			
			File cfile = new File(checkFile);  
			Scanner csc = null;
			try {
				csc = new Scanner(cfile);
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
						
			assertEquals(tsc.nextLine(),documentFilepath);
			assertEquals(tsc.nextLine(),volume);
			assertEquals(tsc.nextLine(),rate);
			assertEquals(tsc.nextLine(),pitch);
			assertEquals(tsc.nextLine(),range);
			
			
			while(csc.hasNextLine()) {
				assertEquals(csc.nextLine(),tsc.nextLine());
			}
			
			ob[0] = "Rot13";
			checkFile = "./testfiles/Document Rot13";
		}	
	}
}
