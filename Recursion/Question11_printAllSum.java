package Recursion;
// import java.util.Scanner;

public class Question11_printAllSum {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * A binary string is a string filled with 0's and 1's
		 * We get an array a and integer sum
		 * we need to print all possible combinations of binary strings where:
		 * 1. the string length is equal to a.length
		 * 2. every element in a subarray of a which is a component of the sum - sum
		 * will be marked as 1 in the string
		 * others will be 0
		 * 
		 * Examples:
		 * a = {1,1,3,7}, sum = 8 => str1 = "1001", str2 = "0101"
		 */
		int[] a1 = {1,1,3,7};
		System.out.println("printAllSum({1,1,3,7}, 8):");
		printAllSum(a1, 8); // 1001, 0101
		System.out.println();
		System.out.println("printAllSum({1,1,3,7}, 10):");
		printAllSum(a1, 10); //0011
		System.out.println();
		System.out.println("printAllSum({1,1,3,7}, 12):");
		printAllSum(a1, 12); //1111

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static void printAllSum(int[] a, int sum) {
		printAllSum(a, sum, 0, "");
	}

	private static void printAllSum(int[] a, int sum, int i, String str) {
		if (sum == 0 && str.length() == a. length){ // Meets criteria for destination
			System.out.println(str);
		}
		if (i >= a.length) { // out of bounds
			return;
		}
		printAllSum(a, sum - a[i], i + 1, str + "1"); // Take and mark
		printAllSum(a, sum, i + 1, str + "0"); // Not take and not mark
	}
}