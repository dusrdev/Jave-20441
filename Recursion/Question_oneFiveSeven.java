package Recursion;
// import java.util.Scanner;

public class Question_oneFiveSeven {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Every positive integer can be written as the sum of 1's, 5's and 7's
		 * IE: 6 = 1 + 5, 10 = 5 + 5, 10 = 7 + 1 + 1 + 1...
		 * The question is to create a function that receives a positive integer
		 * and returns the minimum number of sum elements for that number.
		 * IE: 5 => 1, 10 => 2; 10 = 5 + 5, 6 => 2; 6 = 5 + 1
		 */
		System.out.println("oneFiveSeven(10) = " + oneFiveSeven(10)); // 2
		System.out.println("oneFiveSeven(5) = " + oneFiveSeven(5)); // 1
		System.out.println("oneFiveSeven(6) = " + oneFiveSeven(6)); // 2

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int oneFiveSeven(int num) {
		 // Returns a very big number
		 // If Integer.MAX_VALUE is used it produces unwanted results
		 // Because Integer.MAX_VALUE + 1 is Integer.MIN_VALUE which will win in Math.min()...
		if (num < 0) {
			return 1000000;
		}
		if (num == 0) { // Reached destination
			return 0;
		}
		int one = 1 + oneFiveSeven(num - 1);
		int five = 1 + oneFiveSeven(num - 5);
		int seven = 1 + oneFiveSeven(num - 7);
		return Math.min(one, Math.min(five, seven));
	}
}