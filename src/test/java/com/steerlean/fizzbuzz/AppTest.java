package com.steerlean.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import junit.framework.Assert;
import mockit.Mocked;
import mockit.Verifications;

public class AppTest {
	@Mocked
	private NumberProcessor processor;
	
	@Test
	public void testStart() {
		
		//ARRANGE
		final List<String> processedRange = new ArrayList<String>();
		App app = new App(processor);
		
		//ACT
		app.start();
		
		//ASSERT
		Assert.assertNotNull(processedRange);
		new Verifications() {{
			
			processor.processRange(1, 100,processedRange);
			times=1;
			
		}};
		
	}
	
	

}
