package BST;

import java.util.Stack;

// leetcode 173

public class BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Stack<TreeNode> s = new Stack<>();

    public void BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = s.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    private void pushAll(TreeNode node) {

        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {

    }
}
