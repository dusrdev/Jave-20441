package Recursion;

import LinkedLists.List;
import LinkedLists.Node;

public class Question_longestAscending {
	public static void main(String[] args) {
		// Color code the outputs
		System.out.println("\u001B[40m" + "\033[1;35m");
		// ###########################################

		/**
		 * This file might seem more complex but it is not
		 * The use of <Integer> is due to me creating generic implementation of node and list
		 * so that I can use the same type for integers/Strings/and all other types.
		 * You can ignore all those as the algorithm is the same
		 * btw, I use Integer and not int as int gives compile time errors when used in place
		 * of generics for some reason...
		 */

		Integer[] a1 = { 2, 4, 1, 5, 10, 5, 3 };
		List<Integer> list1 = new List<Integer>(a1);
		System.out.println("longestAscending(a1) = " + longestAscending(list1)); // 4
		Integer[] a2 = { 1, 2, 4, 6, 8, 10, 15 };
		List<Integer> list2 = new List<Integer>(a2);
		System.out.println("longestAscending(a2) = " + longestAscending(list2)); // 7

		// ############################################
		// Reset colors
		System.out.println("\u001B[37m");
	}

	public static int longestAscending(List<Integer> list) {
		Node<Integer> node = list.getHead();
		return longestAscending(list, node.getNext(), node.getData(), 1, 1);
	}

	private static int longestAscending(List<Integer> list, Node<Integer> node, Integer prev, Integer count,
			Integer max) {
		if (node == null) { // If we are out of bounds
			return max;
		}
		Integer current = node.getData(); // save current value
		if (current > prev) { // If we are in ascending order
			count++; // increase count
			prev = current; // save as previous, to avoid messing up the order
			// we only save ascending numbers as prev and so on
		}
		if (count > max) { // if count > max it becomes max
			max = count;
		}
		// continue iteration
		return longestAscending(list, node.getNext(), prev, count, max);
	}
}
