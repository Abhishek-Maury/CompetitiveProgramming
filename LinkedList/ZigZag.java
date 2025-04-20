package LinkedList;

public class ZigZag {

    static class Node{
        int data;
        Node next;
        public Node(int data ) {
            this.data=data;
            this.next=null;
        }
        
    }
    public static void rearrange(Node head){
        // step 1 ->find the mid
        Node slow=head;
        Node fast=head.next; //to find first half of last node

        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        // step 2 -> reverse the secound half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while (curr!=null) {
             next=curr.next;
             curr.next=prev;
             prev=curr;
             curr=next;
        }
        // step-> 3 zig-zag
        Node rhead=prev;
        Node lhead=head;
        Node nextl,nextr;

        while (rhead!=null && lhead!=null) {
            nextl=lhead.next;
            lhead.next=rhead;
            nextr=rhead.next;
            rhead.next=nextl;

            lhead=nextl;
            rhead=nextr;
        }


    }
    public static void main(String[] args) {
        
    }
}
