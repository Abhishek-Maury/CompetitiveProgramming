package BinaryTree;

public class TransformOfSumTree {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            ;
        }

    }

    public static void toSumTree(Node root){
         convert(root);
    }
    public static int convert(Node root){
        if (root==null) {
            return 0;
        }
        int leftSum=convert(root.left);
        int rightSum=convert(root.right);

        int oldValue=root.val;
      // Update current node's data
        root.val=leftSum+rightSum;
        // Return the total sum including the original node value
        return root.val+oldValue;
    }
    public static void main(String[] args) {
        
    }
}
