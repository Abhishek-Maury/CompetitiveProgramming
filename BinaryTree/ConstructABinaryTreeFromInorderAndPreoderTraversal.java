package BinaryTree;
import java.util.*;

public class ConstructABinaryTreeFromInorderAndPreoderTraversal {
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

    public static Node buildTree(int[] preorder,int[] inorder){
         HashMap<Integer,Integer> map =new HashMap<>();
         for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
         }
         Node root=buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1,map);
         return root;
    }

    public static Node buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        if (preStart>preEnd || inStart>inEnd) {
            return null;
        }
        Node root =new Node(preorder[preStart]);
        int inRoot=map.get(root.val);
        int numLeft=inRoot-inStart;

        root.left=buildTree(preorder, preStart+1, preStart+numLeft, inorder, inStart, inRoot-1, map);

        root.right=buildTree(preorder, preStart+numLeft+1, preEnd, inorder, inRoot+1, inEnd, map);

        return root;
    }
    public static void main(String[] args) {
        
    }
}
