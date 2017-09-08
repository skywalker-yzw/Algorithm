/**
 * Created by yizhiw on 9/8/2017.
 * merge two sorted list
 * List1 = [-10,1,2,5,9,20]
 * List2 = [3,6,8,19,30]
 * 	Output[-10, 1,2,3,5,6,8,9,19,20,30]
 */
import java.util.*;

public class MergeSortedList {
    public List<Integer> mergeTwoSortedList(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new LinkedList<Integer>();

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        int idx1 = 0, idx2 = 0;

        while((idx1 < list1.size()) && (idx2 < list2.size())) {
            Integer num1 = list1.get(idx1);
            Integer num2 = list2.get(idx2);

            if (num1 <= num2) {
                res.add(num1);
                idx1++;
            } else {
                res.add(num2);
                idx2++;
            }
        }

        if (idx1 < list1.size()) {
            for(int i = idx1; i < list1.size(); i++) {
                res.add(list1.get(i));
            }
        }
        if (idx2 < list2.size()) {
            for(int i = idx2; i < list2.size(); i++) {
                res.add(list2.get(i));
            }
        }

        return res;
    }

    /*
    *  List1 = [-10,1,2,5,9,20]
    *  List2 = [3,6,8,19,30]
    *   …..
    *  Listk = [……]
            	Output[-10, 1,2,3,5,6,8,9,19,20,30…..]
    */
    class Node {
        List<Integer> list;
        int idx;
        int val;

        public Node(List<Integer> list, int idx, int val) {
            this.list = list;
            this.idx = idx;
            this.val = val;
        }
    }

    public List<Integer> mergeKSortedList(List<List<Integer>> input) {
        List<Integer> res = new LinkedList<Integer>();

        if ((input == null) || (input.size() == 0)) {
            System.out.println("Empty input!");
            return res;
        }

        Queue<Node> queue = new PriorityQueue<Node>(input.size(), new Comparator<Node>(){
           public int compare(Node n1, Node n2) {
               return (n1.val - n2.val);
           }
        });

        // push in the head of all lists into the priority queue
        for(int i = 0; i < input.size(); i++) {
            List<Integer> list = input.get(i);

            Node node = new Node(list, 0, list.get(0));
            queue.offer(node);
        }

        while(queue.isEmpty() == false) {
            Node node = queue.poll();
            res.add(node.val);

            if (node.idx < node.list.size() - 1) {
                Node next = new Node(node.list, node.idx+1, node.list.get(node.idx+1));
                queue.offer(next);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] array1 = {-10,1,2,5,9,20};
        Integer[] array2 = {3,6,8,19,30};
        Integer[] array3 = {11,15,17,33,100};

        List<Integer> list1 = Arrays.asList(array1);
        List<Integer> list2 = Arrays.asList(array2);
        List<Integer> list3 = Arrays.asList(array3);

        MergeSortedList obj = new MergeSortedList();

        System.out.println(obj.mergeTwoSortedList(list1, list2));

        List<List<Integer>> kList = new LinkedList<List<Integer>>();
        kList.add(list1);
        kList.add(list2);
        kList.add(list3);
        System.out.println(obj.mergeKSortedList(kList));
    }
}
