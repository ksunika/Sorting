package sort;

/*
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. 
 * It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. 
 * However, insertion sort provides several advantages:

 Simple implementation
 Efficient for (quite) small data sets
 Adaptive (i.e., efficient) for data sets that are already substantially sorted: the time complexity is O(n + d), 
 where d is the number of inversions
 More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms such as selection sort or 
 bubble sort; the best case (nearly sorted input) is O(n)
 Stable; i.e., does not change the relative order of elements with equal keys
 In-place; i.e., only requires a constant amount O(1) of additional memory space
 Online; i.e., can sort a list as it receives it

 The best case input is an array that is already sorted. In this case insertion sort has a linear running time (i.e., Θ(n)). 
 During each iteration, the first remaining element of the input is only compared with the right-most element of the sorted 
 subsection of the array.

 The simplest worst case input is an array sorted in reverse order. The set of all worst case inputs consists of all arrays 
 where each element is the smallest or second-smallest of the elements before it. In these cases every iteration of the 
 inner loop will scan and shift the entire sorted subsection of the array before inserting the next element. 
 This gives insertion sort a quadratic running time (i.e., O(n2)).

 The average case is also quadratic, which makes insertion sort impractical for sorting large arrays.
 */

public class InsertionSort {

	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
	}

	static int[] replaceUp(int[] array, int first, int last) {
		
		for (int i = last; i > first; i--){
			array[i] = array[i-1];
		}
		return array;
	}
	
	static int[] sort(int[] toSort) {
		
		for (int i = 0; i< toSort.length; i++){
			
			int item = toSort[i];

			for (int j = i; j>=0; j--){
				//printArray(toSort);
				
				if (j == 0 && toSort[j] > item){
					replaceUp(toSort, j, i);
					toSort[j] = item;
				}
				
				if (toSort[j] < item && toSort[j+1] >= item){	
					replaceUp(toSort, j+1, i);
					toSort[j+1] = item;
					break;
					
				}
				
			}
		}
				
		return toSort;

	}

	public static void main(String[] args) {

		int toSort[] = {0, 37, 2, 15, 1,234,42,11,223,3131,22,1};

		printArray(toSort);
		int[] sorted = sort(toSort);
		printArray(sorted);

	}

}
