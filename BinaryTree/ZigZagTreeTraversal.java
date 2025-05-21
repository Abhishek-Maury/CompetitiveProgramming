package BinaryTree;

import java.util.*;

public class ZigZagTreeTraversal {
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

    public static ArrayList<Integer> zigzag(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.remove();
                if (flag)
                    ans.add(node.val);
                else
                    level.add(0, node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.addAll(level);
            flag = !flag;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
