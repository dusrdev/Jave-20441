package Recursion;

public class Question_balancedPartition {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * This question is almost identical to "splitEqualSum" the only difference is
		 * we need to count the amount of items in each sum and in the end compare those
		 * counters as well
		 */

		System.out.println(
				"balancedPartition({-3,5,12,14,-9,13}) => " + balancedPartition(new int[] { -3, 5, 12, 14, -9, 13 })); // True
		System.out.println(
				"balancedPartition({-3,5,-12,14,-9,13}) => " + balancedPartition(new int[] { -3, 5, -12, 14, -9, 13 })); // False
		System.out.println(
				"balancedPartition({-3,5,-12,14,-9}) => " + balancedPartition(new int[] { -3, 5, -12, 14, -9 })); // False

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static boolean balancedPartition(int[] arr) {
		return balancedPartition(arr, 0, 0, 0, 0, 0);
	}

	private static boolean balancedPartition(int[] arr, int i, int count1, int sum1, int count2, int sum2) {
		if (i >= arr.length) { // reached end
			return count1 == count2 && sum1 == sum2; // we need both sums and counts to be equal
		}
		// We try to add the current value to one or the other
		boolean take1 = balancedPartition(arr, i + 1, count1 + 1, sum1 + arr[i], count2, sum2); // Add to first
		boolean take2 = balancedPartition(arr, i + 1, count1, sum1, count2 + 1, sum2 + arr[i]); // Add to second
		return take1 || take2; // either this or that
	}
}
