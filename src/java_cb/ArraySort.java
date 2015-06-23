package java_cb;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {

		int[] numArray = { 1, 2, 4, 3, 0, 9, -9, 12 };
		int[] sortedArray = new int[4];

		//sortedArray = bubbleSort(numArray);
		
		sortedArray = insertionSort(numArray);
		System.out.println(Arrays.toString(sortedArray));
	}

	public static int[] bubbleSort(int[] numArray) {
		boolean swapped = false;
		int len = numArray.length;

		for (int j = 0; j < len; j++) {

			swapped = false;
			for (int i = 1; i < len; i++) {

				// compare two adjacent numbers
				if (numArray[i - 1] > numArray[i]) {
					int temp = numArray[i - 1];
					numArray[i - 1] = numArray[i];
					numArray[i] = temp;
					swapped = true;

				}
			}
			if (!swapped) {
				break;
			}
		}

		return numArray;
	}

	public static int[] insertionSort(int[] numArray) {
		//numArray = new int[] { 1, 3, 2, 4 };
		int temp;
		// compare each number with the number in its left to check if it is
		// bigger. Begin from number is 1 index position
		for (int i = 1; i < numArray.length; i++) {
			// if the number is less that previous, compare it with previous to previous and so on
			for (int j = i; j > 0; j--) {
				//if the number is less than previous, swap the numbers 
				if (numArray[j] < numArray[j - 1]) {
					temp = numArray[j - 1];
					numArray[j - 1] = numArray[j];
					numArray[j] = temp;
				}
			}
		}

		return numArray;
	}

}
