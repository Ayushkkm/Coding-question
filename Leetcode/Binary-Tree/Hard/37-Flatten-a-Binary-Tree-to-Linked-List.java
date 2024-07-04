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
    TreeNode prev = null;

    public void flatten(TreeNode root) {
      
      if(root==null) return ;

      flatten(root.right);
      flatten(root.left);

      root.right = prev;
      root.left = null;

      prev = root;
                   

    }
}
// TC -> O(N)
// SC -> O(H) 

// without global variable

// class Solution {
//     public void flatten(TreeNode root) {
//         flattenTree(root, null);
//     }

//     private TreeNode flattenTree(TreeNode root, TreeNode prev) {
//         if (root == null) {
//             return prev;
//         }
        
//         // Flatten the right subtree first
//         prev = flattenTree(root.right, prev);
//         // Then flatten the left subtree
//         prev = flattenTree(root.left, prev);
        
//         // Set the current node's right to the previously visited node
//         root.right = prev;
//         root.left = null;
        
//         // Update the previous node to be the current node
//         prev = root;
        
//         return prev;
//     }
// }