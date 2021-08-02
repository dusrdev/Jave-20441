package Recursion;

public class Question_splitEqualSum {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[] a1 = {2,8,3,4,2,5};
		int[] a2 = {2,4,6,2,3,4};

		System.out.println("splitEqualSum(a1) = " + splitEqualSum(a1)); // True
		System.out.println("splitEqualSum(a2) = " + splitEqualSum(a2)); // False

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static boolean splitEqualSum(int[] a) {
		return splitEqualSum(a, 0, 0, 0);
	}

	private static boolean splitEqualSum(int[] a, int i, int sum1, int sum2) {
		if (i >= a.length) { // When reached the end return if the sums are equal
			return sum1 == sum2;
		}
		// Recursive call: we need to check all combinations so we use OR
		// in both calls we move forward in the index, but we add the current element
		// to a different sum
		return splitEqualSum(a, i + 1, sum1 + a[i], sum2) || splitEqualSum(a, i + 1, sum1, sum2 + a[i]);
 	}
}