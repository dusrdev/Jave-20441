package Recursion;

public class Question2_longestPath {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * Q3 => Return the longest possible path from (0,0) to (x,y) while moving only on 1's
		 */
		int[][] longestPath = {{1,1,1,1,1,1,1}, {1,1,0,1,0,0,1}, {1,1,1,1,0,1,1}}; //(2 ,5) -> 16
		System.out.println("longestPath (0,0) -> (2,5) = " + longestPath(longestPath, 2, 5)); // 16

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int longestPath(int[][] mat, int x, int y) {
		return longestPath(mat, x, y, 0, 0);
	}

	private static int longestPath(int[][] mat, int x, int y, int i, int j) {
		// If out of bounds or already checked, we return Min_value so that it falls through in the Math.max
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) {
			return Integer.MIN_VALUE;
		}
		if (i == x && j == y) { // Reached destination
			return 1;
		}
		mat[i][j] = 0; // Mark place as visited
		int sumleft = 1 + longestPath(mat, x, y, i - 1, j);
		int sumright = 1 + longestPath(mat, x, y, i + 1, j);
		int sumup = 1 + longestPath(mat, x, y, i, j - 1);
		int sumdown = 1 + longestPath(mat, x, y, i, j + 1);
		mat[i][j] = 1; // Return array to default
		return Math.max(Math.max(sumleft, sumright), Math.max(sumup, sumdown));
	}
}
