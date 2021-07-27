package Efficiency;

public class Question7_printClosest {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q7 => We receive two ascending sorted arrays and an integer x we need to
		 * print the 2 elements (one from each array) where their sum is the closest to
		 * x
		 */

		int[] a = { 0, 4, 6, 11, 11 };
		int[] b = { 10, 20, 30, 40 };
		printClosest(a, b, 11); // 0 10
		printClosest(a, b, 13); // 4 10
		printClosest(a, b, 18); // 0 20 || 11 30
		printClosest(a, b, 70); // 0 40

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	/**
	 * This is one possible solution for the question Time Complexity => O(n) Space
	 * Complexity => O(1)
	 * 
	 * @param a
	 * @param b
	 * @param x
	 */
	public static void printClosest(int[] a, int[] b, int x) {
		int first = 0, second = b.length - 1;
		int x1 = 0, x2 = 0, min = Integer.MAX_VALUE, sum;
		while (first < a.length && second >= 0) { // in bounds
			sum = a[first] + b[second];
			if (Math.abs(x - sum) < min) { // If the distance is smaller than previous smallest
				min = Math.abs(x - sum); // Save the distance
				x1 = a[first]; // Save the first element
				x2 = b[second]; // Save the second element
			}
			if (sum == x) { // If they are equal, it is as close as possible so no further check needed
				break;
			} else if (sum > x) { // If it is bigger we decrease in the second
				second--;
			} else { // sum < x => if smaller we increase first
				first++;
			}
		}
		System.out.println(x1 + " and " + x2);

		/**
		 * It is important to know that while this algorithm works like as good as
		 * possible with this time complexity, and it does produce the desired output,
		 * it is not the most correct. 
		 * int[] a = {0,4,6,11,11}
		 * int[] b = {10,20,30,40}
		 * 
		 * this function with x = 18:
		 * produces 0 and 20 => distance = 20
		 * where the most correct solution is 11 and 30 => distance = 19
		 * 
		 * There are more examples, to achieve the perfect answers we need
		 * time complexity of n^2...
		 */
	}
}
