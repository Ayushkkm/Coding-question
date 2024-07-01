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

    public TreeNode MakeParent(TreeNode root , int target, Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode rt = null ;
        
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            
            if(n.val==target) {
                rt = n;  // set the target
            }
            
            if(n.left!=null){
                parent.put(n.left,n);
                q.add(n.left);
            }
            
            if(n.right!=null){
                parent.put(n.right,n);
                q.add(n.right);
            }
        }
        
        return rt;
        
        
    }
    
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        
        TreeNode node = MakeParent(root , start , parent);
        
        Map<TreeNode , Boolean> vis = new HashMap<>(); // visited
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(node);
        vis.put(node,true);
        
        int time = 0 ; 
        
        while(!q.isEmpty()){
            
            int flag = 0;
            
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++){
                TreeNode n = q.poll();
                
                if(n.left!=null && !vis.containsKey(n.left)){
                    vis.put(n.left,true);
                    flag = 1;
                    q.add(n.left);
                }
                
                if(n.right!=null && !vis.containsKey(n.right)){
                    vis.put(n.right,true);
                    flag = 1;
                    q.add(n.right);
                }
                
                if(parent.containsKey(n) && !vis.containsKey(parent.get(n))){
                    vis.put(parent.get(n),true);
                    flag = 1;
                    q.add(parent.get(n));
                }
            }
            
            if(flag==1) time++;
            
        }
        
        return time;
        
    }
}