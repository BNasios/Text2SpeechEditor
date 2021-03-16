package test;

import org.junit.Test;

import commands.FakeInvoker;

public class TimeTest {

	@Test
	public void test() {
		String documentFilepath = "./testfiles/Time";

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
		ob[6] = "time";
		
		/*
		 *  Test the time of the most time-consuming command
		 */
		FakeInvoker inv = new FakeInvoker(ob);
		inv.testEncodedDocument();
	}
}
