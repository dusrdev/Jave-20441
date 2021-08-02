package Recursion;
// import java.util.Scanner;

public class Question_longestPalindrom {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * We get an array and should return the length of the largest subarray which is
		 * a palindrome
		 */

		int[] arr = { 1, 3, 2, 3, 10, 10, 3, 2, 4 };
		System.out.println("longestPalindrom(arr) = " + longestPalindrom(arr)); // 6

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int longestPalindrom(int[] arr) {
		return longestPalindrom(arr, 0, arr.length - 1);
	}

	private static int longestPalindrom(int[] arr, int start, int end) {
		if (start == end) { // If both are equal, the same letter is a palindrome
			return 1;
		}
		if (end < start) { // Out of bounds
			return 0;
		}
		if (arr[start] == arr[end]) { // If two are equal
			int one = 1 + longestPalindrom(arr, start + 1, end); // Continue with one
			int two = 1 + longestPalindrom(arr, start, end - 1); // Continue with two
			int both = 2 + longestPalindrom(arr, start + 1, end - 1); // Continue with both
			return Math.max(one, Math.max(two, both));
		} else { // Not equal
			// Can't continue with both
			int one = longestPalindrom(arr, start + 1, end); // Continue with one
			int two = longestPalindrom(arr, start, end - 1); // Continue with two
			return Math.max(one, two);
		}
	}
}