package com.steerlean.fizzbuzz;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.steerlean.fizzbuzz.rule.DivisibilityRule;
import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;
import com.steerlean.fizzbuzz.rule.SumOfDigitsDivisibility;

import mockit.Expectations;
import mockit.Mocked;

public class RuleConfiguratorTest1 {
	
//	private RuleFactoryStub ruleFactoryStub; 
	@Test
	public void testConfigure() throws Exception {
		//ARRANGE
		
		//ACT
		RulesConfigurator rulesConfigurator = new RulesConfigurator(new RuleFactoryStub());
		
		List<IRule> actualRuleList = rulesConfigurator.configure();
		
		//ASSERT
		Assert.assertEquals(4, actualRuleList.size());
		Assert.assertEquals(new DivisibilityRule(3, "asd"), actualRuleList.get(0));
		Assert.assertEquals(new DivisibilityRule(3, "asd"), actualRuleList.get(1));
		Assert.assertEquals(new SumOfDigitsDivisibility(3, "asasd"), actualRuleList.get(2));
		Assert.assertEquals(new SumOfDigitsDivisibility(3, "asasd"), actualRuleList.get(3));
		
		
		
	}
	
	
	
	private class RuleFactoryStub extends RuleFactory {
		
		@Override
		public IRule createDivisibilityRule(int divisor, String processedString) {
			return new DivisibilityRule(3, "asd");
		}
		@Override
		public IRule createSumOfDigitsDivisibility(int divisor, String processedString) {
			return new SumOfDigitsDivisibility(3, "asasd");
		}
	}
}


