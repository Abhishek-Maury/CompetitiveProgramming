package BST;

public class IsValidBST {
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

    public boolean isvalid(Node root) {
        return isvalid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isvalid(Node root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.data >= maxVal || root.data <= minVal)
            return false;

        return isvalid(root.left, minVal, root.data) &&
                isvalid(root.right, root.data, maxVal);

    }

    public static void main(String[] args) {

    }
}
