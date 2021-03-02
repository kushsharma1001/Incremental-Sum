package com.operation;

public class Demo {

	public static void main(String[] args) {

		Sum sum = new Sum();
		String input = "";
		try {
			int i = sum.calculate(input);
			System.out.println("input =" + input + ", result=" + i); // exception
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			input = "1";
			int i = sum.calculate(input); // 1
			System.out.println("input =" + input + ", result=" + i);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			input = ";";
			int i = sum.calculate(input); // exception
			System.out.println("input =" + input + ", result=" + i);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			input = "1;2";
			int i = sum.calculate(input); // 3
			System.out.println("input =" + input + ", result=" + i);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			input = ":";
			int i = sum.calculate(input); // exception
			System.out.println("input =" + input + ", result=" + i);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			input = "12;456";
			int i = sum.calculate(input); // exception
			System.out.println("input =" + input + ", result=" + i);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
