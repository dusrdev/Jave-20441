package Efficiency;

public class Question4_included {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q4 => x is k-included in y if every digit in x except k digits is included in y
		 * If a digit appears multiple times in x, it is enough that it appears 1 time in y
		 * Example:
		 * 4342113 is k-included in 45111 with k=2
		 */

		System.out.println("included(4342113, 45111) = " + included(4342113, 45111));

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	/**
	 * This is one possible efficient solution
	 * Time Complexity => O(2n + 10) = O(n)
	 * Space Complexity => O(12) = O(1)
	 * @param x
	 * @param y
	 * @return
	 */
	public static int included(int x, int y) {
		int k = 0;
		// We create an array which represents all digits from 0 to 9
		boolean[] digits = new boolean[10];

		// Every digit in x will be marked True in digits
		while (x > 0) {
			digits[x % 10] = true;
			x /= 10;
		}

		// Every digit in y will be marked False in digits
		while (y > 0) {
			digits[y % 10] = false;
			y /= 10;
		}

		//After previous loops, the only True values in digits
		//are values which are in x but not in y; exactly what k is
		//All is left now is to count the true values into k
		for (int i = 0; i < digits.length; i++) {
			if (digits[i]) {
				k++;
			}
		}

		return k;
	}
}
