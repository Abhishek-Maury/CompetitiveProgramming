package LinkedList;

import java.util.HashSet;
// https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/

public class RemoveDuplicates {
   static class Node {
        int data;
        Node next;
        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    // Approach -> Brute force
    public static Node remdup(Node head){
       Node curr1=head;
       while (curr1!=null) {
        Node curr2=curr1;
        while (curr2.next!=null) {
            if (curr2.next.data==curr1.data) {
                curr2.next=curr2.next.next;
            }else{
           curr2=curr2.next; 
            }
        }
        curr1=curr1.next;
       }
       return head;
    }

    // Approach -> O(N) time, O(N)
    public static Node remdup2(Node head){
        HashSet<Integer> st=new HashSet<>();
        Node curr=head;
        Node prev=null;
        while (curr!=null) {
            if (st.contains(curr.data)) {
                prev.next=curr.next;
            }else{
                st.add(curr.data);
                prev=curr;
            }
            curr=prev.next;
        }
        return head;
    }

    public static void print(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(11);
        head.next.next = new Node(12);
        head.next.next.next = new Node(21);
        head.next.next.next.next = new Node(41);
        head.next.next.next.next.next = new Node(43);
        print(head);
        remdup2(head);
        print(head);
    }
}
