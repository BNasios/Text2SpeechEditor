package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateTest.class, OpenTest.class , SaveTest.class,
				DocumentToSpeechTest.class,	ReverseDocumentToSpeechTest.class, 
				EncodedDocumentTest.class, 	LineToSpeechTest.class , 
				ReverseLineToSpeechTest.class ,    EncodedLineTest.class , TimeTest.class
})


public class AllTests { }
