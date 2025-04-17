package LinkedList;

// https://leetcode.com/problems/reorder-list/description/

public class ReorderList {
    static class Node{
        int data;
        Node next;
        public Node(int data ) {
            this.data=data;
            this.next=null;
        }
        
    }

    public static void rearrange(Node head){
        // step1 ->find the mid

        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        // step 2-> reverse
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

        // step 3

        Node Lhead=head;
        Node Rhead=prev;
        Node nextL,nextR;

        while (Lhead!=null && Rhead!=null) {
            nextL=Lhead.next;
            Lhead.next=Rhead;
            nextR=Rhead.next;
            Rhead.next=nextL;

            Lhead=nextL;
            Rhead=nextR;
        }

    }
    public static void main(String[] args) {
        
    }
}
