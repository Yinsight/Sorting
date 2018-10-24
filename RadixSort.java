public class RadixSort {

	private static int[] DECIMALS = {
		1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000
	};
	
	public static void sort(int[] a) {
		int len = a.length;
		
		int[][] table = new int[10][len];
		int[] counts = new int[10];
		
		int offset = 1, key = -1;
		while (true) {
			ArrayUtil.fill(counts, 0); // fill array counts with 0
			
			for (int i = 0; i < len; i++) {
				key = getDigit(a[i], offset); // key is in [0, 9], from units digit, to high-order digits
				
				table[key][counts[key]] = a[i];
				counts[key]++;  // counts[key] contains the number of elements whoes key is the "key"
			}
			
			for (int i = 0, n = 0; i < 10; i++) {
				// the count of numbers whoes key is i, from 0 to 9, both inclusive
				int keyCount = counts[i];  
				
				for (int j = 0; j < keyCount; j++) {
					a[n++] = table[i][j];
				}
				
				if (keyCount == len) { // all numbers' keys are 0 now, so we finish sorting
					return;
				}
			}
			
			offset++;
		}
		
	}

	/**
	 * Gets the specified digit of a number. The digit is specified by a given
	 * offset, from right to left in the number, offset 1 indicates units digit,
	 * offset 2 indicates tens digit and so on.
	 * 
	 * @param num
	 *            the number
	 * @param offset
	 *            the offset of the digit in number
	 * @return the digit specified by the given offset
	 */
	private static int getDigit(int num, int offset) {
		if (offset > 10) { // an integer can't be greater than 1^10
			return 0;
		}

		return (num / DECIMALS[offset - 1]) % 10;
	}
	
}
