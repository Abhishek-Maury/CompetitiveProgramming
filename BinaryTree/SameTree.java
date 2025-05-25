package BinaryTree;

import BinaryTree.ReverseLevelOrderTraversal.Node;

public class SameTree {
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

    public static boolean isSameTree(Node root1,Node root2){
        if (root1==null && root1==null) {
            return true;
        }
        if (root1==null || root2==null || root1.val!=root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    public static void main(String[] args) {
        
    }
}
