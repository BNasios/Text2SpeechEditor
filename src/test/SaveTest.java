package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import commands.FakeInvoker;

public class SaveTest {

	@Test
	public void test() {
		
		String filepath = "./testfiles/Test Save";
		String author = "author: Test Save";
		String title = "title:  test";
		String creation_date = "creation date:   2020-05-14 18:37:58";
		String last_saved_date = "last saved date: 2020-05-17 19:18:42";
		
		Object[] ob = new Object[6];
		ob[0] = filepath;
		ob[1] = null;
		ob[2] = author;
		ob[3] = title;
		ob[4] = creation_date;
		ob[5] = last_saved_date;


		String lines = "Now i am testing\nthe Save button";
		
		FakeInvoker inv = new FakeInvoker(ob);
		inv.testSave(lines);
		
		File file = new File(filepath);  
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String [] testlines = lines.split("\n");
		
		int i = 0; 
		
		assertEquals(sc.nextLine(),author);
		assertEquals(sc.nextLine(),title);
		assertEquals(sc.nextLine(),creation_date);
		assertEquals(sc.nextLine(),last_saved_date);
		assertEquals(sc.nextLine(),"");
		
		while (sc.hasNextLine()) {
			assertEquals(sc.nextLine(),testlines[i]);
			i++;
		}		
	}
}
