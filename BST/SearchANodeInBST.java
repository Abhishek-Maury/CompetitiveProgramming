package BST;

public class SearchANodeInBST {
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

    boolean search(Node root, int x) {
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        if(root.data>x){
            return search(root.left,x);
        }
        else{
           return search(root.right,x);
        }
        
        
    }
    public static void main(String[] args) {
        
    }
}
