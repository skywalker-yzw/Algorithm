
public class SearchInsertPosition {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
     public int searchInsert(int[] A, int target) {
         //validate the parameters
         if ((A == null) || (A.length == 0)) {
             return 0;
         }

         int start = 0;
         int end = A.length - 1;
         int mid = 0;
         
         //binary search in the sorted array
         while (start + 1 < end) {
             mid = start + (end - start) / 2;
             
             if (target >= A[mid]) {
                 start = mid;
             } else {
                 end = mid;
             }
         }
         
         // determine the return value
 /*     this code can be optimized
         if (A[start] == target) {
             return start;
         } else if (A[end] == target) {
             return end;
         } else if (target < A[start]) {
             if (start - 1 >= 0) {
                 return start - 1;
             } else {
                 return 0;
             }
             
         } else if (target < A[end]) {
             return start + 1;
         } else {
             return end + 1;
         }
 */   
         if (target <= A[start])
         {
             return start;
         } else if (target <= A[end]) {
             return end;
         } else {
             return end + 1;
         }    
     }
   
    public static void main(String[] args)
    {
    	
    }
}
