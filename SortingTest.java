import java.util.Scanner;

public class SortingTest {

	public static void main(String[] args) {
		try (Scanner stdin = new Scanner(System.in)) {
			System.out.print("Please enter the size of the array: ");
			int n = stdin.nextInt();
			System.out.print("Please enter the expected number of repetitions: ");
			int r = stdin.nextInt();
			
			if (n < r) {
				System.out.println("The size of array must be greater than the expected number of repetitions.");
				return;
			}
			
			int bound = n / r; // eg. n=1000, r=10, bound=100
			final int[] a1 = ArrayUtil.generateIntegerArray(n, bound);
			final int[] a2 = ArrayUtil.copy(a1);
			
			double time1 = time(new Runnable() {
				@Override
				public void run() {
					QuickSort.sort(a1);
				}
			});
			System.out.printf("Time used by QuickSort: %.2f ms\n", time1);
			
			double time2 = time(new Runnable() {
				@Override
				public void run() {
					RadixSort.sort(a2);
				}
			});
			System.out.printf("Time used by RadixSort: %.2f ms\n", time2);
		}
	}
	
	/**
	 * Times a given runnable task.
	 * 
	 * @param task
	 *            the given task
	 * @return running time the task used, in milliseconds
	 */
	private static double time(Runnable task) {
		long beginTime = System.nanoTime();
		task.run();
		long endTime = System.nanoTime();
		
		return getTime(beginTime, endTime);
	}
	
	/**
	 * Gets the elapsed time, in milliseconds.
	 * 
	 * @param beginTime
	 *            the begin time, in nanoseconds
	 * @param endTime
	 *            the end time, in nanoseconds
	 * 
	 * @return the elapsed time, in milliseconds
	 */
	private static double getTime(long beginTime, long endTime) {
		return (endTime - beginTime) / 1E6;
	}
	
}
