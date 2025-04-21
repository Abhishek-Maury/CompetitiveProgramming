package LinkedList;

// https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/

  public class RightSide {
  
    static class Node {
        int data;
        Node next;
        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }
    public static Node solution(Node head){
        Node curr=head;
        Node maxNode=head;
        Node temp;

        while (curr!=null && curr.next!=null) {
            if (curr.next.data<maxNode.data) {
                temp=curr.next;
                curr.next=temp.next;
                temp=null;
            }else{
                curr=curr.next;
                maxNode=curr;
            }
        }
        return head;
    }
    public static Node deleteNodeGreater(Node head){
       head=reverse(head);
       head=solution(head);
       return head;
    }
    public static Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        Node next;

        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
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
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);
        print(head);
        head=deleteNodeGreater(head);
        print(head);
    }
  }  

