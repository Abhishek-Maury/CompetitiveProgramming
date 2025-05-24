package BinaryTree;

public class IsomorphicTrees {
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
    boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null || root1.val != root2.val){
            return false;
        }

        boolean same = isIsomorphic(root1.left, root2.left)  &&  isIsomorphic(root1.right, root2.right);
        boolean flip = isIsomorphic(root1.left, root2.right)  &&  isIsomorphic(root1.right, root2.left);

        return same || flip;
    }
    public static void main(String[] args) {
        
    }
}
