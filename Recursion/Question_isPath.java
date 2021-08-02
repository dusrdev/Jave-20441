package Recursion;

public class Question_isPath {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[][] mat = { { 8, 9, 5, 1, 7, 8 }, { 9, 5, 5, 16, 17, 18 }, { 10, 11, 6, 15, 2, 19 },
				{ 7, 12, 13, 14, 4, 20 }, { 9, 13, 4, 15, 22, 21 }, { 10, 11, 12, 12, 23, 22 } };

		System.out.println("isPath(mat) = " + isPath(mat)); // True

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static boolean isPath(int[][] mat) {
		return isPath(mat, 0, 0, mat[0][0]);
	}

	private static boolean isPath(int[][] mat, int i, int j, int prev) {
		if (i == mat.length - 1 && j == mat[0].length - 1) { // If end is reached
			return true;
		}
		prev = mat[i][j]; // save current value
		// In each direction we check bounds, and if prev is smaller than next, only then we move!
		boolean left = j - 1 >= 0 && prev < mat[i][j - 1] && isPath(mat, i, j - 1, prev);
		boolean right = j + 1 < mat[0].length && prev < mat[i][j + 1] && isPath(mat, i, j + 1, prev);
		boolean up = i - 1 >= 0 && prev < mat[i - 1][j] && isPath(mat, i - 1, j, prev);
		boolean down = i + 1 < mat.length && prev < mat[i + 1][j] && isPath(mat, i + 1, j, prev);
		return left || right || up || down; // If any of them is true, return true
	}
}
