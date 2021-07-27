package Efficiency;

public class Question8_minAbsSum {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q8 => We receive an ascending sorted array with positive and negative integers
		 * no duplicates
		 * we need to return the minimal sum of the absolute values of any element
		 * IE: sum = |a1| + |a2|
		 */

		int[] a = {-2,-1,3,5,7,8,11,17,25,30,36};
		System.out.println("minAbsSum(a) = " + minAbsSum(a)); // 4; |-1| + |3|

		/**
		 * In this question I believe an O(n^2) solution will get minimal score.
		 * There is also an in-between option which will be O(n) with a sliding window.
		 * I imagine it will get at close to the maximum number of points as it also shows
		 * good thinking.
		 */

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	/**
	 * Looking at this mathematically, the smallest sum of two absolute values
	 * will be the the number closest to 0 and either the number left of it or right of it
	 * We will search for this number and then we only have 2 options
	 * Time Complexity => O(logn)
	 * Space Complexity => O(1)
	 * @param a
	 * @return
	 */
	public static int minAbsSum(int[] a) {
		int low = 0, high = a.length - 1, mid = 0;
		
		// Binary search for 0 => O(logn)
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == 0) {
				break;
			} else if (a[mid] > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// Now mid is the number closest to zero

		// Initiate both options as MAX_VALUE because one can be out of bounds
		// So it will not be calculated and if it is max, it will fall in Math.min
		int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;

		// First options is if we have elements to the left
		if (mid > 0) {
			op1 = Math.abs(a[mid-1]) + Math.abs(a[mid]);
		}
		// Second is if we have elements to the right
		if (mid < a.length - 1) {
			op2 = Math.abs(a[mid]) + Math.abs(a[mid + 1]);
		}
		return Math.min(op1, op2); // return the smallest of those 2 options
	}
}
