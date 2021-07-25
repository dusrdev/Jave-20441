package Recursion;
// import java.util.Scanner;

public class Question13_equalSum {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		// This code doesn't work...
		// I will get back to this question
		int[] arr = {2,1,6,5,4};
		System.out.println("equalSum(arr) = " + equalSum(arr)); //2

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int equalSum(int[] arr) {
		return equalSum(arr, 0, arr.length, 0, 0);
	}

	private static int equalSum(int[] arr, int start, int end, int sumStart, int sumEnd) {
		if (start + 1 == end) {
			if (sumStart == sumEnd) {
				return start;
			}
			return -1;
		}
		if (start >= arr.length || end <= 0) {
			return -1;
		}
		int one = equalSum(arr, start + 1, end, sumStart + arr[start], sumEnd);
		int two = equalSum(arr, start, end - 1, sumStart, sumEnd + arr[end]);
		return Math.max(one,two);
	}
}