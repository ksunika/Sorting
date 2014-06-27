package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {
	static int NUMBER = 0;

	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
	}

	static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static int median(int[] toSort, int l, int r) {

		if (r == l)
			return l;

		int med = (r - l) % 2;

		if (toSort[med] >= toSort[r] && toSort[med] <= toSort[l]
				|| toSort[med] >= toSort[l] && toSort[med] <= toSort[r])
			return med;

		if (toSort[l] >= toSort[r] && toSort[l] <= toSort[med]
				|| toSort[l] <= toSort[r] && toSort[l] >= toSort[med])
			return l;

		if (toSort[r] >= toSort[med] && toSort[r] <= toSort[l]
				|| toSort[r] <= toSort[med] && toSort[r] >= toSort[l])
			return r;

		return l;

	}

	static int partition(int[] toSort, int l, int r) {
		

		 NUMBER = NUMBER + r-l-1;
		// System.out.println("number of comparisons:" + NUMBER);

		//int pivotIndex = selectPivot("l", toSort, l, r); // left
		int pivotIndex = selectPivot("r", toSort, l, r); // right
		//int pivotIndex = selectPivot("m", toSort, l, r); // median

		int pivotValue = toSort[pivotIndex];

		swap(pivotIndex, r, toSort);

		int storeIndex = l;

		for (int i = l; i < r; i++) {
			if (toSort[i] <= pivotValue) {
				swap(i, storeIndex, toSort);
				storeIndex++;
			}
		}
		
		swap(r, storeIndex, toSort);
		
		return storeIndex;

	}

	
	static int selectPivot(String criteria, int[]toSort, int l, int r){
		
		int pivotIndex = l;
		
		if (criteria.equals("m")){
			 pivotIndex = median(toSort, l, r);
		}
		else if (criteria.equals("r")){
			 pivotIndex = r;
		}

		return pivotIndex;
		
	}
	

	static int[] quickSort(int[] toSort, int l, int r) {


		if (l < r ) {
			int pivotIndex = partition(toSort, l, r);
			quickSort(toSort, l, pivotIndex - 1);
			quickSort(toSort, pivotIndex + 1, r);
		
//		} else if (l < r) {
//			if (toSort[l] > toSort[r])
//				swap(l, r, toSort);
		}

		return toSort;
	}

	public static void main(String[] args) {
		int toSort[] = new int[10000];
		int i = 0;

		try {
			Scanner scanner = new Scanner(new File("src/sort/QuickSort.txt"));
			while (scanner.hasNextInt()) {
				toSort[i++] = scanner.nextInt();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// int toSort[] = {0, 37, 2, 15, 1,234,42,11,223,3131,22,1};

		printArray(toSort);
		int[] sorted = quickSort(toSort, 0, toSort.length - 1);
		printArray(sorted);

		System.out.println("number of comparisons:" + NUMBER);

	}

}
