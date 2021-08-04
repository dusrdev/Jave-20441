package Recursion;

public class Question_shortestPath {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[][] mat = { { 3, 13, 15, 28, 30 }, { 40, 51, 52, 29, 30 }, { 28, 10, 53, 54, 54 }, { 53, 12, 55, 53, 60 },
				{ 70, 62, 56, 20, 80 }, { 80, 81, 90, 95, 100 } };
		System.out.println("shortestPath(mat) => " + shortestPath(mat)); //10

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static int shortestPath(int[][] mat) {
		return shortestPath(mat, 0, 0, Integer.MIN_VALUE, 0);
	}

	/**
	 * @param mat
	 * @param i - row 
	 * @param j - column
	 * @param prev - previous value to ensure order
	 * @param length - length of current path
	 * @return
	 */
	private static int shortestPath(int[][] mat, int i, int j, int prev, int length) {
		// if we are out of bounds or visited or not in order; we return max value so it falls out in the math.min
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == Integer.MAX_VALUE
				|| mat[i][j] <= prev) {
			return Integer.MAX_VALUE;
		}
		if (i == mat.length - 1 && j == mat[0].length - 1) { // if we have reached end we return current place + path length
			return length + 1;
		}
		prev = mat[i][j]; // save current as previous
		mat[i][j] = Integer.MAX_VALUE; // mark as visited
		int up = shortestPath(mat, i - 1, j, prev, length + 1);
		int down = shortestPath(mat, i + 1, j, prev, length + 1);
		int left = shortestPath(mat, i, j - 1, prev, length + 1);
		int right = shortestPath(mat, i, j + 1, prev, length + 1);
		mat[i][j] = prev; // return original value
		return Math.min(Math.min(up, down), Math.min(left, right));
	}
}
