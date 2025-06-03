package BST;

import java.util.ArrayList;

public class InOrderSucessorAndPredcessor {
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

     // 1.If root is NULL then return.
     // 2.if key is found then
          // If its left subtree is not null, then predecessor will be the right most child of left subtree or left child itself.
          // If its right subtree is not null Then The successor will be the left most child of right subtree or right child itself.
     // 3.If key is smaller than root node set the successor as root search recursively into left    subtree.
     //4. Otherwise set the predecessor as root search recursively into right subtree
    static Node rightMost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    static Node leftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public ArrayList<Node> inPreSuc(Node root, int val) {
        Node pre = null, suc = null;
        Node curr = root;
        while (curr != null) {
            if (curr.data < val) {
                pre = curr;
                curr = curr.right;
            } else if (curr.data > val) {
                suc = curr;
                curr = curr.left;
            } else {
                //we find the key in the tree
                if (curr.left != null) {
                    pre = rightMost(curr.left);
                }
                if (curr.right != null) {
                    suc = leftMost(curr.right);
                }
                break;
            }
        }
        ArrayList<Node> res=new ArrayList<>();
        res.add(pre);
        res.add(suc);
        return res;
    }

    public static void main(String[] args) {

    }
}
