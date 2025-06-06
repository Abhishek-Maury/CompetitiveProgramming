package BST;



public class InsertIntoABinarySearchTree {
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

     public Node insertIntoBST(Node root, int data) {
        if(root==null){
            return new Node(data);
        }
        Node curr=root;
        while(true){
            if(curr.val<=data){
                if(curr.right!=null){
                    curr=curr.right;
                }else{
                    curr.right=new Node(data);
                    break;
                }
            }else{
                if(curr.left!=null){
                    curr=curr.left;
                }else{
                    curr.left=new Node(data);
                    break;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
}
