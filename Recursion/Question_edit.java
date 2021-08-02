package Recursion;
// import java.util.Scanner;

public class Question_edit {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * We get 2 strings: str1, str2 We need to convert str1 to str2 in the minimum
		 * required steps IE: "sunday" => "saturday"; "un" => "atur"; 4 steps The
		 * function needs to return the minimum number of required steps
		 */
		System.out.println("edit(sunday,saturday) = " + edit("sunday", "saturday")); // 4
		System.out.println("edit(geek,gesek) = " + edit("geek", "gesek")); // 1

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static int edit(String str1, String str2) {
		return edit(str1, str2, 0, 0);
	}

	private static int edit(String str1, String str2, int i, int j) {
		if (i == str1.length() && j == str2.length()) { // Reached destination
			return 0;
		}
		if (str2.length() == 0) { // If 2 is empty, we need len(1) changes
			return str1.length();
		}
		if (str1.length() == 0) { // If 1 is empty, we need len(2) changes
			return str2.length();
		}
		if (i >= str1.length() || j >= str2.length()) { // If out of bounds
			return 1000000;
		}
		if (str1.charAt(i) == str2.charAt(j)) { //If both sides are equal no need to change
			return edit(str1, str2, i + 1, j + 1);
		} else { // We change the 1's and 2's and return the min
			int one = 1 + edit(str1, str2, i + 1, j);
			int two = 1 + edit(str1, str2, i, j + 1);
			return Math.min(one, two);
		}
	}
}