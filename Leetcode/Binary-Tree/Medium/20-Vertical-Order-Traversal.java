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
    class tuple{
        TreeNode node;
        int ver;
        int level;

        tuple(TreeNode node , int ver , int level){
           this.node = node;
           this.ver = ver;
           this.level = level;
        }

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null){
            return ans;
        }

        Queue<tuple> q = new LinkedList<>();

        TreeMap<Integer,TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();

        q.add(new tuple(root,0,0));
       
        while(!q.isEmpty()){
            tuple t = q.poll();

            TreeNode n = t.node;
            int v = t.ver;
            int lev = t.level;

            if(!map.containsKey(v)){
                map.put(v , new TreeMap<>());
            }

            if(!map.get(v).containsKey(lev)){
                map.get(v).put(lev , new PriorityQueue<>());
            }

            map.get(v).get(lev).add(n.val);

            if(n.left!=null){
                q.add(new tuple(n.left,v-1,lev+1));
            }
            if(n.right!=null){
                q.add(new tuple(n.right,v+1,lev+1));
            }
        }

        for(TreeMap<Integer , PriorityQueue<Integer>> a : map.values()){
            List<Integer> wrap = new ArrayList<>();

            for(PriorityQueue<Integer> b : a.values()){
                while(!b.isEmpty()){
                    wrap.add(b.poll());
                }
            }

            ans.add(wrap);
        }

        return ans;
    }
}
// TC -> O(nlogn)
// SC -> O(n)
