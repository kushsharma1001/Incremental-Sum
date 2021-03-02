package com.operation;

import java.util.Arrays;

public class Sum {

	public int calculate(String input) {
		if (input == null || input.isBlank() || input.isEmpty() || input.length() == 0) {
			return 0;
		}
		
		if (input.length() == 1 && input.matches("^\\d+")) {
			return Integer.parseInt(input); 
		}
		
		if(input.matches("^\\d+(\\;\\d+)+")) {//"^\\d+\\;\\d+"
			String numbers[] = input.split(";");
			return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
		}
		
		throw new InvalidInputException("Invalid input: " + input);

		/*
		 * if (input.contains(";")) {
		 * 
		 * char arr[] = input.toCharArray(); if (input.length() == 1 && (((int) arr[0])
		 * >= 48 && ((int) arr[0] <= 57))) { try { return Integer.parseInt(input); }
		 * catch (Exception e) { throw new Exception("Error parsing input : [" + input +
		 * "] to Int"); } }
		 * 
		 * if (input.length() < 3 || !input.contains(";")) { throw new
		 * Exception("Invalid input: [" + input + "]"); }
		 * 
		 * String numbers[] = input.split(";");
		 * 
		 * if (numbers[numbers.length - 1].equals(";") || numbers[0].equals(";")) {
		 * throw new Exception("Invalid input: " + input); }
		 * 
		 * int sum = 0; sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
		 * return sum; }
		 */

	}
}
