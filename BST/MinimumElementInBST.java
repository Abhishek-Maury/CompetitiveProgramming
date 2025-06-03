package BST;

public class MinimumElementInBST {
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
    public int minValue(Node root){
        while (root.left!=null) {
            root=root.left;
        }
        return root.data;
    }
    public static void main(String[] args) {
        
    }
}
