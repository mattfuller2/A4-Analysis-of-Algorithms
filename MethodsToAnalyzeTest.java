import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Test MethodToAnalyze - count number of statements to MethodToAnalyze() to
 * various arrays.
 *
 * @author mdfulls
 */
public class MethodsToAnalyzeTest {

	/**
	 * Get an array of specified size and pass it to MethodToAnalyze.find(). Report
	 * the results.
	 * 
	 * @param args
	 *            either size of a new array, or a file containing ints
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Random rand = new Random();
		// call modified find() with different array sizes and write results to
		for (int size = 2; size < 101; size += 1) {
			int[] array = ArrayOfInts.randomizedArray(size);
			int value = rand.nextInt(array.length) + 1;
			MethodsToAnalyze.find(array, value); // this is the call we want to measure

			int newValue = rand.nextInt(array.length);
			while (newValue == value) {
				newValue = rand.nextInt(array.length);
			}

			MethodsToAnalyze.replaceAll(array, value, newValue);
			MethodsToAnalyze.order1(array);
			MethodsToAnalyze.order2(array);
			MethodsToAnalyze.order3(array);

			long statements = MethodsToAnalyze.getStatements();

			// summary
			// if (index != -1) {
			System.out.printf("\nfor n = %d, took %d statements\n", size, statements);

			// // show "sorted" array
			// double arraySquared = Math.ceil(Math.sqrt(size));
			// int lineSize = (int) arraySquared;
			// int i = 0;
			// int COUNT = 0;
			// while (i < array.length) {
			// if (COUNT < lineSize) {
			// System.out.print(array[i] + " ");
			// }
			// else {
			// System.out.println();
			// System.out.print(array[i] + " ");
			// COUNT = 0;
			//
			// }
			//
			// COUNT++;
			// i++;
			// }
			//
			// System.out.println();
			// System.out.println();
			// }
			// else {
			// System.out.print("The value " + value + " was not found in the array.");
			// System.out.printf("\nfor n = %d, took %d statements\n", size, statements);
			// System.out.println();
			// }
		}
	}

}
