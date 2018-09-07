import java.util.Random;

public class QuickSort {

	private static final Random RANDOM = new Random();
	
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(int[] a, int low, int high) {
		if (low < high) {
			int q = partition(a, low, high);
			
			sort(a, low, q - 1);
			sort(a, q + 1, high);
		}
	}
	
	private static int partition(int[] a, int low, int high) {
		int i = low, j = high;
		
		// choose the pivot at random
		int p = RANDOM.nextInt(high - low) + low;
		int pivot = a[p];
		// make the pivot be located at a[high]
		ArrayUtil.exchange(a, p, high);
		
		while (true) {
			// the loop will break when "a[i] > pivot"
			// as we find an element which is greater than pivot
			while (i < high && a[i] <= pivot) {
				i++;
			}
			
			// the loop will break when "a[j] < pivot"
			// as we find an element which is less than pivot
			while (j > low && a[j] >= pivot) {
				j--;
			}
			
			if (i >= j) {
				break;
			}
			
			ArrayUtil.exchange(a, i, j);
		}

		// place the pivot(a[high]) in right position
		ArrayUtil.exchange(a, high, i);
		
		return i;
	}
	
}
