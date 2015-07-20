import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {

		int[] numArray = { 3, 1, 2};
		int[] sortedArray = new int[4];

		// sortedArray = bubbleSort(numArray);

		//sortedArray = mergeSort(numArray);
		sortedArray = quickSort(numArray);
		System.out.println("The sorted array is:");
		System.out.println(Arrays.toString(sortedArray));
	}
	
	/* This function checks to see if the number on left of a pivot is less than pivot. If not, 
	 * it gets swapped with a number on the right of the pivot that is less than the pivot.
	 * This way all the elements on the left of the pivot are less than it and all the elements
	 * on the right of the array are greater than it. After that, it recursively sorts the left array
	 * and right array.
	 */
	public static int[] quickSort(int[] numArray)
	{
		if(numArray.length <= 1)
			return numArray;
		
		int[] lessArray = new int[1];
		int[] greaterArray = new int[1];
		int j = 0;
		int k = 0;
		//pivot index = middle of the array
		int pi = numArray.length/2;
		for(int i=0; i < numArray.length; i++)
		{
			if(i == pi)continue;
			if(numArray[i] < numArray[pi])
			{
				lessArray[j++] = numArray[i];
			}
			else
			{
				greaterArray[k++] = numArray[i];
			}
		}
		
		int[] sortedLessArray = quickSort(lessArray);
		
		int [] sortedArray = new int[lessArray.length + 1 + greaterArray.length];
		for(int n=0; n<lessArray.length; n++)
		{
			sortedArray[n] = sortedLessArray[n];
		}
		sortedArray[lessArray.length] = numArray[pi];
		
		int t = 0;
		
		int[] sortedGreaterArray = quickSort(greaterArray);
		
		for(int m =  lessArray.length +1; m < lessArray.length + greaterArray.length; m++)
		{
			sortedArray[m] = sortedGreaterArray[t++];
		}
		
		
		
		/*//check to see if the number on left and right need to be swapped
		for(int i = 0; i < pi; i++)
		{
			if(numArray[i] > numArray[pi])
			{
				for(int j = numArray.length - 1; j > pi; j--)
				{
					if(numArray[j] < numArray[pi])
					{
						int temp;
						temp = numArray[j];
						numArray[j] = numArray[i];
						numArray[i] = temp;
					}
					else
					{
						pi = 
					}
				}
			}
		}*/
		
		//int[] leftArray = Arrays.copyOfRange(numArray, 0, pi);
		
		
		
		
		return sortedArray;
	}
	

	/*
	 * This function checks if a number is bigger than its adjacent number. If
	 * yes, the number bubbles to the right of the number with which it was
	 * compared. This check is done for every number in the array. The time
	 * complexity of this function is: O(n*n)
	 */
	public static int[] bubbleSort(int[] numArray) {
		boolean swapped = false;
		int len = numArray.length;

		// check each number in the array and bubble it to its sorted position
		for (int j = 0; j < len; j++) {

			swapped = false;
			for (int i = 1; i < len; i++) {

				// compare two adjacent numbers, swap if the former is bigger
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

	/*
	 * This function sort an integer array by comparing each element to its
	 * previous element. It has time complexity of O(2n)
	 */
	public static int[] insertionSort(int[] numArray) {
		int temp;

		// compare each number with the number in its left to check if it is
		// smaller. Begin from number in 1 index position
		for (int i = 1; i < numArray.length; i++) {

			// if the number is less that previous, compare it with previous to
			// previous and so on
			for (int j = i; j > 0; j--) {

				// if the number is less than previous, swap the numbers
				if (numArray[j] < numArray[j - 1]) {
					temp = numArray[j - 1];
					numArray[j - 1] = numArray[j];
					numArray[j] = temp;
				}
			}
		}

		return numArray;
	}

	/*
	 * This function sorts a numerical using merging technique between two
	 * sorted arrays
	 */

	public static int[] mergeSort(int[] numArray) {
		if (numArray.length <= 1) {
			return numArray;// the array is already sorted if it has just 1
							// element
		}
		int subArrayLen = numArray.length / 2;
		int[] subArray1 = new int[subArrayLen];
		int[] subArray2 = new int[numArray.length - subArrayLen];

		// copy the elements from original array to two sub arrays
		for (int n = 0; n < subArrayLen; n++) {
			subArray1[n] = numArray[n];
		}
		for (int m = 0; m < subArray2.length; m++) {
			subArray2[m] = numArray[m + subArrayLen];
		}

		// recursively sort each sub arrays
		int[] sortedFirstHalf = mergeSort(subArray1);
		int[] sortedSecondHalf = mergeSort(subArray2);

		// merge the sorted array
		int[] sortedArray = merge(sortedFirstHalf, sortedSecondHalf);

		return sortedArray;
	}
	
	/*
	 * This function merges two ascending arrays to one array and returns it.
	 */

	public static int[] merge(int[] A, int[] B)
	{
		int[] mergedArray = new int[A.length + B.length];//merged array size equal to sum of 2 subarrays.
		
		int i = 0; int j = 0; int n = 0;
		
		//iterate until all the arrays of mergedArray is populated. time complexity of this loop in O(n) as it is constant to the 
		//size of the merged array
		while(n < mergedArray.length)
		{
			//check to see that the array index are within bounds
			if(i < A.length)
			{
				if (j < B.length)
				{
					//check of ascending order
					if(A[i] <= B[j])
					{
						mergedArray[n++] = A[i++];
					}
					else
					{
						mergedArray[n++] = B[j++];
					}
				}
				else
				{
					mergedArray[n++] = A[i++];//if B elements are already copied to mergeArray, copy A to it
				}
			}
			else 				
			{
				mergedArray[n++] = B[j++];//if A is already copied, just copy B to mergeArray
			}
		}
		
		return mergedArray;
	}

	/*
	 * This function merges two sorted arrays recursively.
	 */

	public static int[] mergeR(int[] A, int[] B) {
		// array to hold elements from A and B
		int[] mergedArray = new int[A.length + B.length];

		// if A is empty, the merged array will only contain B
		if (A.length == 0)
			return B;
		// if B is empty, the merged array will only contain A
		if (B.length == 0)
			return A;

		// if the first element of A is smaller that the first element of B,
		// the merged Array will have the smaller number. Then the rest of the A
		// and B will
		// be merged again.
		if (A[0] <= B[0]) {
			mergedArray[0] = A[0];
			int[] remainingA = new int[A.length - 1];

			for (int t = 0; t < remainingA.length; t++) {
				remainingA[t] = A[t + 1];
			}

			int[] mArray = merge(remainingA, B);
			// mergedArray = merge(A[0], mArray);
			for (int k = 0; k < mArray.length; k++) {
				mergedArray[k + 1] = mArray[k];
			}
		} else if (B[0] < A[0]) {
			mergedArray[0] = B[0];
			int[] remainingB = new int[B.length - 1];

			for (int t = 0; t < remainingB.length; t++) {
				remainingB[t] = B[t + 1];
			}
			int[] mArray = merge(A, remainingB);
			for (int k = 0; k < mArray.length; k++) {
				mergedArray[k + 1] = mArray[k];
			}
		}

		return mergedArray;
	}

}
