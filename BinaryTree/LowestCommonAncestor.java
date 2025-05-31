package BinaryTree;
public class LowestCommonAncestor {
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
     Node lca(Node root, int n1, int n2) {
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);
        
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return root;
        }
        
    }
    public static void main(String[] args) {
        
    }
}
