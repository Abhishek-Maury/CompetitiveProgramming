package LinkedList;

// https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
public class DeleteWithoutHeadNode {
    
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void del(ListNode delNode){
       if (delNode==null ||delNode.next==null) {
        return;
       }
       delNode.val=delNode.next.val;
       delNode.next=delNode.next.next;
    }
    public static void main(String[] args) {
        
    }
}
