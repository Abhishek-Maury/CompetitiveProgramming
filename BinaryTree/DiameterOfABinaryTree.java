package BinaryTree;

public class DiameterOfABinaryTree {
    static class Node {
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

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int diameter2(Node root) { // o(n^2)
        if (root == null) {
            return 0;
        }
        int ldiam = diameter2(root.left);
        int rdiam = diameter2(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiam = lh + rh + 1;
        return Math.max(selfDiam, Math.max(rdiam, ldiam));
    }

    static class Info{
        int diam;
        int ht;
        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
        
    }

    public static Info diameter(Node root){
      if (root==null) {
           return new Info(0, 0);
      }

      Info leftInfo=diameter(root.left);
      Info rightInfo=diameter(root.right);

      int diam=Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht+1);
      int ht=Math.max(leftInfo.ht, rightInfo.ht)+1;

      return new Info(diam, ht);
    }

    public static void main(String[] args) {

    }
}
