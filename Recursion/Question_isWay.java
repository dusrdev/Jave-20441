package Recursion;

public class Question_isWay {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[] a1 = { 2, 4, 1, 6, 4, 2, 4, 3, 5 };
		int[] a2 = { 1, 4, 3, 1, 2, 4, 3 };

		System.out.println("isWay(a1) = " + isWay(a1)); // True
		System.out.println("isWay(a2) = " + isWay(a2)); // False

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static boolean isWay(int[] a) {
		return isWay(a, 0);
	}

	private static boolean isWay(int[] a, int i) {
		if (i < 0 || i >= a.length || a[i] == 0) { // If out of bounds or place has been visited
			return false;
		}
		if (i == a.length - 1) { // If at the last element
			return true;
		}
		int val = a[i]; // save current value
		a[i] = 0; // mark place as visited
		boolean result = isWay(a, i + val) || isWay(a, i - val); // check right or left
		a[i] = val; // reset value
		return result;
	}
}
