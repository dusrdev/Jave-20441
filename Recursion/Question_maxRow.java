package Recursion;

public class Question_maxRow {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[][] mat = { { 2, 6, 5, 4 }, { 3, 17, 2, 6 }, { 1, 3, 21, 0 } };
		System.out.println("maxRow(mat) = " + maxRow(mat)); // 1

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int maxRow(int[][] mat) {
		return maxRow(mat, 0, 0, 0, 0, 0);
	}

	private static int maxRow(int[][] mat, int i, int j, int sum, int max, int maxRow) {
		if (j == mat[0].length) { // reached end of line
			if (sum > max) { // compare sum and max, and save if bigger
				max = sum;
				maxRow = i;
			}
			i++; // next line
			j = 0; // first column
			sum = 0; // reset sum
		}
		if (i >= mat.length) { // Finished all rows
			return maxRow;
		}
		return maxRow(mat, i, j + 1, sum + mat[i][j], max, maxRow); // Recursive call
	}
}
