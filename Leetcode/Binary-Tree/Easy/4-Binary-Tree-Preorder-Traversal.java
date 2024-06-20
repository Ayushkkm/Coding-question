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

      public void pre(TreeNode root , List<Integer> list){
        if(root==null) return ;

        list.add(root.val);
        pre(root.left,list);
        pre(root.right,list);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
    
    List<Integer> list = new ArrayList<Integer>();
    pre(root,list);
    return list;

    }
}