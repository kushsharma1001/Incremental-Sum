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
		// input:2
		result = sum.calculate("2;8");
		Assert.assertEquals(10, result);
	}

	@Test
	public void calculate_Positive_MultiplenNumbers() {
		// input:2
		result = sum.calculate("2;8;9;5");
		Assert.assertEquals(24, result);
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

		// input: :
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("Invalid input: " + "2;b");
		result = sum.calculate("2;b");
	}
}
