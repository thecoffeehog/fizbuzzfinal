package com.steerlean.fizzbuzz;


import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;

import mockit.Expectations;
import mockit.Mocked;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RulesConfiguratorTest {
	
	@Mocked
	private RuleFactory mockedRuleFactory;
	
	
	
	@Test
	public void testConfigure(@Mocked final IRule dummyDivisbilityRuleWithDivisor3, 
			@Mocked final IRule dummyDivisbilityRuleWithDivisor5,
			@Mocked final IRule dummySumOfDivisbilityRuleWithDivisor6,
			@Mocked final IRule dummySumOfDivisbilityRuleWithDivisor5) throws Exception {
		//ARRANGE
		new Expectations() {{
			
			mockedRuleFactory.createDivisibilityRule(3, "Fizz");
			returns(dummyDivisbilityRuleWithDivisor3);
			
			mockedRuleFactory.createDivisibilityRule(5, "Buzz");
			returns(dummyDivisbilityRuleWithDivisor5);
			
			mockedRuleFactory.createSumOfDigitsDivisibility(6, "FiJazz");
			returns(dummySumOfDivisbilityRuleWithDivisor6);
			
			mockedRuleFactory.createSumOfDigitsDivisibility(5, "BuJazz");
			returns(dummySumOfDivisbilityRuleWithDivisor5);
		}};
		
		//ACT
		RulesConfigurator rulesConfigurator = new RulesConfigurator(mockedRuleFactory);
		
		List<IRule> actualRuleList = rulesConfigurator.configure();
		
		//ASSERT
		Assert.assertEquals(4, actualRuleList.size());
		Assert.assertEquals(dummyDivisbilityRuleWithDivisor3, actualRuleList.get(0));
		Assert.assertEquals(dummyDivisbilityRuleWithDivisor5, actualRuleList.get(1));
		Assert.assertEquals(dummySumOfDivisbilityRuleWithDivisor6, actualRuleList.get(2));
		Assert.assertEquals(dummySumOfDivisbilityRuleWithDivisor5, actualRuleList.get(3));
		
		
		
	}
}
