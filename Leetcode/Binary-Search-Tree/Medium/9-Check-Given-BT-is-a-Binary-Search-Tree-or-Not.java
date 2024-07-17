/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean preorder(TreeNode root , long min , long max){
        if(root == null){
            return true;
        }

        // check root

        if( max <= root.val || root.val <= min){
            return false;
        }

        if(preorder(root.left , min , root.val)==false){
            return false;
        }

        if(preorder(root.right , root.val , max)== false){
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        
        return preorder(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
}

// TC -> O(n)
// SC -> O(n)
