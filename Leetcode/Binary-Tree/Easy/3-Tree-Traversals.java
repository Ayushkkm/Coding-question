/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
public class Solution {

    public static void inorder(TreeNode root , List<Integer> ls){
        if(root==null) return ;

        inorder(root.left,ls);
        ls.add(root.data);
        inorder(root.right,ls);

    }

    public static void preorder(TreeNode root , List<Integer> ls){
        if(root==null) return ;

        ls.add(root.data);
        preorder(root.left,ls);
        preorder(root.right,ls);
        
    }

    public static void postorder(TreeNode root , List<Integer> ls){
        if(root==null) return ;

        postorder(root.left,ls);
        postorder(root.right,ls);
        ls.add(root.data);
        
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {

       // Code Studio
       List<List<Integer>> list = new ArrayList<>();

       List<Integer> in = new ArrayList<>();
       List<Integer> pre = new ArrayList<>();
       List<Integer> post = new ArrayList<>();

       inorder(root, in);
       preorder(root, pre);
       postorder(root, post);

       list.add(in);
       list.add(pre);
       list.add(post);

       return list;
    }
}