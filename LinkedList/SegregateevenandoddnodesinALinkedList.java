package LinkedList;

// https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/

public class SegregateevenandoddnodesinALinkedList {
    static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public static Node oddEven(Node head) {
        Node estart = new Node(0);
        Node ostart = new Node(0);

        Node eEnd = estart;
        Node oEnd = ostart;

        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                eEnd.next = curr;
                eEnd = eEnd.next;
            } else {
                oEnd.next = curr;
                oEnd = oEnd.next;
            }
            curr=curr.next;
        }
        oEnd.next=null;
        eEnd.next=ostart.next;
        return estart.next;
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
     // 0->1->4->6->9->10->11
     Node head = new Node(0);
     head.next = new Node(1);
     head.next.next = new Node(4);
     head.next.next.next = new Node(6);
     head.next.next.next.next = new Node(9);
     head.next.next.next.next.next = new Node(10);
     head.next.next.next.next.next.next = new Node(11);

     print(head);
     head=oddEven(head);
     print(head);
    }
}
