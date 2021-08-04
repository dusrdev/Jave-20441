package Recursion;

public class Question_splitEqualMult {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * This question is almost exactly the same as splitEqualSum but instead of sum
		 * we compare the multiplication of all the elements in both groups
		 */

		System.out.println("splitEqualMult(a) => " + splitEqualMult(new int[] { 2, 15, 3, 4, 2, 5 })); // True
		System.out.println("splitEqualMult(a) => " + splitEqualMult(new int[] { 2, 4, 6, 2, 3, 4 })); // False

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static boolean splitEqualMult(int[] a) {
		return splitEqualMult(a, 0, 1, 1);
	}

	private static boolean splitEqualMult(int[] a, int i, int mult1, int mult2) {
		if (i >= a.length) { // If we passed the end, check if groups meet requirements
			return mult1 == mult2;
		}
		boolean take1 = splitEqualMult(a, i + 1, mult1 * a[i], mult2); // Add to first group
		boolean take2 = splitEqualMult(a, i + 1, mult1, mult2 * a[i]); // Add to second
		return take1 || take2; // return which ever is true if any, or false
	}
}
