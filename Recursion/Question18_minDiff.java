package Recursion;

public class Question18_minDiff {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q18 => We get an array filled with not negative numbers (0+) We need to split
		 * the array into 2 arrays which in union produce the original array And return
		 * the difference between the arrays of the 2 arrays that produce the minimal
		 * difference
		 */

		int[] arr1 = { 1, 2, 3, 4 }; // 0
		int[] arr2 = { 1, 2, 7, 17, 6 }; // 1
		System.out.println("minDiff({1,2,3,4}) = " + minDiff(arr1));
		System.out.println("minDiff({1,2,7,17,6}) = " + minDiff(arr2));

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static int minDiff(int[] arr) {
		return minDiff(arr, 0, 0, 0);
	}

	/**
	 * By looking at this code you can clearly see the pattern is very similar to
	 * other questions in this folder; You start with the stopping condition which
	 * is when the index in the array passes it's length (out of bounds) here you
	 * use the requirements of the question to return the difference between both
	 * sums then iteration we return the minimum of 2 recursive calls (in each one
	 * we add the current item to another sum; this ensures we have different items
	 * in each array) 
	 * @param arr 
	 * @param i
	 * @param sum1
	 * @param sum2
	 * @return
	 */
	private static int minDiff(int[] arr, int i, int sum1, int sum2) {
		if (i >= arr.length) { // Out of bounds
			return Math.abs(sum1 - sum2); // difference between sums
		}
		return Math.min(minDiff(arr, i + 1, sum1 + arr[i], sum2), minDiff(arr, i + 1, sum1, sum2 + arr[i])); // minimum between recursive calls
	}
}