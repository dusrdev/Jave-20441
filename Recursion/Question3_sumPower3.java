package Recursion;

public class Question3_sumPower3 {
	public static void main (String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		//Q3 => Check if an integer can be written as the sum of powers of 3
		//Example: 37 returns true because 37 = 3^0 + 3^2 + 3^3
		System.out.println("sumPower3(37) = " + sumPower3(37)); //True
		System.out.println("sumPower3(38) = " + sumPower3(38)); //False

		// ############################################
		// Reset colors
		System.out.print("\u001B[37m");
	}

	public static boolean sumPower3(int num) {
		if (num < 1) { // There is no power of 3 that equals less than 1
			return false;
		}
		return sumPower3(num, 0);
	}

	private static boolean sumPower3(int num, int currentPower) {
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
