package LinkedList;

public class RemoveNthNodeFromEndOfList {
    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

   
  static class Node{
        int data;
        Node next;
        public Node(int data ) {
            this.data=data;
            this.next=null;
        }
        
    }
     // brute force
    public static Node removeNth(Node head,int N){
       Node temp=head;
       int size=0;
       while (temp!=null) {
            size++;
            temp=temp.next;
       }
       if (size==N) {
         return head.next;
       }
       int res=size-N;
       temp=head;
       while (temp!=null) {
          res--;
          if (res==0) {
            break;
          }
          temp=temp.next;
       }

       temp.next=temp.next.next;
       return head;
    }

    // optimal approch

    public static Node removNode2(Node head,int n){
        Node fast=head;
        Node slow= head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        if (fast==null) {
            return head.next;
        }
        while (fast.next!=null) {
            fast=fast.next;
            slow=slow.next;
        }
        Node delnode=slow.next;
        slow.next=slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        
    }
}
