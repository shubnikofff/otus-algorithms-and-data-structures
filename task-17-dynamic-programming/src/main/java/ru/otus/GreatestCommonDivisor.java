package ru.otus;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final String line = scanner.nextLine();
		final String[] input = line.split("[/+]");

		final int a = Integer.parseInt(input[0]);
		final int b = Integer.parseInt(input[1]);
		final int c = Integer.parseInt(input[2]);
		final int d = Integer.parseInt(input[3]);

		int x = a * d + b * c;
		int y = b * d;

		final int gcd = gcd(x, y);
		x /= gcd;
		y /= gcd;

		System.out.println(x + "/" + y);
	}

	private static int gcd(int a, int b) {
		if (a == b) {
			return a;
		}

		if (a == 0) {
			return b;
		}

		if (b == 0) {
			return a;
		}

		if (even(a) && even(b)) {
			return gcd(a >> 1, b >> 1) << 1;
		}

		if (even(a) && odd(b)) {
			return gcd(a >> 1, b);
		}

		if (odd(a) && even(b)) {
			return gcd(a, b >> 1);
		}

		return a > b ? gcd((a - b) >> 1, b) : gcd(a, (b - a) >> 1);
	}

	private static boolean even(int number) {
		return (number & 1) == 0;
	}

	private static boolean odd(int number) {
		return (number & 1) == 1;
	}
}
