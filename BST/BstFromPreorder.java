package BST;

// leetcode 1008
public class BstFromPreorder {
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
     public Node bstFPre(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }
     public Node bstFromPreorder(int[] preorder,int bound,int[] i) {
        if(i[0]==preorder.length || preorder[i[0]]>bound) return null;
        Node root=new Node(preorder[i[0]++]);
        root.left=bstFromPreorder(preorder,root.data,i);
        root.right=bstFromPreorder(preorder,bound,i);
        return root;
    }
    public static void main(String[] args) {
        
    }
}
