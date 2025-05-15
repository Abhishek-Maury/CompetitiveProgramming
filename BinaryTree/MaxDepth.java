package BinaryTree;

// leetcode 104
public class MaxDepth {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    public static int height(Node root){
        if (root==null) {
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);

        return 1+Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root =new Node(3);
        root.left=new Node(9);
        root.right=new Node(20);
        root.right.left=new Node(15);
        root.right.right=new Node(7);
        System.err.println(height(root));
    }
}
