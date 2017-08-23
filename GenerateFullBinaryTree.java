/**
 * Created by yizhiw on 7/24/2017.
 */
import java.util.*;

public class GenerateFullBinaryTree {
    class Node {
        int val;
        Node left = null;
        Node right = null;

        public Node(int v) {
            this.val = v;
        }

        public Node() {
            this.val = 0;
        }
    }

    public static void main(String[] args) {
        GenerateFullBinaryTree gfbt = new GenerateFullBinaryTree();
        System.out.println(gfbt.generateFullBinaryTree(1).size());
        System.out.println(gfbt.generateFullBinaryTree(2).size());
        System.out.println(gfbt.generateFullBinaryTree(3).size());
        System.out.println(gfbt.generateFullBinaryTree(4).size());
    }

    public List<Node> generateFullBinaryTree(int n) {
        List res = new ArrayList<Node>(); 
        if (n == 0) {
            res.add(null);
            return res;
        }

        if (n == 1) {
            res.add(new Node());
            return res;
        }
        //divide and conquer approach
        for (int i = 1; i < n; i += 1) {
            //  recursively construct the left and right subtree
            List<Node> leftNodes = generateFullBinaryTree(i);
            List<Node> rightNodes = generateFullBinaryTree(n - i);

            // connect them with the root node
            for (Node l : leftNodes) {
                for (Node r : rightNodes) {
                    Node root = new Node();
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;
    }
}

