package BinaryTree;

import java.util.*;

public class TopViewOfBinaryTree {
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

    public class Info{
        Node node;
        int hd;
        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
        
    }

    public ArrayList<Integer> topView(Node root) {
            Queue<Info> q=new LinkedList<>();
            HashMap<Integer,Node> map =new HashMap<>();  
            ArrayList<Integer> res=new ArrayList<>();
            q.add(new Info(root, 0));
            q.add(null);
            int min =0;
            int max=0;
            while (!q.isEmpty()) {
                Info curr=q.remove();
                if (curr==null) {
                    if (q.isEmpty()) {
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left!=null) {
                        q.add(new Info(curr.node.left, curr.hd-1));
                        min=Math.min(min, curr.hd-1);
                    }
                    if (curr.node.right!=null) {
                        q.add(new Info(curr.node.right, curr.hd+1));
                        max=Math.max(max, curr.hd+1);
                    }
                }
            }
            for (int i = min; i <=max; i++) {
                res.add(map.get(i).data);
            }

            return res;
    }

    public static void main(String[] args) {

    }
}
