package Recursion;

public class Question_countPaths {
	public static void main (String[] args) {
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		int[][] countPaths = {{12,22,23,54}, 
		{43,35,21,20}, 
		{34,21,43,21}, 
		{25,30,0,20}, 
		{0, 22, 10, 10}, 
		{20, 13, 3, 45}};
		System.out.println("countPaths(countPaths) = " + countPaths(countPaths)); //3
		
		
		// ############################################
		System.out.print("\u001B[37m");
	}

	public static int countPaths(int[][] mat) {
		return countPaths(mat, 0, 0);
	}

	private static int countPaths(int[][] mat, int i, int j) {
		// If out of bounds or already checked, we return 0 so that it falls through in the Math.max
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) {
			return Integer.MIN_VALUE;
		}
		if (i == mat.length - 1 && j == mat[0].length - 1) { // Reached destination
			return 1;
		}
		int val = mat[i][j];
		mat[i][j] = 0; // Mark as visited
		// We can move according to the digits of val
		int sum = countPaths(mat, i + (val % 10), j + (val / 10)) +
		countPaths(mat, i + (val / 10), j + (val % 10));
		mat[i][j] = val; // Return to original value
		return sum;
	}
}
