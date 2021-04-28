package ru.otus;

import java.util.Scanner;

public class FiveTimesEight {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();

		long d5 = 1;
		long d8 = 1;
		long d55 = 0;
		long d88 = 0;
		long n5, n8, n55, n88;

		for (int i = 2; i <= n; i++) {
			n5 = d8 + d88;
			n8 = d5 + d55;
			n55 = d5;
			n88 = d8;

			d5 = n5;
			d8 = n8;
			d55 = n55;
			d88 = n88;
		}

		System.out.println(d5 + d55 + d8 + d88);
	}

}
