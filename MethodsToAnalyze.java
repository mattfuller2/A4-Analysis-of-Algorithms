/**
 * A collection of methods that work with arrays of ints.
 * 
 * @author mvail
 */
public class MethodsToAnalyze {
	// NEW VARIABLE ADDED FOR DATA COLLECTION
	private static long numStatements = 0;

	/**
	 * Return index where value is found in array or -1 if not found.
	 * 
	 * @param array
	 *            ints where value may be found
	 * @param value
	 *            int that may be in array
	 * @return index where value is found or -1 if not found
	 */
	public static int find(int[] array, int value) {
		// NEW VARIABLE ADDED FOR DATA COLLECTION
		numStatements += 2; // for loop init and 1st condition check

		for (int i = 0; i < array.length; i++) {
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 1; // If statement condition check

			if (array[i] == value) {
				// NEW VARIABLE ADDED FOR DATA COLLECTION
				numStatements += 1; // return statement
				// System.out.print("POSITION: " + (i + 1));

				return i;
			}

			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 2; // for loop increment and for loop condition check
		}

		// NEW VARIABLE ADDED FOR DATA COLLECTION
		numStatements += 1; // return statement
		return -1;
	}

	/**
	 * Replace all occurrences of oldValue with newValue in array.
	 * 
	 * @param array
	 *            ints where oldValue may be found
	 * @param oldValue
	 *            value to replace
	 * @param newValue
	 *            new value
	 */
	public static void replaceAll(int[] array, int oldValue, int newValue) {
		// NEW VARIABLE ADDED FOR DATA COLLECTION
		numStatements += 2; // initialize index and 1st condition check

		int index = find(array, oldValue);
		while (index > -1) {
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 3; // update array at index, finds next occurence, and condition check
								// again

			array[index] = newValue;
			index = find(array, oldValue);
		}
	}

	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * 
	 * @param array
	 *            ints that need to be ordered
	 */
	public static void order1(int[] array) {
		// NEW VARIABLE ADDED FOR DATA COLLECTION
		numStatements += 2; // for loop init and 1st condition check

		for (int next = 1; next < array.length; next++) {
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 3; // initialize value, initialize index, and check while condition

			int value = array[next];
			int index = next;
			while (index > 0 && value < array[index - 1]) {
				// NEW VARIABLE ADDED FOR DATA COLLECTION
				numStatements += 3; // update array at index, decrement index, and check while
									// condition again

				array[index] = array[index - 1];
				index--;
			}
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 3; // update array, increment next, and check for loop condition again

			array[index] = value;
		}
	}

	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * 
	 * @param array
	 *            ints that need to be ordered
	 */
	public static void order2(int[] array) {
		// NEW VARIABLE ADDED FOR DATA COLLECTION
		numStatements += 2; // initialize index and 1st condition check

		for (int index = 0; index < array.length - 1; index++) {
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 3; // min and scan initialized and 2nd condition check

			int min = index;
			for (int scan = index + 1; scan < array.length; scan++) {
				// NEW VARIABLE ADDED FOR DATA COLLECTION
				numStatements += 1; // condition check

				if (array[scan] < array[min]) {
					// NEW VARIABLE ADDED FOR DATA COLLECTION
					numStatements += 1; // update min

					min = scan;
				}
				// NEW VARIABLE ADDED FOR DATA COLLECTION
				numStatements += 2; // scan incremented and check condition again

			}
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 3; // swap method, increment index, and check for loop condition again

			swap(array, min, index);
		}
	}

	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * 
	 * @param array
	 *            ints that need to be ordered
	 */
	public static void order3(int[] array) {
		// NEW VARIABLE ADDED FOR DATA COLLECTION
		numStatements += 2; // initialize position and 1st condition check

		for (int position = array.length - 1; position > 0; position--) {
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 2; // initialize scan and 2nd condition check

			for (int scan = 0; scan <= position - 1; scan++) {
				// NEW VARIABLE ADDED FOR DATA COLLECTION
				numStatements += 1; // condition check

				if (array[scan] > array[scan + 1]) {
					swap(array, scan, scan + 1);

					// NEW VARIABLE ADDED FOR DATA COLLECTION
					numStatements += 1; // swap method
				}
				// NEW VARIABLE ADDED FOR DATA COLLECTION
				numStatements += 2; // scan incremented and check condition again
			}
			// NEW VARIABLE ADDED FOR DATA COLLECTION
			numStatements += 2; // position incremented and check condition again
		}
	}

	/**
	 * Swaps two ints in an array.
	 * 
	 * @param array
	 *            the array in which the elements are swapped
	 * @param index1
	 *            the index of the first element to be swapped
	 * @param index2
	 *            the index of the second element to be swapped
	 */
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

		// ADDED FOR DATA COLLECTION
		numStatements += 3; // 3 statements in swap sequence
	}

	/**
	 * ADDED FOR DATA COLLECTION method added just to collect data about wrongSort()
	 * 
	 * @return approximate statements executed on last call to order()
	 */
	public static long getStatements() {
		return numStatements;
	}
}
