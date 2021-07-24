// import java.util.Scanner;

class Cls {
	public static void main (String[] args) {
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################


		int[][] pathsWithK = {{1,3,1,6},
		{2,8,1,2},
		{6,2,7,5},
		{2,4,1,3}};
		System.out.println("Result = " + howManyPaths(pathsWithK));


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
}