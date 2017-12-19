package com.steerlean.fizzbuzz.rule;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RuleFactoryTest {
	
	@Test
	public void testDivisibilityRuleIsCreated() {
		//ARRANGE
		RuleFactory ruleFactory = new RuleFactory();
		
		//ACT
		IRule actual = ruleFactory.createDivisibilityRule(2, "hello");
		
		IRule expected = new DivisibilityRule(2, "hello");
		//ASSERT
		Assert.assertEquals(actual.hashCode(),expected.hashCode());
		
	}
	@Test
	public void testSumOfDigitsDivisibilityRuleIsCreated() {
		
	}
	@Test
	public void testDivisibilityRuleIsNotCreated() {
		
	}
	@Test
	public void testSumOfDigitsDivisibilityRuleIsNotCreated() {
		
	}

}
