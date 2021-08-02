package Recursion;

public class Question_longestFlat {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[] arr = { 4, 5, 6, 5, 4, 3 };
		System.out.println("longestFlat(arr) => " + longestFlat(arr)); // 3

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static int longestFlat(int[] arr) {
		if (arr.length <= 1) { // If array is empty or 1 element it is a flat sequence in itself
			return 1;
		}
		return longestFlat(arr, 0, 0);
	}

	private static int longestFlat(int[] arr, int i, int max) {
		if (i >= arr.length) { // if out of bounds return max
			return max;
		}
		int fromHere = lengthFlatSequence(arr, i, 1, arr[0], arr[0]); // check the max from here
		// we need to check from each place to the end because we can have different sets of numbers in the array
		// if we were to calculate count here we would only be able to count if we have one of two numbers.
		if (fromHere > max) { // if count here is bigger than max set max to count
			max = fromHere;
		}
		return longestFlat(arr, i + 1, max); // move forward
	}

	private static int lengthFlatSequence(int[] arr, int index, int count, int firstValue, int secondValue) {
		if (index >= arr.length) { // if we passed bounds return count
			return count;
		}
		// we call the function initially with both numbers as the same one
		// as soon as we reach a different number we set the second to it
		if (arr[index] != firstValue && firstValue == secondValue) {
			secondValue = arr[index];
		}
		// If not first and not second, the flat sequence stops so return the current count
		// we need to return count here because we move forward in longestFlat
		// if we only return in the end and reset here, we will always get the last sequence,
		// not necessarily the longest.
		if (arr[index] != firstValue && arr[index] != secondValue) {
			return count;
		} else { // is equal to one of them, increase count
			count++;
		}
		// go forward
		return lengthFlatSequence(arr, index + 1, count, firstValue, secondValue);
	}
}
