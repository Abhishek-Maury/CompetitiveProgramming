package LinkedList;

public class ArbitaryPointer {

    static class Node{
        int data;
        Node arbitPoint;
        Node next;
        
        public Node(int data ) {
            this.data=data;
            this.next=null;
            this.arbitPoint=null;
        }
        
    }
    public static Node merge(Node left,Node right){
            // If one list is empty, return the other
            if (left == null) return right;
            if (right == null) return left;
    
            Node result = null;
            Node curr = null;
    
            // Initialize result with the smaller node
            if (left.data <= right.data) {
                result = left;
                left = left.arbitPoint;
            } else {
                result = right;
                right = right.arbitPoint;
            }
            curr = result;
    
            // Merge the two lists
            while (left != null && right != null) {
                if (left.data <= right.data) {
                    curr.arbitPoint = left;
                    left = left.arbitPoint;
                } else {
                    curr.arbitPoint = right;
                    right = right.arbitPoint;
                }
                curr = curr.arbitPoint;
            }
    
            // Attach remaining nodes
            curr.arbitPoint = (left != null) ? left : right;
            return result;
    }
    public static Node getMid(Node head){
        if (head==null || head.arbitPoint==null) {
            return null;
        }
        Node slow=head;
        Node fast=head.arbitPoint;

        while (fast!=null && fast.arbitPoint!=null) {
            slow=slow.arbitPoint;
            fast=fast.arbitPoint.arbitPoint;
        }
        Node secound =slow.arbitPoint;
        slow.arbitPoint=null;
        return secound;
    }
    public static Node mergeSort(Node head){
        if (head==null || head.arbitPoint==null) {
            return head;
        }
        Node left =head;
        Node right=getMid(head);

        left=mergeSort(left);
        right=mergeSort(right);

        return merge(left, right);
    }
    public static Node copy(Node head){
        Node curr=head;
        while (curr!=null) {
            curr.arbitPoint=curr.next;
            curr=curr.next;
        }
        return mergeSort(head);

    }
    
    public static void print(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.arbitPoint;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        head=copy(head);
        print(head);
    }
}
