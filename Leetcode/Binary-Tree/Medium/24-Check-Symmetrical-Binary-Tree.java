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

    public boolean check(TreeNode root , TreeNode node){
        if(root==null || node == null){
            return root== node;
        }

        // Same as identical tree -> check -> opposite directions

        if(root.val!=node.val){
            return false;
        }

        if(check(root.left , node.right)==false){
            return false;
        }

        if(check(root.right , node.left)==false){
            return false;
        }

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return check(root.left,root.right);
    }

}

//  TC -> O(N)
//  SC -> O(N)


// class Solution {
//     public boolean check(TreeNode root , TreeNode node){
//         if(root==null || node ==null){
//             return root==node;
//         }

//         if(root.val!=node.val){
//             return false;
//         }

//         return check(root.left,node.right) && check(root.right, node.left);
//     }
    
//     public boolean isSymmetric(TreeNode root) {
//         return check(root.left,root.right);
//     } 
// }



