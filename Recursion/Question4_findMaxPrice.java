package Recursion;
// import java.util.Scanner;

public class Question4_findMaxPrice {

	public static void main (String[] args) {
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		// For this array and stick of length 8, max price is 23; 23 = 3+10+10
		int[] prices = {0,1,3,10,9,10,17,17,20};
		System.out.println("findMaxPrice(prices, 8) = " + findMaxPrice(prices, 8)); //23

		// ############################################
		System.out.print("\u001B[37m");
	}

	public static int findMaxPrice(int[] prices, int n) {
		return findMaxPrice(prices, n, 1);
	}

	public static int findMaxPrice(int[] prices, int n, int i) {
		// If we are out of bounds or passed acceptable length
		if (i >= prices.length || n < 0) {
			return Integer.MIN_VALUE;
		}
		if (n == 0) { // Reached destination
			return 0;
		}
		//				(take price + continue with less length) || skip current index
		return Math.max(prices[i] + findMaxPrice(prices, n - i, i), findMaxPrice(prices, n, i + 1));
	}
}