// import java.util.Scanner;

class Cls {
	public static void main (String[] args) {
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		//Q1 => Count the paths from start to finish while only moving by K from each element K.
		int[][] pathsWithK = {{1,3,1,6},
		{2,8,1,2},
		{6,2,7,5},
		{2,4,1,3}}; // 2 paths
		System.out.println("pathsWithK = " + howManyPaths(pathsWithK));

		//Q2 => Count the longest path from (0,0) to (x,y) while moving only on 1's
		int[][] longestPath = {{1,1,1,1,1,1,1}, {1,1,0,1,0,0,1}, {1,1,1,1,0,1,1}}; //(2 ,5) -> 16
		System.out.println("longestPath = " + longestPath(longestPath, 2, 5));


		// ############################################
		System.out.print("\u001B[37m");
	}

	public static int howManyPaths(int[][] mat) {
		boolean[][] mem = new boolean[mat.length][mat[0].length];
		return howManyPaths(mat, 0, 0, mem);
	}

	private static int howManyPaths(int[][] mat, int r, int c, boolean[][] mem) {
		if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mem[r][c] == true) {
			return 0;
		}
		if (r == mat.length - 1 && c == mat[0].length - 1) {
			return 1;
		}
		int k = mat[r][c];
		mem[r][c] = true;
		return howManyPaths(mat, r + k, c, mem) +
		howManyPaths(mat, r - k, c, mem) +
		howManyPaths(mat, r, c + k, mem) +
		howManyPaths(mat, r, c - k, mem);
	}

	public static int howManyPathsV2(int[][] mat) {
		return howManyPathsV2(mat, 0, 0);
	}

	private static int howManyPathsV2(int[][] mat, int r, int c) {
		if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] == 0) {
			return 0;
		}
		if (r == mat.length - 1 && c == mat[0].length - 1) {
			return 1;
		}
		int k = mat[r][c];
		mat[r][c] = 0;
		int sum = howManyPathsV2(mat, r + k, c) +
		howManyPathsV2(mat, r - k, c) +
		howManyPathsV2(mat, r, c + k) +
		howManyPathsV2(mat, r, c - k);
		mat[r][c] = k;
		return sum;
	}

	public static int longestPath(int[][] mat, int x, int y) {
		return longestPath(mat, x, y, 0, 0);
	}

	public static int longestPath(int[][] mat, int x, int y, int i, int j) {
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) {
			return Integer.MIN_VALUE;
		}
		if (i == x && j == y) {
			return 1;
		}
		mat[i][j] = 0;
		int sumleft = 1 + longestPath(mat, x, y, i - 1, j);
		int sumright = 1 + longestPath(mat, x, y, i + 1, j);
		int sumup = 1 + longestPath(mat, x, y, i, j - 1);
		int sumdown = 1 + longestPath(mat, x, y, i, j + 1);
		mat[i][j] = 1;
		return Math.max(Math.max(sumleft, sumright), Math.max(sumup, sumdown));
	}
}