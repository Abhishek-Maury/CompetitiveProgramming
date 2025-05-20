package BinaryTree;

import java.util.ArrayList;

public class leftViewOfBinaryTree {
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

      public ArrayList<Integer> leftView(Node root) {
       ArrayList<Integer> result=new ArrayList<>();
       rvbt(root, result, 0);
       return result;

    }

    public void rvbt(Node curr,ArrayList<Integer> result,int level){
        if (curr==null) {
            return;
        }
        if (level==result.size()) {
            result.add(curr.val);
        }

        
        rvbt(curr.left, result, level+1);
        rvbt(curr.right, result, level+1);
    }

      public static void main(String[] args) {
        
    }
}
