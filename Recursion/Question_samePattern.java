package Recursion;

public class Question_samePattern {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		System.out.println("samePattern(TheExamIsEasy, The*xamIs*y) = " + samePattern("TheExamIsEasy", "The*xamIs*y")); // True
		System.out.println("samePattern(TheExamIsEasy, The*xamIsEasy) = " + samePattern("TheExamIsEasy", "The*xamIsEasy")); // True
		System.out.println("samePattern(TheExamIsEasy, *) = " + samePattern("TheExamIsEasy", "*")); // True
		System.out.println("samePattern(TheExamIsEasy, The*IsHard) = " + samePattern("TheExamIsEasy", "The*IsHard")); // False

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	private static boolean samePattern(String s1, String s2) {
		if (s2.length() == 0) { // If s2 is empty, obviously it is substring of s1 => the empty group is subgroup of every group
			return true;
		}
		if (s1.length() == 0) { // If s1 is empty before s2, something is wrong...
			return false;
		}
		if (s1.charAt(0) == s2.charAt(0)) { // If both are equal we cut both
			return samePattern(s1.substring(1), s2.substring(1));
		}
		if (s2.charAt(0) == '*') { // A wild card is acceptable as any character so cut s2
			return samePattern(s1, s2.substring(1));
		}
		return samePattern(s1.substring(1), s2); // Not equal and not wildcard, cut s1
	}
}
