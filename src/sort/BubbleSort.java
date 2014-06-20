package sort;

/*
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that works 
 * by repeatedly stepping through the list to be sorted, comparing each pair of adjacent items and 
 * swapping them if they are in the wrong order. The pass through the list is repeated until no swaps 
 * are needed, which indicates that the list is sorted. The algorithm gets its name from the way smaller 
 * elements "bubble" to the top of the list. Because it only uses comparisons to operate on elements, it 
 * is a comparison sort. Although the algorithm is simple, most of the other sorting algorithms are more 
 * efficient for large lists.
 * 
 * 
 * Bubble sort has worst-case and average complexity both О(n2), where n is the number of items being sorted. 
 * There exist many sorting algorithms with substantially better worst-case or average complexity of O(n log n). 
 * Even other О(n2) sorting algorithms, such as insertion sort, tend to have better performance than bubble sort. 
 * Therefore, bubble sort is not a practical sorting algorithm when n is large.

 The only significant advantage that bubble sort has over most other implementations, even quicksort, but not 
 insertion sort, is that the ability to detect that the list is sorted is efficiently built into the algorithm. 
 When the list is already sorted (best-case), the complexity of bubble sort is only O(n). By contrast, most other 
 algorithms, even those with better average-case complexity, perform their entire sorting process on the set and 
 thus are more complex. However, not only does insertion sort have this mechanism too, but it also performs better 
 on a list that is substantially sorted (having a small number of inversions).

 Bubble sort should be avoided in case of large collections. It will not be efficient in case of reverse ordered collection.*/

public class BubbleSort {

	static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static int[] sort(int[] toSort) {
		boolean swapped = true;

		while (swapped) {

			swapped = false;

			for (int i = 0; i < toSort.length - 1; i++) {
				if (toSort[i] > toSort[i + 1]) {
					swap(i, i + 1, toSort);
					swapped = true;
				}
			}
		}

		return toSort;
	}

	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
	}

	public static void main(String[] args) {

		int toSort[] = { 0, 37, 2, 15, 1, 234, 42, 11, 223, 3131, 22, 1 };

		printArray(toSort);
		int[] sorted = sort(toSort);
		printArray(sorted);

	}

}
