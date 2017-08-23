/**
 * Created by yizhiw on 8/7/2017.
 */
public class ReverseLinkedList {
    static class Node {
        String val;
        Node next;

        Node(String val) {
            this.next = null;
            this.val = val;
        }
    }

    Node reverse(Node head) {
        // parameter check
        if (head == null) {
            return null;
        }

        Node prev = null;
        Node cur = head;
        Node next = null;
        // traverse the list to reverse the list one by one
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // prev will be the new head, return it
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node("a");
        head.next = new Node("b");
        head.next.next = new Node("c");
        head.next.next.next = new Node("d");

        Node traverse = head;
        System.out.println("Before reverse");
        while(traverse!= null) {
            if (traverse.next != null) {
                System.out.print(traverse.val + "-->");
            } else {
                System.out.print(traverse.val);
            }

            traverse = traverse.next;
        }

        ReverseLinkedList obj = new ReverseLinkedList();
        head = obj.reverse(head);

        traverse = head;
        System.out.println("\nAfter reverse");
        while(traverse!= null) {
            if (traverse.next != null) {
                System.out.print(traverse.val + "-->");
            } else {
                System.out.print(traverse.val);
            }

            traverse = traverse.next;
        }
    }
}


