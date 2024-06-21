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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1 + Math.max(l,r);
    }
}

// Level Order Solution

class Solution {
    public int levelOrder(TreeNode root) {
             
        int height = 0;

        if(root==null) return height;

        Queue<TreeNode> q = new LinkedList<>();
 
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                if(q.peek().left!=null ) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);

                q.poll();
            }

            height++; // Level complete
        }

        return height ;
    }
}