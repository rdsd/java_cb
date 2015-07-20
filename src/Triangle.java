

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Triangle {

	/*
	 * This function calculates the maximum sum of the adjacent number in each row of a number triangle
	 */
	public int calculateTriangleSum(String file) {
		// read triangle.txt line by line
		// split each line for numbers
		// save the adjacent numbers in each line to array
		// calculate cumulative sum with the maximum adjacent number on each row
		// and update maxSum
		// At the end of the last triangle number line, print out the maxSum
		int maxSum = 0;
		try {
			File triangleFile = new File(file);
			FileReader fr = new FileReader(triangleFile);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			int arrayIndex = 0;
			int maxNumberIndex = arrayIndex;
			while ((line = br.readLine()) != null) {
				String[] numbers = line.split(" ");
				int[] numberArray = new int[numbers.length];

				for (int i = 0; i < numbers.length; i++) {
					numberArray[i] = Integer.parseInt(numbers[i]);
				}
				System.out.println(Arrays.toString(numberArray));
				if (maxSum == 0) {
					maxSum = Integer.parseInt(numbers[0]);
				} else {
					maxNumberIndex = findMaxAdjacentNumberNextRowIndex(numberArray, arrayIndex);
					maxSum = maxSum + numberArray[maxNumberIndex];
					arrayIndex = maxNumberIndex;
				}

			}
			System.out.println("The maximum adjacanet number sum of the triangle is: " + maxSum);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return maxSum;

	}

	/*
	 * This function finds the index of the greatest number among adjacent
	 * numbers in next row
	 */
	private static int findMaxAdjacentNumberNextRowIndex(int[] numberArray,
			int arrayIndex) {
		int maxNumIndex;
		int maxNum;

		// if arrayIndex is 0, there are only 2 adjacent numbers
		if (arrayIndex == 0) {
			maxNumIndex = arrayIndex;
			maxNum = numberArray[maxNumIndex];
			if (maxNum < numberArray[maxNumIndex + 1]) {
				maxNum = numberArray[maxNumIndex + 1];
				maxNumIndex = maxNumIndex + 1;
			}
		}
		// If arrayIndex is not zero, there are 3 adjacent numbers.
		// If arrayIndex is second from last or last, we need to check for out
		// of bounds error
		else {
			maxNumIndex = arrayIndex - 1;
			maxNum = numberArray[maxNumIndex];
			for (int i = maxNumIndex; i < maxNumIndex + 3; i++) {
				if (i < numberArray.length && maxNum < numberArray[i]) {
					maxNum = numberArray[i];
					maxNumIndex = i;
				}
			}
		}

		return maxNumIndex;
	}

}
