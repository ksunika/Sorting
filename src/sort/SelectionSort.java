package sort;

/*
 
In computer science, selection sort is a sorting algorithm, specifically an in-place comparison sort. 
It has O(n2) time complexity, making it inefficient on large lists, and generally performs worse than 
the similar insertion sort. Selection sort is noted for its simplicity, and it has performance advantages 
over more complicated algorithms in certain situations, particularly where auxiliary memory is limited.

The algorithm divides the input list into two parts: the sublist of items already sorted, which is built 
up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that 
occupy the rest of the list. Initially, the sorted sublist is empty and the unsorted sublist is the entire 
input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element 
in the unsorted sublist, exchanging it with the leftmost unsorted element (putting it in sorted order), and 
moving the sublist boundaries one element to the right.

Here is an example of this sort algorithm sorting five elements:

64 25 12 22 11 // this is the initial, starting state of the array
11 25 12 22 64 // sorted sublist = {11}
11 12 25 22 64 // sorted sublist = {11, 12}
11 12 22 25 64 // sorted sublist = {11, 12, 22}
11 12 22 25 64 // sorted sublist = {11, 12, 22, 25}
11 12 22 25 64 // sorted sublist = {11, 12, 22, 25, 64}*/


public class SelectionSort {
	
	static int findMax(int[] array, int length){		
		int max = array[0];
		int index = 0;
		for (int i = 0; i < length+1; i++){
			if (array[i] > max){
				max = array[i];
				index = i;
			}
		}	
		return index;		
	}
	
	static void swap (int i, int j, int[] array){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	static int[] sort(int[] toSort){		
		for (int i = toSort.length - 1; i >=0; i-- ){			
			int index = findMax(toSort, i);			
			swap(index, i, toSort);	
		}
		return toSort;
	}
	
	static void printArray(int[] array){		
		for (int i = 0; i<array.length; i++){
			System.out.print(array[i]);
			if (i != array.length-1)
				System.out.print(", ");
			else 
				System.out.println();
		}		
	}

	public static void main(String[] args) {
		
		int toSort[] = {0, 37, 2, 15, 1,234,42,11,223,3131,22,1};
			//{98,43,13,553,12,54,45,42,56,88, 43,23,1,44,2414,22};
		
		printArray(toSort);
		int[] sorted = sort(toSort);
		printArray(sorted);

	}
}
