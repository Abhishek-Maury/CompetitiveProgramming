package BinaryTree;

import java.util.*;

import org.xml.sax.HandlerBase;

import StackandQueue.nextSmallerElement;

public class PrintAllNodesAtDistanceKFromAGivenNode {
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

    public static void markParents(Node root, HashMap<Node, Node> parent_pointer, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr.left != null) {
                parent_pointer.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent_pointer.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public static ArrayList<Integer> kDistance(Node root, Node target, int k) {
        HashMap<Node, Node> parent_pointer = new HashMap<>();
        markParents(root, parent_pointer, target);

        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        visited.put(target, true);
        int currLevel = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (currLevel == k) {
                break;
            }
            currLevel++;
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                if (curr.left != null && visited.get(curr.left) == null) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_pointer.get(curr) != null && visited.get(parent_pointer.get(curr)) == null) {
                    q.add(parent_pointer.get(curr));
                    visited.put(parent_pointer.get(curr), true);
                }

            }

        }
        ArrayList<Integer> res=new ArrayList<>();
        while (!q.isEmpty()) {
            Node curr=q.remove();
            res.add(curr.data);
        }
        Collections.sort(res);
        
        return res;

    }

    public static void main(String[] args) {

    }
}
