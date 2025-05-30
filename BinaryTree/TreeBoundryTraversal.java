package BinaryTree;

import java.util.*;

public class TreeBoundryTraversal {
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
    public boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    public void leftBoundry(Node root,ArrayList<Integer> res){
        if (root==null || isLeaf(root)) {
            return;
        }
        res.add(root.data);

        if (root.left!=null) {
            leftBoundry(root.left, res);
        }
       else if (root.right!=null) {
            leftBoundry(root.right, res);
        }
        
    }
    public void addLeaf(Node root,ArrayList<Integer> res){
        if (root==null) {
            return;
        }
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        addLeaf(root.left, res);
        addLeaf(root.right, res);
        
    }
    public void rightBoundry(Node root,ArrayList<Integer> res){
        if (root==null || isLeaf(root)) {
            return;
        }
        if (root.right!=null) {
            rightBoundry(root.right, res);
        }else if (root.left!=null) {
            rightBoundry(root.left, res);
        }
        res.add(root.data);
        
    }
   public ArrayList<Integer> boundaryTraversal(Node root) {
         ArrayList<Integer> res =new ArrayList<>();
         if (root==null) {
            return res;
         }
         if (!isLeaf(root)) {
            res.add(root.data);
         }
         leftBoundry(root.left, res);
         addLeaf(root, res);
         rightBoundry(root.right, res);
         
         return res;
        
    }
    public static void main(String[] args) {
        
    }
}
