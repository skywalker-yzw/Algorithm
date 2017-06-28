/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 import java.util.*;
 
public class LevelOrderBinaryTreeTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBFS(TreeNode root) {
        // write your code here
    	int i = 0;
    	int size = 0;
    	TreeNode node = null;
    	
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root == null) {
            return result;
        }
        
        //add the root into the queue
        queue.offer(root);
        
        while(queue.peek() != null) {
        	size = queue.size();
        	ArrayList<Integer> levelResult = new ArrayList<Integer>();
        	
        	for(i=0; i < size; i++) {
        		node = queue.poll();
        		//add node into the level list
        		levelResult.add(node.val);
        		
        		//add left and right children into queue
        		if (node.left != null) {
        		    queue.offer(node.left);
        		}
        		if (node.right != null) {
        		    queue.offer(node.right);
        		}
        	}
        	
        	result.add(levelResult);
        }
        
        return result;
    }
    
    public void DepthFirstSearch(TreeNode root, ArrayList<Integer> levelResult, int level) {    	

    	if (level == 0 && (root != null)) {
    		levelResult.add(root.val);
    	}
    	else {
        	if (root.left != null) {
        		DepthFirstSearch(root.left, levelResult,  level - 1);
        	}
        	
        	if (root.right != null) {
        		DepthFirstSearch(root.right, levelResult, level - 1); 		
        	}    	    
    	}
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	int level = 0; 
        
    	if (root == null) {
    		return result;
    	}

        while (true) {
        	ArrayList<Integer> levelResult = new ArrayList<Integer>();
        	DepthFirstSearch(root, levelResult, level);
        	if (levelResult.size() == 0) {
        		break;
        	}
        	
        	result.add(levelResult);
        	level++;
        }
    	
    	return result;
    }
}
