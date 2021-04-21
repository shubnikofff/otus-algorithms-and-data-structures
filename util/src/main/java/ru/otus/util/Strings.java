package ru.otus.util;

public class Strings {

	public static String substringLeft(String str, int length) {
		return str.substring(0, length);
	}

	public static String substringRight(String str, int length) {
		return str.substring(str.length() - length);
	}

}
