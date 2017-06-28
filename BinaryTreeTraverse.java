import java.util.*;

/**
 * This class will implement all the possible ways to traverse a binary tree
 * 
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * @author Yizhi
 *
 */
public class BinaryTreeTraverse {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */	
	public ArrayList<Integer> preorderTraverse(TreeNode root){
	/*  recursive implementation 
	    ArrayList<Integer> array = new ArrayList<Integer>();
	    
	    if (root == null) {
	        return result;
	    }

		result.add(root.val);
	    result.addAll(postorderTraversal(root.left));
	    result.addAll(postorderTraversal(root.right));
	
	    return result;
	*/

	    ArrayList<Integer> preorder = new ArrayList<Integer>();	
	    Stack<TreeNode> stack = new Stack<TreeNode>(); //java stack type, need more study
	    TreeNode node = null;
	    
	    //validate parameter
	    if (root == null) {
	    	return preorder;
	    } else {
	    	stack.push(root);
	    }

        while (!stack.empty()) {
        	node = stack.pop();
        	preorder.add(node.val);
        	
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        }
        
        return preorder;	    
	}

	public ArrayList<Integer> inorderTraverse(TreeNode root) {
	/*  recursive implementation 
	    ArrayList<Integer> array = new ArrayList<Integer>();
	     
	    if (root == null) {
	        return result;
	    }

	    result.addAll(postorderTraversal(root.left));
	    result.add(root.val);
	    result.addAll(postorderTraversal(root.right));
	
	    return result;
	*/ 		
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		
		if (root == null) {
			return inorder;
		}
		
		while ((curr != null) || (!stack.empty())) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.peek();
			inorder.add(curr.val);
			stack.pop();
			curr = curr.right;
		}
		
		return inorder;
	}
	
	public ArrayList<Integer> postorderTraverse(TreeNode root) {
	/*  recursive implementation 
	    ArrayList<Integer> result = new ArrayList<Integer>();
	
	    if (root == null) {
	        return result;
	    }
	
	    result.addAll(postorderTraversal(root.left));
	    result.addAll(postorderTraversal(root.right));
	    result.add(root.val);
	
	    return result;
		*/ 	
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = null;
		TreeNode prev = null; 
		
		stack.push(root);
		
		while (!stack.empty()) {
			curr = stack.peek();
			
			//traverse down the tree
			if ((prev == null) || (prev.left == curr) || (prev.right == curr)) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				}
			} else if (curr.left == prev) { //traverse up from the left
				if (curr.right != null) {
					stack.push(curr.right);
				}
			} else { //traverse up from the right
				postorder.add(curr.val);
				stack.pop();
			} 
			
			prev = curr;
		}
		
		return postorder;
	}
	
	public static void main(String[] args) {
		
	}
}
