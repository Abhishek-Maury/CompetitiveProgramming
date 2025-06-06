package BST;

// leetcode 203

public class KthSmallestElementInBst {
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

    int count = 0;
    int ans = 0;

    public int kthSmallest(Node root, int k) {
        // Approach : inorder traversal(Already sorted)
        if (root == null) {
            return 0;
        }
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            ans = root.data;
            return ans;
        }
        kthSmallest(root.right, k);
        return ans;
    }

    public static void main(String[] args) {

    }
}
