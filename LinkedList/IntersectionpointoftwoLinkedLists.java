package LinkedList;

import java.util.HashSet;

public class IntersectionpointoftwoLinkedLists {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
    // brute force Approach -> O(m + n) Time and O(m) Space

    public static Node intersection(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        Node temp1 = head1;
        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        Node temp2 = head2;
        while (temp2 != null) {
            if (set.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;

    }

    // optimal Approach -> O(m + n) Time and O(1) Space
    public static int Length(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static Node collision(int diff, Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        for (int i = 0; i < diff; i++) {
            if (curr1 == null) {
                return null;
            }
            curr1 = curr1.next;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    public static Node intersection2(Node head1, Node head2) {
        int Length1 = Length(head1);
        int Length2 = Length(head2);

        int diff = 0;
        if (Length1 > Length2) {
            diff = Length1 - Length2;
            return collision(diff, head1, head2);
        } else {
            diff = Length2 - Length1;
            return collision(diff, head2, head1);
        }
    }

    public static void main(String[] args) {
        // creation of first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        // 15 is the intersection point
        head2.next.next.next = head1.next;

        // Node intersectionPoint = intersection(head1, head2);

        // if (intersectionPoint == null)
        //     System.out.println("-1");
        // else
        //     System.out.println(intersectionPoint.data);

        Node intersectionPoint = intersection2(head1, head2);

        if (intersectionPoint == null)
            System.out.println("-1");
        else
            System.out.println(intersectionPoint.data);
    }
}
