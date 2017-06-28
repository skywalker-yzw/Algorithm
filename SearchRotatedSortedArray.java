/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

O(logN) time
 */
public class SearchRotatedSortedArray {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        //validate the parameters
    	if ((A == null) || (A.length == 0)) {
    		return -1;
    	}
    	
    	int start = 0;
    	int end = A.length - 1;
    	int mid = 0;
    	
    	//binary search the rotated sorted array
    	while ( start + 1 < end) {
    		mid = start + (end - start) / 2;
    		
    		if (A[mid] == target) {
    			return mid;
    		}
    		
    		//the rotation pivot is on the left side
    		if (A[mid] <= A[start]) {
    		    if ((target > A[mid]) && (target <= A[end])) {
    		        start = mid;
    		    } else {
    				end = mid;
    			}
    		} else {  // the rotation pivot is on the right side
    			if ((target >= A[start]) && (target < A[mid])) {
    				end = mid;
    			} else {
    				start = mid;
    			}
    				
    		}
    	}
    	
    	if (target == A[start]) {
    		return start;
    	} else if (target == A[end]) {
    		return end;
    	} else {
    		return -1;
    	}
    }
    
    public static void main(String[] args) {
    	
    }
}
