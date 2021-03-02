package com.operation;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SumTest {

	private Sum sum = new Sum();

	private int result = 0;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void calculate_Positive_Null() {

		// input: null

		result = sum.calculate(null);
		Assert.assertEquals(0, result);
	}

	@Test
	public void calculate_Positive_SingleNumber() {
		// input:2
		result = sum.calculate("2");
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void calculate_Positive() {
		// input:2,8
		result = sum.calculate("2,8");
		Assert.assertEquals(10, result);
	}

	@Test
	public void calculate_Positive_MultiplenNumbers() {
		// input:2,8,9,5
		result = sum.calculate("2,8,9,5");
		Assert.assertEquals(24, result);
	}
	
	@Test
	public void calculate_Positive_MultiplenNumbersNewLine() {
		// input:2\n8,9\n1
		result = sum.calculate("2\n8,9\n1");
		Assert.assertEquals(20, result);
	}
	
	@Test
	public void calculate_Positive_MultiplenNumbersNewLine2() {
		// input:2,8,9\n1
		result = sum.calculate("2,8,9\n1");
		Assert.assertEquals(20, result);
	}
	
	
	@Test
	public void calculate_Negative_NegativeNumbers() {

		// input: 1,2,-4
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("Negatives not allowed: " + "-4");
		result = sum.calculate("1,2,-4");
	}
	 
	
	@Test
	public void calculate_Negative_InvalidColon() {

		// input: :
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("Invalid input: " + ":");
		result = sum.calculate(":");
	}
	
	@Test
	public void calculate_Negative_InvalidAlphabets() {

		// input: 2,b
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("Invalid input: " + "2,b");
		result = sum.calculate("2,b");
	}
}
