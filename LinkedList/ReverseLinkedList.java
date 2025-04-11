package LinkedList;

public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head){
        if (head==null) {
            return head;
        }
        // three variable four step
        ListNode prev = null;
        ListNode curr=head;
        ListNode next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
