import java.util.Random;

public class ArrayUtil {

	/**
	 * Copies a given array.
	 * 
	 * @param a the given array
	 * @return a copy of the given array
	 */
	public static int[] copy(int[] a) {
		int[] c = new int[a.length];
		System.arraycopy(a, 0, c, 0, a.length);
		
		return c;
	}
	
	/**
	 * Assigns a given value to each element of a given array.
	 * 
	 * @param a the given array
	 * @param v the given value
	 */
	public static void fill(int[] a, int v) {
		int len = a.length;
        for (int i = 0; i < len; i++)
            a[i] = v;
    }
	
	/**
	 * Exchanges two elements in an array.
	 * 
	 * @param a the array
	 * @param i the first element's index
	 * @param j the second element's index
	 */
	public static void exchange(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	/**
	 * Generates an integer array of a given size randomly, including the sign.
	 * 
	 * @param size
	 *            the size of the array to be generated
	 * @return an integer array of the given size
	 */
	public static int[] generateIntegerArray(int size, int bound) {
		Random random = new Random();
		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = Math.abs(random.nextInt(bound));
		}

		return array;
	}
	
}
