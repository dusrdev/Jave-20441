package Recursion;
// import java.util.Scanner;

public class Question6_Split3 {
	public static void main(String[] args) {
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[] arr1 = { 8, 4, 7, 1, 2, 3, 5 };
		int[] arr2 = { 8, 4, 7, 1, 3, 5 };

		System.out.println("Split3(arr1) = " + split3(arr1)); // True
		System.out.println("Split3(arr2) = " + split3(arr2)); // False

		// ############################################
		System.out.print("\u001B[37m");
	}

	public static boolean split3(int[] arr) {
		return split3(arr, 0, 0, 0, 0);
	}

	private static boolean split3(int[] arr, int i, int sum1, int sum2, int sum3) {
		// If checked all elements compare all 3 sums
		if (i == arr.length) {
			return sum1 == sum2 && sum2 == sum3;
		}
		// Continue to 3 branches where in each one we add current to a different sum
		return split3(arr, i + 1, sum1 + arr[i], sum2, sum3) || split3(arr, i + 1, sum1, sum2 + arr[i], sum3)
				|| split3(arr, i + 1, sum1, sum2, sum3 + arr[i]);
	}
}