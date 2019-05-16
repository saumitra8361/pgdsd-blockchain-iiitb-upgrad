package com.company;

public class Swap {
	public static void main(String[] args) {
		String string1 = "Welcome";
		uppercase(string1);
		System.out.println(string1);
	}

	public static String uppercase(String string1) {
		string1.toUpperCase();
		return string1;
	}
}
