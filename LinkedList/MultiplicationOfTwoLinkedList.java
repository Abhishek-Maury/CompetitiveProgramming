package LinkedList;

public class MultiplicationOfTwoLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }
    static long multiplyTwoLists(Node first, Node second) {
        long MOD = 1000000007;
        long num1 = 0, num2 = 0;
      
		// Traverse the first list and 
      	// construct the number with modulo
        while (first != null || second != null) {
            if (first != null) {
                num1 = ((num1 * 10) + first.data) % MOD;
                first = first.next;
            }
          
			// Traverse the second list and 
          	// construct the number with modulo
            if (second != null) {
                num2 = ((num2 * 10) + second.data) % MOD;
                second = second.next;
            }
        }
      
      	// Return the product of the two 
      	// numbers with modulo
        return (num1 * num2) % MOD;
    }
    public static void main(String[] args) {
        
    }
}
