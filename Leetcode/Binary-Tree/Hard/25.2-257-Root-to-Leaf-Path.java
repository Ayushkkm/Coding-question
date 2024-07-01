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

    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    public void inorder(TreeNode root, List<String> list, StringBuilder str){
        if (root == null) {
            return;
        }
        
        int len = str.length(); // Store current length of the string builder
        
        if (len > 0) { // Add '->' only if it's not the root node
            str.append("->");
        }
        
        str.append(root.val);
        
        if (isLeaf(root)) {
            list.add(str.toString()); // Add the path to the list
        } else {
            inorder(root.left, list, str);
            inorder(root.right, list, str);
        }
        
        // Remove added part to backtrack to previous state
        str.setLength(len); 
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        
        if (root == null) {
            return list;
        }
        
        inorder(root, list, str);
        
        return list;
    }
}

// str.delete(str.length() - 1) ->  instead of str.setLength(len) -> might not be appropriate
// Because -> we add a "->" separator -> between node values -> deleting the last character -> won't remove the separator

// TC -> O(N)
// SC -> O(H) -> list -> path
