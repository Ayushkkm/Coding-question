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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;

        while(true){

            if(root.val < val){ // go and -> check right
              
              if(root.right !=null){ // check null
                root = root.right;
              }

              else{ // if null -> insert new node
               
               root.right = new TreeNode(val);
               break; 
              }

            }
            else{ // go -> left

              if(root.left !=null){ // move left
                 root = root.left ;
              }

              else{ // if null -> insert new node
                root.left = new TreeNode(val);
                break;
              }
            }

        }

        return curr;
    }
}
// TC -> O(log(N))
// SC -> O(1)