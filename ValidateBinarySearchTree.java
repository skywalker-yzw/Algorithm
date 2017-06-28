public class ValidateBinarySearchTree {
    //inner class here to define the result type
	class ResultType {
	    boolean is_bst;
	    int maxValue, minValue;
	    
	    ResultType(boolean is_bst, int maxValue, int minValue) {
	        this.is_bst = is_bst;
	        this.maxValue = maxValue;
	        this.minValue = minValue;
	    }
	}
	
	public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;			
	}
	
	private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        
        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }

        if (root.left != null && left.maxValue >= root.val || 
                root.right != null && right.minValue <= root.val) {
              return new ResultType(false, 0, 0);
          }
        
        return new ResultType(true,
                Math.max(root.val, right.maxValue),
                Math.min(root.val, left.minValue));       
	}
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
/* This code is wrong. We need to keep tracking of the max value of left tree and min value of right tree
        to make sure that: max of left tree < root.val < min of right tree
        one failing test case is: {10,5,15,#,#,6,20}
*/
/*	
    public boolean isValidBST(TreeNode root) {
   
        // write your code here
        boolean left = true;
        boolean right = true;
        int leftValue = Integer.MIN_VALUE;
        int rightValue = Integer.MAX_VALUE;
        
        if (root == null) {
            return true;
        }
        
        if (root.left != null) {
            left = isValidBST(root.left);
            leftValue = root.left.val;
        }
        
        if (root.right != null) {
            right = isValidBST(root.right);
            rightValue = root.right.val;
        } 
        
        if (root.left == null && root.right == null) {
            return true;
        } else if ((leftValue >= root.val) || (rightValue <= root.val)) {
            return false;
        } else {
            return left & right;
        }
       
    }
*/

}
