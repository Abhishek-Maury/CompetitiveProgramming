package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public ArrayList<Integer> reverseLevelOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            Node curr = q.remove();
            ans.add(0, curr.data);  //reverse order start from here

            if (curr.right != null) {
                q.add(curr.right);
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
