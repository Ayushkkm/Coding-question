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
        
        if(root == null){
            return null;
        }

        int curr = root.val;

        if(curr > p.val && curr > q.val){ // root > greater than both -> move to left
            
           TreeNode node =  lowestCommonAncestor(root.left , p , q );

           return node;
        }

        if(curr < p.val && curr < q.val){ // if both greater -> move right

           TreeNode node =  lowestCommonAncestor(root.right , p , q);

           return node;
        }

        return root ; // it means -> path divide -> or -> p or q become equal -> to root
    }
}
// TC -> O(H)
// SC -> O(H)