package bussiness;

import java.util.Arrays;

public class Test {
	static String sp = "ABCD";

	static void testMethod() {
		int n=2;
		int[][] arr = new int[n][n];
		int inc = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = inc;
				inc++;
			}
		}

		String lineSeparator = System.lineSeparator();
		StringBuilder sb = new StringBuilder();

		for (int[] row : arr) {
		    sb.append(Arrays.toString(row))
		      .append(lineSeparator);
		}

		String result = sb.toString();
		System.out.println(result);
	}

	public static void main(String[] args) {
		testMethod();
	}
}
