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

    public TreeNode preorderFun( int preorder[] , int maxR , int idx[]){
        
        if(idx[0] == preorder.length ||preorder[idx[0]] > maxR){
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx[0]++]);

        root.left = preorderFun(preorder , root.val , idx);

        root.right = preorderFun(preorder , maxR , idx);

        return root;
    } 

    public TreeNode bstFromPreorder(int[] preorder) {
        
        int idx[] = new int[]{0};

        return preorderFun(preorder , Integer.MAX_VALUE , idx);
        
    }
}
// TC -> O(H)
// SC -> O(H)
