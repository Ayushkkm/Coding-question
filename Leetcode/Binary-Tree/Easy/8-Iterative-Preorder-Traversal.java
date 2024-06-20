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
    
    public List<Integer> preorderTraversal(TreeNode root) {
    
    List<Integer> pre = new ArrayList<>();

    if(root==null) return pre;

    Stack<TreeNode> str = new Stack<>();

    str.push(root);

    while(!str.isEmpty()){
        TreeNode temp = str.pop();
        pre.add(temp.val);

        if(temp.right!=null) str.push(temp.right);
        if(temp.left!=null) str.push(temp.left);
     
    }
    return pre;
   
    }
}