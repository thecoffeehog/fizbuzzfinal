package com.steerlean.fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import junit.framework.Assert;
import mockit.Expectations;
import mockit.Mocked;

public class NumberProcessorTest {
	
	@Mocked
	private RuleEngine mockedRuleEngine;
	
	@Test
	public void testProcessRange() throws Exception {
		//ARRANGE
		new Expectations() {{
			
			mockedRuleEngine.run(1);
			returns("abc");
			
			mockedRuleEngine.run(2);
			returns("pqr");
			
			mockedRuleEngine.run(3);
			returns("rst");
			
			
		}};
		NumberProcessor numberProcessor = new NumberProcessor(mockedRuleEngine);
		List<String> expectedProcessNumbers = Arrays.asList("abc", "pqr", "rst");
		List<String> actualProcessedNumbers = new ArrayList<String>();
		
		//ACT
		numberProcessor.processRange(1, 3, actualProcessedNumbers);
		
		//ASSERT
		Assert.assertEquals(expectedProcessNumbers, actualProcessedNumbers);
		
	}

}
