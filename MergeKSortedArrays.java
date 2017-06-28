import java.io.*;
import java.util.*;

/**
 * Created by yizhiw on 6/27/2017.
 */
public class MergeKSortedArrays {
    public class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    // function to merge k sorted array
    public int[] merge(int[][] arrs) {
        if ((arrs == null) || (arrs.length == 0)) {
            return null;
        }

        int row = arrs.length;
        int col = arrs[0].length;
        int[] result = new int[row*col];
        int pos = 0;

        Queue<Node> pQueue = new PriorityQueue<Node>(row, new Comparator<Node>(){
            // override the compare method
            public int compare(Node a, Node b) {
                return (a.val - b.val);
            }
        });

        // push in the first node of all rows into the priority queue
        for (int i = 0; i < row; i++) {
            Node node = new Node(i, 0, arrs[i][0]);

            pQueue.offer(node);
        }

        while (pQueue.isEmpty() == false) {
            Node node = pQueue.poll();

            result[pos++] = node.val;

            // if the current array hasn't reach to the end, add the next node
            if (node.col < arrs[node.row].length - 1) {
                Node newNode = new Node(node.row, node.col + 1, arrs[node.row][node.col + 1]);

                pQueue.offer(newNode);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{2,4,6}, {1,3,5}, {5,7}, {4,8,9,10}};

        MergeKSortedArrays sol = new MergeKSortedArrays();

        int[] result = sol.merge(array);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}