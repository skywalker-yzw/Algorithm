
public class Search2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //validate the parameters
        if ((matrix == null) || (matrix.length == 0) ){
            return false;
        }
        
        //two binary search should do the work. First binary search the number in the last column; 
    	//then, binary search the number in the row.        
        int rowStart = 0, rowEnd = matrix.length -1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        int finalRow = 0;
        
        //first, search for the row
        while (rowStart + 1 < rowEnd){
        	int rowMid = rowStart + (rowEnd - rowStart) / 2;
        
        	if (matrix[rowStart][colEnd] >= target) {
        		rowEnd = rowMid;
        	} else {
        		rowStart = rowMid;
        	}
        }	
        
        if ((target == matrix[rowStart][colEnd]) || (target == matrix[rowEnd][colEnd])){
        	return true;
        } else if (target < matrix[rowStart][colEnd]){
        	finalRow = rowStart;
        } else {
        	finalRow = rowEnd;
        }	
     
        //second, search inside the finalRow
        while (colStart + 1 < colEnd){
        	int colMid = colStart + (colEnd - colStart) / 2; 
        	
        	if (matrix[finalRow][colStart] >= target){
        		colEnd = colMid;
        	} else {
        		colStart = colMid;
        	}	
        }
        	
        if ((matrix[finalRow][colStart] == target) || (matrix[finalRow][colEnd] == target)){
        	return true;
        }	
        
        return false;
    }
 
    public boolean searchMatrixBinarySearchOnce(int[][] matrix, int target) {
        //validate the parameters
        if ((matrix == null) || (matrix.length == 0) ){
            return false;
        }
        
    	int rowLen = matrix.length;
    	int colLen = matrix[0].length;
    	
    	int start = 0;
    	int end = rowLen * colLen - 1;
        int mid = 0;
        
    	while (start + 1 < end)
    	{
    		mid = start + (end - start) / 2;
    		
    		if (target >= matrix[mid/colLen][mid%colLen]){
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}	
    	
    	if ((matrix[start/colLen][start%colLen] == target) || (matrix[end/colLen][end%colLen] == target))
    	{
    		return true;
    	}	
    	
    	return false;
    }
    
    public static void main(String[] args)
    {
    	int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    	Search2DMatrix searchObj = new Search2DMatrix();
    	
    	if(searchObj.searchMatrix(matrix, 3)){
    		System.out.println("Found the number");
    	} else {
    		System.out.println("Number doesn't exist in the matrix");
    	}
 
    	if(searchObj.searchMatrixBinarySearchOnce(matrix, 16)){
    		System.out.println("Found the number");
    	} else {
    		System.out.println("Number doesn't exist in the matrix");
    	}
    }
}
