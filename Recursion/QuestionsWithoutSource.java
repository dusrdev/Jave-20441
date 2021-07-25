package Recursion;
// import java.util.Scanner;

class Cls {
	public static void main (String[] args) {
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		//Q1 => Count the paths from start to finish while only moving by K from each element K.
		int[][] pathsWithK = {{1,3,1,6},
		{2,8,1,2},
		{6,2,7,5},
		{2,4,1,3}};
		System.out.println("pathsWithK = " + howManyPaths(pathsWithK)); //2

		//Q2 => Count the longest path from (0,0) to (x,y) while moving only on 1's
		int[][] longestPath = {{1,1,1,1,1,1,1}, {1,1,0,1,0,0,1}, {1,1,1,1,0,1,1}}; //(2 ,5) -> 16
		System.out.println("longestPath (0,0) -> (2,5) = " + longestPath(longestPath, 2, 5));
		
		//Q3 => Check if an integer can be written as the sum of powers of 3
		//Example: 37 returns true because 37 = 3^0 + 3^2 + 3^3
		System.out.println("sumPower3(37) = " + sumPower3(37)); //True
		System.out.println("sumPower3(38) = " + sumPower3(38)); //False
		
		// ############################################
		System.out.print("\u001B[37m");
	}

	public static int howManyPaths(int[][] mat) {
		boolean[][] mem = new boolean[mat.length][mat[0].length];
		return howManyPaths(mat, 0, 0, mem);
	}

	private static int howManyPaths(int[][] mat, int r, int c, boolean[][] mem) {
		// If out of bounds or already checked, we return 0 so that it doesnt count 
		if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mem[r][c] == true) {
			return 0;
		}
		if (r == mat.length - 1 && c == mat[0].length - 1) { // Reached destination
			return 1;
		}
		int k = mat[r][c]; // Take k
		mem[r][c] = true; // Mark place in copy array as visited
		return howManyPaths(mat, r + k, c, mem) +
		howManyPaths(mat, r - k, c, mem) +
		howManyPaths(mat, r, c + k, mem) +
		howManyPaths(mat, r, c - k, mem);
	}

	public static int howManyPathsV2(int[][] mat) {
		return howManyPathsV2(mat, 0, 0);
	}

	/**
	 * This is a veriation of the howManyPaths where we change the original array instead of copy
	 */ 
	private static int howManyPathsV2(int[][] mat, int r, int c) {
		// If out of bounds or already checked, we return 0 so that it doesnt count 
		if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] == 0) {
			return 0;
		}
		if (r == mat.length - 1 && c == mat[0].length - 1) { //Reached destination
			return 1;
		}
		int k = mat[r][c]; // take K
		mat[r][c] = 0; // Mark as visited
		int sum = howManyPathsV2(mat, r + k, c) +
		howManyPathsV2(mat, r - k, c) +
		howManyPathsV2(mat, r, c + k) +
		howManyPathsV2(mat, r, c - k);
		mat[r][c] = k; // Reset to default
		return sum;
	}

	public static int longestPath(int[][] mat, int x, int y) {
		return longestPath(mat, x, y, 0, 0);
	}

	public static int longestPath(int[][] mat, int x, int y, int i, int j) {
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

	public static boolean sumPower3(int num) {
		if (num < 1) { // There is no power of 3 that equals less than 1
			return false;
		}
		return sumPower3(num, 0);
	}

	public static boolean sumPower3(int num, int currentPower) {
		if (num == 0) { // Reached destination
			return true;
		}
		if (num < 0 || num < Math.pow(3, currentPower)) { // If negative or not worth the effort
			return false; 
		}
		// Take or no take
		// Deside whether to subtract current power of 3 or skip this one.
		return sumPower3(num - (int)Math.pow(3, currentPower), currentPower + 1) || sumPower3(num, currentPower + 1);
	}
}