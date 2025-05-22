package BinaryTree;

public class LeavesAtSameLevel {
     static class Node {
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
   public static boolean check(Node root) {
      return helper(root, 0, 0);
        
    }
    public static boolean helper(Node root,int level,int max){
        if (root==null) {
            return true;
        }
        if (root.right==null && root.left==null) {
            if (max==0) {
                max=level;
                return true;
            }
            return (max==level);
        }
      return  helper(root.left, level+1, max) &&
              helper(root.right, level+1, max);
    }
    public static void main(String[] args) {
          Node root = new Node(1);
             root.left = new Node(2);
             root.right = new Node(3);
             root.left.right = new Node(4);
             root.right.left = new Node(5);
             root.right.right = new Node(6);
             System.out.println(check(root));
             
    }
}
