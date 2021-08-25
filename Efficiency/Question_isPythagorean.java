package Efficiency;

public class Question_isPythagorean {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * A pythagorean triplet is a group of 3 numbers a, b, c where
		 * a^2+b^2=c^2. We receive an ascending sorted array with no duplicates We need
		 * to find if there is at least one possible pythagorean triplet as efficiently
		 * as possible.
		 */

		int[] a = { 1, 3, 4, 5, 6 };
		int[] b = { 1, 3, 6, 9 };

		System.out.println("isPythagorean(a) = " + isPythagorean(a)); // true; 3,4,5
		System.out.println("isPythagorean(b) = " + isPythagorean(b)); // false

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	/**
	 * This is one possible solution Time Complexity => O(n^2); the last if, makes
	 * it possible to iterate n times from c to the rest
	 * Space Complexity => O(1)
	 * @param arr
	 * @return
	 */
	public static boolean isPythagorean(int[] arr) {
		int a = 0, c = arr.length - 1, b = c - 1, aa, bb, cc;
		while (a != b && b != c && c < arr.length) {
			aa = arr[a] * arr[a]; // a^2
			bb = arr[b] * arr[b]; // b^2
			cc = arr[c] * arr[c]; // c^2
			if (aa + bb == cc) { // If they are equal => this is a pythagorean triplet
				return true;
			} else if (aa + bb > cc) { // aa + bb > cc => reduce b
				b--;
			} else { // aa + bb < cc => increase a
				a++;
			}
			if (a == b) { // if a and b are equal => reduce c and iterate all over
				c--;
				b = c - 1;
				a = 0;
			}
		}
		return false;
	}
}