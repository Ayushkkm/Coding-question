/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public void markParents(TreeNode root, Map<TreeNode , TreeNode> parent ){
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left!= null){
                parent.put(node.left,node);
                q.add(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                q.add(node.right);
            }
        }
    } 

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        markParents(root,parent); // parent use -> to move upward

        Map<TreeNode, Boolean> vis = new HashMap<>(); // visited 

        Queue<TreeNode> q = new LinkedList<>();

        int cnt = 0 ;
        q.add(target); // add target
        vis.put(target,true);

        while(!q.isEmpty()){
            int size = q.size();

            if(cnt==k) break; // we will -> get -> our -> ans -> in queue

            cnt++;

            for(int i = 0 ;  i< size ; i++){
                TreeNode node = q.poll();
                
                // Travel -> downward -> direction
                if(node.left!=null && !vis.containsKey(node.left)){
                    vis.put(node.left,true); // mark visited
                    q.add(node.left); // normal BFS
                }

                if(node.right != null && !vis.containsKey(node.right)){
                    vis.put(node.right , true);
                    q.add(node.right);
                }

                // Move -> upward direction

                if(parent.containsKey(node) && !vis.containsKey(parent.get(node))){ // root -> has no parents -> so check each node
                    vis.put(parent.get(node),true);
                    q.add(parent.get(node)); 
                }

            }
            
        } 

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            list.add(q.poll().val);
        }

        return list;
     }
}