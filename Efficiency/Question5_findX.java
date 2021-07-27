package Efficiency;

public class Question5_findX {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################
		
		/**
		 * Q5 => A semi-sorted array is an array in which the even indexes are sorted
		 * ascending and the odd indexes are sorted ascending but they are sorted
		 * seperately We receive a semi-sorted array and need to check if there is a
		 * pair of 2 consecutive elements which sum is x
		 */

		int[] a = { 1, 2, 5, 3, 6, 10, 9 };

		System.out.println("findX(a, 9) = " + findX(a, 9)); // true; 3+6
		System.out.println("findX(a, 5) = " + findX(a, 5)); // false

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	/**
	 * The solution is a modified binary search instead of searching for a single
	 * element we search for the element and the one after it. Required modifitions
	 * are 2 mid values, and a second check in the while loop to prevent the mid + 1
	 * going out of bounds
	 * Time Complexity => O(logn)
	 * Space Complexity => O(1)
	 * @param a
	 * @param x
	 * @return
	 */
	public static boolean findX(int[] a, int x) {
		int low = 0, high = a.length - 1, mid1, mid2, sum;
		while (low <= high && low < a.length - 1) {
			mid1 = (low + high) / 2;
			mid2 = mid1 + 1;
			sum = a[mid1] + a[mid2];
			if (sum > x) {
				low = mid2;
			} else if (sum < x) {
				high = mid1 - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}