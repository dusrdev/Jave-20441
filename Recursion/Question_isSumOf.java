package Recursion;

public class Question_isSumOf {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[] s1 = { 4, 5 };
		int[] s2 = { 4, 9, 3 };

		System.out.println("isSumOf(s1, 13) = " + isSumOf(s1, 13)); // True => 4 4 5
		System.out.println("isSumOf(s1, 6) = " + isSumOf(s1, 6)); // False
		System.out.println("isSumOf(s2, 15) = " + isSumOf(s2, 15)); // True => 4 4 4 3 || 9 3 3
		System.out.println("isSumOf(s2, 5) = " + isSumOf(s2, 5)); // False
		System.out.println("isSumOf(s2, 0) = " + isSumOf(s2, 0)); // True

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static boolean isSumOf(int[] s, int n) {
		return isSumOf(s, n, 0, "");
	}

	private static boolean isSumOf(int[] s, int n, int i, String used) {
		if (i >= s.length) { // If we are out of bounds and not returned true yet, we are out of options.
			return false;
		}
		if (n == 0) { // If we reach 0, we print the used items and return true
			System.out.println(used);
			return true;
		}
		else if (n < 0) { // If we passed 0, false
			return false;
		}
		// Recursive calls: Common pattern -> take and do again || not take and proceed
		return isSumOf(s, n - s[i], i, used + s[i] + " ") || isSumOf(s, n, i + 1, used);
	}
}
