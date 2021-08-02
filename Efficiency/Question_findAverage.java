package Efficiency;

public class Question_findAverage {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q9 => Write an efficient function which receives an ascending sorted array
		 * and double x the function should return whether the array has a group of
		 * consecutive elements whose average equals x.
		 */

		int[] arr = { 2, 3, 8, 14, 15, 35 };
		findAverage(arr, 8); // 2 -- 2
		findAverage(arr, 10); // 1 -- 4
		findAverage(arr, 2.5); // 0 -- 1
		findAverage(arr, 8.5); // Not found


		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	/**
	 * One possible answer using sum and convergence
	 * We sum all the values in the array
	 * Then we decrease from each side according to if the current average is smaller or larger
	 * than x
	 * Time Complexity => O(2n) => O(n)
	 * Space Complexity => O(1)
	 * @param arr
	 * @param x
	 * @return
	 */
	public static boolean findAverage(int[] arr, double x) {
		int sum = 0;

		// sum up all the array
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		// Convergence
		int i = 0, j = arr.length - 1;
		double average = 0;

		while (i <= j) {
			average = sum / (double)(j - i + 1); // Calculate new average
			if (average == x) { // If equal print and return true
				System.out.println(i + " -- " + j);
				return true;
			} else if (average < x) { // If below, we remove from start to enlarge average
				sum -= arr[i];
				i++;
			} else { // If above we remove from end to decrease average
				sum -= arr[j];
				j--;
			}
			// We can remove from the sides because the array is ordered.
			// Smaller values in the start decrease average
			// Bigger values in the end increase average
		}

		System.out.println("Not found");
		return false;
	}
}
