package LinkedList;

public class DoublyReverse {

    static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data ) {
            this.data=data;
            this.next=null;
        }
        
    }
    public static Node reverse(Node head){
      Node curr=head;
      Node prev=null;
      Node next;
      while (curr!=null) {
        next=curr.next;
        curr.next=prev;
        curr.prev=next;
        prev=curr;
        curr=next;    
      }
      return head;
    }
    public static void main(String[] args) {
        
    }
}
