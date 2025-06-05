package BST;

public class DeleteNodeInABST {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            ;
        }

    }

    public Node deleteNode(Node root,int key){
        if (root==null) {
            return null;
        }
        if (root.data==key) {
           return helper(root);
        }
        Node curr=root;
        while (curr!=null) {
            // Binary search
            if (curr.data>key) {
                if (curr.left!=null && curr.left.data==key) {
                    curr.left=helper(curr.left);
                    break;
                }else{
                    curr=curr.left;
                }
            }else{
                if (curr.right!=null && curr.right.data==key) {
                    curr.left=helper(curr.right);
                    break;
                }else{
                    curr=curr.right;
                }
            }
        }
        return root;
    }
    public Node helper(Node root){
        if (root.right==null) {
            return root.left;
        }
        else if (root.left==null) {
            return root.right;
        }else{
        Node rightChild=root.right;
        Node lastRight=findLastRight(root.left);
        lastRight.right=rightChild;
        return root.left;
        }

    }
    public Node findLastRight(Node root){
        if (root.right==null) {
            return root;
        }
        return findLastRight(root.right);
    }
    public static void main(String[] args) {
        
    }
}
