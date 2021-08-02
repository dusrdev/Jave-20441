package Recursion;

public class Question_match {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[] pattern = { 1, 0, 2 };

		System.out.println("match({2, 3, 57}, {1, 0, 2}) = " + match(new int[] { 2, 3, 57 }, pattern)); // true
		System.out.println("match({5, 39, 67}, {1, 0, 2}) = " + match(new int[] { 5, 39, 67 }, pattern)); // true
		System.out.println(
				"match({2, 3, 573, 4, 34, 35}, {1, 0, 2}) = " + match(new int[] { 2, 3, 573, 4, 34, 35 }, pattern)); // true
		System.out.println(
				"match({2, 3, 573, 4, 324, 35}, { }) = " + match(new int[] { 2, 3, 53, 4, 324, 35 }, new int[] {})); // true
		System.out.println("match({2, 3}, {1, 0, 2}) = " + match(new int[] { 2, 3 }, pattern)); // false
		System.out.println(
				"match({2, 3, 573, 4, 324, 35}, {1, 0, 2}) = " + match(new int[] { 2, 3, 573, 4, 324, 35 }, pattern)); // false

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static boolean match(int[] a, int[] pattern) {
		return match(a, pattern, 0, 0);
	}

	private static boolean match(int[] a, int[] pattern, int i, int j) {
		// If we reach pattern length then all conditions have been met
		// If pattern is empty we still reach end because j is 0 at start and length of
		// empty
		// array is 0 so j >= pattern.length => 0 >= 0
		if (j >= pattern.length) {
			return true;
		}
		if (i >= a.length) { // We haven't reached conditions but a is ended so false
			return false;
		}
		if (pattern[j] == 0 && a[i] >= 0 && a[i] <= 99) { // condition 0, increase index of pattern
			j++;
		} else if (pattern[j] == 1 && a[i] >= 0 && a[i] <= 9) { // condition 1, increase index
			j++;
		} else if (pattern[j] == 2 && a[i] >= 10 && a[i] <= 99) { // condition 2, increase index
			j++;
		} else { // condition of pattern has not been met, reset index
			j = 0;
		}
		// Continue iteration
		return match(a, pattern, i + 1, j);
	}
}
