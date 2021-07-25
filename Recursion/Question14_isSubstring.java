package Recursion;

public class Question14_isSubstring {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		// This doesn't work perfectly...
		// There is a possible solution which involes using a second method.
		// I want to stray away from using help methods, I will get back to this question to attempt again.

		System.out.println("isSubstring(substring, string) = " + isSubstring("substring", "string")); // true
		System.out.println("isSubstring(hello, hell) = " + isSubstring("hello", "hell")); // true
		System.out.println("isSubstring(Madam, dad) = " + isSubstring("Madam", "ada")); // true
		System.out.println("isSubstring(program, pgram) = " + isSubstring("program", "pgram")); // false

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static boolean isSubstring(String s1, String s2) {
		if (s2.length() == 0) {
			return true;
		}
		if (s2.length() >= s1.length()) {
			return false;
		}
		if (s1.charAt(0) == s2.charAt(0)) {
			return isSubstring(s1.substring(1), s2.substring(1));
		}
		return isSubstring(s1.substring(1), s2);
	}
}
