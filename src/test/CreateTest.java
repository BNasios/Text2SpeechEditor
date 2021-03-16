package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import commands.FakeInvoker;

public class CreateTest {

	@Test
	public void test() {
		String filepath = "./testfiles/Test Create";
		String author = "author: Create author";
		String title = "title:  Create";
		String creation_date = "creation date:   2020-05-15 18:37:58";
		String last_saved_date = "last saved date: -";
		
		Object[] ob = new Object[5];
		ob[0] = filepath;
		ob[1] = author; 
		ob[2] = title;
		ob[3] = creation_date;
		ob[4] = last_saved_date;
		
		FakeInvoker inv = new FakeInvoker(ob);
		inv.testCreate();
		
		File file = new File(filepath);  
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(sc.nextLine(),author);
		assertEquals(sc.nextLine(),title);
		assertEquals(sc.nextLine(),creation_date);
		assertEquals(sc.nextLine(),last_saved_date);
		assertEquals(sc.nextLine(),"");
		assertEquals(sc.hasNextLine(),false);		
	}
}
