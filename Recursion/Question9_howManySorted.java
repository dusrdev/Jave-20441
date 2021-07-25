package Recursion;
// import java.util.Scanner;

public class Question9_howManySorted {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * We get an array of length n, and integer max
		 * We need to return the number of possibilites of filling the array with
		 * numbers from 1 to max in ascending order
		 * IE: n = 3, max = 2; possibilities = 4;
		 * [1,1,1],[1,1,2],[1,2,2],[2,2,2]
		 */
		System.out.println("howManySorted(3,2) = " + howManySorted(3, 2)); // 4
		System.out.println("howManySorted(2,3) = " + howManySorted(2, 3)); // 6

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int howManySorted(int n, int max) {
		return howManySorted(n, max, 1);
	}

	private static int howManySorted(int n, int max, int i) {
		if (i > max) return 0; // if i passed max
		if (n == 0) { // reached destination
			return 1;
		}
		int nexti = howManySorted(n, max, i + 1); // only increment i
		int nextelement = howManySorted(n - 1, max, i); // only increment place in n
		return nexti + nextelement;
	}
}