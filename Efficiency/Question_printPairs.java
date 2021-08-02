package Efficiency;
import java.util.Arrays;

public class Question_printPairs {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q2 => We receive an ascending sorted array a and an integer k
		 * we need to print all pairs of elements in which the difference between the elements is equal to k
		 * 
		 * a = {-7, -3,0,1,3,5,12,14,17,19,25,30};
		 * 
		 * for k=2:
		 * {1,3}, {3,5}, {12,14}, {17,19}
		 * for k=6:
		 * {-3,3}, {19,25}
		 */

		int[] a = {-7, -3,0,1,3,5,12,14,17,19,25,30};
		System.out.println("a => " + Arrays.toString(a));
		System.out.println("k = 2:");
		printPairs(a, 2);
		System.out.println("k = 6:");
		printPairs(a, 6);

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	/**
	 * This is the most efficient solution => Algorithm = sliding window
	 * Time complexity => O(n)
	 * Space complexity => O(1)
	 * @param a
	 * @param k
	 */
	public static void printPairs(int[] a, int k) {
		int x = 0, y = 1, diff; //x is the first in the pair and y second, diff prevents multiple calculations for the same pair, unneccessary but good practice
		// x<=y keeps us in ascending order, y < a.length prevents going out of bounds
		while (x <= y && y < a.length) {
			diff = a[y] - a[x]; // difference calculation
			if (diff > k) { // If difference is bigger we decrease it
				x++;
			}
			else if (diff < k) { // If difference is smaller we increase it
				y++;
			}
			else { // If the difference is right, we print and increment both; if we don't increment both we will continue to print the same pair forever
				System.out.println("Pair Found: (" + a[x] + "," + a[y] + ")");
				x++;
				y++;
			}
		}
	}
}
