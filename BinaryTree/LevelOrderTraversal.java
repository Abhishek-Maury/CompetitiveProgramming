package BinaryTree;
import java.util.*;

public class LevelOrderTraversal {

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
    public static void level1(Node root){
        if (root==null) {
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode=q.remove();
            if (currNode==null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(root.val);
                if (currNode.left!=null) {
                    q.add(currNode.left);
                }
                if (currNode.right!=null) {
                    q.add(currNode.right);
                }
            }
        }

    }

    public static List<List<Integer>> level2(Node root){
        if (root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int currLevel=0;
        while (!q.isEmpty()) {
            int len=q.size();
            res.add(new ArrayList<>());
            // this will first run for curr length that is only root 
            for (int i = 0; i < len; i++) {
                Node node=q.remove();
                res.get(currLevel).add(node.val);

                if (node.left!=null) {
                    q.add(node.left);
                }
                if (node.right!=null) {
                    q.add(node.right);
                }
            }
            currLevel++;
        }
        return res;

    }
    public static void main(String[] args) {
        
    }
}
