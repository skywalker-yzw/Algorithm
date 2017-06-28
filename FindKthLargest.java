import java.util.*;

public class FindKthLargest {
	   public void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	 
	    /* regular partition algorithm, same as used in quick sort
	     * */
	    public int partition(int[] nums, int low, int high) {
	        //always pick the first one as pivot. To get avarage O(n), we need to
	        //pick a randomized pivot
	        int pivot = nums[low]; 
	        int pIdx = low + 1;
	        
	        for (int j = low + 1; j <= high; j++) {
	            if (nums[j] < pivot) {
	                swap(nums, j, pIdx);
	                pIdx++;
	            }
	        }
	        
	        swap(nums, pIdx - 1, low);
	        
	        return pIdx - 1;
	    }
	    
	    /* Randomized partition function to avoid worst case and get average O(n)
	     * */
	    public int partitionR(int[] nums, int low, int high) {
	        //To get average O(n), we need to pick a randomized pivot
	        Random rand = new Random();
	        int randomNum = rand.nextInt(high - low + 1) + low;
	        int pivot = nums[randomNum];
	        
	        //swap with the first element, the rest will be the same as the regular partition
	        swap(nums,low,randomNum);
	        int pIdx = low + 1;
	        
	        for (int j = low + 1; j <= high; j++) {
	            if (nums[j] < pivot) {
	                swap(nums, j, pIdx);
	                pIdx++;
	            }
	        }
	        
	        swap(nums, pIdx - 1, low);
	        
	        return pIdx - 1;
	    }
	 
	    
	    /*
	     * @param k : description of k
	     * @param nums : array of nums
	     * @return: description of return
	     */
	    public int kthLargestElement(int k, int[] nums) {
	        // write your code here
	        
	        //valid parameters
	        if (nums == null || nums.length == 0 || k <= 0) {
	            return Integer.MIN_VALUE;
	        }
	        
	        int low = 0;
	        int high = nums.length - 1;
	        
	        while (low <= high) {
	            int j = partitionR(nums, low, high);
	            
	            if (j < nums.length - k) {
	                low = j + 1;
	            } else if (j > nums.length - k) {
	                high = j - 1;
	            } else {
	                return nums[j];
	            }
	        }
	        
	        return Integer.MIN_VALUE;
	    }
	    
	    public static void main(String[] args) {
	    	int[] array = {3,1,5,4,2,6};
	    	
	    	FindKthLargest obj = new FindKthLargest();
	    		    	
	    	System.out.println("The " + 2 + "th largest element of array is " + obj.kthLargestElement(2, array));
	    }
}
