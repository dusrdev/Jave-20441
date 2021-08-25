package Efficiency;

public class Question_passingCars {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * We receive an array filled with 0's and 1's which represent cars
		 * 0 represents a car that is going east.
		 * 1 represents a car that is going west.
		 * We need to return the number of pairs of elements in which the cars pass each other (meaning one is going west and one east)
		 */

		int[] a = {0,1,0,1,1};
		// |{{0,1},{0,3},{0,4},{2,3},{2,4}}| = 5
		System.out.println("passingCars(a) = " + passingCars(a));

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	/**
	 * This is one possible efficient solution.
	 * Time Complexity => O(2n) = O(n)
	 * Space Complexity => O(1)
	 * @param a
	 * @return
	 */
	public static int passingCars(int[] a) {
		int oneCount = 0, pairCount = 0;
		// Count the number of 1's (cars that are going west)
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				oneCount++;
			}
		}
		// For every 0 we have the number of pairs equivalent to the number of 1's after it
		// So first 0, has oneCount pairs
		// After we pass each 1, we decrease oneCount so the next 0 has less possible pairs.
		for (int i = 0; i < a.length && oneCount > 0; i++) {
			if (a[i] == 0) {
				pairCount += oneCount;
			} else {
				oneCount--;
			}
		}
		return pairCount;
	}
}
