package Recursion;
import java.util.Arrays;

public class Question_merge {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[] ar1 = { 1, 2, 2 };
		int[] ar2 = { 2, 4, 6 };
		System.out.println("merge(ar1, ar2) = " + Arrays.toString(merge(ar1, ar2))); // {1,2,2,2,4,6}

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int[] merge(int[] ar1, int[] ar2) {
		int[] union = new int[ar1.length + ar2.length];
		return merge(ar1, ar2, union, 0, 0);
	}

	private static int[] merge(int[] ar1, int[] ar2, int[] union, int x, int y) {
		if (x+y == union.length) { // Reached end
			return union;
		}
		// If within bounds & 1 smaller than 2 or 2 is at the end
		if ((x < ar1.length && y < ar2.length && ar1[x] <= ar2[y]) || y == ar2.length) {
			union[x+y] = ar1[x];
			x++;
		} else { // If 2 is smaller than 1
			union[x+y] = ar2[y];
			y++;
		}
		return merge(ar1, ar2, union, x, y);
	}
}
