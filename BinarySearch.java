
public class BinarySearch{
	/**
	 * Recursive implementation of binary search for classic binary search
	 * @param num
	 * @param sortedArray
	 * @param start
	 * @param end
	 * @return
	 */
	public int binarySearchRecur(int num, int[] sortedArray, int start, int end)
	{
		int mid = 0;
		
		if(start <= end) 
		{
			mid = start + (end - start) / 2; // to avoid integer number overflow, can't do (start + end)/2
		}
		else
		{
			return -1;
		}	
		
		if(num > sortedArray[mid])
		{
			return binarySearchRecur(num, sortedArray, mid+1, end);
		}
		else if(num < sortedArray[mid])
		{
			return binarySearchRecur(num, sortedArray, start, mid-1);
		}
		else
		{
			return mid;
		}	
	}
	
	/**
	 * Non-recursive implementation of binary search with while loop for the classic binary search problem
	 * @param num
	 * @param sortedArray
	 * @return
	 */
	public int binarySearchNonrecurClassic(int num, int[] sortedArray)
	{
		int start = 0; 
		int mid = 0;
		int end = sortedArray.length - 1;
		
		while(start <= end)
		{	
			mid = start + (end - start) / 2; // to avoid integer number overflow, can't do (start + end)/
			
			if(num > sortedArray[mid])
			{
				start = mid + 1;
			}
			else if(num < sortedArray[mid])
			{
				end = mid - 1;
			}
			else
			{
				return mid;
			}	
		}	
		
		return -1;
	}
	
	/**
	 * The non-recursive implementation to find the first position of the number in a sorted ascending array using binary search
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binarySearchNonrecurFirstPosition(int target, int[] nums)
	{
		/*validate parameters*/
        if ( (nums == null ) || (nums.length == 0))
        {
            return -1;    
        }
        
		int start = 0;
		int mid = 0;
		int end = nums.length - 1;
		
		//idea is to narrow the search window to 2 when start and end meets, or start and end are adjacent
		while (start + 1 < end)
        {
            mid = start + (end - start) / 2; //to avoid integer number overflow 
            
            if (target > nums[mid])
            {
                start = mid;
            }
            else if (target <= nums[mid])
            {
                end = mid;
            }
        }
        
		//check start and end number to determine what to return
        if (target == nums[start])
        {
            return start;
        }
        if (target == nums[end])
        {
            return end;
        }
        
        return -1;		
	}

	/**
	 * The non-recursive implementation to find the last position of a number in a sorted ascending array using binary search
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binarySearchNonrecurLastPosition(int target, int[] nums)
	{
		/*validate parameters*/
        if ( (nums == null ) || (nums.length == 0))
        {
            return -1;    
        }
        
		int start = 0;
		int mid = 0;
		int end = nums.length - 1;
		
		//idea is to narrow the search window to 2 when start and end meets, or start and end are adjacent
		while (start + 1 < end)
        {
            mid = (start + end)/2;
            
            if(target >= nums[mid])
            {
                start = mid;
            }
            else if(target < nums[mid])
            {
                end = mid;
            }
        }
        
		//check start and end number to determine what to return
        if (target == nums[end])
        {
            return end;
        }        
        if (target == nums[start])
        {
            return start;
        }

        return -1;	
	}
	
	public static void main(String[] args)
	{
		int[] sortedArray = {1, 6, 8, 8, 8, 8, 9};
		BinarySearch obj = new BinarySearch();
		int ret = obj.binarySearchRecur(8, sortedArray, 0, sortedArray.length - 1);
		if(ret == -1)
		{
			System.out.println("Couldn't find the number in the array");
		}
		else
		{	
			System.out.println("Using recursive binary search, found the number at index " + ret);
		}	
	
		ret = obj.binarySearchNonrecurClassic(8, sortedArray);
		if(ret == -1)
		{
			System.out.println("Couldn't find the number in the array");
		}
		else
		{	
			System.out.println("Using classic non-recursive binary search, found the number at index " + ret);
		}	

		ret = obj.binarySearchNonrecurFirstPosition(8, sortedArray);
		if(ret == -1)
		{
			System.out.println("Couldn't find the number in the array");
		}
		else
		{	
			System.out.println("Using classic non-recursive binary search, found the first number occurrence at index " + ret);
		}	
		
		ret = obj.binarySearchNonrecurLastPosition(8, sortedArray);
		if(ret == -1)
		{
			System.out.println("Couldn't find the number in the array");
		}
		else
		{	
			System.out.println("Using classic non-recursive binary search, found the last number occurrence at index " + ret);
		}			
	}	
}
