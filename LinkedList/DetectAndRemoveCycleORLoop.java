package LinkedList;

public class DetectAndRemoveCycleORLoop {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void removeCycle(Node head) {
        // step 1->detect a cycle through fast and slow pinter
        Node slow = head;
        Node fast = head;
        Boolean cycle=false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle=true;
                break;
            }
        }
        if (cycle==false) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev=fast;
            slow = slow.next;          
            fast = fast.next;
        }

        prev.next = null;

    }

    public static void main(String[] args) {

    }
}
