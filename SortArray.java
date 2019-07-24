// Made by Ayush Kumar @ayushwashere

public class SortArray {
	private static <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] array) {
		for(int  i = 0; i < array.length - 1; ++i)
			for(int j = 0; j < array.length - 1; ++j)
				if(array[j].compareTo(array[j+1]) > 0)
					SortArray.swap(array, j, j+1);
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] array) {
		for(int i = 0; i < array.length; ++i) {
			T bestFit = array[i];
			int bestFitIndex = i;
			
			for(int j = i; j < array.length; ++j)
				if(array[j].compareTo(bestFit) < 0) {
					bestFit = array[j];
					bestFitIndex = j;
				}
			SortArray.swap(array, i, bestFitIndex);
		}
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] array) {  
		for(int i = 1; i < array.length; ++i)
			for(int j = i; j > 0; --j)
				if(array[j].compareTo(array[j-1]) < 0)
					SortArray.swap(array, j, j-1);
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] array) {
		SortArray.mergeSortRecursive(array, 0, array.length);
	}
	
	private static <T extends Comparable<T>> void mergeSortRecursive(T[] array, int left, int right) {
		if(left >= right - 1)
			return;
		
		int mid = (left + right) / 2;
		
		mergeSortRecursive(array, left, mid);
		mergeSortRecursive(array, mid, right);
		
		mergeSortMerger(array, left, mid, right);
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void mergeSortMerger(T[] array, int left, int mid, int right) {
		
		int lenLeftArray = mid - left;
		int lenRightArray = right - mid;
		
		T[] leftArray = (T[]) new Comparable[lenLeftArray];
		T[] rightArray = (T[]) new Comparable[lenRightArray];
		
		for(int i = 0; i < lenLeftArray; ++i)
			leftArray[i] = array[left + i];
		for(int i = 0; i < lenRightArray; ++i)
			rightArray[i] = array[mid + i];
		
		//merging by comparing values for both
		int index = left, i = 0, j = 0; 
		
		while(i < lenLeftArray && j < lenRightArray) {
			if(leftArray[i].compareTo(rightArray[j]) > 0) {
				array[index] = rightArray[j];
				j++;
			}
			else {
				array[index] = leftArray[i];
				i++;
			}
			index++;
		}
		
		while(i < lenLeftArray) {
			array[index] = leftArray[i];
			i++;
			index++;
		}
		
		while(j < lenRightArray) {
			array[index] = rightArray[j];
			j++;
			index++;
		}
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] array) {
		SortArray.quickSortRecursive(array, 0, array.length - 1);
	}
	
	private static <T extends Comparable<T>> void quickSortRecursive(T[] array, int start, int end) {
		if(start >= end)
			return;
		
		int partitionIndex = quickSortPartition(array, start, end);
		
		SortArray.quickSortRecursive(array, start, partitionIndex - 1);
		SortArray.quickSortRecursive(array, partitionIndex + 1, end);
	}
	
	public static <T extends Comparable<T>> int quickSortPartition(T[] array, int start, int end) {
		T pivot = array[end];
		
		int partitionIndex = start;
		
		for(int i = start; i <= end; ++i) {
			if(pivot.compareTo(array[i]) > 0) {
				SortArray.swap(array, i, partitionIndex);
				partitionIndex++;
			}
		}
		SortArray.swap(array, partitionIndex, end);
		
		return partitionIndex;
	}
}
