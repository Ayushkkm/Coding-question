/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root==null || root==p || root ==q){
        //     return root;
        // }

        if(root==null){
            return null;
        }

        if(root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{ // both left and right -> are not null -> found our result
            return root;
        }

        
    }
}
// TC -> O(N)
// SC -> O(H) -> recursion stack 