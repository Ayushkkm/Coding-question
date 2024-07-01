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

    class pair{
        TreeNode node ;
        int lev;

        pair(TreeNode node , int lev){
            this.node = node ;
            this.lev = lev;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        
        if(root==null) return ans;

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(root,0));

        while(!q.isEmpty()){
            
            int size = q.size();
            int min = q.peek().lev;

            int left = 0 ;
            int right = 0;
        
            for(int i = 0 ; i< size ; i++){
                pair p = q.poll();
                TreeNode n = p.node;
                int v = p.lev;

                int curr = v - min;

                if(i==0) left = curr;
                if(i==size-1) right = curr;

                if(n.left!=null){
                    q.add(new pair(n.left,2*curr+1));
                }

                if(n.right!=null){
                    q.add(new pair(n.right,2*curr+2));
                }

            }

            ans = Math.max(ans, right-left+1);


    }

    return ans;
}

}