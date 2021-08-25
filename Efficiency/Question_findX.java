package Efficiency;

public class Question_findX {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################
		
		/**
		 * A semi-sorted array is an array in which the even indexes are sorted
		 * ascending and the odd indexes are sorted ascending but they are sorted
		 * separately We receive a semi-sorted array and need to check if there is a
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
	 * element we search for the element and the one after it. Required modifications
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
		// usual binary search condition, second condition prevents going out of bounds with arr[low+1]
		while (low <= high && low < a.length - 1) {
			mid1 = (low + high) / 2; // set middle
			mid2 = mid1 + 1; // middle+1
			sum = a[mid1] + a[mid2]; // saves as a duplicate calculation
			if (sum < x) { // need bigger values in sum
				low = mid2;
			} else if (sum > x) { // need smaller values in sum
				high = mid1 - 1;
			} else { // destination
				return true;
			}
		}
		return false;
	}
}