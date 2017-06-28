
import java.util.*;

public class SortingAlgorithms {
	/*
	 * bubble sort, sweep all the numbers sequentially, compare the adjacent numbers and swap them if needed
	 * worst case: O(n2), when the nums in the array is in descending order
	 * */
	public void bubbleSort(int[] nums) {
	    boolean swapFlag = true; 
	    int temp;
	    
	    while (swapFlag) {
	        swapFlag = false;
	        for (int j = 0; j < nums.length - 1; j++) {
	            if (nums[j] > nums[j + 1]) {
	                //swap
	                temp = nums[j];
	                nums[j] = nums[j + 1];
	                nums[j + 1] = temp;
	                
	                swapFlag = true;
	            }
	        }
	    }			
	}
	
	/*
	 * The algorithm selects the minimum value, swaps it with the value in the first position, 
	 * and repeats these steps for the remainder of the list.[18] 
	 * It does no more than n swaps, and thus is useful where swapping is very expensive
	 * */
	public void selectionSort(int[] nums) {
		int min;
		int idx = 0;
		int temp;
		
		for (int i = 0; i < nums.length; i++) {
			min = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j] < min) {
					min = nums[j];
					idx = j;
				}
			}
			
			if (min != nums[i]) {
				temp = nums[i];
				nums[i] = nums[idx];
				nums[idx] = temp;			
			}
		}
	}
	
	/*
	 * It works by taking elements from the list one by one and 
	 * inserting them in their correct position into a new sorted list. 
	 * In arrays, the new list and the remaining elements can share the array's space, 
	 * but insertion is expensive, requiring shifting all following elements over by one
	 * */
	public void insertionSort(int[] nums) {
		int sortedIdx = 0;
		int temp = 0;
		
		for (int i = 0; i < nums.length; i++) {
			//find a position to insert
			for (int j = 0; j < sortedIdx; j++) {
				if (nums[j] > nums[i]) {
					temp = nums[i];
					
					//shift number right from j to i one by one
					for (int k = i; k > j; k--) {
						nums[k] = nums[k - 1];
					}
					
					nums[j] = temp;
				}
			}
			
			sortedIdx++;
		}
	}
	
	public int[] merge(int[] array1, int size1, int[] array2, int size2) {
		if (size1 <= 0 || size2 <= 0) {
			return null;
		}
		
		//allocate memory for the result array
		int[] result = new int[size1 + size2];
		
		int i = 0;
		int j = 0; 
		int idx = 0;
		
		//merge the two arrays
		while ((i <= size1 -1) && (j <= size2 -1)) {
			if (array1[i] > array2[j]) {
				result[idx++] = array2[j];
				j++;
			} else {
				result[idx++] = array1[i];
				i++;
			}
		}
		
		if (i <= size1 -1) {
			for (int k = i; k <= size1 -1; k++) {
				result[idx++] = array1[k];
			}
		}
		
		if (j <= size2 -1) {
			for (int k = j; k <= size2 -1; k++) {
				result[idx++] = array2[k];
			}
		}
		
		return result;
	}
	
	/*
	 * Merge sort: the idea is divide & conquer. Divide the array into two part, first half and second half.
	 * Then recursively do merge sort on those two half. After that, merge the two halves into one final array, 
	 * which will be the final results (conquer)
	 * */
	public int[] mergeSort(int[] nums, int low, int high) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		if (low == high) { //only 1 element left
			int[] ret = {nums[low]};
			return ret;
		} else if (low + 1 == high) { //two elements left
			int[] lowArr = {nums[low]};
			int[] highArr = {nums[high]};
			return merge(lowArr, 1, highArr, 1);
		}
		
		int mid = low + (high - low)/2;
		
		//merge sort on the first and second half
		int[] firstHalf = mergeSort(nums, low, mid);
		int[] secondHalf = mergeSort(nums, mid + 1, high);
		
		//merge the sorted first half and second half
		return merge(firstHalf, firstHalf.length, secondHalf, secondHalf.length);
	}

	/*
	 * */
	public int partition(int[] nums, int left, int right) {

		//always choose the first one as pivot 
		//this can be optimized to pick pivot randomly, so that it can avoid some worst case scenarios
		int pivot = nums[left];
		int pivotIdx = left + 1;
		int temp = 0;
		
		for (int i = left + 1; i <= right; i++) {
			if (nums[i] < pivot) {
				//swap them
				temp = nums[i];
				nums[i] = nums[pivotIdx];
				nums[pivotIdx] = temp;
				
				pivotIdx++;
			}
		}
		
		// move the pivot into the right position
		temp = nums[pivotIdx - 1];
		nums[pivotIdx - 1] = nums[left];
		nums[left] = temp;
		
		return pivotIdx - 1;
	}
	
	/*Quick sort: idea is to choose a pivot, partition the array around the pivot, such that the left < pivot < right. Then
	 * recursively quick sort on the left and right part
	 * 
	 * */	
	public void quickSort(int[] nums, int left, int right) {
		//check parameters
		if (nums == null || nums.length == 0) {
			return;
		}
		
		//exit condition
		if (left >= right) {
			return;
		}
		
		//partition the array around the pivot
		int pivot = partition(nums, left, right);
		
		// quicksort on the two parts
		quickSort(nums, left, pivot);
		quickSort(nums, pivot + 1, right);
	}
	
	public static void main(String[] args) {
		int[] array = {3,2,1,4,5,8,1,7, 1,9,10,1,6};
		//int[] array = {3,2,1,4,5,8};
		
		SortingAlgorithms obj = new SortingAlgorithms();
		

		int[] result = obj.mergeSort(array, 0, array.length - 1);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

		System.out.print("\n"); 
		//obj.bubbleSort(array);
		//obj.selectionSort(array);
		//obj.insertionSort(array);
		obj.quickSort(array, 0, array.length - 1);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
}
