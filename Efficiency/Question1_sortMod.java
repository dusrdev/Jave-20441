package Efficiency;

import java.util.Arrays;

public class Question1_sortMod {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q1 => k mod array is an array where for every i,j indexes, array[i]%k <=
		 * array[j]%k we need to get an array of positive integers and sort it to make
		 * it a k mod array in maximum efficiency. {35,17,13,252,4,128,7,3,81} =>
		 * {81,252,13,3,4,35,17,7,128}
		 * 
		 * Important Note:
		 * The key in this question is realizing that K is a fixed value,
		 * thus, any loop of 0->K will have time efficieny of O(1)
		 */
		int[] a = { 35, 17, 13, 252, 4, 128, 7, 3, 81 };
		System.out.println("a[] => kmod[]");
		System.out.print(Arrays.toString(a) + " => ");
		sortMod(a, 10);
		System.out.print(Arrays.toString(a));

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	/**
	 * Most efficient solution
	 * It seems like it is O(k*n) which looks worse than O(nlogn)
	 * but K is a fixed value => O(k*n) = k * O(n) = O(n)
	 * @param a
	 * @param k
	 */
	public static void sortMod(int[] a, int k) {
		int posA = 0, temp;

		// We loop from the start of the % -> 0 Will be first in order and so on...
		for (int i = 0; i <= k && posA < a.length; i++) {
			// Loop from the last saved position
			for (int j = posA; j < a.length && posA < a.length; j++) {
				// If A[j]%k == 1 means every element with the correct order from i->k will go to the array starting for saved position
				// It will start from the start of the array, then after all the places with %k==1 and so on...
				if (a[j] % k == i) {
					// Swap places
					temp = a[posA];
					a[posA] = a[j];
					a[j] = temp;
					// Increase current position
					posA++; 
				}
			}
		}
		// Adding posA < a.length as an additional check prevents going out of bounds or re-sorting already sorted elements.
	}

	/**
	 * Trivial solution => to modify any sorting algorithm (even the quickest one)
	 * The modification is comparing each value by the %k
	 * Very simple to code, therefore, trivial
	 * @param arr
	 * @param start
	 * @param end
	 * @param k
	 */
	public static void quickSort(int[] arr, int start, int end, int k) {

		int partition = partition(arr, start, end, k);

		if (partition - 1 > start) {
			quickSort(arr, start, partition - 1, k);
		}
		if (partition + 1 < end) {
			quickSort(arr, partition + 1, end, k);
		}
	}

	public static int partition(int[] arr, int start, int end, int k) {
		int pivot = arr[end], temp;

		for (int i = start; i < end; i++) {
			if (arr[i] % k <= pivot % k) {
				temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
			}
		}

		temp = arr[start];
		arr[start] = pivot;
		arr[end] = temp;

		return start;
	}
}
