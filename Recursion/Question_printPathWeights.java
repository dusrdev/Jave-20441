package Recursion;

public class Question_printPathWeights {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[][] m = { { 8, 4, 2, 4, 3 }, { 6, 3, 8, 4, 5 }, { 1, 4, 9, 9, 7 }, { 2, 1, 7, 6, 5 } };
		printPathWeights(m);

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static void printPathWeights(int[][] m) {
		printPathWeights(m, 0, 0, 0, "");
	}

	private static void printPathWeights(int[][] m, int i, int j, int sum, String path) {
		// i or j are out of bounds or place has been visited
		if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] == -1) {
			return;
		}
		// If reached end
		if (i == m.length - 1 && j == m[0].length - 1) {
			sum += m[i][j]; // Add last element to sum
			System.out.println(path + m[i][j] + " = " + sum); // format output
			return;
		}
		int current = m[i][j]; // save current value
		m[i][j] = -1; // mark place as visited
		// Continue to all 4 directions
		printPathWeights(m, i + 1, j, sum + current, path + current + "+");
		printPathWeights(m, i - 1, j, sum + current, path + current + "+");
		printPathWeights(m, i, j + 1, sum + current, path + current + "+");
		printPathWeights(m, i, j - 1, sum + current, path + current + "+");
		m[i][j] = current; // return value to original
		return;
	}
}
