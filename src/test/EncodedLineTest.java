package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import commands.FakeInvoker;

public class EncodedLineTest {

	@Test
	public void test() {
		String filepath = "./testfiles/test audio commands";
		
		String str = "abcdefghijklmnopqrstuvwxyz123456789.,/";
		String volume = "10.0";
		String rate   = "150.0";
		String pitch  = "100.0";
		String range  = "11.0";
		String encode = "AtBash";
		
		
		for(int i =0; i<2; i++) {
		
			Object[] ob = new Object[7];
			ob[0] = encode;
			ob[1] = str;
			ob[2] = volume;       		
			ob[3] = rate; 	  			
			ob[4] = pitch;     			
			ob[5] = range;      						
			ob[6] = "test";
			
			
			FakeInvoker inv = new FakeInvoker(ob);
			inv.testEncodedLine();
			
			
			File file = new File(filepath);  
			Scanner sc = null;
			try {
				sc = new Scanner(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			assertEquals(sc.nextLine(),volume);
			assertEquals(sc.nextLine(),rate);
			assertEquals(sc.nextLine(),pitch);
			assertEquals(sc.nextLine(),range);
			
			if(encode.equals("AtBash")) {
				assertEquals(sc.nextLine(),"zyxwvutsrqponmlkjihgfedcba123456789.,/");
			}
			if(encode.equals("Rot13")) {
				assertEquals(sc.nextLine(),"nopqrstuvwxyzabcdefghijklm123456789.,/");
			}
			
			encode = "Rot13";
		}
	}
}
