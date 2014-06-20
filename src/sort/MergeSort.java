package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {

	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
	}

	static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length + arr2.length;
		int[] result = new int[n];

		int k = 0;
		int l = 0;
		
		for (int i = 0; i < n; i++) {
			
			
			if(k == arr1.length)
				result[i] = arr2[l++];
			else if(l == arr2.length)
				result[i] = arr1[k++];

			else if (arr1[k] < arr2[l])
				result[i] = arr1[k++];
			
			else 
				result[i] = arr2[l++];
	
		}

		return result;

	}

	static int[] sort(int[] toSort) {
		
		if (toSort.length == 0 || toSort.length == 1){
			return toSort;
		}
		
		int[] arrLeft = new int[toSort.length/2];
		int[] arrRight = new int[toSort.length-arrLeft.length];
		
		for (int i = 0; i < arrLeft.length; i++)
			arrLeft[i] = toSort[i];
		
		for (int i = 0; i < arrRight.length; i++)
			arrRight[i] = toSort[i+arrLeft.length];
		
		
		int[] sortedLeft = sort(arrLeft);
		int[] sortedRight = sort(arrRight);
		
		int[] result = merge(sortedLeft, sortedRight);

		return result;
	}

	public static void main(String[] args) {
		//int toSort[] = { 55, 37, 2, 15, 1, 234, 42, 11, 223, 3131, 22, 1 ,0,2424242,-3,424,22};
		
		int toSort[] = new int[100000];
		int i = 0;
		try {
			Scanner scanner = new Scanner(new File("src/sort/IntegerArray.txt"));
			while(scanner.hasNextInt()){
				   toSort[i++] = scanner.nextInt();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		printArray(toSort);
		int[] sorted = sort(toSort);
		printArray(sorted);

	}

}
