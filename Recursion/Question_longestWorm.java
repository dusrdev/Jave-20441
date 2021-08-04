package Recursion;

public class Question_longestWorm {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[][] mat = {{3,13,15,28,30},{50,51,52,29,30},{51,10,53,54,55}, {53,12,14,53,11}};
		System.out.println("longestWorm(mat) => " + longestWorm(mat)); // 6

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static int longestWorm(int[][] mat) {
		return longestWorm(mat, 0, 0, mat[0][0] - 1, 1, 1);
	}

	/**
	 * @param mat
	 * @param i - row
	 * @param j - column
	 * @param prev - previous value to ensure we are counting only in worm configuration
	 * @param count - current worm length
	 * @param max - max length in current path
	 * @return
	 */
	private static int longestWorm(int[][] mat, int i, int j, int prev, int count, int max) {
		// If we are out of bounds return current max, it fits also if the we passed all values
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == Integer.MIN_VALUE) {
			return max;
		}
		if (mat[i][j] - prev != 1) { // If current n is not (n-1) + 1, meaning is not part of a worm
			count = 1; // any element can start a worm, so we reset to 1 and not 0
		}
		prev = mat[i][j]; // save current element as prev
		mat[i][j] = Integer.MIN_VALUE; // mark place as visited
		if (count > max) { // always remember the max
			max = count;
		}
		int up = longestWorm(mat, i - 1, j, prev, count + 1, max);
		int down = longestWorm(mat, i + 1, j, prev, count + 1, max);
		int left = longestWorm(mat, i, j - 1, prev, count + 1, max);
		int right = longestWorm(mat, i, j + 1, prev, count + 1, max);
		mat[i][j] = prev; // return original value
		return Math.max(Math.max(up, down), Math.max(left, right));
	}
}
