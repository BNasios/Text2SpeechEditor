package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import commands.FakeInvoker;

public class LineToSpeechTest {

	@Test
	public void test() {
		String filepath = "./testfiles/test audio commands";
		
		String str = "i am good\n all good";
		String volume = "10.0";
		String rate   = "150.0";
		String pitch  = "100.0";
		String range  = "11.0";
		
		Object[] ob = new Object[6];
		ob[0] = str;
		ob[1] = volume;       		
		ob[2] = rate; 	  			
		ob[3] = pitch;     			
		ob[4] = range;      						
		ob[5] = "test";
		
		
		FakeInvoker inv = new FakeInvoker(ob);
		inv.testLine();
		
		
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
		
		String[] lines = str.split("\n");
		
		for(String l: lines) {
			assertEquals(l,sc.nextLine());
		}
	}
}
