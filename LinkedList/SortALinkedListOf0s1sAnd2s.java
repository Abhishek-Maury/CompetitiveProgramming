package LinkedList;

public class SortALinkedListOf0s1sAnd2s {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void sort(Node head) {
        Node ptr = head;
        int[] arr = { 0, 0, 0 };

        while (ptr != null) {
            arr[ptr.data] += 1;
            ptr = ptr.next;
        }
           
        int idx=0;
        ptr=head;

        while (ptr!=null) {
            if (arr[idx]==0) {
                idx++;
            }else{
                ptr.data=idx;
                arr[idx]-=1;
                ptr=ptr.next;
            }
        }
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
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        print(head);
        sort(head);
        print(head);
    }
}
