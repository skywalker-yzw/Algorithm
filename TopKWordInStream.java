/**
 * Created by yizhiw on 7/28/2017.
 */
/**
 input stream - "ipad", "iphone", "iphone 5", "iphone" ......
 Top k most frequently occurring words. The

 iphone - 2,
 ipad - 1
 iphone 5 - 1
 */
import java.util.*;

public class TopKWordInStream {
    class Node {
        String str;
        int  frequency;

        Node(String str, int frequency) {
            this.str = str;
            this.frequency = frequency;
        }
    }

    Map<String, Node>  map;
    Queue<Node> pQueue;
    int k;

    public TopKWordInStream(int k) {
        map = new HashMap<String, Node>();
        pQueue = new PriorityQueue<Node>(k, new Comparator<Node>() {
            public int compare(Node node1, Node node2) {
                return (node1.frequency - node2.frequency);
            }
        });
        this.k = k;
    }

    public void add(String s) {
        if ((s == null) || (s.length() == 0)) {
            return;
        }

        // update the hashmap
        Node node = map.get(s);
        if (node == null) {
            node = new Node(s, 1);
        } else {
            node.frequency++;
        }
        map.put(s, node);

        // update the priority queue
        if (pQueue.contains(node) == true) { // if the word already exist in the queue
            // remove the old node, add the new node which has update frequency
            pQueue.remove(node);
            pQueue.offer(node);
        } else {
            if (pQueue.size() < k) { // if queue is not full yet
                pQueue.offer(node);
            } else {
                Node top = pQueue.peek();
                // when new node is more frequnent than the top node of the priority queue,
                // we should poll out the top and add the new node in
                if (top.frequency < node.frequency) {
                    pQueue.poll();
                    pQueue.offer(node);
                }
            }
        }
    }

    public List<String> get() {
        List<String> ret = new LinkedList<String>();

        // iterate the priority queue, add into the result list
        for(Iterator<Node> it = pQueue.iterator(); it.hasNext() == true;) {
            Node node = it.next();
            ret.add(node.str);
        }

        return ret;
    }

    public static void main(String[] args) {
        TopKWordInStream obj = new TopKWordInStream(4);

        obj.add("iphone");
        obj.add("ipad");
        obj.add("imac");
        obj.add("iphone");
        obj.add("iphone");
        obj.add("itune");
        obj.add("imac");
        obj.add("iphone8");
        obj.add("ipad");
        obj.add("macbook");
        obj.add("macbook pro");
        obj.add("macbook air");
        obj.add("imac");
        obj.add("macbook");

        System.out.println(obj.get());
    }
}
